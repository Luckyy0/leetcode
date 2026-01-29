/* Write your T-SQL query statement below */
WITH Ranked AS (
    SELECT 
        username, activity, startDate, endDate,
        RANK() OVER (PARTITION BY username ORDER BY startDate DESC) as rk,
        COUNT(*) OVER (PARTITION BY username) as cnt
    FROM UserActivity
)
SELECT username, activity, startDate, endDate
FROM Ranked
WHERE rk = 2 OR cnt = 1;
