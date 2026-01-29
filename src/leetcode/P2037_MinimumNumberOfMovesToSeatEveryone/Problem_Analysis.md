# Problem Analysis: Minimum Number of Moves to Seat Everyone

## Problem Description
Arrays `seats`, `students`. Move student at `pos` to `seat` costs `|pos - seat|`.
Min moves.

## Analysis

1.  **Sorting**:
    -   To minimize sum of distances, match sorted.
    -   Sort `seats`. Sort `students`.
    -   Sum `|seats[i] - students[i]|`.

## Implementation Details
-   Sort.
-   Sum.
