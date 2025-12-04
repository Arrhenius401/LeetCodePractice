-- 表：Transactions
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | country       | varchar |
-- | state         | enum    |
-- | amount        | int     |
-- | trans_date    | date    |
-- +---------------+---------+
-- id 是这个表的主键。
-- 该表包含有关传入事务的信息。
-- state 列类型为 ["approved", "declined"] 之一。
--
--
-- 编写一个 sql 查询来查找每个月和每个国家/地区的事务数及其总金额、已批准的事务数及其总金额。
--
-- 以 任意顺序 返回结果表。

SELECT SUBSTRING(t.trans_date, 1, 7) AS month, t.country, COUNT(*) AS trans_count, SUM(CASE WHEN t.state = "approved" THEN 1 ELSE 0 END) AS approved_count,
       SUM(t.amount) AS trans_total_amount, SUM(CASE WHEN t.state = "approved" THEN t.amount ELSE 0 END) AS approved_total_amount
FROM Transactions t
GROUP BY SUBSTRING(t.trans_date, 1, 7), t.country;

-- 标准 SQL 语句的执行顺序
-- FROM -> WHERE -> GROUP BY -> 聚合函数 -> HAVING -> SELECT -> DISTINCT -> ORDER BY -> LIMIT 的执行顺序

-- 主流数据库中有 substring() 方法，但因早期面向非编程人员，索引从 1 开始
-- MySQL 中的 substring() 方法
-- -- 写法1：从 pos 位置（1起始）截取到末尾（对应 Java substring(beginIndex)）
-- SUBSTRING(str, pos)
-- -- 写法2：从 pos 位置截取 length 个字符（对应 Java substring(begin, end)，length = end - begin）
-- SUBSTRING(str, pos, length)
--
-- -- 简写：SUBSTR 和 SUBSTRING 完全一样
-- SUBSTR(str, pos)
-- SUBSTR(str, pos, length)