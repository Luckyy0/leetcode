# Problem Analysis: Maximum Number of Words You Can Type

## Problem Description
String `text`, string `brokenLetters`.
Count words in `text` that do NOT contain any broken letters.

## Analysis

1.  **Set Lookup**:
    -   Store `brokenLetters` in Set/Boolean array.
    -   Split `text` by space.
    -   Iterate words. Check chars.

## Implementation Details
-   `boolean[26]`.
