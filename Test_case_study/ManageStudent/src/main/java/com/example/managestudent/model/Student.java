package com.example.managestudent.model;

public class Student {
    private String studentId;
    private String studentName;
    private String birthDate;
    private int gender;
    private String address;

    public Student(String studentName, String birthDate, int gender, String address) {
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public Student(String studentId, String studentName, String birthDate, int gender, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
