/* Write your T-SQL query statement below */
WITH Counts AS (
    SELECT activity, COUNT(*) as cnt
    FROM Friends
    GROUP BY activity
),
MinMax AS (
    SELECT MAX(cnt) as max_c, MIN(cnt) as min_c
    FROM Counts
)
SELECT activity
FROM Counts, MinMax
WHERE cnt != max_c AND cnt != min_c;
