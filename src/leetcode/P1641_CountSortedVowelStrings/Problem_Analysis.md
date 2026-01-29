# Problem Analysis: Count Sorted Vowel Strings

## Problem Description
Given an integer `n`, return the number of strings of length `n` that consist only of vowels (`a`, `e`, `i`, `o`, `u`) and are **lexicographically sorted**.
A string `s` is lexicographically sorted if for all valid `i`, `s[i]` is the same as or comes before `s[i+1]` in the alphabet.

## Analysis

1.  **Combinatorial Approach**:
    -   We need to select `n` characters from $\{a, e, i, o, u\}$ such that the order is non-decreasing.
    -   Since the order is forced by the sorting requirement, selecting the counts of each vowel uniquely determines the string (e.g., 2 'a's, 1 'e' -> "aae").
    -   This is equivalent to choosing `n` items from 5 types with replacement, where order doesn't matter (since sorted order is fixed).
    -   Stars and Bars formula: Putting `n` items into 5 bins.
    -   $\binom{n + 5 - 1}{5 - 1} = \binom{n + 4}{4}$.

2.  **Calculation**:
    -   $\binom{n+4}{4} = \frac{(n+4)(n+3)(n+2)(n+1)}{24}$.
    
3.  **Complexity**:
    -   Time: $O(1)$.
    -   Space: $O(1)$.

## Implementation Details
-   Return calculated value.
