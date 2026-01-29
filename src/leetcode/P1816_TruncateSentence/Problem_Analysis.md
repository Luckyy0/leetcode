# Problem Analysis: Truncate Sentence

## Problem Description
Sentence `s`, integer `k`.
Truncate `s` to first `k` words.

## Analysis

1.  **Split and Join**:
    -   Split `s` by space.
    -   Take first `k` elements.
    -   Join by space.

2.  **One pass**:
    -   Count spaces. Stop at k-th space.
    -   Substring.

## Implementation Details
-   `split` and `String.join` or loop.
