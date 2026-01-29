# Problem Analysis: Percentage of Users Attended a Contest

## Problem Description
Table: `Users` (user_id, user_name)
Table: `Register` (contest_id, user_id)

Write an SQL query to find the percentage of the users registered in each contest rounded to two decimals.
Return the result table ordered by `percentage` in descending order. In case of a tie, order it by `contest_id` in ascending order.

## Analysis

1.  **Logic**:
    -   Total users `(SELECT COUNT(*) FROM Users)`.
    -   Group `Register` by `contest_id`.
    -   Count users per contest.
    -   Formula: `(COUNT(user_id) * 100.0) / TotalUsers`.
    -   Round to 2 decimals.

2.  **Query**:
    ```sql
    SELECT 
        contest_id, 
        ROUND(COUNT(user_id) * 100.0 / (SELECT COUNT(*) FROM Users), 2) AS percentage
    FROM Register
    GROUP BY contest_id
    ORDER BY percentage DESC, contest_id ASC;
    ```

## Implementation Details
-   Standard SQL aggregation.
