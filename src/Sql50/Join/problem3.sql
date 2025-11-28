-- 表：Visits
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | visit_id    | int     |
-- | customer_id | int     |
-- +-------------+---------+
-- visit_id 是该表中具有唯一值的列。
-- 该表包含有关光临过购物中心的顾客的信息。
--
--
-- 表：Transactions
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | transaction_id | int     |
-- | visit_id       | int     |
-- | amount         | int     |
-- +----------------+---------+
-- transaction_id 是该表中具有唯一值的列。
-- 此表包含 visit_id 期间进行的交易的信息。
--
--
-- 有一些顾客可能光顾了购物中心但没有进行交易。请你编写一个解决方案，来查找这些顾客的 ID ，以及他们只光顾不交易的次数。
--
-- 返回以 任何顺序 排序的结果表。

-- 错误答案，因为 transaction 表的 amount 字段可能自身就是 null
SELECT v.customer_id, COUNT(*) AS count_no_trans FROM Visits v LEFT JOIN Transactions t ON v.visit_id = t.visit_id WHERE t.amount IS NULL GROUP BY v.customer_id;

SELECT v.customer_id, COUNT(*) AS count_no_trans FROM Visits v LEFT JOIN Transactions t ON v.visit_id = t.visit_id WHERE t.transaction_id IS NULL GROUP BY v.customer_id;

SELECT
    v.customer_id, count(*) AS count_no_trans
FROM
    Visits v
WHERE
    v.visit_id NOT IN (
    SELECT
        t.visit_id
    FROM
        Transactions t
    )
GROUP BY
    v.customer_id;