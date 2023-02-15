package com.example.final_md3.Service.impl;

import com.example.final_md3.Repository.IBenhNhanRepo;
import com.example.final_md3.Repository.impl.BenhNhanRepo;
import com.example.final_md3.Service.IBenhNhanService;
import com.example.final_md3.model.BenhAn;
import com.example.final_md3.model.BenhNhan;

import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    IBenhNhanRepo benhNhanRepo = new BenhNhanRepo();

    @Override
    public void insertBenhNhan(BenhNhan benhNhan) {
        this.benhNhanRepo.insert(benhNhan);
    }

    @Override
    public void updateBenhNhan(BenhNhan benhNhan) {
        this.benhNhanRepo.update(benhNhan);
    }

    @Override
    public void deleteByMaBenhNhan(String maBenhNhan,String maBenhAn) {
        this.benhNhanRepo.deleteById(maBenhNhan,maBenhAn);
    }

    @Override
    public List<BenhNhan> getAll() {
        return this.benhNhanRepo.getAll();
    }

    @Override
    public BenhNhan findByMaBenhNhan(String maBenhNhan,String maBenhAn) {
        return this.benhNhanRepo.findById(maBenhNhan,maBenhAn);
    }

    @Override
    public BenhAn getBenhAn(String maBenhAn) {
        return this.benhNhanRepo.getBenhAn(maBenhAn);
    }
}
