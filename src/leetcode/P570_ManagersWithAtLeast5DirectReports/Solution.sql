/*
# 570. Managers with at Least 5 Direct Reports

Table: Employee
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
id is the primary key column for this table.
Each row of this table indicates the name of an employee, their department, and the id of their manager.
If managerId is null, then the employee has no manager.
No employee will be the manager of themself.

Write an SQL query to report the managers with at least 5 direct reports.
*/

/*
SELECT 
    Name
FROM 
    Employee
WHERE 
    Id IN (
        SELECT 
            ManagerId
        FROM 
            Employee
        GROUP BY 
            ManagerId
        HAVING 
            COUNT(*) >= 5
    );
*/
