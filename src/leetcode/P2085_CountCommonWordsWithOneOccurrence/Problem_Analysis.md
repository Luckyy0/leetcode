# Problem Analysis: Count Common Words With One Occurrence

## Problem Description
Two string arrays `words1`, `words2`.
Count strings that appear **exactly once** in `words1` AND **exactly once** in `words2`.

## Analysis

1.  **Two Freq Maps**:
    -   Count freqs in `words1`.
    -   Count freqs in `words2`.
    -   Iterate keys of one map (or `words1`).
    -   Check if `map1.get(s) == 1` and `map2.get(s) == 1`.

## Implementation Details
-   `HashMap`.
