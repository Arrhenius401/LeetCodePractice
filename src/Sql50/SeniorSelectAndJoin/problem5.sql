-- 产品数据表: Products
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | new_price     | int     |
-- | change_date   | date    |
-- +---------------+---------+
-- (product_id, change_date) 是此表的主键（具有唯一值的列组合）。
-- 这张表的每一行分别记录了 某产品 在某个日期 更改后 的新价格。
-- 一开始，所有产品价格都为 10。
--
-- 编写一个解决方案，找出在 2019-08-16 所有产品的价格。
--
-- 以 任意顺序 返回结果表。

SELECT DISTINCT i.product_id, (CASE WHEN p.new_price IS NULL THEN 10 ELSE new_price END) AS price
FROM (SELECT DISTINCT product_id FROM Products) AS i
    LEFT JOIN
    (SELECT product_id, new_price
     FROM Products
     WHERE (product_id, change_date)
     IN (SELECT product_id, MAX(change_date) FROM Products WHERE change_date <= "2019-08-16" GROUP BY product_id)) AS p
    ON i.product_id = p.product_id;
