# Problem Analysis: Find Valid Matrix Given Row and Column Sums

## Problem Description
You are given two arrays `rowSum` and `colSum` of non-negative integers where `rowSum[i]` is the valid sum of the elements in the i-th row and `colSum[j]` is the valid sum of the elements in the j-th column of a 2D matrix. 
Find any matrix of non-negative integers of size `rowSum.length x colSum.length` that satisfies the rowSum and colSum requirements.
It is guaranteed that at least one matrix exists.

## Analysis

1.  **Greedy Approach**:
    -   We can construct the matrix element by element or row by row.
    -   At position `(i, j)`, we want to satisfy as much of `rowSum[i]` and `colSum[j]` as possible without expecting impossible values.
    -   Since we must not exceed either sum (as values are non-negative), the maximum value we can put at `(i, j)` is `min(rowSum[i], colSum[j])`.
    -   Let `val = min(rowSum[i], colSum[j])`.
    -   Set `matrix[i][j] = val`.
    -   Subtract val from `rowSum[i]` and `colSum[j]`.
    -   One of the sums (either row or col) will become 0.
    -   Assuming consistent total sums (guaranteed), iterating through all `(i, j)` will perfectly fill the matrix.
    
2.  **Iteration**:
    -   Typical nested loop `i` in `0..m`, `j` in `0..n`.
    -   Actually, simpler logical optimization:
        -   If `rowSum[i]` becomes 0, we are done with this row.
        -   If `colSum[j]` becomes 0, we can technically skip to next column? Or just putting 0 is fine.
        -   Standard loops work fine.

3.  **Correctness**:
    -   At each step, we satisfy at least one constraint (reduce a Row sum to 0 or Col sum to 0).
    -   Total sum of RowSums == Total sum of CovSums is maintained invariant.
    -   This guarantees completion.

4.  **Complexity**:
    -   Time: $O(M \times N)$.
    -   Space: $O(1)$ (output matrix).

## Implementation Details
-   `rowSum` and `colSum` can be modified in place or copies used.
