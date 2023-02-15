package com.example.managestudent.model;

public class Result {
    private String studentId;
    private int semester;
    private double result;

    public Result(String studentId, int semester, double result) {
        this.studentId = studentId;
        this.semester = semester;
        this.result = result;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
