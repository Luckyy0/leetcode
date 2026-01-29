# Problem Analysis: Check if All the Integers in a Range Are Covered

## Problem Description
Ranges `ranges` 2D array. `left`, `right`.
Check if every integer in `[left, right]` is covered by at least one range.

## Analysis

1.  **Boolean Array / Scan**:
    -   Range is small (`1 <= left <= right <= 50`).
    -   Create `covered` array size 51.
    -   Mark covered indices.
    -   Check `[left, right]`.

## Implementation Details
-   `boolean[51]`.
