-- 表：Tweets
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | tweet_id       | int     |
-- | content        | varchar |
-- +----------------+---------+
-- 在 SQL 中，tweet_id 是这个表的主键。
-- content 只包含字母数字字符，'!'，' '，不包含其它特殊字符。
-- 这个表包含某社交媒体 App 中所有的推文。

SELECT tweet_id FROM Tweets WHERE char_length(content) > 15;