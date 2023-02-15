package com.example.managestudent.Service;

import com.example.managestudent.model.Result;

import java.util.List;

public interface IResultService {
    void insertNewResult(Result newResult);
    void editResult(Result newResult);
    void deleteResult(String studentId,int semester);
    List<Result> getAll();
    List<Result> findById(String id);
}
