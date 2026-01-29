# Problem Analysis: Jump Game VI

## Problem Description
Array `nums`. Jump at most `k` steps forward. Score is sum of visited elements.
Start at 0. End at n-1. Maximize score.

## Analysis

1.  **DP + Sliding Window Max**:
    -   `dp[i]` = max score ending at `i`.
    -   `dp[i] = nums[i] + max(dp[i-k], ..., dp[i-1])`.
    -   Naive DP: $O(N \cdot K)$. $N=10^5, K=10^5$. Start TLE.
    -   Optimization: Use Deque to maintain indices of decreasing `dp` values.
    -   Front of Deque is always max index for `dp`.
    -   Remove old indices. Add current index.

2.  **Algorithm**:
    -   `dp[0] = nums[0]`. Steps.
    -   Deque stores indices `j`. `dp[j]` is decreasing.
    -   Loop `i` from 1 to `n-1`:
        -   Remove `j < i - k` from front.
        -   `maxPrev = dp[deque.peekFirst()]`.
        -   `dp[i] = nums[i] + maxPrev`.
        -   While `dp[deque.peekLast()] <= dp[i]`, pollLast.
        -   Add `i`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `LinkedList` as Deque.
