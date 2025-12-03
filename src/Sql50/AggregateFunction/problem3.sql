-- 项目表 Project：
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | project_id  | int     |
-- | employee_id | int     |
-- +-------------+---------+
-- 主键为 (project_id, employee_id)。
-- employee_id 是员工表 Employee 表的外键。
-- 这张表的每一行表示 employee_id 的员工正在 project_id 的项目上工作。
--
--
-- 员工表 Employee：
--
-- +------------------+---------+
-- | Column Name      | Type    |
-- +------------------+---------+
-- | employee_id      | int     |
-- | name             | varchar |
-- | experience_years | int     |
-- +------------------+---------+
-- 主键是 employee_id。数据保证 experience_years 非空。
-- 这张表的每一行包含一个员工的信息。
--
--
-- 请写一个 SQL 语句，查询每一个项目中员工的 平均 工作年限，精确到小数点后两位。
--
-- 以 任意 顺序返回结果表。

SELECT p.project_id, ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p LEFT JOIN Employee e ON p.employee_id = e.employee_id
GROUP BY p.project_id;

-- 如果Employee表也存在project_id字段（虽然业务逻辑上不合理），第二段代码会报错（字段歧义），而第一段代码仍能正常运行 —— 这是显式指定表别名的核心优势。