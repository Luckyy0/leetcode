# Problem Analysis: Jump Game VII

## Problem Description
Binary string `s`. Start at `0` (must be '0').
Jump from `i` to `j` if:
- `i + minJump <= j <= min(i + maxJump, n - 1)`
- `s[j] == '0'`
Return true if can reach `n - 1`.

## Analysis

1.  **Sliding Window / DP**:
    -   Let `dp[i]` be true if index `i` is reachable.
    -   `dp[i]` is true if `s[i] == '0'` AND there exists `k` such that `dp[k]` is true and `i - maxJump <= k <= i - minJump`.
    -   We can check range condition efficiently.
    -   Maintain a count of reachable indices `k` in the current valid window `[i - maxJump, i - minJump]`.
    -   As `i` increments, the window slides.
    -   Add `dp[i - minJump]` (if valid index) to count.
    -   Remove `dp[i - maxJump - 1]` (if valid index) from count.
    -   If `count > 0`, `dp[i] = true`.

2.  **Complexity**:
    -   $O(N)$.

## Implementation Details
-   Boolean array `dp`.
-   `reachableCount` int.
