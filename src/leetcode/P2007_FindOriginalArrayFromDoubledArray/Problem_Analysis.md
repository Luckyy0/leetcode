# Problem Analysis: Find Original Array From Doubled Array

## Problem Description
Array `changed` is formed by appending `2*x` for each `x` in `original`, then shuffling.
Retrieve `original`. If invalid, return empty.
Zeros: `0 -> 0, 0`. Handled carefully.

## Analysis

1.  **Sorting + Frequency Map**:
    -   Sort `changed`.
    -   Count frequencies.
    -   Iterate small to large `x`.
    -   If `count[x] > 0`:
        -   It must be an original number.
        -   We need `2*x` to exist.
        -   If `count[2*x] < count[x]`, invalid.
        -   Decrement `count[2*x]` by `count[x]`. (Actually simpler to process one by one or in batches).
        -   Because sorted, `x` cannot be the doubled part of a smaller number (already processed).
        -   Special case `0`: need even count of 0s.

2.  **Implementation**:
    -   Sort.
    -   Use `TreeMap` or Array (if range small). Range $10^5$. Array `freq[100001]` works.
    -   Iterate sorted keys `x`.
    -   If `freq[x] > 0`:
        -   Need `freq[2*x] >= freq[x]`.
        -   Add `x` to result `freq[x]` times.
        -   Subtract `freq[x]` from `freq[2*x]`.
        -   Set `freq[x] = 0`.
    -   Check 2*x bounds.

## Implementation Details
-   Freq Array.
-   Loop max value is 100000.
