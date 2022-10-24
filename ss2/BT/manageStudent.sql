create table Student(
id int primary key,
 `name` nvarchar(30),
 age int 
 );
 create table Teacher (
id int primary key,
 `name` nvarchar(30),
 age int ,
 country nvarchar(30)
 );

 create table subject(
	subID int not null,
    subName nvarchar(20),
    Credit tinyint ,
    `status` bit not null
 );

 create table Mark(
	MarkID int not null,
    subID int ,
    StudentID int ,
    mark tinyint,
    examTimes tinyint
 );

create table class(
	ClassID int primary key ,
    ClassName nvarchar(20),
    startDate date,
    `status` bit);
alter table`subject`  add primary key(subID);
alter table mark add primary key(MarkID);

alter table mark add foreign key(subID) references subject(subID);
alter table mark add foreign key(StudentID) references student(id);

insert into subject 

values(1,'physical',5,1),
(2,'math',4,0),
(3,'history',3,0);

		(4,'A0622i1',2022-05-28,0);
delete from class where classID < 4;

insert into class 
values (1,'21TCLC_DT2','2021-09-21',0),
(2,'A0522i1','2022-05-28',1);
use student;
insert into class 
values (3,'22TCLC_DT2','2022-09-21',0)

    