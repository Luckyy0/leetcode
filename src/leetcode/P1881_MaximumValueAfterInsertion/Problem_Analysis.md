# Problem Analysis: Maximum Value after Insertion

## Problem Description
String `n` (number). Digit `x`.
Insert `x` to maximize value.

## Analysis

1.  **Greedy**:
    -   If `n` is positive: Start from left. Insert `x` immediately before the first digit smaller than `x`. If none, append at end.
    -   If `n` is negative (starts with '-'): Start from index 1. Insert `x` immediately before the first digit larger than `x`. (To minimize magnitude). If none, append at end.

## Implementation Details
-   Check sign. Loop.
