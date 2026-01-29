# Problem Analysis: Calculate Money in Leetcode Bank

## Problem Description
Total `n` days.
Monday `1`, Tuesday `2`... Sunday `7`.
Next Monday `2`, Tuesday `3`...
Calculate total money.

## Analysis

1.  **Arithmetic Series**:
    -   Weeks `k = n / 7`.
    -   Remaining days `d = n % 7`.
    -   Sum of first week: `28`.
    -   Sum of `i-th` week (0-indexed): `28 + 7*i`.
    -   Total full weeks = $\sum_{i=0}^{k-1} (28 + 7i) = 28k + 7 \frac{k(k-1)}{2}$.
    -   Remaining days start at `k+1`. Sum `(k+1) + (k+2) + ... + (k+d)`.
    -   Sum is `k*d + d(d+1)/2`.

2.  **Complexity**:
    -   Time: $O(1)$.
    -   Space: $O(1)$.

## Implementation Details
-   Math.
