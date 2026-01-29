# Problem Analysis: Count Number of Homogenous Substrings

## Problem Description
Count substrings where all chars are same. Modulo $10^9+7$.

## Analysis

1.  **Group Counting**:
    -   Group consecutive identical chars.
    -   If group length is `L`, it contributes `L * (L + 1) / 2` substrings.
    -   Iterate string, track `currentLength`. Reset when char changes.
    -   Sum up.

2.  **Implementation**:
    -   Loop.

## Implementation Details
-   Mod arithmetic. `long` for sum.
