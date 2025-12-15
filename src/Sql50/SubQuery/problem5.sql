-- RequestAccepted 表：
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | requester_id   | int     |
-- | accepter_id    | int     |
-- | accept_date    | date    |
-- +----------------+---------+
-- (requester_id, accepter_id) 是这张表的主键(具有唯一值的列的组合)。
-- 这张表包含发送好友请求的人的 ID ，接收好友请求的人的 ID ，以及好友请求通过的日期。
--
--
-- 编写解决方案，找出拥有最多的好友的人和他拥有的好友数目。
--
-- 生成的测试用例保证拥有最多好友数目的只有 1 个人。

SELECT id, num
FROM (
    SELECT id, SUM(num) AS num
    FROM(
        SELECT accepter_id AS id, COUNT(*) AS num
        FROM RequestAccepted
        GROUP BY accepter_id

        UNION ALL

        SELECT requester_id AS id, COUNT(*) AS num
        FROM RequestAccepted
        GROUP BY requester_id
        ) AS t1
    GROUP BY id
    ) AS t2
ORDER BY num DESC
LIMIT 1;

-- WITH 子句的意义
-- （1）替代嵌套子查询，解决 “查询地狱”
--      传统复杂查询依赖多层嵌套子查询（也称 “派生表地狱”），逻辑层层嵌套后，可读性和可维护性急剧下降。
-- 反例（无 WITH 的嵌套写法）：
-- （2）复用临时结果集，避免重复代码
--      如果同一个临时结果集需要在查询中多次使用，传统写法需重复写子查询（冗余且易出错），而 CTE 定义一次即可复用。
-- （3）支持递归查询，处理层级 / 树形结构
--      这是 WITH 子句无可替代的核心能力—— 传统 SQL（无 CTE）无法简洁实现递归逻辑，必须依赖存储过程、函数或多层嵌套（极不优雅），而WITH RECURSIVE可原生处理树形 / 层级数据：
-- （4）提升查询的可调试性
--      CTE 的模块化特性让调试更高效：可以单独执行每个 CTE 的查询逻辑，验证中间结果是否符合预期，再拼接主查询。比如调试上述 “活跃用户订单统计” 时，可先执行：
--
-- WITH 子句的用法
-- （1）基础用法（单 CTE）
--      最常用的场景：拆分复杂查询，提升可读性（替代嵌套子查询）。
-- （2）多 CTE（逗号分隔）
--      可同时定义多个 CTE，后定义的 CTE 可引用先定义的 CTE。
-- （3）递归 CTE（WITH RECURSIVE）
--      这是 CTE 的高级用法（SQL 标准支持），用于处理层级 / 树形结构（如组织架构、分类层级、递归计算），语法需加RECURSIVE关键字。
-- （4）CTE 的列名指定
--      可显式指定 CTE 的列名（覆盖 SELECT 的列名，或解决列名重复 / 无列名的问题）：