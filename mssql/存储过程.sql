

alter procedure usp_add
@number1 int = 100,
@number2 int = 200,
@sum int output
as 
begin 
set @sum=@number1+@number2
print @sum
end 

declare @number int
execute usp_add 3,5,@number
print @number
