# Problem Analysis: Count Salary Categories

## Problem Description
Table `Accounts` (account_id, income).
Output `category`, `accounts_count`.
Categories:
-   "Low Salary": income < 20000
-   "Average Salary": 20000 <= income <= 50000
-   "High Salary": income > 50000
Result must include all 3 categories (count 0 if missing).

## Analysis

1.  **Union Approach**:
    -   Select 'Low Salary', Count where income < 20000.
    -   UNION ALL
    -   Select 'Average Salary', Count where income between ...
    -   UNION ALL
    -   Select 'High Salary', Count where income > 50000.
    -   This ensures all rows appear.

## Implementation Details
-   SQL UNION ALL.
