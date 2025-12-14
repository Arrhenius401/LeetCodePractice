-- 表: Customer
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | customer_id   | int     |
-- | name          | varchar |
-- | visited_on    | date    |
-- | amount        | int     |
-- +---------------+---------+
-- 在 SQL 中，(customer_id, visited_on) 是该表的主键。
-- 该表包含一家餐馆的顾客交易数据。
-- visited_on 表示 (customer_id) 的顾客在 visited_on 那天访问了餐馆。
-- amount 是一个顾客某一天的消费总额。
--
--
-- 你是餐馆的老板，现在你想分析一下可能的营业额变化增长（每天至少有一位顾客）。
--
-- 计算以 7 天（某日期 + 该日期前的 6 天）为一个时间段的顾客消费平均值。average_amount 要 保留两位小数。
--
-- 结果按 visited_on 升序排序。

SELECT DISTINCT visited_on,
                sum_amount AS amount,
                ROUND(sum_amount/7, 2) AS average_amount
-- 以上是破解【绊子1】并计算平均值，少用一次窗口函数提高运行速度
FROM (
         SELECT visited_on,
                SUM(amount) OVER ( ORDER BY visited_on ROWS 6 PRECEDING ) AS sum_amount
         -- 以下是计算每天的金额总量，破解【绊子2】
         FROM (
                  SELECT visited_on,
                         SUM(amount) AS amount
                  FROM Customer
                  GROUP BY visited_on
              ) TT
     ) LL
-- 最后手动只要覆盖完整7天的数据，破解【绊子1】
WHERE DATEDIFF(visited_on, (SELECT MIN(visited_on) FROM Customer)) >= 6

-- 一、基础概念：ROWS vs RANGE
--      首先区分两种范围类型，这是滑动范围的核心：
--      类型	定义方式	特点
--      ROWS	按「物理行」计数（行号）	精准控制行数（如前 1 行、后 2 行），不受列值重复影响，最常用
--      RANGE	按「列值逻辑范围」计数	按排序列的数值范围（如≤当前值的所有行），重复值会被批量包含，较少用
--
-- 二、常用滑动范围关键词
-- 关键词	含义
--      UNBOUNDED PRECEDING	分组内的第一行（无边界的开头）
--      UNBOUNDED FOLLOWING	分组内的最后一行（无边界的结尾）
--      CURRENT ROW	当前行
--      n PRECEDING	当前行的前 n 行（n 是数字，如 1 PRECEDING = 前 1 行）
--      n FOLLOWING	当前行的后 n 行（n 是数字，如 2 FOLLOWING = 后 2 行）