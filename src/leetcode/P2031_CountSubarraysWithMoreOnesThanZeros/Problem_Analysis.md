# Problem Analysis: Count Subarrays With More Ones Than Zeros

## Problem Description
Binary array `nums`. Count subarrays where number of 1s > number of 0s.
Mod $10^9 + 7$.

## Analysis

1.  **Transform and Prefix Sums**:
    -   Replace 0 with -1.
    -   Problem becomes: Count subarrays with `sum > 0`.
    -   `prefix[j] - prefix[i] > 0` => `prefix[j] > prefix[i]`.
    -   Equivalent to counting Inversions? No, pairs `i < j` with `prefix[j] > prefix[i]`.
    -   This is "Count pairs in specific order". Can use Fenwick Tree (BIT) or Merge Sort.
    -   Iterate `j`. Query BIT for count of values `< prefix[j]`.
    -   Values: Range `-N` to `N`. Offset by `N`.
    -   Update BIT with `prefix[j]`.

## Implementation Details
-   BIT.
-   Offset.
-   Modulo arithmetic.
