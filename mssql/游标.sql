-- 1. �����α�
declare mycursor cursor Fast_Forward for select * from T_Student
-- 2. ���α�
open mycursor
-- 3. ʹ���α�
Fetch Next from mycursor
while (@@FETCH_STATUS=0)
begin
	-- ��������
	Fetch Next from mycursor
end 
-- 4. �ر��α�
close mycursor 
-- 5. �ͷ���Դ
deallocate mycursor 
