# Problem Analysis: Minimum XOR Sum of Two Arrays

## Problem Description
`nums1` and `nums2` of length `n`.
Permute `nums2` to min `sum(nums1[i] ^ nums2[i])`.
`n <= 14`.

## Analysis

1.  **Bitmask DP**:
    -   `dp[mask]` = min XOR sum matching first `k` elements of `nums1` with subset `mask` of `nums2`.
    -   `k = bitCount(mask)`.
    -   State transition: `mask` represents chosen elements from `nums2`.
    -   To reach state `mask`, we might have added `j` (j-th bit set in mask) as the LAST matching.
    -   This `j` matches `nums1[k-1]`.
    -   `dp[mask] = min(dp[mask ^ (1<<j)] + (nums1[k-1] ^ nums2[j]))` for all `j` set in `mask`.
    -   Iterate mask `1` to `2^n - 1`.

## Implementation Details
-   `int[] dp` size `1<<n`. Values init MAX.
