# Problem Analysis: Primary Department for Each Employee

## Problem Description
Table `Employee` (employee_id, department_id, primary_flag).
Find primary dept.
Rules:
-   If `primary_flag='Y'`, count it.
-   If employee has ONE department, it's primary.

## Analysis

1.  **Union**:
    -   Select where `primary_flag='Y'`.
    -   UNION
    -   Select where `employee_id` in (employees with count=1).

## Implementation Details
-   `GROUP BY` having count=1.
