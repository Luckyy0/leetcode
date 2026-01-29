/* Write your T-SQL query statement below */
WITH DailyStats AS (
    SELECT 
        action_date, 
        COUNT(DISTINCT a.post_id) as reported_count,
        COUNT(DISTINCT r.post_id) as removed_count
    FROM Actions a
    LEFT JOIN Removals r ON a.post_id = r.post_id
    WHERE a.extra = 'spam'
    GROUP BY action_date
)
SELECT ROUND(AVG(removed_count * 100.0 / reported_count), 2) as average_daily_percent
FROM DailyStats;
