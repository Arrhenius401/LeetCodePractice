-- 表: Products
--
-- +------------------+---------+
-- | Column Name      | Type    |
-- +------------------+---------+
-- | product_id       | int     |
-- | product_name     | varchar |
-- | product_category | varchar |
-- +------------------+---------+
-- product_id 是该表主键(具有唯一值的列)。
-- 该表包含该公司产品的数据。
--
--
-- 表: Orders
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | order_date    | date    |
-- | unit          | int     |
-- +---------------+---------+
-- 该表可能包含重复行。
-- product_id 是表单 Products 的外键（reference 列）。
-- unit 是在日期 order_date 内下单产品的数目。
--
--
-- 写一个解决方案，要求获取在 2020 年 2 月份下单的数量不少于 100 的产品的名字和数目。
--
-- 返回结果表单的 顺序无要求 。

SELECT p.product_name, SUM(o.unit) AS unit
FROM Products p JOIN Orders o ON p.product_id = o.product_id
WHERE SUBSTRING(o.order_date, 1, 7) = '2020-02'
GROUP BY p.product_id
HAVING SUM(o.unit) >= 100;