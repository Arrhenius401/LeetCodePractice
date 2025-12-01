-- 表: Signups
--
-- +----------------+----------+
-- | Column Name    | Type     |
-- +----------------+----------+
-- | user_id        | int      |
-- | time_stamp     | datetime |
-- +----------------+----------+
-- User_id是该表的主键。
-- 每一行都包含ID为user_id的用户的注册时间信息。
--
--
-- 表: Confirmations
--
-- +----------------+----------+
-- | Column Name    | Type     |
-- +----------------+----------+
-- | user_id        | int      |
-- | time_stamp     | datetime |
-- | action         | ENUM     |
-- +----------------+----------+
-- (user_id, time_stamp)是该表的主键。
-- user_id是一个引用到注册表的外键。
-- action是类型为('confirmed'， 'timeout')的ENUM
-- 该表的每一行都表示ID为user_id的用户在time_stamp请求了一条确认消息，该确认消息要么被确认('confirmed')，要么被过期('timeout')。
--
--
-- 用户的 确认率 是 'confirmed' 消息的数量除以请求的确认消息的总数。没有请求任何确认消息的用户的确认率为 0 。确认率四舍五入到 小数点后两位 。
--
-- 编写一个SQL查询来查找每个用户的 确认率 。
--
-- 以 任意顺序 返回结果表。

SELECT s.user_id, ROUND(IFNULL(AVG(c.action = "confirmed"), 0), 2) AS confirmation_rate
FROM Signups s LEFT JOIN Confirmations c ON s.user_id = c.user_id
GROUP BY s.user_id;

-- COUNT(表达式) 的逻辑是：
-- 统计表达式结果非 NULL 的行数（不管表达式结果是 TRUE/FALSE/ 数字 / 字符串，只要不是 NULL，就计 1）；
-- 只有当表达式结果为 NULL 时，才不计入计数。

-- 在 MySQL 中，布尔表达式（如 c.action = 'confirmed'）出现在数值上下文时，会被隐式转换为数值（1 代表真，0 代表假）；
-- 但在非数值上下文（如纯布尔判断）中，仍保持布尔语义。

-- Oracle、SQL Server 等数据库没有 “布尔表达式转 1/0” 的隐式转换
-- 因此 SUM(c.action = 'confirmed') 在这些数据库中会报错，需改用 CASE 表达式：
-- SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END)