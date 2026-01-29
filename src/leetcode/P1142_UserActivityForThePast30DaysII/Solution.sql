/* Write your T-SQL query statement below */
SELECT ISNULL(ROUND(CAST(COUNT(DISTINCT session_id) AS FLOAT) / NULLIF(COUNT(DISTINCT user_id), 0), 2), 0.00) AS average_sessions_per_user
FROM Activity
WHERE activity_date BETWEEN DATEADD(day, -29, '2019-07-27') AND '2019-07-27';
