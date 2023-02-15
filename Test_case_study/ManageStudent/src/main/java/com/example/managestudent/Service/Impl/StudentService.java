package com.example.managestudent.Service.Impl;

import com.example.managestudent.Repository.IStudentRepo;
import com.example.managestudent.Repository.impl.StudentRepo;
import com.example.managestudent.Service.IStudentService;
import com.example.managestudent.model.Student;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepo studentRepo = new StudentRepo();

    @Override
    public void insertStudent(Student newStudent) {
        this.studentRepo.add(newStudent);
    }

    @Override
    public void editStudent(Student newStudent) {
        this.studentRepo.update(newStudent);
    }

    @Override
    public void deleteById(String id) {
        this.studentRepo.deleteByID(id);
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepo.getAll();
    }

    @Override
    public List<Student> findByAddress(String address) {
        return this.studentRepo.findByAddress(address);
    }

    @Override
    public Student findbyStudentId(String studentId) {
        return this.studentRepo.findById(studentId);
    }
}
