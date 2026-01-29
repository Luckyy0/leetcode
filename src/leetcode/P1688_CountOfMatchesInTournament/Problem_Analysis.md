# Problem Analysis: Count of Matches in Tournament

## Problem Description
N teams. If even, N/2 matches, N/2 proceed. If odd, (N-1)/2 matches, (N-1)/2 + 1 proceed.
Count total matches.

## Analysis

1.  **Logic**:
    -   Every match eliminates exactly 1 team.
    -   To reduce N teams to 1 winner, we need $N-1$ eliminations.
    -   So $N-1$ matches.

## Implementation Details
-   Return `n-1`.
