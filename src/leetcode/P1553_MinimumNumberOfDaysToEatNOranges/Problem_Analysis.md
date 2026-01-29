# Problem Analysis: Minimum Number of Days to Eat N Oranges

## Problem Description
There are `n` oranges in the kitchen and you decided to eat some of them every day. You can eat the oranges according to these actions:
1.  Eat one orange.
2.  If the number of remaining oranges `n` is divisible by 2, you can eat `n/2` oranges. (So `n/2` remains).
3.  If the number of remaining oranges `n` is divisible by 3, you can eat `2*(n/3)` oranges. (So `n/3` remains).

You can only choose one of the actions per day.
Return the minimum number of days to eat `n` oranges.

## Analysis

1.  **Approach**:
    This can be modeled as a shortest path problem on a graph where nodes are numbers of oranges and edges are the operations.
    Since `n` can be up to $2 \times 10^9$, a linear BFS/DP O(N) is impossible.
    We need something logarithmic.

2.  **Key Insight**:
    It is always optimal to reach a multiple of 2 or 3 as quickly as possible and then divide, rather than subtracting 1 repeatedly for a long time.
    Why? Subtracting 1 costs 1 day to reduce size by 1. Dividing reduces size significantly for 1 day cost.
    
    Recursive relation:
    To solve for `n`:
    -   Option A: Reach the nearest multiple of 2 (which is `n - (n%2)`), divide by 2, and solve for `n/2`.
        Cost: `(n % 2) + 1 + minDays(n / 2)`.
        (`n % 2` gives the steps to subtract 1 to make it divisible by 2. `1` is the day for division operation).
    -   Option B: Reach the nearest multiple of 3 (which is `n - (n%3)`), divide by 3, and solve for `n/3`.
        Cost: `(n % 3) + 1 + minDays(n / 3)`.
    
    `minDays(n) = 1 + min((n % 2) + minDays(n / 2), (n % 3) + minDays(n / 3))` works?
    Actually, we should count the days spent subtracting 1s.
    Correct recurrence:
    `minDays(n) = min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3))`
    Base cases: `minDays(0) = 0`, `minDays(1) = 1`.

3.  **Memoization**:
    Use a Map to store results for `n` to avoid recomputing.
    Since we divide by 2 or 3 at each meaningful step, the number of states visited is roughly $O(\log n \cdot \log n)$ or even smaller ($O(\log n)$ if we consider only unique values generated).

4.  **Complexity**:
    -   Time Complexity: Roughly $O((\log N)^2)$. The number of reachable states is polylogarithmic.
    -   Space Complexity: $O((\log N)^2)$ for the memoization map.

## Implementation Details
-   Use `HashMap<Integer, Integer>` for memoization.
-   Recursive function with base cases.
