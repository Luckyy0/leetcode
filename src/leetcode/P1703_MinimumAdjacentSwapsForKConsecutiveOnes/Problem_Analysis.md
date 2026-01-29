# Problem Analysis: Minimum Adjacent Swaps for K Consecutive Ones

## Problem Description
Array `nums` (0/1). `k`.
Min swaps to make `k` consecutive ones.

## Analysis

1.  **Transformation**:
    -   Indices of ones: `p`.
    -   We pick a window of `k` ones: `p[i] \dots p[i+k-1]`.
    -   We want to move them to `x, x+1, \dots, x+k-1`.
    -   Cost: `\sum_{j=0}^{k-1} |p[i+j] - (x+j)|`.
    -   Cost: `\sum |(p[i+j] - j) - x|`.
    -   Let `y_j = p[i+j] - j`. We minimize `\sum |y_j - x|`.
    -   Optimal `x` is the median of `y` values in the window.
    -   Since `y` is sorted (proven in previous steps), median is middle element.
    
2.  **Calculation with Sliding Window**:
    -   Construct array `zeros`?
    -   Or construct `p`. Then `A[j] = p[j] - j`.
    -   For window `A[i \dots i+k-1]`.
    -   Median index `mid = i + k/2`. Median value `med = A[mid]`.
    -   Cost = `(countRight * med - sumRight) + (sumLeft - countLeft * med)`. Wait, standard median deviation formula.
    -   Sum of `|A[j] - med|`.
    -   Since `A` is sorted:
        -   Right half (values >= med): `sum(Right) - countRight * med`.
        -   Left half (values <= med): `countLeft * med - sum(Left)`.
    -   We need `sum(Right)` and `sum(Left)` efficiently.
    -   Prefix sums of `A`.
    -   `P[x]` sum of `A[0 \dots x-1]`.
    -   Sum of `A[u \dots v]` = `P[v+1] - P[u]`.
    -   Window size `k`.
        -   Even `k`: Median can be either, costs same? Actually `k` points, median is usually `(k-1)/2`.
        -   Let `radius = (k-1)/2` (number of elements to left).
        -   `mid` index relative to window start `i`: `i + k/2`.
    
3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   Extract indices `p`.
-   Compute `new_p` where `new_p[j] = p[j] - j`.
-   Prefix sum of `new_p`.
-   Iterate windows.
-   Be careful with indices.
