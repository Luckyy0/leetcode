/* Write your T-SQL query statement below */
WITH PlayerStats AS (
    SELECT player_id, MIN(event_date) as install_date
    FROM Activity
    GROUP BY player_id
)
SELECT 
    ps.install_date, 
    COUNT(ps.player_id) as installs,
    ROUND(CAST(SUM(CASE WHEN a.event_date IS NOT NULL THEN 1 ELSE 0 END) AS FLOAT) / COUNT(ps.player_id), 2) as Day1_retention
FROM PlayerStats ps
LEFT JOIN Activity a 
    ON ps.player_id = a.player_id 
    AND a.event_date = DATEADD(day, 1, ps.install_date)
GROUP BY ps.install_date;
