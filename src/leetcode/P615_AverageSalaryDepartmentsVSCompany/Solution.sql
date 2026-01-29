/*
# 615. Average Salary: Departments VS Company

Table: Salary
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| employee_id | int  |
| amount      | int  |
| pay_date    | date |
+-------------+------+
id is the primary key column for this table.
Each row of this table indicates the salary of an employee in one month.
employee_id is a foreign key from the Employee table.

Table: Employee
+-------------+------+
| Column Name | Type |
+-------------+------+
| employee_id | int  |
| department_id| int |
+-------------+------+
employee_id is the primary key column for this table.
Each row of this table indicates the department of an employee.

Write an SQL query to report the comparison result (higher/lower/same) of the average salary of employees in a department to the company's average salary for each month.
Return the result table ordered by pay_month desc, department_id.
*/

/*
WITH MonthlyStats AS (
    SELECT 
        LEFT(s.pay_date, 7) AS pay_month,
        e.department_id,
        AVG(amount) OVER(PARTITION BY LEFT(s.pay_date, 7)) AS company_avg,
        AVG(amount) OVER(PARTITION BY LEFT(s.pay_date, 7), e.department_id) AS dept_avg
    FROM 
        Salary s 
    JOIN 
        Employee e 
    ON 
        s.employee_id = e.employee_id
)
SELECT DISTINCT 
    pay_month, 
    department_id,
    CASE
        WHEN dept_avg > company_avg THEN 'higher'
        WHEN dept_avg < company_avg THEN 'lower'
        ELSE 'same'
    END AS comparison
FROM 
    MonthlyStats
ORDER BY 
    pay_month DESC, 
    department_id;
*/
