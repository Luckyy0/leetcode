/*
# 569. Median Employee Salary

Table: Employee
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| company      | varchar |
| salary       | int     |
+--------------+---------+
id is the primary key column for this table.
Each row of this table indicates the company and the salary of one employee.

Write an SQL query to find the median salary of each company.
*/

/*
WITH RankedEmployee AS (
    SELECT 
        id, 
        company, 
        salary, 
        ROW_NUMBER() OVER (PARTITION BY company ORDER BY salary) AS rn,
        COUNT(*) OVER (PARTITION BY company) AS total
    FROM 
        Employee
)
SELECT 
    id, 
    company, 
    salary
FROM 
    RankedEmployee
WHERE 
    rn BETWEEN total / 2.0 AND total / 2.0 + 1;
*/
