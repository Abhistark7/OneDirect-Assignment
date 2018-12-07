package Question2;

import java.io.Serializable;


//POJO student
class student implements Serializable
{
    // SerialVersionUID
    private static final long serialVersionUID = 19L;
    String name;
    int age;
    String address;
    int roll_no;
    char[] courses;

    public student(String name, int age, String address, int roll_no, char[] courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.roll_no = roll_no;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public char[] getCourses() {
        return courses;
    }

}
