# Problem Analysis: Maximum Transaction Each Day

## Problem Description
Table `Transactions` (transaction_id, day, amount).
Find IDs with max amount for their respective day.

## Analysis

1.  **Window Function**:
    -   `RANK()` or `DENSE_RANK()` over partition by day order by amount DESC.
    -   Select where rank = 1.

## Implementation Details
-   SQL.
