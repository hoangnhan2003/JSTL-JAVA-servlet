package com.example.managestudent.Repository.impl;

import com.example.managestudent.Repository.IResultRepo;
import com.example.managestudent.model.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultRepo implements IResultRepo {
    public static final String UPDATE_RESULT = "UPDATE `managestudent`.`result` SET `result` = ? WHERE (`studentId` = ?) and (`semester` = ?);";
    public static final String SELECT_RESULT = "SELECT * FROM result";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public void add(Result newResult) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `managestudent`.`result` (`studentId`, `semester`, `result`) VALUES (?, ?, ?);");
            preparedStatement.setString(1, newResult.getStudentId());
            preparedStatement.setInt(1,newResult.getSemester());
            preparedStatement.setDouble(3,newResult.getResult());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Result newResult) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESULT);
            preparedStatement.setDouble(1,newResult.getResult());
            preparedStatement.setString(2,newResult.getStudentId());
            preparedStatement.setInt(3,newResult.getSemester());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String id,int semester) {
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM result WHERE studentId = ? and semester = ?");
            preparedStatement.setString(1,id);
            preparedStatement.setInt(2,semester);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Result> getAll() {
        List<Result> resultList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESULT);
            ResultSet resultSet = preparedStatement.executeQuery();
            Result newResult;
            while(resultSet.next()){
                String studentId = resultSet.getString("studentId");
                int semester = resultSet.getInt("semester");
                double result = resultSet.getDouble("result");
                newResult = new Result(studentId,semester,result);
                resultList.add(newResult);
            }
            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Result> findById(String id) {
        List<Result> resultList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM result WHERE studentId = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Result newResult;
            while(resultSet.next()){
                String studentId = resultSet.getString("studentId");
                int semester = resultSet.getInt("semester");
                double result = resultSet.getDouble("result");
                newResult = new Result(studentId,semester,result);
                resultList.add(newResult);
            }
            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
