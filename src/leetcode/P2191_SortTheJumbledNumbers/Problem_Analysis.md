# Problem Analysis: Sort the Jumbled Numbers

## Problem Description
Mapping `mapping` (digit -> digit).
Map each number to new value.
Sort based on mapped value. Stability required (preserve original relative order for ties).

## Analysis

1.  **Map and Sort**:
    -   Create helper objects `(mappedVal, originalIndex, originalVal)`?
    -   Or simply `(mappedVal, originalVal)`. Since Java `Arrays.sort` is stable for objects, we can just sort by mapped value.
    -   Helper function to compute mapped value.
    -   Convert to String/Digits, map, convert back.
    -   Constraints: `nums[i] <= 10^9`. Simple arithmetic.
    -   Use `Integer[]` indices or wrapper class.

## Implementation Details
-   `Pair` class or sort indices.
-   `getMapped(num, mapping)`.
