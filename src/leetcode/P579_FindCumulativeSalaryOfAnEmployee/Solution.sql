/*
# 579. Find Cumulative Salary of an Employee

Table: Employee
+-------------+------+
| Column Name | Type |
+-------------+------+
| Id          | int  |
| Month       | int  |
| Salary      | int  |
+-------------+------+
(Id, Month) is the primary key for this table.
Each row containing information about the salary of an employee in one month.

Write an SQL query to calculate the cumulative salary summary for every employee.
*/

/*
WITH MaxMonth AS (
    SELECT 
        Id, 
        MAX(Month) AS MaxM
    FROM 
        Employee
    GROUP BY 
        Id
)
SELECT 
    E.Id, 
    E.Month, 
    SUM(E.Salary) OVER (
        PARTITION BY E.Id 
        ORDER BY E.Month 
        ROWS BETWEEN 2 PRECEDING AND CURRENT ROW
    ) AS Salary
FROM 
    Employee E
JOIN 
    MaxMonth M 
ON 
    E.Id = M.Id
WHERE 
    E.Month < M.MaxM
ORDER BY 
    E.Id ASC, 
    E.Month DESC;
*/
