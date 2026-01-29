# Problem Analysis: Minimum Elements to Add to Form a Given Sum

## Problem Description
Array `nums`. `limit`. `goal`.
Add elements with `abs(val) <= limit`.
Min elements to result in sum `goal`.

## Analysis

1.  **Greedy**:
    -   Calc `currentSum`.
    -   `diff = abs(goal - currentSum)`.
    -   We need to cover `diff` using max contributions `limit`.
    -   `count = (diff + limit - 1) / limit` (Ceiling division).

## Implementation Details
-   Use `long` for sum.
