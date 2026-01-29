# Problem Analysis: All the Pairs With the Maximum Number of Common Followers

## Problem Description
Table `Relations` (user_id, follower_id).
Find pair `(user1_id, user2_id)` such that `user1_id < user2_id` and they have maximum number of common followers.
Return pairs.

## Analysis

1.  **Self Join and Count**:
    -   Join `Relations r1` and `Relations r2`.
    -   Condition `r1.follower_id = r2.follower_id` AND `r1.user_id < r2.user_id`.
    -   Group by `user1, user2`.
    -   Count common followers.
    -   Use `RANK()` or `MAX()` to filter.

## Implementation Details
-   SQL CTE and Window Function.
