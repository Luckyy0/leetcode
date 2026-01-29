/* Write your T-SQL query statement below */
SELECT 
    gender, 
    day, 
    SUM(score_points) OVER (PARTITION BY gender ORDER BY day) as total
FROM Scores
ORDER BY gender, day;
