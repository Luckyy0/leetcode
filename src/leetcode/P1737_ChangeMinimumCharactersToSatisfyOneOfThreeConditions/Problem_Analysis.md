# Problem Analysis: Change Minimum Characters to Satisfy One of Three Conditions

## Problem Description
Two strings `a` and `b`.
Change characters to satisfy one of:
1.  Every char in `a` is strictly less than every char in `b`.
2.  Every char in `b` is strictly less than every char in `a`.
3.  Both `a` and `b` consist of only one distinct letter (the same letter).
Return min moves.

## Analysis

1.  **Count Frequencies**:
    -   Count chars of `a` and `b` (arrays size 26).
    
2.  **Condition 3 (Same Char)**:
    -   For each char `c` ('a' to 'z'):
        -   Moves = (len(a) - countA[c]) + (len(b) - countB[c]).
        -   Calculate min over all `c`.
        
3.  **Condition 1 (A < B)**:
    -   We need a partition point `k` ('a' to 'z'-1).
    -   All chars in `a` must be $\le k$. All chars in `b` must be $> k$.
    -   Wait, strictly less means `a` are in range `[some_min...k]`, `b` are in range `[k+1...some_max]`.
    -   So for a partition at `k` (where `k` goes from 'a' to 'y'):
        -   Change all `a` chars $> k$ to be $\le k$. Moves = count of `a` chars $> k$.
        -   Change all `b` chars $\le k$ to be $> k$. Moves = count of `b` chars $\le k$.
        -   Actually, we just need to move them into the respective ranges.
        -   Moves = sum(countA[i] for i > k) + sum(countB[j] for j <= k).
        -   Total moves = `(totalA - prefixSumA[k]) + prefixSumB[k]`.
    -   Valid `k` is 'a' to 'y'. (Can't split at 'z', because B must be strictly greater, impossible if boundary is 'z').

4.  **Condition 2 (B < A)**:
    -   Symmetric to Condition 1.
    -   Moves = `(totalB - prefixSumB[k]) + prefixSumA[k]`.

5.  **Complexity**:
    -   Time: $O(N + M + 26)$.
    -   Space: $O(26)$.

## Implementation Details
-   Prefix sums for counts.
