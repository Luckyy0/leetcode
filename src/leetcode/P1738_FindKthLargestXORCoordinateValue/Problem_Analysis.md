# Problem Analysis: Find Kth Largest XOR Coordinate Value

## Problem Description
Matrix `matrix`.
`value[i][j]` is XOR of all elements in rectangle top-left `(0,0)` to bottom-right `(i,j)`.
Find `k`-th largest value in `value`.

## Analysis

1.  **2D Prefix XOR**:
    -   `value[i][j] = matrix[i][j] ^ value[i-1][j] ^ value[i][j-1] ^ value[i-1][j-1]`.
    -   Careful with boundaries (indices < 0).
    -   Compute all values. Store in a list/priority queue.
    
2.  **Selection**:
    -   We need K-th largest.
    -   Collect all `m*n` values. Sort or use MinHeap of size K (or MaxHeap/Sort for simplicity given constraints).
    -   $M, N \le 1000$. Total $10^6$. Sorting is $10^6 \log 10^6 \approx 2 \cdot 10^7$, acceptable.

3.  **Complexity**:
    -   Time: $O(MN \log (MN))$ or $O(MN)$ with QuickSelect.
    -   Space: $O(MN)$.

## Implementation Details
-   DP array same size as matrix.
-   List.
