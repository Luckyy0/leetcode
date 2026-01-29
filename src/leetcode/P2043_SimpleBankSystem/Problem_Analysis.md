# Problem Analysis: Simple Bank System

## Problem Description
`Bank(long[] balance)`.
`transfer(acc1, acc2, amount)`.
`deposit(acc, amount)`.
`withdraw(acc, amount)`.
Accounts 1-indexed.
Return false if invalid (acc invalid or insufficient funds).

## Analysis

1.  **Direct Implementation**:
    -   Check bounds `1 <= acc <= n`.
    -   Transfer: Check accs valid. Check `balance[acc1] >= amount`. Update both.
    -   Deposit: Check acc valid. Add.
    -   Withdraw: Check acc valid. Check balance. Subtract.

## Implementation Details
-   `long[] balance`.
-   1-based to 0-based index.
