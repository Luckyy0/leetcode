# Problem Analysis: Redistribute Characters to Make All Strings Equal

## Problem Description
Array `words`. Move chars between words.
Check if possible to make all strings equal.

## Analysis

1.  **Frequency Count**:
    -   Count total occurrence of each char 'a'-'z'.
    -   Check if `totalCount % n == 0` for all chars.
    -   If yes, we can distribute equally.

## Implementation Details
-   `int[26]`.
