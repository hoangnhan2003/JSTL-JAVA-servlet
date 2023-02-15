package com.example.managestudent.Service;

import com.example.managestudent.model.Student;

import java.util.List;

public interface  IStudentService {
    void insertStudent(Student newStudent);
    void editStudent(Student newStudent);
    void deleteById(String id);
    List<Student> getAll();
    List<Student> findByAddress(String address);
    Student findbyStudentId(String studentId);
}
