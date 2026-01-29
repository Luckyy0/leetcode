# Problem Analysis: Strong Friendship

## Problem Description
Table `Friendship` (user1_id, user2_id).
Strong friendship: `u1` and `u2` are friends AND they have at least 3 common friends.

## Analysis

1.  **Join and Count**:
    -   CTE `AllFriends`: Normalise (u, f). `u1, u2` UNION `u2, u1`.
    -   Condition `f1.user1_id` and `f1.user2_id` are friends. (Exists in `Friendship`).
    -   Count common friends.
    -   Filter count >= 3.
    -   Select from `Friendship(u1, u2)`.
    -   Join `AllFriends af1` on `u1` -> `friend`.
    -   Join `AllFriends af2` on `u2` -> `friend`.
    -   Where `af1.friend = af2.friend` (this is a common friend).
    -   Group by `u1, u2`.
    -   Having count >= 3.

## Implementation Details
-   SQL.
