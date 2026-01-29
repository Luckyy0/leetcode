# Problem Analysis: Maximize Palindrome Length From Subsequences

## Problem Description
Two strings `word1`, `word2`. Concatenate `s = word1 + word2`.
Find longest palindrome subsequence in `s` that uses chars from BOTH `word1` and `word2`.
If no such subsequence, return 0.

## Analysis

1.  **Longest Palindromic Subsequence (LPS)**:
    -   Standard DP: `dp[i][j]` = LPS of `s[i...j]`.
    -   Constraints: `N, M <= 1000`. Total length 2000. $O(L^2)$ allowed.
    -   Compute standard LPS for `s`.
    -   However, constraint is: must use at least one index from `word1` (0 to n-1) and one from `word2` (n to n+m-1).
    -   We need to find `max(dp[i][j])` such that:
        -   `s[i] == s[j]` (boundary characters match).
        -   `i < n` (start in word1).
        -   `j >= n` (end in word2).
        -   If `s[i] == s[j]`, then LPS length is `2 + dp[i+1][j-1]`.
        -   This condition (boundary match across words) ensures we used at least one from each side?
        -   Yes. If the outermost pair `(i, j)` matches and spans the boundary, then `s[i]` is from word1 and `s[j]` is from word2. The rest of the palindrome is between them.
        -   Is it possible the optimal palindrome doesn't have matching *outermost* characters from both sides?
        -   No. Every palindrome has outermost matching characters. If the palindrome spans the boundary (uses both sides), let `i` be the leftmost index (must be in word1) and `j` be the rightmost index (must be in word2). Then `s[i] == s[j]`.
        -   So, iterate all `i < n` and `j >= n`. If `s[i] == s[j]`, candidate length `2 + dp[i+1][j-1]`.
        -   Note: `dp` table needs to be fully computed first.

2.  **Implementation**:
    -   Standard LPS DP.
    -   Iterate valid `(i, j)` pairs.

## Implementation Details
-   2D Array.
