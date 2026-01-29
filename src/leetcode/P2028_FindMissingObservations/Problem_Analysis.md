# Problem Analysis: Find Missing Observations

## Problem Description
`m` observed dice rolls `rolls`. Total `n + m` rolls. Mean is `mean`.
Find `n` missing rolls (1-6). Return any valid array, or empty if impossible.

## Analysis

1.  **Sum Calculation**:
    -   Total sum = `mean * (n + m)`.
    -   Observed sum = `sum(rolls)`.
    -   Missing sum = Total - Observed.
    -   Check if `missing sum` can be formed by `n` dice (value 1-6).
    -   Condition: `n * 1 <= missing sum <= n * 6`.
    -   Construct:
        -   Base value `val = missing / n`.
        -   Remainder `rem = missing % n`.
        -   Fill `n` elements with `val`.
        -   Add 1 to first `rem` elements.

## Implementation Details
-   If impossible return empty.
