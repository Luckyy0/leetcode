# Problem Analysis: Minimum Cost of Buying Candies With Discount

## Problem Description
Buy candies. For every 2 bought, get 1 free.
Free candy must cost <= min(cost of 2 bought).
Min cost to get all.

## Analysis

1.  **Greedy Sort**:
    -   Sort descending.
    -   Buy largest 2 (`i`, `i+1`). Get `i+2` free.
    -   Total cost `sum(cost[i], cost[i+1])`. Skip `cost[i+2]`.
    -   Repeat.

## Implementation Details
-   Sort. Iterate.
