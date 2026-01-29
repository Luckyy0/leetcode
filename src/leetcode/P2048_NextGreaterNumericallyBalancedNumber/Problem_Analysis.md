# Problem Analysis: Next Greater Numerically Balanced Number

## Problem Description
Integer `n`. Numerically balanced if freq of digit `d` is `d`.
Find smallest numerically balanced number strictly greater than `n`.
$0 \le n \le 10^6$.
Result will likely be $\le 10^7$.

## Analysis

1.  **Brute Force / Generation**:
    -   Balanced numbers are sparse.
    -   Max digits needed?
        -   Maybe 7 digits? `122333` (len 6). `1224444` (len 7).
        -   Sum of digits = length.
        -   Lengths possible:
            -   1: 1
            -   2: 22 ? No. sum is 2. (2 appearing 2 times) -> 22.
            -   3: 1, 2. (1 appearing 1, 2 appearing 2). Permutations of 122.
            -   3: 333 (sum 3).
            -   4: 1333, 4444.
            -   5: 14444, 22333, 55555.
            -   6: 122333, 155555, 222444, 666666.
            -   7: 1224444.
    -   Since $n \le 10^6$, answer has at most 7 digits.
    -   Strategy: Iterate `x = n + 1` upwards and check?
    -   Or Generate all balanced numbers up to ~10^7, sort, find upper bound.
    -   Generation is faster.
    -   Total balanced numbers is small.

## Implementation Details
-   Backtracking to generate balanced numbers.
-   Sort and search.
-   Combinations of digits summing to L (1 to 7).
-   Then Permutations.
