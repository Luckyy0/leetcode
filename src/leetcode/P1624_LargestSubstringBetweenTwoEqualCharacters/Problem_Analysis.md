# Problem Analysis: Largest Substring Between Two Equal Characters

## Problem Description
Given a string `s`, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring, return -1.

## Analysis

1.  **Logic**:
    -   Track the first occurrence of each character.
    -   Iterate through the string.
    -   If `s[i]` has been seen before at `firstOccur[s[i]]`:
        -   Length between = `i - firstOccur[s[i]] - 1`.
        -   Update `maxLength`.
    -   Else:
        -   `firstOccur[s[i]] = i`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$ (26 chars).

## Implementation Details
-   Initialize `firstOccur` with -1.
