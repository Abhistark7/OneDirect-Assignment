package com.OD.Question5.controller;

import javax.validation.Valid;

import com.OD.Question5.model.PhoneNumber;
import com.OD.Question5.model.User;
import com.OD.Question5.service.OTPGenerator;
import com.OD.Question5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //login page
    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userLogin");
        return modelAndView;
    }

    //signup get page
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        PhoneNumber number = new PhoneNumber();
        modelAndView.addObject("PhoneNumber", number);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    //signup post page
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView sendOTP(@ModelAttribute(value = "PhoneNumber") PhoneNumber number) {
        String OTPgen=null;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");

        //When no OTP in entered
        if(number.getOTP().length()!=6) {
            //Input number and send otp

            //check if number is registered previously or not
            User userExists = userService.findUserByNumber(number.getNumber());
            if (userExists != null) {
                ModelAndView model = new ModelAndView();
                model.setViewName("signup");
                model.addObject("otpMessage","Number already registered!");
                return model;
            }

            ModelAndView model = new ModelAndView();
            model.setViewName("signup");
            model.addObject("otpMessage","OTP Sent!");
            OTPGenerator otpGenerator = new OTPGenerator();
            OTPgen = otpGenerator.setNumber(number.getNumber());
            System.out.println("Received otp"+OTPgen);
            return model;
        }

        //When OTP is entered
        if(number.getOTP().length()==6){
            String enteredOTP = number.getOTP();
            OTPGenerator otpGenerator = new OTPGenerator();
            OTPgen = otpGenerator.getOTP();
            //Validate entered OTP with generated OTP
            if(enteredOTP.matches(OTPgen)){
                //If true go to registration form
                ModelAndView modelView = new ModelAndView();
                User user = new User();
                modelView.addObject("userPhone",number.getNumber());
                modelView.addObject("user", user);
                modelView.setViewName("registration");
                return modelView;
            } else {
                //Display OTP is invalid
                System.out.println("Invalid OTP!");
                modelAndView.addObject("errorMessage","Invalid OTP!");
            }
        }

        return modelAndView;
    }

    //registration get page *blocked*
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    //registration post page
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }


    //Admin home page
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","You are an ADMIN");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


}
