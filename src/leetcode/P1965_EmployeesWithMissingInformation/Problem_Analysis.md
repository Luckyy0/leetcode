# Problem Analysis: Employees With Missing Information

## Problem Description
Table `Employees` (employee_id, name).
Table `Salaries` (employee_id, salary).
Find IDs of employees with missing information (either name missing or salary missing).
Ordering: ASC by employee_id.
Missing name: ID in Salaries but not in Employees.
Missing salary: ID in Employees but not in Salaries.

## Analysis

1.  **Full Outer Join (Union)**:
    -   MySQL doesn't support FULL OUTER JOIN.
    -   Use `UNION`.
    -   (IDs in Emp diff Sal) UNION (IDs in Sal diff Emp).
    -   Or `(SELECT id FROM Emp WHERE id NOT IN (SELECT id FROM Sal))` UNION ...
    -   Order by `employee_id`.

## Implementation Details
-   SQL.
