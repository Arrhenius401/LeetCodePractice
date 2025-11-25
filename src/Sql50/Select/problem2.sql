-- 表: Customer
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- | referee_id  | int     |
-- +-------------+---------+
-- 在 SQL 中，id 是该表的主键列。
-- 该表的每一行表示一个客户的 id、姓名以及推荐他们的客户的 id。
-- 找出以下客户的姓名：
--
-- 被任何 id != 2 的用户推荐。
-- 没有被 任何用户推荐。
-- 以 任意顺序 返回结果表。

SELECT `name` FROM `Customer` WHERE referee_id <> 2 OR referee_id IS NULL;
