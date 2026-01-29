# Problem Analysis: Check if Word Can Be Placed In Crossword

## Problem Description
Board `m x n` (chars ' ', '#', lower letters).
Word `word`.
Can match strictly locally?
Horizontal or Vertical. Left-Right, Right-Left, Top-Down, Bottom-Up.
Constraints: Must match length. Must fit between bounds/hashes.
Spaces match any char. Letters must match.

## Analysis

1.  **Iterate Slots**:
    -   Iterate rows and cols.
    -   Split each row/col by '#'.
    -   Each segment between '#' (or boundaries) is a potential slot.
    -   If segment length == word.length:
        -   Check if slot matches `word` or `reversed(word)`.
    -   Matching logic: `slot[k] == ' ' || slot[k] == word[k]`.

## Implementation Details
-   Helper `match(segment, word)`.
-   Iterate rows, then cols.
