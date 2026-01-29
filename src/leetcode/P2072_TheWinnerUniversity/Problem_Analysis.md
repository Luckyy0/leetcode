# Problem Analysis: The Winner University

## Problem Description
Table `NewYork` (student_id, score).
Table `California` (student_id, score).
Count "excellent" students (score >= 90).
Compare counts. Winner 'New York University', 'California University', or 'No Winner'.

## Analysis

1.  **Aggregation**:
    -   SELECT SUM(score >= 90).
    -   UNION with literal name?
    -   Or two queries?
    -   Simple `CASE`.

## Implementation Details
-   `SELECT COUNT` with WHERE.
