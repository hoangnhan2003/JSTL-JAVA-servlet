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
