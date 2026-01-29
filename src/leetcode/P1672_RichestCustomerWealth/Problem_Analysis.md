# Problem Analysis: Richest Customer Wealth

## Problem Description
You are given an `m x n` integer grid `accounts` where `accounts[i][j]` is the amount of money the `i-th` customer has in the `j-th` bank. Return the wealth that the richest customer has.
A customer's wealth is the sum of money they have in all their bank accounts.

## Analysis

1.  **Iteration**:
    -   Iterate rows.
    -   Sum intervals.
    -   Track max.

2.  **Complexity**:
    -   Time: $O(M \cdot N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Simple loops.
