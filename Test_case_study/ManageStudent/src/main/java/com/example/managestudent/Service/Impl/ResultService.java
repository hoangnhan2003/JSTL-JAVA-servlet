package com.example.managestudent.Service.Impl;

import com.example.managestudent.Repository.IResultRepo;
import com.example.managestudent.Repository.impl.ResultRepo;
import com.example.managestudent.Service.IResultService;
import com.example.managestudent.model.Result;

import java.util.List;

public class ResultService implements IResultService {
    IResultRepo resultRepo = new ResultRepo();

    @Override
    public void insertNewResult(Result newResult) {
        this.resultRepo.add(newResult);
    }

    @Override
    public void editResult(Result newResult) {
        this.resultRepo.update(newResult);
    }

    @Override
    public void deleteResult(String studentId, int semester) {
        this.resultRepo.delete(studentId,semester);
    }

    @Override
    public List<Result> getAll() {
        return this.resultRepo.getAll();
    }

    @Override
    public List<Result> findById(String id) {
        return this.resultRepo.findById(id);
    }
}
