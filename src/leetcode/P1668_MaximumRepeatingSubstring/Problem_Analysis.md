# Problem Analysis: Maximum Repeating Substring

## Problem Description
Given a string `sequence` and a string `word`, return maximum `k` value such that `word` concatenated `k` times is a substring of `sequence`.
If `word` is not a substring, return 0.

## Analysis

1.  **Brute Force Construction**:
    -   Since sequence length is small (not detailed, typically small for this type, usually 100).
    -   Construct `sb = word`.
    -   `k = 0`.
    -   While `sequence.contains(sb)`:
        -   `k++`.
        -   `sb.append(word)`.
    
2.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N)$.

## Implementation Details
-   `StringBuilder`.
