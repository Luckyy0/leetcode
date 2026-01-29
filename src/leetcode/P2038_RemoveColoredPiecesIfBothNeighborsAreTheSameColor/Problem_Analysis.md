# Problem Analysis: Remove Colored Pieces if Both Neighbors are the Same Color

## Problem Description
String `colors` ('A', 'B').
Alice removes 'A' if neighbors are 'A'. Bob removes 'B' if neighbors are 'B'.
Cannot remove edge pieces (must have 2 neighbors).
Turn based. If cannot move, lose. Alice first.

## Analysis

1.  **Counting Available Moves**:
    -   Moves are independent. Removing 'A' doesn't affect 'B' (except merging segments, but wait...).
    -   If A removes 'A' from `AA...A`, the segment shrinks. This might merge two B segments?
    -   No. If sequence is `..B A AA A B..`. Removing middle A -> `..B A A B..`.
    -   Only 'A's surrounded by 'A's can be removed.
    -   A segment of `k` 'A's allows `k-2` moves (if `k >= 3`).
    -   Removing an 'A' reduces length to `k-1`, allowing `k-3` moves.
    -   So a segment of `k` allows exactly `max(0, k-2)` TOTAL moves.
    -   Does removing A affect B? B needs `BBB`.
    -   Since removing A just shortens A segments, B segments remain separate?
    -   Actually, `AAABBBB`. B removes B -> `AAABBB`. A removes A -> `AABBB`.
    -   The boundaries are fixed by alternating colors?
    -   Yes, because A can only remove A surrounded by A. So `AB A B` cannot become `ABB`.
    -   Thus, A moves and B moves are pre-calculated and independent.
    -   Game is simple number comparison.
    -   Alice wins if `movesA > movesB`. (Alice starts, so need strictly more? No, if `A > B`, then A plays, B plays... B runs out first? Yes).
    -   Usually: A moves $N_A$, B moves $N_B$. A wins if $N_A > N_B$.

## Implementation Details
-   Loop string. Count consecutive.
