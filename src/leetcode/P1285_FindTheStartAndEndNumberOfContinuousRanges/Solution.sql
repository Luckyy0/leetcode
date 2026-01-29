/* Write your T-SQL query statement below */
WITH Ranked AS (
    SELECT 
        log_id, 
        ROW_NUMBER() OVER (ORDER BY log_id) as rn
    FROM Logs
),
Groups AS (
    SELECT 
        log_id,
        log_id - rn as grp
    FROM Ranked
)
SELECT 
    MIN(log_id) AS start_id, 
    MAX(log_id) AS end_id
FROM Groups
GROUP BY grp
ORDER BY start_id;
