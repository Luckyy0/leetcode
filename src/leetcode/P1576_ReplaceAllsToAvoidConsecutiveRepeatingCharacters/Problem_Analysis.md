# Problem Analysis: Replace All ?'s to Avoid Consecutive Repeating Characters

## Problem Description
Given a string `s` containing only lowercase English letters and the '?' character, convert all the '?' characters into lowercase letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
Return the final string. If there are multiple solutions, return any of them.

## Analysis

1.  **Greedy Check**:
    -   Iterate through the string.
    -   If a character is '?', we need to replace it.
    -   The constraint is that it cannot match the previous character `s[i-1]` (if `i>0`) and the next character `s[i+1]` (if `i<n-1`).
    -   Since we have 26 lowercase letters, and at most 2 neighbors, we can always find a valid letter. Even 'a', 'b', 'c' are sufficient to distinguish from any 2 neighbors.

2.  **Algorithm**:
    -   Loop `i` from 0 to `n-1`.
    -   If `s[i] == '?'`:
        -   Try candidate char `c` in 'a'...'z'.
        -   Start with 'a'. If `c == s[i-1]` or `c == s[i+1]`, increment `c`.
        -   Assign `s[i] = c`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$ for char array modification.

## Implementation Details
-   Convert string to char array for mutability.
