# Problem Analysis: Users That Actively Request Confirmation Messages

## Problem Description
Table `Signups`, `Confirmations`.
Active users: Request confirmation messages.
Find users who requested conversion message twice within 24 hour window.
Specifically: `time_stamp` of requests. Exists `t1`, `t2` ($t1 < t2$) such that $t2 - t1 <= 24$ hours.

## Analysis

1.  **Self Join**:
    -   Join `Confirmations` with itself on `user_id`.
    -   Condition `c2.time_stamp > c1.time_stamp` AND `timestampdiff(SECOND, c1.time_stamp, c2.time_stamp) <= 24 * 60 * 60`.
    -   Select distinct `user_id`.

## Implementation Details
-   SQL functionality.
