-- 1. 创建游标
declare mycursor cursor Fast_Forward for select * from T_Student
-- 2. 打开游标
open mycursor
-- 3. 使用游标
Fetch Next from mycursor
while (@@FETCH_STATUS=0)
begin
	-- 处理数据
	Fetch Next from mycursor
end 
-- 4. 关闭游标
close mycursor 
-- 5. 释放资源
deallocate mycursor 
