-- 第一种用法，对每一行补充聚合函数
select [Subject],avg(isnull(score,0)) over() as 平均分 from T_Score
-- 第二种用法，对每个分组使用聚合函数
select [Subject],Score,avg(isnull(score,0)) over(partition by Subject) as 该科成绩平均分 from T_Score
-- 第三种用法，排序
select row_number() over(order by score asc),* from T_Score

