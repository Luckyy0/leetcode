# Problem Analysis: Minimum Number of Steps to Make Two Strings Anagram II

## Problem Description
Strings `s` and `t`.
Step: Append any character to `s` or `t`.
Min steps to make them anagrams.
Anagram: Same counts of characters.

## Analysis

1.  **Frequency Counts**:
    -   We need `countS[c] == countT[c]` for all chars.
    -   We can only *add* characters.
    -   If `countS[c] < countT[c]`, we must add `diff` to `s`.
    -   If `countS[c] > countT[c]`, we must add `diff` to `t`.
    -   Total steps = `sum(abs(countS[c] - countT[c]))`.

## Implementation Details
-   Freq arrays.
-   Sum differences.
