# Problem Analysis: Biggest Window Between Visits

## Problem Description
Table `UserVisits` (user_id, visit_date).
Assume today is '2021-01-01'.
Calc largest window of days between distinct visits (or today).

## Analysis

1.  **Window**:
    -   Sort by date for user.
    -   `LEAD(visit_date, 1, '2021-01-01')`.
    -   `DATEDIFF(next, curr)`.
    -   Max per user.
    
2.  **Implementation**:
    -   `DATEDIFF` may vary by SQL dialect. Assuming MySQL `DATEDIFF(expr1, expr2)`.

3.  **Query**:
    ```sql
    SELECT user_id, MAX(diff) AS biggest_window
    FROM (
        SELECT 
            user_id, 
            DATEDIFF(
                LEAD(visit_date, 1, '2021-01-01') OVER (PARTITION BY user_id ORDER BY visit_date), 
                visit_date
            ) AS diff
        FROM UserVisits
    ) t
    GROUP BY user_id
    ORDER BY user_id;
    ```
    
## Implementation Details
-   Common SQL.
