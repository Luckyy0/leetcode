# Problem Analysis: Count Special Quadruplets

## Problem Description
Array `nums`. Count `(a, b, c, d)` such that `a < b < c < d` and `nums[a] + nums[b] + nums[c] == nums[d]`.
$N \le 50$. Values $\le 100$.

## Analysis

1.  **Brute Force ($N^4$)**:
    -   $50^4 = 6.25 \times 10^6$. Feasible.
    -   Or $O(N^3)$ with Map/Freq array.
    -   Iterate `c` from `n-2` down to 2.
    -   Store `nums[d]` in freq array (for `d > c`).
    -   Iterate `b` from `c-1` down to 1.
    -   Iterate `a` from `b-1` down to 0.
    -   Check if `nums[a] + nums[b] + nums[c]` exists in frequency.
    -   Wait, freq array logic `d > c`:
        -   Iterate `b` (pivot).
        -   Iterate `a < b`. `sum = A + B`. Need `D - C == sum`? No. `A+B+C=D`.
        -   Better: Iterate `b` from `1` to `n-3`.
        -   Maintain counts of `nums[d] - nums[c]`? No.
        -   $N=50$ allows $N^4$. Simple loops.

2.  **Implementation**:
    -   4 nested loops.
    -   Optimized: `O(N^3)`.
    -   Iterate `c` from `n-2` to `2`.
    -   Iterate `d` from `c+1` to `n-1`. Update count of `nums[d]`. No, `c` changes.
    -   Correct $O(N^2)$ approach:
        -   Iterate `b` from `n-3` down to `1`.
        -   Maintain counts of `nums[d] - nums[c]` for all `c > b, d > c`.
        -   Iterate `a < b`. Add counts.
    -   But $N=50$ is tiny. Just brute force.

## Implementation Details
-   4 Loops.
