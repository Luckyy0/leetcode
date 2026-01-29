# Problem Analysis: Stone Game VII

## Problem Description
Stones `stones[i]`. Alice/Bob remove left or right. Score = sum of remaining.
Diff = Alice - Bob. Maximize diff.
`n <= 1000`.

## Analysis

1.  **DP**:
    -   `dp[i][j]` = Max possible score difference for current player given subarray `i \dots j`.
    -   Base case: `i == j` (1 stone). Remove it -> sum 0. Diff 0. `dp[i][i] = 0`?
        -   If 1 stone, remove it, score 0. Diff 0. Yes.
    -   Transition:
        -   Remove Left (`i`): Score gained = `sum[i+1...j]`. Opponent does best on `dp[i+1][j]`. Net = `sum - dp[i+1][j]`.
        -   Remove Right (`j`): Score gained = `sum[i...j-1]`. Net = `sum - dp[i][j-1]`.
        -   `dp[i][j] = max(Sum(i+1, j) - dp[i+1][j], Sum(i, j-1) - dp[i][j-1])`.
    
2.  **Optimization**:
    -   Prefix sums for O(1) range sum.
    -   Space can be optimized to O(N) since we only need length `len-1` to compute `len`.

## Implementation Details
-   2D DP easiest max 1000.
