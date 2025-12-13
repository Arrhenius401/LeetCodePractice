-- 表: Employees
--
-- +-------------+----------+
-- | Column Name | Type     |
-- +-------------+----------+
-- | employee_id | int      |
-- | name        | varchar  |
-- | manager_id  | int      |
-- | salary      | int      |
-- +-------------+----------+
-- 在 SQL 中，employee_id 是这个表的主键。
-- 这个表包含了员工，他们的薪水和上级经理的id。
-- 有一些员工没有上级经理（其 manager_id 是空值）。
--
--
-- 查找这些员工的id，他们的薪水严格少于$30000 并且他们的上级经理已离职。当一个经理离开公司时，他们的信息需要从员工表中删除掉，但是表中的员工的manager_id  这一列还是设置的离职经理的id 。
--
-- 返回的结果按照employee_id 从小到大排序。

SELECT employee_id
FROM Employees
WHERE
    salary < 30000 AND manager_id NOT IN (SELECT DISTINCT employee_id FROM Employees)
ORDER BY employee_id ASC;
