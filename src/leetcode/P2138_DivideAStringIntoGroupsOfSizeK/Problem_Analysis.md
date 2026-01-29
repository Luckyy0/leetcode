# Problem Analysis: Divide a String Into Groups of Size k

## Problem Description
String `s`. Groups size `k`.
Fill last group with `fill`.

## Analysis

1.  **Chunking**:
    -   StringBuilder or slice `substring`.
    -   Loop `i` by `k`.
    -   If partial, append `fill`.

## Implementation Details
-   Array size `ceil(n/k)`.
