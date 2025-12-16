-- 表： Users
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | user_id        | int     |
-- | name           | varchar |
-- +----------------+---------+
-- user_id 是该表的主键(具有唯一值的列)。
-- 该表包含用户的 ID 和名字。名字仅由小写和大写字符组成。
--
--
-- 编写解决方案，修复名字，使得只有第一个字符是大写的，其余都是小写的。
--
-- 返回按 user_id 排序的结果表。

SELECT user_id, CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) AS name
FROM Users
ORDER BY user_id;

-- UPPER ()：字符串转大写
-- LOWER ()：字符串转小写
-- SUBSTRING ()：字符串截取。从指定字符串中截取部分子串，核心是指定「起始位置」和「截取长度」（部分数据库支持省略长度，截取到末尾，如MySQL）。