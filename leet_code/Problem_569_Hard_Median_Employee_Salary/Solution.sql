/*
Problem: 569. Median Employee Salary
Difficulty: Hard
Description: Find the median salary for each company.
Approach: Use ROW_NUMBER() and COUNT() window functions to identify middle ranks.
*/

WITH RankedEmployees AS (
    SELECT 
        id, 
        company, 
        salary,
        ROW_NUMBER() OVER(PARTITION BY company ORDER BY salary, id) as rnk,
        COUNT(*) OVER(PARTITION BY company) as total_count
    FROM 
        Employee
)
SELECT 
    id, 
    company, 
    salary
FROM 
    RankedEmployees
WHERE 
    -- Median rank condition: rank must be in the middle
    -- For example, N=5: rnk=3 is median. (3 >= 2.5 and 3 <= 3.5)
    -- For example, N=6: rnk=3,4 are medians. (3 >= 3 and 3 <= 4; 4 >= 3 and 4 <= 4)
    rnk >= total_count / 2.0 
    AND rnk <= total_count / 2.0 + 1;
