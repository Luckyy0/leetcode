# Problem Analysis: Stone Game V

## Problem Description
There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array `stoneValue`.
In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.
The game ends when there is only one stone remaining. Alice's is initially 0.
Return the maximum score that Alice can obtain.

## Analysis

1.  **Dynamic Programming (Range DP)**:
    -   State: `dp[i][j]` is the max score Alice can get from the subarray `stoneValue[i...j]`.
    -   Base Case: If `i == j`, `dp[i][j] = 0` (Game ends, no split possible).
    -   Transitions: Try all split points `k` from `i` to `j-1`.
        -   Left part: `i` to `k`. Sum `L`.
        -   Right part: `k+1` to `j`. Sum `R`.
        -   Bob's logic:
            -   If `L < R`: Alice keeps Left. Score = `L + dp[i][k]`.
            -   If `L > R`: Alice keeps Right. Score = `R + dp[k+1][j]`.
            -   If `L == R`: Alice chooses best. Score = `max(L + dp[i][k], R + dp[k+1][j])`.
        -   `dp[i][j] = max(over all k) of outcome`.

2.  **Optimizations**:
    -   Prefix Sums to calculate range sums in $O(1)$.
    -   Constraints: `n <= 500`. $O(N^3)$ is acceptable ($500^3 \approx 1.25 \times 10^8$, might be tight but Java usually passes within 2-3 sec).
    -   $O(N^3)$ approach is the straightforward one.

3.  **Complexity**:
    -   Time: $O(N^3)$.
    -   Space: $O(N^2)$ for DP table.

## Implementation Details
-   Precompute Prefix Sums `preSum`. `sum(i, j) = preSum[j+1] - preSum[i]`.
-   Iterate `len` from 2 to `n`.
-   Iterate `i` from 0 to `n - len`.
-   `j = i + len - 1`.
-   Loop `k` and take max.
