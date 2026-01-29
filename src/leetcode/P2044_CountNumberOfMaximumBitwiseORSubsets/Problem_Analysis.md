# Problem Analysis: Count Number of Maximum Bitwise-OR Subsets

## Problem Description
Array `nums`.
Find max bitwise OR of any subset.
Count number of subsets with this OR.

## Analysis

1.  **Recursion / Backtracking**:
    -   Constraint $N \le 16$.
    -   $2^{16} = 65536$. Trivial.
    -   Calculate Max OR (OR of all elements).
    -   Recursively count subsets matching Max OR.

## Implementation Details
-   `dfs(index, currentOR)`.
