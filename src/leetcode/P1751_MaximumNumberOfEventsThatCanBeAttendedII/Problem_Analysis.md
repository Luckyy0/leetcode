# Problem Analysis: Maximum Number of Events That Can Be Attended II

## Problem Description
Events `(start, end, value)`. Attend max `k` events. Non-overlapping.
Maximize value.

## Analysis

1.  **DP with Binary Search**:
    -   Sort events by start time.
    -   `dp[i][k]` = max value starting from event `i` with `k` choices left.
    -   Choice 1: Skip event `i` -> `dp[i+1][k]`.
    -   Choice 2: Take event `i` -> `events[i].value + dp[nextIndex][k-1]`.
    -   `nextIndex` is first event starting after `events[i].end`. Find via Binary Search (Upper Bound).
    
2.  **Memoization**:
    -   State `(index, count)`.
    -   $N \le 10^3$ or bigger? Input says $10^5$. K is usually small. Wait.
    -   If $N$ is big, iterative DP or memo is fine if states visited limited?
    -   Actually limits: $N \le 10^6$? No. Usually $N \le 2000$ or similar for this type unless $K=1$.
    -   Checking constraint: $N \le 10^5$, $K \le N$, $K \cdot N \le 10^6$?
    -   Usually $K$ is small.
    -   Wait, standard constraints: $N \le 10^5$. Time limit might be tight for $O(NK)$.
    -   Wait, $N \le 10^5$ usually means $O(N \log N)$ or similar. $O(NK)$ if $K$ is small.
    -   Let's check recursive approach with memoization.

3.  **Complexity**:
    -   Time: $O(N \cdot K \cdot \log N)$ (with search) or $O(N \cdot K)$.
    -   If $K \cdot N$ is large, this is TLE.
    -   Let's assumed constraints. Usually $N$ up to 2000, $K$ up to N.
    -   Often $N=2000$ for $O(NK)$ solutions.
    -   But for $N=10^5$, usually $K$ is small or we optimize.

## Implementation Details
-   Sort by start time.
-   `next_event_index` array precomputed.
