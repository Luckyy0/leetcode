# Problem Analysis: Palindrome Partitioning IV

## Problem Description
Split string `s` into exactly three non-empty palindromic substrings.

## Analysis

1.  **Palindrome Check**:
    -   Precompute `isPal[i][j]` using DP or expansion. $O(N^2)$.
    -   Check all split points `i, j`: `s[0...i]`, `s[i+1...j]`, `s[j+1...n-1]`.
    -   Loop `i` from `0` to `n-3`.
    -   If `isPal[0][i]`:
        -   Loop `j` from `i+1` to `n-2`.
        -   If `isPal[i+1][j]` and `isPal[j+1][n-1]`, true.
    
2.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N^2)$.

## Implementation Details
-   `boolean[][] dp`.
