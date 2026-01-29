# Problem Analysis: Largest Number After Mutating Substring

## Problem Description
String `num`. Array `change` (0-9 mapping).
Mutate a **single substring** of `num` by replacing digit `d` with `change[d]`.
Maximize the resulting number string.
Greedy: Change a substring if `change[d] >= d`.
Start mutating as soon as `change[d] > d`.
Continue as long as `change[d] >= d`.
Stop when `change[d] < d`.
Only mutate one contiguous block.

## Analysis

1.  **Greedy Scan**:
    -   Iterate `i` from 0.
    -   Find first `i` where `change[num[i]] > num[i]`.
    -   If none, return `num`.
    -   From `i`, continue while `change[num[k]] >= num[k]`.
    -   Replace digits.
    -   Break when `change[num[k]] < num[k]`.
    -   Return modified string.

## Implementation Details
-   `char[]` to modify.
