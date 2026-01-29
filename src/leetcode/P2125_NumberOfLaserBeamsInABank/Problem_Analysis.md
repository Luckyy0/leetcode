# Problem Analysis: Number of Laser Beams in a Bank

## Problem Description
Grid `bank` of '0' and '1' (security devices).
Beam between `(r1, c1)` and `(r2, c2)` if:
-   `r1 < r2`.
-   No row between `r1` and `r2` has any device.
-   Total beams = sum for adjacent active rows `count1 * count2`.

## Analysis

1.  **Count per Row**:
    -   Filter rows with > 0 devices.
    -   If row `i` has `c_i` devices, row `j` has `c_j` devices, and no active rows between.
    -   Beams = `c_i * c_j`.
    -   Sum adjacent pairs in list of counts.

## Implementation Details
-   Loop rows.
-   `prevCount`.
-   `ans += prevCount * currCount`.
