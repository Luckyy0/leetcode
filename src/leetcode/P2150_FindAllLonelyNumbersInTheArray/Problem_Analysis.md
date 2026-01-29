# Problem Analysis: Find All Lonely Numbers in the Array

## Problem Description
Lonely: Appears exactly once. No adjacent numbers (`x-1`, `x+1`) appear in array.

## Analysis

1.  **HashMap Frequency**:
    -   Count freq.
    -   Iterate keys.
    -   if `freq[x] == 1` and `!containsKey(x-1)` and `!containsKey(x+1)`: add `x`.

## Implementation Details
-   `Map<Integer, Integer>`.
-   Result List.
