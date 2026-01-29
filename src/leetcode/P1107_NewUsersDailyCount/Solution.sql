/* Write your T-SQL query statement below */
WITH FirstLogin AS (
    SELECT user_id, MIN(activity_date) as login_date
    FROM Traffic
    WHERE activity = 'login'
    GROUP BY user_id
)
SELECT login_date, COUNT(user_id) as user_count
FROM FirstLogin
WHERE login_date >= DATEADD(day, -90, '2019-06-30')
GROUP BY login_date;
