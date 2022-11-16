
create table service (
	SCode int primary key,
    SName varchar(40),
    AreaRoom int,
    fee float,
    maxPerson int,
    typeRent int,
    typeSCode int,
    qulifiedRoom int,
    desciption text,
    poolArea float,
    amountOfFloor int
);
create table typeRent(
	typeRent int primary key,
    nameRent varchar(50)
);
create table serviceType(
	Scode int primary key,
    SName varchar(50)
);
create table accomService(
	DContractCode int primary key,
    accSerName varchar(40),
    price float,
    unit varchar(10),
    status varchar(45)
);
create table type_service(
	typeSerCode int primary key ,
    typeSerName varchar(40)
);
select * from customer where customer.CName like  "T%" or customer.CName like "%H";
select  *
from customer C
where year(now()) - year(C.bornDate) between 18 and 50 and C.address like '%Quang Binh';
use furamaresort;
drop table `employee`;
alter table `employee` add foreign key (levelCode) references level(levelCode);
alter table `employee` add foreign key (posCode) references pos(posCode);
alter table `employee` add foreign key (departmentCode) references department(DCode);
alter table `employee` add column email VARCHAR(45);
alter table type_customer add primary key (typeCustomerCode);
alter table customer add foreign key (typeCustomerCode) references type_customer(typeCustomerCode);
alter table contract add foreign key (CCode) references customer(customerCode);
alter table contract add foreign key (ECode) references employee(ECode);
alter table contract add foreign key (ServiceCode) references service(Scode);
alter table service add foreign key (typeSCode) references type_service(typeSerCode);
alter table service add foreign key (typeRent) references typeRent(typeRent);
alter table service change typeRent typeRentCode int;
alter table typeRent change typeRent typeRentCode int;
create table detail_contract (
	DCCode int primary key,
    CCode int ,
    AccomSCode int,
    amount int,
	foreign key (CCode) references contract(contractCode),
	foreign key (AccomSCode) references contract(contractCode)
);
alter table detail_contract drop constraint detail_contract_ibfk_2;
alter table accomservice change DContractCode AccomSCode int;
alter table detail_contract add foreign key (AccomSCode) references accomservice(AccomSCode);

-- Vị Trí --
INSERT INTO pos
VALUES 	(1, 'Giám đốc'), 
		(2, 'Quản Lý'),
		(3, 'Giám Sát'),
		(4, 'Chuyên Viên'),
		(5, 'Phục Vụ'),
		(6, 'Lễ Tân');
        
-- Trình Độ --
INSERT INTO `level`
VALUES 	(1,'Trung Cấp'),
		(2,'Cao Đẳng'),
        (3,'Đại Học'),
        (4,'Sau Đại Học');
        
-- Bộ Phận --        
INSERT INTO department
VALUES 	(1,'Sale-Marketing'),
		(2,'Hành Chính'),
		(3,'Phục Vụ'),
		(4,'Quản Lý');
        
-- Nhân Viên --        
INSERT INTO employee(ECode,EName,bornDate,ID,salary,numberPhone,email,address,posCode,levelCode,departmentCode)
VALUES  (1, 'Nguyễn Ngọc Trung Bảo', '2003-6-25', '206493602', 1000, '0389056171', 'baokx2k3@gmail.com', 'Thăng Bình', 1, 4, 4 ),
		(2, 'Nguyễn Ngọc Huy Bảo', '2003-6-25', '206493603', 800, '0329002453', 'hbkx22kx3@gmail.com', 'Thăng Bình', 3, 2, 1 ),
        (3, 'Huỳnh Văn Nam', '2003-3-10', '206493154', 1000, '0321724124', 'namhuynh@gmail.com', 'Thăng Bình', 2, 1, 4 ),
        (4, 'Phạm Nguyễn Trường Tín', '2003-5-12', '206412171', 900, '0312388242', 'tinpham@gmail.com', 'Núi Thành', 4, 1, 2 ),
		(5, 'Võ Nguyễn Phát', '2003-6-19', '206492131', 1100, '0312324912', 'phatvo@gmail.com', 'Nông Sơn', 1, 3, 4 ),
		(6, 'Dương Tấn Tài', '2003-2-12', '206437123', 500, '0342417234', 'taiduong@gmail.com', 'Duy Xuyên', 6, 1, 1 ),
		(7, 'Trần Công Nhật', '2003-11-8', '206812337', 650, '0981234412', 'nhattran@gmail.com', 'Phú Ninh', 5, 2, 3 ),
		(8, 'Nguyễn Đức Việt', '2003-4-12', '206781231', 480, '0931231284', 'vietnguyen@gmail.com', 'Thăng Bình', 6, 1, 4 ),
		(9, 'Ngô Ngọc Huy', '2003-9-11', '206152351', 700, '09137127312', 'huyngo@gmail.com', 'Núi Thành', 3, 1, 4 ),
		(10, 'Kiều Nhật Tân', '2003-10-12', '206812312', 800, '0313192412', 'tankieu@gmail.com', 'Thăng Bình', 4, 2, 4 ),
		(11, 'Phạm Thị Thuý Hằng', '2003-5-24', '206123144', 800, '0283183211', 'hangpham@gmail.com', 'Thăng Bình', 5, 2, 3);
        
-- Loại Khách --
INSERT INTO type_customer(typeCustomerCode,nameTC)
VALUES  (1,'Diamond'),
		(2,'Platinium'),
		(3,'Gold'),
		(4,'Silver'),
		(5,'Member');
        
-- Khách Hàng --   
delete from customer where customerCode > 0;     
INSERT INTO customer(customerCode,CName,bornDate,sex,ID,numberPhone,email,address,typeCustomerCode)
VALUES 	 
         (5,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
         (6,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
         (7,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
         (8,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
         (9,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1);

-- Hợp Đồng --          
INSERT INTO contract(contractCode,contractDate,contractEndDate,deposit,ECode,CCode,ServiceCode)
VALUES  -- (1,'2020-12-08','2020-12-08',0,3,1,3),
-- 		(2,'2020-07-14','2020-07-21',200000,7,3,1),
-- 		(3,'2021-03-15','2021-03-17',50000,3,4,2),
-- 		(4,'2021-01-14','2021-01-18',100000,7,5,5),
		(5,'2021-07-14','2021-07-15',0,7,2,6),
		(6,'2021-06-01','2021-06-03',0,7,7,6),
		(7,'2021-09-02','2021-09-05',100000,7,4,4),
		(8,'2021-06-17','2021-06-18',150000,3,4,1),
		(9,'2020-11-19','2020-11-19',0,3,4,3);
		(10,'2021-04-12','2021-04-14',0,10,3,5),
		(11,'2021-04-25','2021-04-25',0,2,2,1),
		(12,'2021-05-25','2021-05-27',0,7,8,1);

-- Hợp Đồng Chi Tiết --        
INSERT INTO detail_contract(DCCode,amount,CCode,AccomSCode)
VALUES  (1,5,2,4),
		(2,8,2,5),
		(3,15,2,6),
		(4,1,3,1),
		(5,11,3,2),
		(6,1,1,3),
		(7,2,1,2),
		(8,2,1,2);

-- Dịch Vụ Đi Kèm --        
INSERT INTO accomservice(AccomSCode,accSerName,price,unit,`status`)
VALUES  (1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),
		(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
		(3,'Thuê xe đạp',20000,'chiếc','tốt'),
		(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
		(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
		(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');



-- Kiểu Thuê --        
INSERT INTO `furamaresort`.`typerent` (`typeRentCode`, `nameRent`) VALUES ('1', 'Year');
INSERT INTO `furamaresort`.`typerent` (`typeRentCode`, `nameRent`) VALUES ('2', 'Month');
INSERT INTO `furamaresort`.`typerent` (`typeRentCode`, `nameRent`) VALUES ('3', 'Date');
INSERT INTO `furamaresort`.`typerent` (`typeRentCode`, `nameRent`) VALUES ('4', 'Hour');

-- Dịch Vụ --       
INSERT INTO service(SCode,SName,AreaRoom,fee,maxPerson,qulifiedRoom,desciption,poolArea,amountOfFloor,typeRentCode,typeSCode)
VALUES  (1,'Villa Beach Front',25000,10000000,10,1,'Có hồ bơi',500,4,3,1),
		(2,'House Princess 01',14000,5000000,7,2,'Có thêm bếp nướng',NULL,3,2,2),
		(3,'Room Twin 01',5000,1000000,2,3,'Có tivi',NULL,NULL,4,3),
		(4,'Villa No Beach Front',22000,9000000,8,4,'Có hồ bơi',300,3,3,1),
		(5,'House Princess 02',10000,4000000,5,1,'Có thêm bếp nướng',NULL,2,3,2),
		(6,'Room Twin 02',3000,900000,2,1,'Có tivi',NULL,NULL,4,3);

UPDATE `furamaresort`.`service` SET `qulifiedRoom` = '1' WHERE (`SCode` = '1');
UPDATE `furamaresort`.`service` SET `qulifiedRoom` = '2', `poolArea` = '300' WHERE (`SCode` = '2');
UPDATE `furamaresort`.`service` SET `qulifiedRoom` = '3', `poolArea` = '200', `amountOfFloor` = '3' WHERE (`SCode` = '3');
UPDATE `furamaresort`.`service` SET `qulifiedRoom` = '4' WHERE (`SCode` = '4');
UPDATE `furamaresort`.`service` SET `qulifiedRoom` = '1', `poolArea` = '100' WHERE (`SCode` = '5');
UPDATE `furamaresort`.`service` SET `qulifiedRoom` = '2', `poolArea` = '100', `amountOfFloor` = '4' WHERE (`SCode` = '6');
-- update contract--
UPDATE `furamaresort`.`contract` SET `contractDate` = '2020-05-14', `contractEndDate` = '2021-03-13', `deposit` = '150000', `ECode` = '2', `ServiceCode` = '2' WHERE (`contractCode` = '1');
UPDATE `furamaresort`.`contract` SET `contractDate` = '2020-06-12', `contractEndDate` = '2020-10-06', `deposit` = '412300', `ECode` = '4', `ServiceCode` = '3' WHERE (`contractCode` = '2');
UPDATE `furamaresort`.`contract` SET `contractDate` = '2020-04-11', `contractEndDate` = '2020-06-30', `deposit` = '435000', `ECode` = '1', `ServiceCode` = '1' WHERE (`contractCode` = '3');
UPDATE `furamaresort`.`contract` SET `contractDate` = '2020-05-12', `contractEndDate` = '2022-04-23', `deposit` = '124400', `ECode` = '2', `ServiceCode` = '6' WHERE (`contractCode` = '4');
alter table type_service rename to service_type;
use furamaresort;
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.

select * from customer
where (customer.Cname like 'T%' or customer.Cname like 'H%' or customer.Cname like 'K%')
		and length(C.Cname) < 15;
        
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select C.*    
from customer C
where (YEAR(CURDATE()) - year(C.bornDate) > 18 and YEAR(CURDATE()) - year(C.bornDate) < 30)
	and (C.address like '%Quang binh' or C.address like '%Quang Tri' or C.address like '%Đà Nẵng');

--  Select Khách hàng và hợp đồng, số lần khách hàng tạo hợp đồng và hiển thị tăng dần theo số lần lập hợp đồng 
-- của khách hàng 
Select CT.*,C.CName,C.typeCustomerCode, count(contractCode) as timesRent 
from customer C join contract CT on C.customerCode = CT.CCode
-- where C.typeCustomerCode = 4
group by CT.CCode 
having timesRent > 0
order by timesRent;

select *
from customer C join contract CT join service S
	on C.customerCode = CT.CCode  on CT.serviceCode = S.Scode;
    
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các
--  loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3
select S.SCode,S.SName,S.AreaRoom,S.fee,ST.typeSerName
from customer C join contract CT on C.customerCode = CT.CCode
join service S  on CT.serviceCode = S.Scode
join service_type ST on S.typeSCode = ST.typeSerCode
where CT.contractCode not in (
					   select CT1.contractCode from contract CT1
                       where CT1.ContractDate > '2021-01-01' and CT1.ContractDate < '2021-03-31' 
);
	 
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select distinct(C.Cname) from customer C;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021
--  thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(CT.contractDate) as 'tháng',count(CT.contractCode) as 'số hợp đồng' from contract CT
where CT.contractDate > '2021-01-01' and CT.contractDate < '2021-12-31'
group by month(CT.contractDate);

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
use furamaresort;
create view viewAttachSer as
		select DCT.accomScode , count(DCT.AccomSCode) as times
		from detail_contract DCT
		group by DCT.AccomScode;
-- tạo view hiển thị Mã dvu đính kèm và số lần sử dụng dvu dinh kem
        
select *
from attachSer ATS
where ATS.accomScode in (
						select accomScode  -- lay ra code cua dvu co so lan su dung nhieu nhat
						from viewAttachSer
						where times = (
									select max(times) -- lay ra so lan su dung nhieu nhat
									from viewAttachSer
									   )
							)
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).

select DCT.contractCode , S.SName, accSerName,viewATS.times 
from detail_contract DCT 
join contract CT on DCT.contractCode = CT.contractCode
join service S on CT.serviceCode = S.SCode
join attachSer ATS on ATS.accomSCode = DCT.accomScode
join viewAttachSer viewATS on DCT.accomScode = viewATS.accomScode
where DCT.accomScode in (
						select accomSCode  
						from viewAttachSer
						where times =1
);

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

create view E_numbersOfCT as
select CT.ECode , count(CT.contractCode) as amountOfCT
from contract CT
where CT.contractDate > '2020-01-01' and CT.contractDate < '2021-12-31'
group by CT.ECode ;

select E.ECode,E.EName,P.PosName,D.DName,E.numberPhone,E.address,ECT.amountOfCT
from E_numbersOfCT ECT 
join employee E on ECT.ECode = E.Ecode
join pos P on P.PosCode = E.posCode 
join department D on D.DCode= E.departmentCode
where ECT.amountOfCT < 3;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from employee E1 where E1.ECode in ( 
											Select distinct(E.ECode) -- lay ra codeNV khong co 
											from employee E left join contract CT on CT.ECode = E.Ecode
											where E.ECode not in (
																select CT.ECode from contract CT
																where CT.contractDate > '2019-01-01' and CT.contractDate < '2021-12-31'
											)
											);
                                            
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
	delete from customer
    where customer.customerCode in (
								select C.customerCode from customer C
                                where C.contractDate < '2021-01-01'
    );


-- select CT.*,DateDIFF(CT.contractEndDate,CT.contractDate) as numOfDate                                        
-- from contract CT;

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
use furamaresort;
select C.customerCode as E_C_code,C.CName as `name`,C.email,C.numberPhone,C.bornDate,C.address
from customer C 
union
select E.ECode,E.EName,E.email,E.numberPhone,E.bornDate,E.address
from employee E

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 3 lần trong năm 2020,2021 lên gấp đôi.

create view viewTimesAtSer as
		select DCT.accomScode , count(DCT.AccomSCode) as times
		from detail_contract DCT 
        join contract CT on DCT.contractCode = CT.contractCode
        where CT.contractDate > '2020-01-01' and CT.contractDate < '2021-12-31'
		group by DCT.AccomScode
        ;
set sql_safe_updates =0;
update attachSer
set price = price*2
where accomSCode in(
					select accomSCode 
					from viewTimesAtSer
					where times > 2
				);
-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
drop view v_nhanvien;
create view v_nhanvien as
	select E.* 
    from employee E 
    join contract C on E.Ecode = C.Ecode
    where E.address like '%Hải Châu%' and C.contractDate = '2019-12-12';

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả 
-- các nhân viên được nhìn thấy bởi khung nhìn này.
select * from v_nhanvien;
update  employee E
set E.address = 'Liên Chiểu'
where E.Ecode in (
					select V.Ecode from v_nhanvien V
       
);
-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó
--  với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
delimiter //
create procedure sp_xoa_khach_hang(id int)
begin 
delete from customer C where C.customerCode = id;
end //
delimiter ;



