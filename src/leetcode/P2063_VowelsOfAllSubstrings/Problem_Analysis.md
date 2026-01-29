# Problem Analysis: Vowels of All Substrings

## Problem Description
String `word`. Count total number of vowels in **every** substring.
Return `long`.

## Analysis

1.  **Contribution Technique**:
    -   For each character `word[i]`:
    -   If `word[i]` is a vowel, how many substrings include it?
    -   A substring `word[L...R]` includes `i` if `L <= i <= R`.
    -   Choices for L: `0` to `i` (count `i + 1`).
    -   Choices for R: `i` to `n - 1` (count `n - i`).
    -   Total occurrences: `(long)(i + 1) * (n - i)`.
    -   Sum this product for all vowel positions.
    -   This is $O(N)$.

## Implementation Details
-   Loop `i`. Check vowel. Add contrib.
