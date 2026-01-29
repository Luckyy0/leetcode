# Problem Analysis: Maximum Ice Cream Bars

## Problem Description
Array `costs` of ice creams. `coins`.
Buy max ice creams.

## Analysis

1.  **Sort**:
    -   Sort costs.
    -   Buy cheapest until coins run out.

2.  **Counting Sort**:
    -   Since costs are up to $10^5$, counting sort is $O(N + MaxCost)$.
    -   Standard sort is $N \log N$. Both fast enough.

## Implementation Details
-   `Arrays.sort`.
