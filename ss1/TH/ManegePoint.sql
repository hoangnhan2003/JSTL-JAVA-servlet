create database ManagePoint;
USE QuanLyDiemThi;
CREATE TABLE Hocsinh(
    maHs VARCHAR(20) PRIMARY KEY  ,
    tenHs VARCHAR(50),
    ngaysinh datetime,
    lop VARCHAR(20),
    gt VARCHAR(20)
);
CREATE TABLE monhoc(
    maMH VARCHAR(20) PRIMARY KEY ,
    tenMH VARCHAR(50)
);
CREATE TABLE BangDiem(
    maHs VARCHAR(20),
    maMH VARCHAR(20),
    diemThi INT,
    ngayKT datetime,
    PRIMARY KEY (maHs,maMH),
    FOREIGN KEY (maHs,maMH),
    FOREIGN kEY (maHs) REFERENCES Hocsinh(maHs),
    FOREIGN KEY(maMH) REFERENCES monhoc(maMH)
);
CREATE TABLE GiaoVien(
    maGV VARCHAR(20) PRIMARY KEY ,
    tenGv VARCHAR(30),
    sdt VARCHAR(10)
);
ALTER TABLE monhoc ADD maGV VARCHAR(20);
ALTER TABLE monhoc ADD CONSTRAINT Fk_maGV FOREIGN kEY(maGV) REFERENCES GiaoVien(maGV);