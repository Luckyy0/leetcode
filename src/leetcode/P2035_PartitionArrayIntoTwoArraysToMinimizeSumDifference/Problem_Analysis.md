# Problem Analysis: Partition Array Into Two Arrays to Minimize Sum Difference

## Problem Description
Array `nums` length `2n`.
Partition into two arrays of length `n`.
Minimize `|sum(A) - sum(B)|`.

## Analysis

1.  **Meet-in-the-Middle**:
    -   Split `nums` into left half (`n`) and right half (`n`).
    -   Generate all subset sums for Left. Group by subset size (0 to n). `leftSums[k]` = list of sums using `k` elements.
    -   Generate all subset sums for Right. `rightSums[k]` = list of sums using `k` elements.
    -   We need to pick `k` elements from Left and `n-k` from Right to form set A (size n).
    -   Total sum `S`.
    -   Sum(A) = `L_sum + R_sum`.
    -   Minimize `|2 * Sum(A) - S|`. Equivalent to `Sum(A)` close to `S/2`.
    -   For each `k` (0 to n):
        -   Iterate `val` in `leftSums[k]`.
        -   We need `val + R_val` approx `S/2`.
        -   `R_val` approx `S/2 - val`.
        -   Use Binary Search (lower_bound) on `rightSums[n-k]` (must be sorted).
        -   Update min absolute difference.

## Implementation Details
-   Generate subsets: $2^{15} = 32768$. Feasible.
-   Sort lists.
-   Binary Search.
