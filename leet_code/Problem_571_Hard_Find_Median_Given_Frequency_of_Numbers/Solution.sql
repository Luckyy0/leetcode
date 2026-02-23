/*
Problem: 571. Find Median Given Frequency of Numbers
Difficulty: Hard
Description: Calculate median from a (value, frequency) table.
Approach: Use cumulative sums from both ASC and DESC order to find middle values.
*/

WITH Stats AS (
    SELECT 
        num,
        SUM(frequency) OVER(ORDER BY num ASC) as sum_asc,
        SUM(frequency) OVER(ORDER BY num DESC) as sum_desc,
        SUM(frequency) OVER() as total_count
    FROM 
        Numbers
)
SELECT 
    ROUND(AVG(num * 1.0), 1) as median
FROM 
    Stats
WHERE 
    -- A number is a median if it covers the halfway point from both ends
    sum_asc >= total_count / 2.0 
    AND sum_desc >= total_count / 2.0;
