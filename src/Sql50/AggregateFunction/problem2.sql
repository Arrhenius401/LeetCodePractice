-- 表：Prices
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | start_date    | date    |
-- | end_date      | date    |
-- | price         | int     |
-- +---------------+---------+
-- (product_id，start_date，end_date) 是 prices 表的主键（具有唯一值的列的组合）。
-- prices 表的每一行表示的是某个产品在一段时期内的价格。
-- 每个产品的对应时间段是不会重叠的，这也意味着同一个产品的价格时段不会出现交叉。
--
--
-- 表：UnitsSold
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | purchase_date | date    |
-- | units         | int     |
-- +---------------+---------+
-- 该表可能包含重复数据。
-- 该表的每一行表示的是每种产品的出售日期，单位和产品 id。

SELECT p.product_id, IFNULL(ROUND(SUM(u.units * p.price) / SUM(u.units), 2), 0) AS average_price
FROM Prices p LEFT JOIN UnitsSold u ON p.product_id = u.product_id AND u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;

-- 把日期关联起来，用 BETWEEN AND