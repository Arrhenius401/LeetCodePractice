-- 表：Movies
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | movie_id      | int     |
-- | title         | varchar |
-- +---------------+---------+
-- movie_id 是这个表的主键(具有唯一值的列)。
-- title 是电影的名字。
-- 每部电影都有一个唯一的 title。
-- 表：Users
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | user_id       | int     |
-- | name          | varchar |
-- +---------------+---------+
-- user_id 是表的主键(具有唯一值的列)。
-- 'name' 列具有唯一值。
-- 表：MovieRating
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | movie_id      | int     |
-- | user_id       | int     |
-- | rating        | int     |
-- | created_at    | date    |
-- +---------------+---------+
-- (movie_id, user_id) 是这个表的主键(具有唯一值的列的组合)。
-- 这个表包含用户在其评论中对电影的评分 rating 。
-- created_at 是用户的点评日期。
--
--
-- 请你编写一个解决方案：
--
-- 查找评论电影数量最多的用户名。如果出现平局，返回字典序较小的用户名。
-- 查找在 February 2020 平均评分最高 的电影名称。如果出现平局，返回字典序较小的电影名称。
-- 字典序 ，即按字母在字典中出现顺序对字符串排序，字典序较小则意味着排序靠前。

SELECT name AS results
FROM Users
WHERE user_id = (
    SELECT user_id
    FROM (
        SELECT u.user_id, name, COUNT(*) AS rate_count
        FROM Users u JOIN MovieRating m2 ON u.user_id = m2.user_id
        GROUP BY u.user_id
        ORDER BY rate_count DESC, name ASC
        LIMIT 1
        ) AS t1
    )

UNION ALL

SELECT title AS results
FROM Movies
WHERE movie_id = (
    SELECT movie_id
    FROM(
        SELECT m1.movie_id, AVG(m2.rating) AS avg_rating, title
        FROM Movies m1 JOIN MovieRating m2 ON m1.movie_id = m2.movie_id
        WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29'
        GROUP BY m1.movie_id
        ORDER BY avg_rating DESC, title ASC
        LIMIT 1
        ) AS t2
    );

-- PS:
-- 问题 1：IN + LIMIT 不支持
--      MySQL 设计上禁止「IN 子查询 + LIMIT」的组合，替代方案有两种：
--      方案 1：将子查询用 SELECT * FROM (...) AS t 包裹（把带 LIMIT 的子查询转为派生表，再取目标列）；
--      方案 2：用 JOIN 替代 IN，直接关联 Top1 结果。
-- 问题 2：子查询返回多列
--      IN 子查询必须返回单列（比如仅 user_id 或 movie_id），否则会触发「Operand should contain 1 column (s)」错误（你的代码还没走到这一步，因为先触发了 LIMIT 错误）。
-- 问题 3：UNION 和 UNION ALL 比较
--      特性	UNION	                                | UNION ALL
--      去重	✅ 自动去除结果集中的重复行	                | ❌ 保留所有行（包括重复行）
--      排序	✅ 会对合并后的结果集默认排序（按第一列升序）	| ❌ 不排序，按 SELECT 语句顺序保留行的顺序
--      性能	低（去重 + 排序需要额外计算）	            | 高（无额外操作，直接合并）