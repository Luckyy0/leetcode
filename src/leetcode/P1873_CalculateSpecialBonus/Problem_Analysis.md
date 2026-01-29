# Problem Analysis: Calculate Special Bonus

## Problem Description
Table `Employees` (employee_id, name, salary).
Bonus = salary IF (id is odd AND name not start with 'M'). Else 0.
Order by `employee_id`.

## Analysis

1.  **CASE statement**:
    -   `CASE WHEN employee_id % 2 = 1 AND name NOT LIKE 'M%' THEN salary ELSE 0 END`.

## Implementation Details
-   SQL.
