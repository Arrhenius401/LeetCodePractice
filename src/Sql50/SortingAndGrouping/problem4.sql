-- 表: Courses
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | student     | varchar |
-- | class       | varchar |
-- +-------------+---------+
-- (student, class)是该表的主键（不同值的列的组合）。
-- 该表的每一行表示学生的名字和他们注册的班级。
--
--
-- 查询 至少有 5 个学生 的所有班级。
--
-- 以 任意顺序 返回结果表

SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(*) >= 5;

-- 在 SQL 中，GROUP BY必须写在HAVING之前，和执行顺序一样