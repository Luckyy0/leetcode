# Problem Analysis: Hopper Company Queries II

## Problem Description
Report `month`, `working_percentage`.
`working_percentage`: (Number of drivers who accepted at least one ride in that month / Number of active drivers) * 100.
Rounded to 2 decimal places.

## Analysis

1.  **Active Drivers**:
    -   Joined on or before end of month.
    -   Logic: `COUNT(d.driver_id) WHERE d.join_date <= MonthEnd`.

2.  **Working Drivers**:
    -   Drivers who appear in `AcceptedRides` joined with `Rides` where `requested_at` is in that month.
    -   `COUNT(DISTINCT driver_id)`.

3.  **Query Structure**:
    -   Recursive CTE for 1-12 months.
    -   Subqueries in SELECT clause for Active and Working counts.
    -   Computation.

## Implementation Details
-   `IFNULL` for division by zero.
