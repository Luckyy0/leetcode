# Problem Analysis: Widest Pair of Indices With Equal Range Sum

## Problem Description
Two arrays `nums1`, `nums2` (binary 0/1).
Find pair `(i, j)` with $i \le j$ such that `sum(nums1[i...j]) == sum(nums2[i...j])`.
Maximize `j - i`.
Condition equivalent to: `(prefix1[j+1] - prefix1[i]) == (prefix2[j+1] - prefix2[i])`.
`prefix1[j+1] - prefix2[j+1] == prefix1[i] - prefix2[i]`.
Let `diff[k] = prefix1[k] - prefix2[k]`.
Find `i, j` such that `diff[j+1] == diff[i]`. Maximize `(j+1) - i`.
Basically find min index and max index for each value in `diff` array.

## Analysis

1.  **Prefix Difference + HashMap**:
    -   Compute `diff` array.
    -   Store `first_occurrence[value]`.
    -   For each `k`, `dist = k - first_occurrence[diff[k]]`. Maximize.

## Implementation Details
-   `Map<Integer, Integer>`.
-   Range `i` from `0` to `n`.
