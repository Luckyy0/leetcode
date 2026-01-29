# Problem Analysis: Leetflex Banned Accounts

## Problem Description
Table `LogInfo` (account_id, ip_address, login, logout).
Find accounts that logged in from different IPs at same time (overlapping intervals).

## Analysis

1.  **Self Join**:
    -   Join `LogInfo l1` and `LogInfo l2`.
    -   Condition: `l1.account_id = l2.account_id`.
    -   Condition: `l1.ip_address != l2.ip_address`.
    -   Condition: Overlap `l1.login <= l2.logout` AND `l2.login <= l1.logout`.
    -   Distinct account_id.

## Implementation Details
-   SQL.
