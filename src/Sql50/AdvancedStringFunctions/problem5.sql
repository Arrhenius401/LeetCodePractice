-- 表 Activities：
--
-- +-------------+---------+
-- | 列名         | 类型    |
-- +-------------+---------+
-- | sell_date   | date    |
-- | product     | varchar |
-- +-------------+---------+
-- 该表没有主键(具有唯一值的列)。它可能包含重复项。
-- 此表的每一行都包含产品名称和在市场上销售的日期。
--
--
-- 编写解决方案找出每个日期、销售的不同产品的数量及其名称。
-- 每个日期的销售产品名称应按词典序排列。
-- 返回按 sell_date 排序的结果表。
-- 结果表结果格式如下例所示。

SELECT sell_date, COUNT(DISTINCT (product)) AS num_sold, GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') AS products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date ASC

-- GROUP_CONCAT() 是 MySQL 特有的聚合函数（Oracle/SQL Server 无原生支持，需用其他方式模拟）
-- 核心作用是将分组后的多行字符串拼接成单行字符串，常用于 “一对多” 场景的结果汇总（比如一个用户的多个订单号、一个部门的所有员工姓名）。
--
-- GROUP_CONCAT([DISTINCT] 要拼接的字段/表达式
--              [ORDER BY 排序字段 ASC/DESC]
--              [SEPARATOR '分隔符']
--              [LIMIT 长度限制]  -- MySQL 8.0.19+支持
--             )