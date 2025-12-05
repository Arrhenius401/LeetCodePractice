-- 配送表: Delivery
--
-- +-----------------------------+---------+
-- | Column Name                 | Type    |
-- +-----------------------------+---------+
-- | delivery_id                 | int     |
-- | customer_id                 | int     |
-- | order_date                  | date    |
-- | customer_pref_delivery_date | date    |
-- +-----------------------------+---------+
-- delivery_id 是该表中具有唯一值的列。
-- 该表保存着顾客的食物配送信息，顾客在某个日期下了订单，并指定了一个期望的配送日期（和下单日期相同或者在那之后）。
--
--
-- 如果顾客期望的配送日期和下单日期相同，则该订单称为 「即时订单」，否则称为「计划订单」。
--
-- 「首次订单」是顾客最早创建的订单。我们保证一个顾客只会有一个「首次订单」。
--
-- 编写解决方案以获取即时订单在所有用户的首次订单中的比例。保留两位小数。

SELECT ROUND(SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) / COUNT(*) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (SELECT customer_id, MIN(order_date) FROM Delivery GROUP BY customer_id);

-- SELECT ROUND(SUM(CASE WHEN t1.order_date = t1.customer_pref_delivery_date THEN 1 ELSE 0 END) / COUNT(*), 2) AS immediate_percentage
-- FROM (SELECT * FROM Delivery GROUP BY customer_id ORDER BY order_date ASC LIMIT 0, 1) t1;
--
-- 首次编写的 SQL 语句问题在于分组和筛选首次订单的逻辑错误：
-- 1. GROUP BY customer_id ORDER BY order_date ASC LIMIT 0, 1 这种写法无法正确获取每个用户的首次订单：
--      GROUP BY customer_id 会将同一用户的所有订单聚合，但未使用聚合函数（如 MIN (order_date)），仅保留随机一条数据；
--      LIMIT 0,1 只会返回整个结果集的第一条数据，而非每个用户的首次订单。
-- 2. 最终计算的是错误数据集的即时订单比例，自然结果不正确。