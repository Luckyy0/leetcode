/* Write your T-SQL query statement below */
WITH AvgActivity AS (
    SELECT event_type, AVG(occurences * 1.0) as avg_occ
    FROM Events
    GROUP BY event_type
)
SELECT e.business_id
FROM Events e
JOIN AvgActivity a ON e.event_type = a.event_type
WHERE e.occurences > a.avg_occ
GROUP BY e.business_id
HAVING COUNT(e.event_type) > 1;
