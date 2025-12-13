-- 表: Seat
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | student     | varchar |
-- +-------------+---------+
-- id 是该表的主键（唯一值）列。
-- 该表的每一行都表示学生的姓名和 ID。
-- ID 序列始终从 1 开始并连续增加。
--
--
-- 编写解决方案来交换每两个连续的学生的座位号。如果学生的数量是奇数，则最后一个学生的id不交换。
--
-- 按 id 升序 返回结果表。

SELECT (
    CASE
        WHEN MOD(id, 2) = 1 AND id = (SELECT COUNT(*) FROM seat) THEN id
        WHEN MOD(id, 2) = 1 THEN id+1
        ELSE id-1
    END
           ) AS id, student
FROM Seat
ORDER BY id ASC;