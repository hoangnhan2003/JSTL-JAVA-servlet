CREATE DATABASE quanLiBanHang;
USE quanLiBanHang;
CREATE TABLE customer(
    cID INT PRIMARY KEY AUTO_INCREMENT,
    cName nvarchar(30),
    cAge INT 
);  
CREATE TABLE `order` (
    o_ID int PRIMARY KEY auto_increment,
    cID int not null ,
    oDate DATE ,
    totalPrice FLOAT ,
    foreign key (cID) REFERENCES customer(cID)
);
CREATE TABLE product (
    pID int PRIMARY KEY AUTO_INCREMENT,
    pName nvarchar(40),
    pPrice FLOAT
);
CREATE TABLE OderDetails(
    o_ID int not null,
    pID int not null,
    odQTY int not null,
    foreign key (o_ID) REFERENCES `order`(o_ID),
    foreign key (pID) REFERENCES product(pID)
);
ALTER TABLE OderDetails ADD PRIMARY KEY (o_ID,pID);

select O.o_ID,O.oDate,P.pPrice 
from oderdetails OS,`order` O , product P
where (OS.o_ID = O.o_ID)
	and(OS.pID = P.pID);
    

select C.cID,C.cname,C.cAge,P.pID,P.pName,Pprice
from customer C,`order` O,OderDetails OD,product P
where (C.cID = O.cID)
	and(O.o_ID = OD.o_ID)
    and(OD.pID = P.pID);
Select * from customer
where  customer.cID = (
select C.cID
from customer C
where true except Select C.cID
from `order` O ,customer C
where (O.cID = C.cID)
);
use quanlibanhang;
select O.o_ID,O.oDate,P.Pprice * OD.odQTY as thanhtien
from product P , OderDetails OD ,`order` O
where (OD.pID = P.pID)
	and(OD.o_ID = O.o_ID)