# Problem Analysis: Check If Two String Arrays are Equivalent

## Problem Description
Given two string arrays `word1` and `word2`, return `true` if the two arrays represent the same string, and `false` otherwise.
A string is represented by an array if the array elements concatenated in order form the string.

## Analysis

1.  **Concatenation**:
    -   Simulate concatenation.
    -   `String.join("", word1)` equals `String.join("", word2)`.
    
2.  **Complexity**:
    -   Time: $O(N \cdot K)$. Elements are concatenated.
    -   Space: $O(N \cdot K)$ to store strings.

3.  **Optimization**:
    -   Iterate character by character using 4 pointers (array index, string index).
    -   Compare chars.
    -   This is $O(1)$ space. Given Java `String`, charAt is fast.

## Implementation Details
-   `String.join` is cleanest. Constraints usually allow it.
-   Let's use `StringBuilder` or `String.join`.

