# Problem Analysis: Employees Whose Manager Left the Company

## Problem Description
Table `Employees` (employee_id, name, manager_id, salary).
Find employees with salary < 30000 AND manager_id is NOT NULL AND manager_id NOT IN (Employees.employee_id).
Order by employee_id.

## Analysis

1.  **Filter and Subquery**:
    -   Select from Employees e.
    -   Where salary < 30000.
    -   And manager_id IS NOT NULL.
    -   And manager_id NOT IN (SELECT employee_id FROM Employees).
    -   Simple.

## Implementation Details
-   SQL.
