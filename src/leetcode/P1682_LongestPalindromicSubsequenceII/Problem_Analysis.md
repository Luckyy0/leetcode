# Problem Analysis: Longest Palindromic Subsequence II

## Problem Description
Find length of longest palindromic subsequence of string `s` such that length is even and no two consecutive characters in the subsequence are same.
Example: "abcabc" -> "abccba" no. "abcba" (odd). "abba" (consecutive bb). "abca" (two a's, not consec). good.

## Analysis

1.  **DP State**:
    -   `dp[i][j][last]` = Max length of good palindrome subsequence in `s[i...j]` where the previous outer wrapper char was `last` (values 0-26, 0 for none).
    -   Actually `last` refers to the character added most recently to the outside.
    -   When we try to add `s[i]` and `s[j]`:
        -   Condition: `s[i] == s[j]`.
        -   Condition 2: `s[i] != last`.
        -   If valid: length goes up by 2. New last is `s[i]`. Recursion to `inner`.
    -   If we drop `s[i]`: `dp[i+1][j][last]`.
    -   If we drop `s[j]`: `dp[i][j-1][last]`.
    
2.  **Memoization**:
    -   `memo[250][250][27]`.
    -   Entries approx $250^2 \times 27 \approx 1.6 \times 10^6$. Integer array. 6MB. Fine.

3.  **Complexity**:
    -   Time: $O(N^2 \cdot 26)$.
    -   Space: $O(N^2 \cdot 26)$.

## Implementation Details
-   27 for `last`: 1-26 for a-z, 0 for initial.
-   Be careful with array bounds.
