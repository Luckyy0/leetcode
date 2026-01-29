# Problem Analysis: Average Time of Process per Machine

## Problem Description
Table: `Activity` (machine_id, process_id, activity_type, timestamp).
`activity_type` is 'start' or 'end'.
Calculate average time each machine takes to complete a process.
(end_time - start_time) averaged over all processes for each machine.
Round to 3 decimal places.

## Analysis

1.  **Self Join**:
    -   Join `Activity` table as `a1` (start) and `a2` (end).
    -   Conditions: `a1.machine_id = a2.machine_id`, `a1.process_id = a2.process_id`, `a1.type = 'start'`, `a2.type = 'end'`.
    
2.  **Aggregation**:
    -   Group by `machine_id`.
    -   `AVG(a2.timestamp - a1.timestamp)`.
    -   `ROUND(..., 3)`.

## Implementation Details
-   Standard query.

