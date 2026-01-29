# Problem Analysis: Finding Pairs With a Certain Sum

## Problem Description
Data structure `FindSumPairs`.
- `nums1` (static, small size <= 1000).
- `nums2` (dynamic, large size <= 10^5).
- `add(index, val)`: `nums2[index] += val`.
- `count(tot)`: Pairs `(i, j)` with `nums1[i] + nums2[j] == tot`.

## Analysis

1.  **Map for nums2**:
    -   Since `nums2` is large and dynamic, but we need fast lookup for `tot - nums1[i]`, we maintain a frequency map of `nums2`.
    -   `nums1` is small, so in `count(tot)`, we iterate `nums1` ($O(1000)$), and look up `map2` ($O(1)$). Total $O(1000)$.
    -   `add(index, val)`:
        -   Update `nums2[index]`.
        -   Update `map2`: dec old val count, inc new val count.
        -   $O(1)$.

## Implementation Details
-   `HashMap<Integer, Integer> map2`.
-   `int[] nums1`, `int[] nums2`.
