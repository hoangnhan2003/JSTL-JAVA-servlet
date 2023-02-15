package com.example.managestudent.Repository;

import com.example.managestudent.model.Student;

import java.util.List;

public interface  IStudentRepo {
    void add(Student newStudent);
    void deleteByID(String id);
    void update(Student newStudent);
    List<Student> findByAddress(String address);
    List<Student> getAll();
    Student findById(String studentid);
}
