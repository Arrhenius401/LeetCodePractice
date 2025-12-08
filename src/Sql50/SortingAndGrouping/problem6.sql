-- MyNumbers 表：
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | num         | int  |
-- +-------------+------+
-- 该表可能包含重复项（换句话说，在SQL中，该表没有主键）。
-- 这张表的每一行都含有一个整数。
--
--
-- 单一数字 是在 MyNumbers 表中只出现一次的数字。
--
-- 找出最大的 单一数字 。如果不存在 单一数字 ，则返回 null 。

SELECT MAX(num) AS num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) < 2
     ) AS n;

-- 使用 GROUP BY + COUNT() 可以实现对某特定值的属性总数的计数