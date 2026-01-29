# Problem Analysis: Number of Accounts That Did Not Stream

## Problem Description
Table `Subscriptions` (account_id, start_date, end_date).
Table `Streams` (session_id, account_id, stream_date).
Count accounts that have a subscription in 2021 but did not stream in 2021.
Wait. Subscriptions can span 2021. Any active sub in 2021.
"Did not stream in 2021".

## Analysis

1.  **Filter Subscriptions**:
    -   Active in 2021 means `start_date <= '2021-12-31' AND end_date >= '2021-01-01'`.
    -   Distinct `account_id` from this set.
2.  **Filter Streams**:
    -   Stream in 2021 `YEAR(stream_date) = 2021`.
3.  **Set Difference**:
    -   (Accounts with sub in 2021) MINUS (Accounts with stream in 2021).
    -   Count distinct? Or return count? Or list?
    -   "Count the number of accounts". `COUNT(DISTINCT account_id)`? Or distinct accounts.
    -   Usually Title implies count, but SQL problems often ask for Table/List.
    -   P2020: "Number of Accounts...". LeetCode SQL usually asks for the count value as a column `accounts_count`.
    -   Let's check expected schema. "Report the number of accounts...". Usually select count.

## Implementation Details
-   `COUNT`.
