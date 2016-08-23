

create table T_Work
(
	ID uniqueidentifier primary key,									-- ����Լ��
	Name nvarchar(10) not null,											-- �ǿ�Լ��
	Sex nchar(1) constraint DE_Person_Sex default (N'��'),				-- Ĭ��Լ��
	Age int constraint CK_Person_Age check (Age>=10 and Age <=90),		-- ���Լ��
	WorkNumber int 
		constraint CK_Person_Number check (WorkNumber>0 and WorkNumber < 10000)
		constraint DE_Person_Number default (100)
)

alter table T_Work add constraint CK_Person_Sex check (Sex=N'��' or Sex=N'Ů')		-- ��Ӽ��Լ��

/*
	�������Լ��
	alter table T_Work add
		constraint DE_Person_Sex default (N'��') for Sex,
		constraint CK_Person_Age check (Age>=20 and Age<=90)
	����ɾ��Լ��
	alter table T_Work drop
		constraint DE_Person_Sex,
		constraint CK_Person_Age

*/

-- ���Լ��
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
		constraint FK_Score_Student_ID_Score_PersonID foreign key (PersonID) references T_Person(ID)	-- ���Լ��
) 
alter table T_Score add constraint CK_Score_Subject check ([Subject]=N'����' or [Subject]=N'��ѧ' or [Subject]=N'Ӣ��')



insert into T_Person(ID,Name) values (newid(),N'��С˫')
insert into T_Person(ID,Name) values (newid(),N'����')
insert into T_Person(ID,Name) values (newid(),N'����Ȼ')

insert into T_Score(ID,Score,PersonID,[Subject]) values(lower(newid()),100,'6BAF1635-BFD4-4AA9-B869-FF3C61E320E52',N'Ӣ��')

select * from T_Score

select * from T_Person

select top 10 percent * from T_Person

select * into T_New_Person from T_Person


select * from T_New_Person

insert into T_New_Person select * from T_Person

update T_New_Person set Remark=null where Name='��С˫'

select count(Remark) from T_New_Person








