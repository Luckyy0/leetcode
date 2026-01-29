# Problem Analysis: Maximum Score from Performing Multiplication Operations

## Problem Description
`nums` array, `multipliers` array. Sizes $N$ and $M$.
Perform $M$ operations. Pick left or right of `nums`, multiply by `multipliers[i]`.
Max score.

## Analysis

1.  **DP**:
    -   State: `(opIndex, leftIndex)`. `rightIndex` is implicit: `n - 1 - (opIndex - leftIndex)`.
    -   $dp[i][left]$: max score from operation `i` onwards, having picked `left` elements from left side.
    -   Transitions:
        -   Pick Left: `mul[i] * nums[left] + dp[i+1][left+1]`.
        -   Pick Right: `mul[i] * nums[right] + dp[i+1][left]`.
    
2.  **Complexity**:
    -   State: $M \times M$. ($M \le 1000$).
    -   Time: $O(M^2)$.
    -   Space: $O(M^2)$.

## Implementation Details
-   `Integer[][] memo` or `int[][] dp` (iterative).
-   Use iterative to save recursion stack and potential overhead. Or memo. $N$ can be $10^5$, but state only depends on $M$.
