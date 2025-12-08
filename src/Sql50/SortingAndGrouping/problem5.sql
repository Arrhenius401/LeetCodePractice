-- 表： Followers
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | user_id     | int  |
-- | follower_id | int  |
-- +-------------+------+
-- (user_id, follower_id) 是这个表的主键（具有唯一值的列的组合）。
-- 该表包含一个关注关系中关注者和用户的编号，其中关注者关注用户。
--
--
-- 编写解决方案，对于每一个用户，返回该用户的关注者数量。
--
-- 按 user_id 的顺序返回结果表。

SELECT user_id, COUNT(*) AS followers_count
FROM Followers
GROUP BY user_id
ORDER BY user_id ASC;