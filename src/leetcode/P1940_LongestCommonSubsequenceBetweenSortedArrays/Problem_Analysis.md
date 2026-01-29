# Problem Analysis: Longest Common Subsequence Between Sorted Arrays

## Problem Description
Arrays of integers `arrays`. Each array sorted strictly increasing.
Find LCS (subsequence common to all).
Since arrays are sorted, common subsequence is just intersection of elements. Order is preserved automatically.

## Analysis

1.  **Intersection / Frequency Count**:
    -   Values are small? Or use pointers.
    -   Since sorted, we can iterate all arrays with pointers?
    -   Better: Since we need elements present in ALL arrays.
    -   Count frequency of each element across all arrays.
    -   If frequency == `arrays.length`, include in result.
    -   Since inputs are sorted, traversing logic is implicit.
    -   Values range? If range is small (`1 <= val <= 100`), just count.
    -   If range large, use Map.
    -   Return sorted list of common elements.

2.  **Constraints**:
    -   Constraints usually small for "Sorted Arrays" type (Linear scan).
    -   Or range 1 to 100. Let's assume counting array if range allows, else Map.
    -   Assuming generic: use Map or `retainAll`.

## Implementation Details
-   Frequency array `int[101]` if range small.
-   Else pointers.
-   Common logic: intersection.
