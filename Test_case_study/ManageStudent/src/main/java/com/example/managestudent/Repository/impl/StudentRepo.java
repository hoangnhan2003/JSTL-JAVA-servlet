package com.example.managestudent.Repository.impl;

import com.example.managestudent.Repository.IStudentRepo;
import com.example.managestudent.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    public static final String INSERT_STUDENT = "INSERT INTO `managestudent`.`student` (`studentID`, `Studentname`, `birthDate`, `Gender`, `address`) VALUES (?, ?, ?, ?, ?);";
    public static final String SELECT_STUDENT_BY_ADDRESS = "SELECT * FROM student WHERE address LIKE ?";
    public static final String SELECT_ALL_STUDENT = "SELECT * FROM student";
    public static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE studentId = ?";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public void add(Student newStudent) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setString(1, newStudent.getStudentId());
            preparedStatement.setString(2,newStudent.getStudentName());
            preparedStatement.setString(3, newStudent.getBirthDate());
            preparedStatement.setInt(4, newStudent.getGender());
            preparedStatement.setString(5, newStudent.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(String id) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student where studentId = ?");
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Student newStudent) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `managestudent`.`student` SET `Studentname` = ?, `birthDate` = ?, `Gender` = ?, `address` = ? WHERE (`studentID` = ?);");
            preparedStatement.setString(1,newStudent.getStudentName());
            preparedStatement.setString(2,newStudent.getBirthDate());
            preparedStatement.setInt(3, newStudent.getGender());
            preparedStatement.setString(4, newStudent.getAddress());
            preparedStatement.setString(5, newStudent.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Student> findByAddress(String address) {
        List<Student> studentList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ADDRESS);
            preparedStatement.setString(1,"%"+address+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while(resultSet.next()){
                String studentId = resultSet.getString("studentId");
                String studentName = resultSet.getString("studentName");
                String birthDate = resultSet.getString("birthDate");
                int genger = resultSet.getInt("gender");
                String addressX = resultSet.getString("address");
                student = new Student(studentId,studentName,birthDate,genger,addressX);
                studentList.add(student);

            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while(resultSet.next()){
                String studentId = resultSet.getString("studentId");
                String studentName = resultSet.getString("studentName");
                String birthDate = resultSet.getString("birthDate");
                int genger = resultSet.getInt("gender");
                String addressX = resultSet.getString("address");
                student = new Student(studentId,studentName,birthDate,genger,addressX);
                studentList.add(student);

            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(String studentId) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setString(1,studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String studentID = resultSet.getString("studentId");
                String studentName = resultSet.getString("studentName");
                String birthDate = resultSet.getString("birthDate");
                int gender = resultSet.getInt("gender");
                String address = resultSet.getString("address");
                Student student = new Student(studentID,studentName,birthDate,gender,address);
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
