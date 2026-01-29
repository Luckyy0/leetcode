# Problem Analysis: Number of Calls Between Two Persons

## Problem Description
Table `Calls` (from_id, to_id, duration).
Report number of calls and total duration between each pair of persons `(person1, person2)` where `person1 < person2`.
(1, 2) and (2, 1) should be merged.

## Analysis

1.  **Normalization**:
    -   Convert each row to `LEAST(from_id, to_id), GREATEST(from_id, to_id), duration`.
    -   Group by these two columns.
    
2.  **Aggregation**:
    -   `COUNT(*)`, `SUM(duration)`.

## Implementation Details
-   `SELECT LEAST...`.
