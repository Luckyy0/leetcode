# Problem Analysis: Two Out of Three

## Problem Description
Three arrays `nums1`, `nums2`, `nums3`.
List distinct integers present in at least two arrays.

## Analysis

1.  **Sets and Frequency**:
    -   Use 3 boolean arrays (size 101) or HashSets.
    -   Mark presence.
    -   Iterate 1 to 100.
    -   If `(in1 + in2 + in3) >= 2`, add to result.

## Implementation Details
-   `Set` or `boolean[]`.
