

create table T_Work
(
	ID uniqueidentifier primary key,									-- 主键约束
	Name nvarchar(10) not null,											-- 非空约束
	Sex nchar(1) constraint DE_Person_Sex default (N'男'),				-- 默认约束
	Age int constraint CK_Person_Age check (Age>=10 and Age <=90),		-- 检查约束
	WorkNumber int 
		constraint CK_Person_Number check (WorkNumber>0 and WorkNumber < 10000)
		constraint DE_Person_Number default (100)
)

alter table T_Work add constraint CK_Person_Sex check (Sex=N'男' or Sex=N'女')		-- 添加检查约束

/*
	批量添加约束
	alter table T_Work add
		constraint DE_Person_Sex default (N'男') for Sex,
		constraint CK_Person_Age check (Age>=20 and Age<=90)
	批量删除约束
	alter table T_Work drop
		constraint DE_Person_Sex,
		constraint CK_Person_Age

*/

-- 外键约束
create table T_Person
(
	ID uniqueidentifier primary key,
	Name nvarchar(10) not null,
	Age int not null 
		constraint CK_Person_TAge check (Age>=20 and Age<=100)
		constraint DE_Person_TAge default (20)
)

create table T_Score 
(
	ID uniqueidentifier primary key,
	Score decimal not null constraint CK_Person_Score check (Score>=0 and Score<=100),
	PersonID uniqueidentifier not null 
		constraint FK_Score_Student_ID_Score_PersonID foreign key (PersonID) references T_Person(ID)	-- 外键约束
) 
alter table T_Score add constraint CK_Score_Subject check ([Subject]=N'语文' or [Subject]=N'数学' or [Subject]=N'英语')



insert into T_Person(ID,Name) values (newid(),N'孙小双')
insert into T_Person(ID,Name) values (newid(),N'李娟娟')
insert into T_Person(ID,Name) values (newid(),N'李怡然')

insert into T_Score(ID,Score,PersonID,[Subject]) values(lower(newid()),100,'6BAF1635-BFD4-4AA9-B869-FF3C61E320E52',N'英语')

select * from T_Score

select * from T_Person

select top 10 percent * from T_Person

select * into T_New_Person from T_Person


select * from T_New_Person

insert into T_New_Person select * from T_Person

update T_New_Person set Remark=null where Name='孙小双'

select count(Remark) from T_New_Person








