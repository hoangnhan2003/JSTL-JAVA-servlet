use student ;
select S.address ,  count(S.ID) as 'số lượng sinh viện'
from studenttable S
group by S.address;

select S.ID,S.name ,S.classID, avg(M.mark) as AvgMark
from studenttable S join  Mark M on S.ID = M.studentID
group by S.ID;

-- select student have a highest average mark
select * from studenttable , Mark
where studenttable.name in (
select S.ID,S.name ,S.classID, avg(M.mark) as AvgMark
from studenttable S join  Mark M on S.ID = M.studentID
group by S.ID
having max(AvgMark)
);

-- select student have a highest average mark
select S.ID,S.name ,S.classID, avg(M.mark) as AvgMark
from studenttable S join  Mark M on S.ID = M.studentID
group by S.ID
having AvgMark >= all (
select avg(M.mark) as AvgMark
from  Mark M 
group by M.studentID
);
Select * from subject S
where S.Credit = (
select max(S.Credit)
from subject S);

Select S.subID,S.subName,S.Credit,S.status,max(M.mark)
from mark M join subject S on M.subID = S.subID
group by M.subID;
select ST.id,ST.name,ST.age,ST.address,ST.age,ST.classID ,avg(M.mark) as AvgMark
from mark M join subject S on M.subID = S.subID join studenttable ST on ST.ID = M.StudentID
group by M.StudentID
order by AvgMark desc


