# Problem Analysis: Maximum Alternating Subsequence Sum

## Problem Description
Array `nums`.
Alternating sum: $x_0 - x_1 + x_2 - x_3 \dots$
Maximize sum.

## Analysis

1.  **Dynamic Programming**:
    -   State `even`: Max sum ending with a `+` term (index 0, 2, 4 in the subsequence).
    -   State `odd`: Max sum ending with a `-` term (index 1, 3, 5...).
    -   Iterate `x` in `nums`.
    -   New `even`: Can come from previous `even` (skipping `x`) OR from previous `odd` (appending `+x` after a `-` term).
        -   `even = max(even, odd + x)`.
    -   New `odd`: Can come from previous `odd` (skipping `x`) OR from previous `even` (appending `-x` after a `+` term).
        -   `odd = max(odd, even - x)`.
    -   Initially `even = 0` (empty sum), `odd = 0`.
    -   Wait, strictly speaking first term is `+`.
    -   If we start fresh, `odd` transition needs a valid `even`.
    -   However, math works out if we init `odd = 0` (effectively `0 - x`? No, first element must be `+`).
    -   But `odd = max(odd, even - x)`: if `even` is 0 (empty), `0 - x` is negative. A valid subsequence must start with `+`.
    -   However, since we want MAX sum, negative starts won't be chosen over 0 unless forced?
    -   Actually, just init `even = 0`, `odd = 0`.
    -   Or better: `odd` sum must represent a sequence ending in `-`. A sequence cannot start with `-`. So initially `odd` is invalid (or `-infinity`).
    -   `even` sum can be empty (0).
    -   Let's trace:
        -   `even = 0`. `odd = -val`. But we can't do `-val`.
        -   Actually, `odd = even - x` implies subsequence `... + a - x`. Valid.
        -   What if subsequence is just `+x`? `even = odd + x` (where prev odd was 0? No).
        -   If we just take `x` as start: `0 + x`.
        -   Let's refine:
        -   `newEven` considers extending `odd` with `+x`. `odd` represents `sum - last`. `odd + x` = `sum - last + x`.
        -   Also `newEven` can be just `x` (start new). But `odd` initialized to 0 implies `0 + x`? No, effectively `odd` tracks `sum(previous) - last_val`.
        -   If we initialize `odd = 0`, then `odd + x` = `x`. Correct (sequence `x` only).
    -   Result is `even`.

## Implementation Details
-   `long` variables `even`, `odd`.
