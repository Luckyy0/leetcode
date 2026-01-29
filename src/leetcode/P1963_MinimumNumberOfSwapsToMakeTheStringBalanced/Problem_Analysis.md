# Problem Analysis: Minimum Number of Swaps to Make the String Balanced

## Problem Description
String `s` (even length, equal '[' and ']').
Swap any two characters. Make balanced.
Minimize swaps.

## Analysis

1.  **Imbalance Counting**:
    -   Cancel out valid `[]`.
    -   Remaining string will look like `]]]...[[[` (m closing, m opening).
    -   Each swap can fix 2 unbalanced pairs best case?
    -   Actually, `][` -> swap `[` and `]` -> `[]`. One swap fixes 1 pair?
    -   Look at `]]]...[[[`. Example `][`. Swap to `[]`. 1 swap. Imbalance 1.
    -   Example `]]][[[`. Swap first `]` with last `[`. `[]][[]`. Middle `][` remains.
    -   Wait. Swap `s[0]` (`]`) with `s[5]` (`[`). Result `[]][[]`.
    -   The `[]` at ends are valid. Inner `][` needs 1 swap.
    -   Total 2 swaps? No, 1 swap fixed middle?
    -   Actually, count `max_closed` imbalance.
    -   Traverse string. `balance`. `[`: +1, `]`: -1.
    -   Track minimum balance reached (most negative).
    -   Let `min_bal` be the minimum value. E.g. -3.
    -   This means we have 3 excess `]` at some point.
    -   We need to swap `[` from later to fix these `]`.
    -   One swap fixes 2 units of imbalance?
    -   Formula: `(max_imbalance + 1) / 2`.
    -   Why? Each swap converts `]...[` to `[...`.
    -   Effectively turning a `-1` contribution to `+1`, changing balance by +2.
    -   So to cover a deficit of `D` (where D is absolute min balance), we need `ceil(D / 2)` swaps.

2.  **Implementation**:
    -   Scan `s`. `bal`. `minBal`.
    -   Return `(-minBal + 1) / 2`.

## Implementation Details
-   Loop.
