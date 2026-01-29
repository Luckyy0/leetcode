# Problem Analysis: Count Pairs in Two Arrays

## Problem Description
Count pairs `i < j` s.t. `nums1[i] + nums1[j] > nums2[i] + nums2[j]`.
Equivalent to `(nums1[i] - nums2[i]) + (nums1[j] - nums2[j]) > 0`.

## Analysis

1.  **Sorting + Two Pointers**:
    -   Create `diff` array. `diff[i] = nums1[i] - nums2[i]`.
    -   We need `diff[i] + diff[j] > 0` with `i < j`.
    -   Sorting `diff` doesn't change element values, just order. Since pair condition and sum is commutative, original indices don't matter for the count (just need distinct pairs).
    -   Sort `diff` ascending.
    -   Using two pointers: `l=0, r=n-1`.
    -   If `diff[l] + diff[r] > 0`: `r` can pair with any index from `l` to `r-1`. Count `r-l`. Dec `r`.
    -   Else: `diff[l]` is too small. Inc `l`.

## Implementation Details
-   Loop.
