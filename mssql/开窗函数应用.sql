-- ��һ���÷�����ÿһ�в���ۺϺ���
select [Subject],avg(isnull(score,0)) over() as ƽ���� from T_Score
-- �ڶ����÷�����ÿ������ʹ�þۺϺ���
select [Subject],Score,avg(isnull(score,0)) over(partition by Subject) as �ÿƳɼ�ƽ���� from T_Score
-- �������÷�������
select row_number() over(order by score asc),* from T_Score

