package net.braniumacademy.lesson210.exercises1;

import java.util.Objects;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String midName;
    private String address;
    private String email;
    private int age;
    private float gpa;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(Student other) {
        id = other.id;
        firstName = other.firstName;
        lastName = other.lastName;
        midName = other.midName;
        address = other.address;
        email = other.email;
        age = other.age;
        gpa = other.gpa;
    }

    public Student(String id, String firstName, String lastName,
                   String midName, String address, String email, int age, float gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.midName = midName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
