# Problem Analysis: Unique Length-3 Palindromic Subsequences

## Problem Description
String `s`. Count unique palindromes of length 3 (subsequences).
"aba", "aaa", etc.

## Analysis

1.  **Iterate Middle + Boundaries**:
    -   Palindrome Length 3 form: `XYX`.
    -   First and last char match. Middle can be anything.
    -   Approach: Iterate over every unique character `c` ('a' to 'z').
    -   Find the **first occurrence** and **last occurrence** of `c` in `s`.
    -   Let indices be `start` and `end`.
    -   If `end - start < 2`, no palindrome with outer `c` possible.
    -   Otherwise, any distinct character `mid` found between `start` and `end` forms a unique palindrome `c + mid + c`.
    -   Count distinct chars in `s[start+1 ... end-1]`.
    -   Sum up counts for all `c`.
    -   Complexity: $26 \times N$. Very fast.

## Implementation Details
-   `first[26]`, `last[26]`.
-   Set for counting unique middle chars.
