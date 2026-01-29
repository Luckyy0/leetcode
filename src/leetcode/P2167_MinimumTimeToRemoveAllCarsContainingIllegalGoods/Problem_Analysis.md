# Problem Analysis: Minimum Time to Remove All Cars Containing Illegal Goods

## Problem Description
String `s`. '1' illegal.
Remove:
1.  Left (1)
2.  Right (1)
3.  Middle (2)

## Analysis

1.  **DP / Cost Function**:
    -   `left[i]`: cost to clear prefix `0..i`.
        -   `min(i+1, left[i-1] + (s[i]=='1' ? 2 : 0))`.
    -   `right[i]`: cost to clear suffix `i..n-1`.
        -   `min(n-i, right[i+1] + (s[i]=='1' ? 2 : 0))`.
    -   Result `min(left[i] + right[i+1])`.
    -   Base cases: `left[-1] = 0`, `right[n] = 0`.
    -   Iterate split point from `-1` to `n-1`.

## Implementation Details
-   Arrays.
-   Loop forward, loop backward.
-   Combine.
