# Problem Analysis: Finding 3-Digit Even Numbers

## Problem Description
Array `digits`.
Construct unique 3-digit even numbers using these digits.
No leading zeros. Digits used must respect original count.

## Analysis

1.  **Enumeration**:
    -   3-digit numbers are 100 to 999.
    -   Check each even number (100, 102, ... 998).
    -   For number `num`, verify if it can be formed by `digits`.
    -   Precompute frequency of `digits`.
    -   For `num`, count its digits. Check if `digits` has enough.

## Implementation Details
-   `freq` array.
-   Loop `100` to `998` step 2.
-   Check. Add to List.
