# Problem Analysis: Sum of Special Evenly-Spaced Elements in Array

## Problem Description
Array `nums`. Queries `[index, stride]`.
Sum elements at `index, index + stride, ...`. Modulo $10^9+7$.

## Analysis

1.  **Sqrt Decomposition**:
    -   Let $B = \sqrt{N}$.
    -   For `stride >= B`:
        -   Directly loop. Number of steps $\le N/B = \sqrt{N}$.
    -   For `stride < B`:
        -   Precompute `dp[stride][index]`.
        -   `dp[stride][i] = nums[i] + dp[stride][i + stride]`.
        -   Can be computed backwards.
        -   Max stride $\approx 200$.
    
2.  **Complexity**:
    -   Preprocessing: $O(N \cdot B)$.
    -   Query: $O(1)$ or $O(N/B)$. Total $Q \sqrt{N}$.
    -   For $N=50000$, $\sqrt{N} \approx 225$.

## Implementation Details
-   `B = 250` roughly.
-   `dp[B][N]`.
