-- 表: Teacher
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | teacher_id  | int  |
-- | subject_id  | int  |
-- | dept_id     | int  |
-- +-------------+------+
-- 在 SQL 中，(subject_id, dept_id) 是该表的主键。
-- 该表中的每一行都表示带有 teacher_id 的教师在系 dept_id 中教授科目 subject_id。
--
--
-- 查询每位老师在大学里教授的科目种类的数量。
--
-- 以 任意顺序 返回结果表。

SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;
