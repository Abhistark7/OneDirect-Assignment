
/**
 *
 * @author Abhishek Sahu
 */

package Question2;


import java.io.*;
import java.util.*;

import static java.lang.System.exit;


public class Solution2 {


    static Scanner sc = new Scanner(System.in);

    static ArrayList<student> studentList = new ArrayList<>();

    static String FILENAME = "studentList.ser";

    public static void main(String[] args) throws IOException {

        //load previously saved data
        studentList = loadStudentDetails();

        int option = 0;

        while(option!=5){

            System.out.println("Select Option-");
            System.out.println("1. Add User details");
            System.out.println("2. Display User details");
            System.out.println("3. Delete User details");
            System.out.println("4. Save User details");
            System.out.println("5. Exit");

            try {
                option = Integer.parseInt(sc.next());
                if(!checkChoice(option)){
                    System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid choice");
            }

            switch (option){

                case  1: addUser();
                    break;
                case 2: displayUsers();
                    break;
                case 3: deleteUser();
                    break;
                case 4: saveDetails();
                    break;
                case 5: runExit();
                    break;
                default:

            }

        }


    }

    //method which adds new users
    static void addUser(){
        String  address, courseInput;
        int roll_no=0, age=0;
        char[] courses;
        System.out.println("Enter User details");
        System.out.println("Enter Full Name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter Age");
        try {
            age = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid age");
            exit(0);
        }
        System.out.println("Enter Address");
        address = sc.nextLine();
        System.out.println("Enter Roll no");
        try {
            roll_no = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid Roll no");
            exit(0);
        }
        System.out.println("Select courses to enroll [A,B,C,D,E,F]");
        courseInput = sc.nextLine();
        String newstr = courseInput.replaceAll("[^A-Za-z]+", "");
        newstr = removeDuplicateCharacter(newstr);
        System.out.println(newstr);
        courses = newstr.toCharArray();

        // if courses are correct then enter the data
        if(correctCourse(courses)){
            studentList.add(new student(name, age, address, roll_no, courses));
            NameCompare nameCompare = new NameCompare();
            Collections.sort(studentList, nameCompare);
        }



    }

    //method to display all users
    public static void displayUsers(){

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Name\t\t\t Roll Number\t\t\t Age\t\t\t Address \t\t\t Courses");
        System.out.println("-------------------------------------------------------------------------------------------");

        for(int i=0; i< studentList.size(); i++){

            System.out.print(studentList.get(i).getName()+"\t\t"+studentList.get(i).getRoll_no()+"\t\t\t\t\t"+studentList.get(i).getAge()+"\t\t\t\t"+studentList.get(i).getAddress()+"\t\t\t");
            for (int j =0; j<studentList.get(i).getCourses().length; j++){
                System.out.print(studentList.get(i).getCourses()[j]);
                if(!(j==studentList.get(i).getCourses().length-1)){
                    System.out.print(",");
                }
            }
            System.out.println("\n");
        }


    }


    //method which deletes a user
    public static void deleteUser(){

        System.out.println("Enter roll number to delete user");
        int roll=0;
        boolean flag = false;
        try {
            roll = Integer.parseInt(sc.next());
        } catch (NumberFormatException e){
            System.out.println("Not a valid Roll number!");
            return;
        }

        for(int i=0; i<studentList.size(); i++){

            if(studentList.get(i).getRoll_no() == roll){
                studentList.remove(i);
                System.out.println("Deleted Question2.Solution2 at position : "+i);
                flag = true;
            }
        }

        if(!flag){
            System.out.println("Roll no not found!");
        }

    }

    //Serialize details
    public static void saveDetails() throws IOException {

        ObjectOutputStream oos = null;
        FileOutputStream fout = null;
        System.out.println("Saving List size = "+ studentList.size());
        try{
            fout = new FileOutputStream(FILENAME);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(studentList);
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(oos != null){
                oos.close();
            }
        }


    }


    //Deserialize
    public static ArrayList<student> loadStudentDetails(){

        ArrayList<student> loadStudentList = new ArrayList<>();

        try{
            FileInputStream fin = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fin);
            loadStudentList = (ArrayList<student>) in.readObject();
            in.close();
            System.out.println("Loading List size "+loadStudentList.size());
        } catch (Exception e){
            System.out.println("Not loaded!");
            e.printStackTrace();
        }

        return loadStudentList;

    }

    //exit method asking to save changes or not
    public static void runExit() {

        char choice = 'n';
        do {
            System.out.println("Do you want to save latest changes (y/n)");
            choice = sc.next().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                try {
                    saveDetails();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 'n' || choice == 'N') {
                exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        } while (choice!= 'y');


    }

    //method to check if choice is correct
    public static Boolean checkChoice(int choice){

        if(choice>0 && choice<6){
            return true;
        } else {
            return false;
        }
    }

    //method which checks if course entered is correct or not
    public static Boolean correctCourse(char[] courses){

        boolean res = false;

        if(courses.length!=4){
            res = false;
            System.out.println("It is mandatory to select 4 courses!");
        } else {
            for (int i = 0; i < 4; i++) {
                if (courses[i] != 'A' && courses[i] != 'B' && courses[i] != 'C' && courses[i] != 'D' && courses[i] != 'E' && courses[i] != 'F') {
                    res = false;
                    System.out.println("Wrong course entered!");
                } else {
                    res = true;
                }
            }
        }
        return res;
    }

    //method to remove duplicate characters to avoid duplicate course entries
    static String removeDuplicateCharacter(String string){

        char[] chars = string.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        return sb.toString();

    }



}