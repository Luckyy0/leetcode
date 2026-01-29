# Problem Analysis: The Latest Login in 2020

## Problem Description
Table `Logins` (user_id, time_stamp).
Find latest login in 2020.
Exclude users who didn't login in 2020.

## Analysis

1.  **Filtering and Aggregation**:
    -   `WHERE YEAR(time_stamp) = 2020`.
    -   `GROUP BY user_id`.
    -   `MAX(time_stamp)`.

## Implementation Details
-   SQL.
