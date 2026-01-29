# Problem Analysis: Group Employees of the Same Salary

## Problem Description
Table `Employees`.
Group by salary.
Exclude salaries with only 1 employee.
Assign `team_id`: dense rank of salary (lowest salary = team 1).
Order by `team_id`, `employee_id`.

## Analysis

1.  **Window Functions**:
    -   `COUNT(*) OVER (PARTITION BY salary)` to filter valid groups.
    -   `DENSE_RANK() OVER (ORDER BY salary)` to assign IDs.
    
2.  **Implementation**:
    -   Subquery or CTE to get counts.

## Implementation Details
-   SQL.
