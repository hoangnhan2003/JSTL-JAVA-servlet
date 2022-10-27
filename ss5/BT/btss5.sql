create database BTViewIndexStore;
use BTViewIndexStore;
create table Product (
	id int primary key,
    productCode int unique,
    productName varchar(40),
    productAmount int ,
    productDescription varchar(50),
    productStatus bit
);
insert into product 
values 
	   (2,2,'iphone8',4,'yellow',1),
	   (3,3,'iphone',5,'blue',1),
		(4,4,'iphone11',7,'blue',1),
		(5,5,'iphone12',10,'blue',1);
alter table product add column productPrice float; 
create unique index productCode_index on product(productCode);
create index index_name_price on product (productName,productPrice);
explain select productName 
from product 
where productName = 'iphone12';

create view viewProduct as 
select productCode, productName, productPrice, productStatus 
from product ; 
select *
from viewProduct;
alter view viewProduct as
	select productCode, productName, productPrice, productDescription,productStatus 
from product ;
drop view viewProduct;

drop procedure getInfoAll;
delimiter //
create procedure getInfoAll ()
begin
select * 
from product;
end //
delimiter ;
call getInfoAll ;
delimiter // 
create procedure inserProduct()


