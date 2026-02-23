/*
Problem: 579. Find Cumulative Salary of an Employee
Difficulty: Hard
Description: Calculate 3-month rolling salary sum, excluding the most recent month.
Approach: 
1. Identify max month for each employee using window MAX.
2. Filter out max months.
3. Calculate rolling sum using ROWS BETWEEN 2 PRECEDING AND CURRENT ROW.
*/

WITH MaxMonths AS (
    SELECT 
        id, 
        month, 
        salary,
        MAX(month) OVER(PARTITION BY id) as max_m
    FROM 
        Employee
)
SELECT 
    id, 
    month, 
    SUM(salary) OVER(PARTITION BY id ORDER BY month ROWS BETWEEN 2 PRECEDING AND CURRENT ROW) as Salary
FROM 
    MaxMonths
WHERE 
    month < max_m
ORDER BY 
    id ASC, 
    month DESC;
