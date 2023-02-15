package com.example.managestudent.Repository;

import com.example.managestudent.model.Result;

import java.util.List;

public interface  IResultRepo {
    void add(Result newResult);
    void update(Result newResult);
    void delete(String id,int semester);
    List<Result> getAll();
    List<Result> findById(String id);
}
