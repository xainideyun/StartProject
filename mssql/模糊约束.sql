

alter table T_Person add constraint CK_Person_CardID check(CardID like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9Xx]')


insert into T_Person(ID,Name,Age,CardID) values(newid(),'–Ï¿⁄',29,'233432432324323243')
insert into T_Person(ID,Name,Age,CardID) values(newid(),'–Ï¿⁄',29,'23343243232413234x')

select * from T_Person

select * from T_Person where Name like 'ª®___' 

select * from T_Score
update T_Score set Score=null where [Subject]='”¢”Ô'



