# Problem Analysis: Longest Substring Of All Vowels in Order

## Problem Description
String `word`.
Longest substring containing 'a', 'e', 'i', 'o', 'u' in that order.
Must contain ALL 5.
Order: a <= e <= i <= o <= u.

## Analysis

1.  **Linear Scan**:
    -   Track `currentLength`, `distinctCount`.
    -   Check `word[i] >= word[i-1]`.
    -   If valid:
        -   If `word[i] > word[i-1]`, distinctCount++.
        -   length++.
    -   Else (decreasing or break):
        -   Reset length = 1, distinctCount = 1 (current char).
    -   If distinctCount == 5, update max length.
    -   Need to ensure it starts with 'a'?
    -   Actually, just the sequence constraints handling.
    -   Correct reset logic: If `word[i] < word[i-1]`, reset chain.
    -   Chain starts anew. New start is `i`.
    -   Also check if chain effectively contains 5 distinct vowels.

## Implementation Details
-   Loop.
