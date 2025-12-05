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
-- 1. FROM/JOIN：先确定查询的数据源（表 / 视图），执行表连接（JOIN）操作，生成临时中间表（包含所有关联数据）。
-- 2. WHERE：对 FROM/JOIN 生成的中间表进行行级筛选（过滤不满足条件的记录），只保留符合条件的行。
--          注意：WHERE 中不能使用 SELECT 后的别名（此时别名尚未定义）。
-- 3. GROUP BY：将 WHERE 筛选后的行按指定字段分组，每组聚合为一条记录。
-- 4. 聚合函数：SUM/COUNT/AVG等
-- 5. HAVING：对 GROUP BY 分组后的结果进行组级筛选（过滤不满足聚合条件的组）。
--          例：HAVING COUNT(*) > 1（只保留记录数大于 1 的组），只能用聚合函数 / 分组字段。
-- 6. WINDOW FUNCTION（窗口函数）：对分组后的结果执行窗口计算（如排名、累计求和），不改变记录行数。
-- 7. SELECT：筛选需要展示的字段（或聚合函数结果），并为字段指定别名（此时别名生效）。
-- 8. DISTINCT：对 SELECT 的结果去重（若指定该关键字）。
-- 9. ORDER BY：按指定字段对最终结果排序（升序 ASC / 降序 DESC），此时可使用 SELECT 的别名。
-- 10. LIMIT/OFFSET：限制返回的记录数（如分页查询），仅在最后执行。

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