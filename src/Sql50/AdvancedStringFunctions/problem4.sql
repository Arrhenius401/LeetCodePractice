-- Employee 表：
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | salary      | int  |
-- +-------------+------+
-- id 是这个表的主键。
-- 表的每一行包含员工的工资信息。
--
--
-- 查询并返回 Employee 表中第二高的 不同 薪水 。如果不存在第二高的薪水，查询应该返回 null(Pandas 则返回 None) 。

SELECT (CASE WHEN COUNT(*) = 0 THEN NULL ELSE salary END) AS SecondHighestSalary
FROM (
    SELECT *, DENSE_RANK() OVER(ORDER BY salary DESC) AS salary_rank
    FROM Employee
     ) AS t1
WHERE salary_rank = 2;