# Problem Analysis: Maximum Absolute Sum of Any Subarray

## Problem Description
Max absolute sum of subarray.

## Analysis

1.  **Kadane Variant**:
    -   Max absolute sum is either `abs(max_pos_sum)` or `abs(min_neg_sum)`.
    -   Run Kadane to find Max Subarray Sum.
    -   Run Kadane to find Min Subarray Sum.
    -   Result = `max(maxSum, abs(minSum))`.

2.  **Prefix Sum Method**:
    -   Result = `max(prefix) - min(prefix)`.
    -   Prefix array includes 0.
    -   Why? Any subarray sum is `P[j] - P[i]`.
    -   Max value of `|P[j] - P[i]|` is max diff between any two prefix sums.
    -   Which is `max(P) - min(P)`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   `maxPref`, `minPref`, `currPref`.
