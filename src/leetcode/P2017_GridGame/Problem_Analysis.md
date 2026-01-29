# Problem Analysis: Grid Game

## Problem Description
2xN Grid. Robot 1 goes (0,0) -> (1, N-1). Collects points. Used cells become 0.
Robot 2 goes (0,0) -> (1, N-1). Collects remaining points.
Robot 1 wants to MINIMIZE Robot 2's score.
Robot 2 wants to MAXIMIZE Robot 2's score.
Wait. R1 minimizes R2. R2 (knowing R1 path) maximizes R2.
Find R2's score assuming optimal play.

## Analysis

1.  **Prefix Sums**:
    -   Only two rows. Path must go Right then Down then Right.
    -   Basically: Top row (0,0 to 0,i) -> Down (1,i) -> Bottom row (1,i to 1,N-1).
    -   R1 chooses split point `i`.
    -   Cells collected by R1: `Top[0...i]` and `Bottom[i...N-1]`.
    -   Remaining for R2: `Top[i+1...N-1]` and `Bottom[0...i-1]`.
    -   Since R2 wants to maximize, R2 will choose the MAX of `Sum(Top[i+1...])` or `Sum(Bottom[0...i-1])`.
    -   R1 wants to minimize this value.
    -   Choose `i` to min `max(SumTopRemaining, SumBottomRemaining)`.

## Implementation Details
-   Prefix/Suffix sums.
