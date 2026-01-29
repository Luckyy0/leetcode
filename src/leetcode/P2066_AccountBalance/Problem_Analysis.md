# Problem Analysis: Account Balance

## Problem Description
Table `Transactions` (account_id, day, type, amount).
Type: 'Deposit' or 'Withdraw'.
Report balance of each account after each transaction, ordered by `account_id`, `day`.

## Analysis

1.  **Window Functions**:
    -   Sort by `account_id`, `day`.
    -   Process amount: Deposit -> `+amount`, Withdraw -> `-amount`.
    -   Cumulative sum `SUM(signed_amount) OVER (PARTITION BY account_id ORDER BY day)`.

## Implementation Details
-   `CASE` for sign.
-   `SUM() OVER`.
