# Problem Analysis: The Number of Employees Which Report to Each Employee

## Problem Description
`Employees` (employee_id, name, reports_to, age).
Return manager_id, manager_name, reports_count, average_age.
Round average age nearest integer.
Order by employee_id.

## Analysis

1.  **Join**:
    -   Table `E` (managers) and `R` (reports).
    -   `JOIN Employees E ON E.employee_id = R.reports_to`.
    -   `GROUP BY E.employee_id`.

## Implementation Details
-   `ROUND(AVG(R.age))`.
