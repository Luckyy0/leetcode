# Problem Analysis: Determine Color of a Chessboard Square

## Problem Description
Input string `coordinates` (e.g., "a1").
Return `true` if white, `false` if black.
Start: a1 is black.

## Analysis

1.  **Parity Logic**:
    -   'a' (1) + '1' (1) = 2 (even) -> Black.
    -   'a' (1) + '2' (2) = 3 (odd) -> White.
    -   'b' (2) + '1' (1) = 3 (odd) -> White.
    -   Rule: `(col_index + row_index) % 2 != 0` is White.

2.  **Implementation**:
    -   Characters to int. 'a' is 1. '1' is 1.

## Implementation Details
-   Convert chars.
