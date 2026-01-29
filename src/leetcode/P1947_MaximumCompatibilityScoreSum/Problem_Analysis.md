# Problem Analysis: Maximum Compatibility Score Sum

## Problem Description
`students` (`m x n`), `mentors` (`m x n`).
Pair each student with distinct mentor.
Score of pair: number of matching answers.
Maximize total score. `m <= 8`.

## Analysis

1.  **Backtracking or DP Bitmask**:
    -   $m \le 8$ is tiny.
    -   Try all permutations of mentors assigned to students.
    -   $8! = 40320$. Feasible.
    -   Or `dp[mask]` = max score for subset of students `mask` paired with first `k` mentors?
    -   Actually `dp[mask]` where mask represents used mentors, for student `i` (where `i = countSetBits(mask)`).
    -   `dp[mask] = max(dp[mask ^ (1<<j)] + score(student[i-1], mentor[j]))`.

## Implementation Details
-   Precompute pair scores `score[i][j]`.
-   DP array `dp[1 << m]`.
