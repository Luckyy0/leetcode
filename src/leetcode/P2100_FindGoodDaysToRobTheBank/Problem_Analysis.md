# Problem Analysis: Find Good Days to Rob the Bank

## Problem Description
Array `security`. `time`.
Good day `i`:
-   `security[i - time] >= ... >= security[i]` (non-increasing for `time` days before).
-   `security[i] <= ... <= security[i + time]` (non-decreasing for `time` days after).

## Analysis

1.  **Prefix/Suffix Arrays**:
    -   `nonInc[i]`: length of non-increasing suffix ending at `i`.
        -   If `security[i-1] >= security[i]`, `nonInc[i] = nonInc[i-1] + 1`. Else 0.
        -   (Actually count of days before. Day `i` itself is part of sequence).
        -   Let's say `left[i]` = consecutive days before `i` satisfying condition.
    -   `nonDec[i]`: length of non-decreasing prefix starting at `i`. (Or suffix logic from right).
        -   Scan right-to-left. `right[i]`.
    -   Condition: `left[i] >= time` AND `right[i] >= time`.

## Implementation Details
-   `left`, `right` arrays.
-   Loop.
