# Problem Analysis: Minimum Absolute Sum Difference

## Problem Description
`nums1`, `nums2`.
Sum `|nums1[i] - nums2[i]|`.
Can verify ONE `nums1[i]` with any `nums1[j]`.
Minimize sum.

## Analysis

1.  **Optimization**:
    -   Calculate initial total `diff`.
    -   For each `i`, we can hypothetically change `nums1[i]` to `nums1[j]`.
    -   Gain = `|nums1[i] - nums2[i]| - |nums1[j] - nums2[i]|`.
    -   We want to maximize Gain.
    -   For a fixed `i`, we want `nums1[j]` closest to `nums2[i]`.
    -   Use a `TreeSet` or sorted array of `nums1` to efficiently find closest element to `nums2[i]`.
    -   Iterate all `i`, find best `j`.
    
2.  **Complexity**:
    -   Sort `nums1`: $O(N \log N)$.
    -   Iterate and search: $O(N \log N)$.
    -   Total $O(N \log N)$.

## Implementation Details
-   `TreeSet` ceiling/floor.
-   Modulo arithmetic for final sum? Only at return stage? No, intermediate sum can exceed int? Not usually, but return is modulo. Constraints: values up to $10^5$, N up to $10^5$. Max sum $10^{10}$, fits in long.

