# Problem Analysis: Longest Winning Streak

## Problem Description
Table `Matches` (player_id, match_day, result 'Win'/'Draw'/'Lose'?).
Actually `result` usually "Win"/"Lose". Draw breaks streak?
"Winning Streak": Consecutive wins.
Find longest streak for each player.

## Analysis

1.  **Gaps and Islands**:
    -   Filter only 'Win' matches? No, streak is broken by loss.
    -   Need to look at sequence of matches for each player ordered by day.
    -   Assign `row_number()` per player.
    -   Identify "Groups" of consecutive wins.
    -   A group of wins is consecutive if `rn - row_number_filtered_by_win` is constant?
    -   Wait. Standard Gaps and Islands:
        -   Filter `result = 'Win'`.
        -   `RN_All`: row_number over (partition player order day).
        -   `RN_Win`: row_number over (partition player order day) -- calculated ONLY on Win subset?
        -   Difference `diff = RN_All - RN_Win`?
        -   Actually: `RN_All` on full set (Wins and Losses). `RN_Win` on subset of Wins.
        -   If we have `W W L W W W`.
        -   Indices: 1 2 3 4 5 6.
        -   Wins at: 1 2 4 5 6.
        -   RN_Win: 1 2 3 4 5.
        -   Diff: 0 0 1 1 1.
        -   Groups: (0, 0) -> W W. (1, 1, 1) -> W W W.
        -   Yes. Group by `player_id`, `diff`. Count.
    -   Find Max Count per player.
    -   Must define `result` column values. Assuming 'Win'.

## Implementation Details
-   CTE for Win matches with `diff`.
-   Group by player, diff.
-   Max per player.
-   Handle players with 0 wins.
