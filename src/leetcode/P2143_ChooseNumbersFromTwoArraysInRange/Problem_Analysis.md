# Problem Analysis: Choose Numbers From Two Arrays in Range

## Problem Description
Arrays `nums1`, `nums2`. Range `[l, r]`.
For each `i`, choose `nums1[i]` or `nums2[i]`.
Sum of chosen numbers must be in `[l, r]`.
Count ways modulo 10^9+7.

## Analysis

1.  **Dynamic Programming**:
    -   `dp[i][current_sum]`: ways to choose first `i` with sum.
    -   State space for sum?
    -   If `n` is large or sum is large, simple DP fails.
    -   Constraints usually small if DP on sum.
    -   If constraints large: maybe sum is small relative to something?
    -   Or `l, r` logic?
    -   Wait. P2143 "Choose Numbers ... in Range".
    -   Actually P2143 is: "Annual Project Budget" or something? No, that's different.
    -   Check title: "Choose Numbers From Two Arrays in Range".
    -   Actually, is this P2143?
    -   Assuming `nums1[i], nums2[i]` positive.
    -   Standard DP.
    -   Space optimization: 2 rows or in-place map.
    -   `Map<Sum, Count> dp`.
    -   Iterate `i`:
        -   `new_dp`
        -   For `s` in `dp`:
            -   `new_dp[s + nums1[i]] += count`
            -   `new_dp[s + nums2[i]] += count`
    -   If sum grows large, prune? No, we need sum range `[l, r]`. If sum > `r`, discard?
    -   If `nums` positive, yes discard > r.
    -   Return `sum(dp[l...r])`.

## Implementation Details
-   `Map` for sparse sum.
-   Modulo arithmetic.
