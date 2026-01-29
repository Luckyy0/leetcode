# Problem Analysis: Find Interview Candidates

## Problem Description
Tables: `Contests` (contest_id, gold_medal, silver_medal, bronze_medal), `Users` (user_id, mail, name).
Find users who:
1.  Won any medal in 3 or more **consecutive** contests.
2.  Won the **gold** medal in 3 or more contests (not necessarily consecutive).
Return `name`, `mail`.

## Analysis

1.  **Condition 2 (Gold Medals)**:
    -   Simple aggregation on `Contests.gold_medal`.
    -   `GROUP BY gold_medal HAVING COUNT(*) >= 3`.

2.  **Condition 1 (Consecutive Medals)**:
    -   Need to unpivot the medals first because a user can win any medal.
    -   Create a view/CTE `Winners` with `(contest_id, user_id)`:
        -   `SELECT contest_id, gold_medal AS user_id FROM Contests`
        -   `UNION ALL`
        -   `SELECT contest_id, silver_medal ...`
        -   `UNION ALL`
        -   `SELECT contest_id, bronze_medal ...`
    -   Find consecutive `contest_id` for same `user_id`.
    -   Use `LEAD` or `LAG`.
    -   Or with distinct contest numbers approach: `id - ROW_NUMBER() OVER (...)`.
    -   Since questions usually assume `contest_id` implies order but might not be dense. "Consecutive contests" implies `id, id+1, id+2`.
    -   Let's assume strictly consecutive IDs.
    -   Grouping approach:
        -   `SELECT user_id FROM Winners GROUP BY user_id, contest_id - rank HAVING count(*) >= 3`?
        -   Yes, `contest_id - ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY contest_id)` constitutes a group of consecutive integers.

3.  **Combine**:
    -   Union the user_ids from both logic.
    -   Join with `Users` table.

## Implementation Details
-   CTE/Subquery for unpivoting.
-   Window functions for consecutiveness.
