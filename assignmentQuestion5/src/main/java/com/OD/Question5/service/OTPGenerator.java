package com.OD.Question5.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Random;

public class OTPGenerator {


    public String setNumber(String number){
        CLIENT_NUMBER = number;
        String OTP = this.main(null);
        return OTP;
    }

    public String getOTP(){
        return OTPgen;
    }

    //Twilio Account Credentials
    public static final String ACCOUNT_SID = "AC1c560230c25d721db1930d84b4aa2c0d";
    public static final String AUTH_TOKEN  = "57a0c3e5fe6cd9f8be597879ebb3f9af";
    public static final String TWILIO_NUMBER = "+15127649767";
    public static String CLIENT_NUMBER = "";
    private static String OTPgen;

    public static String main(String[] args) {

        System.out.println("Inside OTP main" + CLIENT_NUMBER);

        //Generate OTP with required length
        String OTP =generate(6);
        OTPgen = OTP;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(CLIENT_NUMBER),
                new PhoneNumber(TWILIO_NUMBER),
                "Your OTP is - "+OTP)
                .create();

        return OTP;
    }

    static String generate(int len)
    {

        String numbers = "0123456789";
        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[6];

        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));

        }
        return String.valueOf(password);
    }



}
