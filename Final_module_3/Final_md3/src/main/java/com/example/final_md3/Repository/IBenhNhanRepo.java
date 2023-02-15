package com.example.final_md3.Repository;

import com.example.final_md3.model.BenhAn;
import com.example.final_md3.model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepo {
    void insert(BenhNhan benhNhan);
    void update(BenhNhan benhNhan);
    void deleteById(String id,String maBenhAn);
    BenhNhan findById(String maBenhNhan,String maBenhAn);
    List<BenhNhan> getAll();
    BenhAn getBenhAn(String maBenhAn);

}
