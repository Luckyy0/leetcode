# Problem Analysis: Find Total Time Spent by Each Employee

## Problem Description
Table `Employees` (emp_id, event_day, in_time, out_time).
Calc total time spent by each employee on each day. `out_time - in_time`.

## Analysis

1.  **Group By**:
    -   `event_day`, `emp_id`.
    -   Sum `out_time - in_time`.

## Implementation Details
-   SQL.
