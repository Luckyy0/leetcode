# Problem Analysis: Rearrange Spaces Between Words

## Problem Description
You are given a string `text` of words that are separated by some number of spaces. Each word consists of lowercase English letters.
Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as `text`.

## Analysis

1.  **Steps**:
    -   Count total spaces.
    -   Identify words given by non-space sequences.
    -   If there is only 1 word: return word + all spaces.
    -   If `n` words ($n > 1$):
        -   `gapCount = n - 1`.
        -   `spacesPerGap = totalSpaces / gapCount`.
        -   `extraSpaces = totalSpaces % gapCount`.
    -   Construct result.

2.  **Edge Cases**:
    -   Leading/Trailing spaces in input are counted.
    -   Single word case.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$ for builder.

## Implementation Details
-   `text.charAt(i)` check.
-   `StringBuilder`.
