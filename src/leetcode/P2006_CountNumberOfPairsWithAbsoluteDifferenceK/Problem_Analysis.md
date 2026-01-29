# Problem Analysis: Count Number of Pairs With Absolute Difference K

## Problem Description
Array `nums`. Integer `k`. Count `i < j` such that `|nums[i] - nums[j]| == k`.

## Analysis

1.  **HashMap Frequency**:
    -   Iterate `x` in `nums`.
    -   Count `+ map.get(x - k) + map.get(x + k)`.
    -   Update map.
    -   Wait, `|a - b| == k` means `a - b = k` or `b - a = k`.
    -   If we iterate and count previously seen elements:
        -   `prev = x - k`: `|x - (x-k)| = k`.
        -   `prev = x + k`: `|x - (x+k)| = k`.
        -   Sum frequencies.

## Implementation Details
-   `Map<Integer, Integer>`.
