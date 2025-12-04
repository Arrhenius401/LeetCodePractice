-- Queries 表：
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | query_name  | varchar |
-- | result      | varchar |
-- | position    | int     |
-- | rating      | int     |
-- +-------------+---------+
-- 此表可能有重复的行。
-- 此表包含了一些从数据库中收集的查询信息。
-- “位置”（position）列的值为 1 到 500 。
-- “评分”（rating）列的值为 1 到 5 。评分小于 3 的查询被定义为质量很差的查询。
--
--
-- 将查询结果的质量 quality 定义为：
--
-- 各查询结果的评分与其位置之间比率的平均值。
--
-- 将劣质查询百分比 poor_query_percentage 定义为：
--
-- 评分小于 3 的查询结果占全部查询结果的百分比。
--
-- 编写解决方案，找出每次的 query_name 、 quality 和 poor_query_percentage。
--
-- quality 和 poor_query_percentage 都应 四舍五入到小数点后两位 。
--
-- 以 任意顺序 返回结果表。

SELECT q.query_name, ROUND(AVG(q.rating / q.position), 2) AS quality, ROUND(SUM(CASE WHEN q.rating  < 3 THEN 1 ELSE 0 END) / COUNT(*) * 100, 2) AS poor_query_percentage
FROM Queries q
GROUP BY q.query_name;

-- 1. 简单 CASE 表达式（等值匹配）
-- CASE 表达式/字段
--   WHEN 取值1 THEN 结果1
--   WHEN 取值2 THEN 结果2
--   ...
--   [ELSE 默认结果]
-- END

-- 2.搜索 CASE 表达式（条件匹配）
-- CASE
--   WHEN 条件1 THEN 结果1
--   WHEN 条件2 THEN 结果2
--   ...
--   [ELSE 默认结果]
-- END