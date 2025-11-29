-- 表: Activity
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | machine_id     | int     |
-- | process_id     | int     |
-- | activity_type  | enum    |
-- | timestamp      | float   |
-- +----------------+---------+
-- 该表展示了一家工厂网站的用户活动。
-- (machine_id, process_id, activity_type) 是当前表的主键（具有唯一值的列的组合）。
-- machine_id 是一台机器的ID号。
-- process_id 是运行在各机器上的进程ID号。
-- activity_type 是枚举类型 ('start', 'end')。
-- timestamp 是浮点类型,代表当前时间(以秒为单位)。
-- 'start' 代表该进程在这台机器上的开始运行时间戳 , 'end' 代表该进程在这台机器上的终止运行时间戳。
-- 同一台机器，同一个进程都有一对开始时间戳和结束时间戳，而且开始时间戳永远在结束时间戳前面。
--
--
-- 现在有一个工厂网站由几台机器运行，每台机器上运行着 相同数量的进程 。编写解决方案，计算每台机器各自完成一个进程任务的平均耗时。
--
-- 完成一个进程任务的时间指进程的'end' 时间戳 减去 'start' 时间戳。平均耗时通过计算每台机器上所有进程任务的总耗费时间除以机器上的总进程数量获得。
--
-- 结果表必须包含machine_id（机器ID） 和对应的 average time（平均耗时） 别名 processing_time，且四舍五入保留3位小数。
--
-- 以 任意顺序 返回表。

SELECT a1.machine_id, ROUND(AVG(a2.timestamp - a1.timestamp), 3) as processing_time
FROM Activity a1 JOIN Activity a2 USING (machine_id, process_id)
WHERE a1.activity_type = "start" AND a2.activity_type = "end"
GROUP BY a1.machine_id;