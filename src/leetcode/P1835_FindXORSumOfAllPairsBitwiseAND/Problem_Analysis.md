# Problem Analysis: Find XOR Sum of All Pairs Bitwise AND

## Problem Description
Lists `arr1`, `arr2`.
Sum = `(arr1[0] & arr2[0]) ^ (arr1[0] & arr2[1]) ... ` (all pairs).

## Analysis

1.  **Distributive Property**:
    -   `XOR_sum( (a & b_i) )` over i = `a & XOR_sum(b_i)`.
    -   `XOR_sum( (a_j & b_i) )` over i, j = `XOR_sum( a_j & (XOR B) )` over j.
    -   = `(XOR A) & (XOR B)`.

2.  **Implementation**:
    -   Calculate XOR sum of arr1.
    -   Calculate XOR sum of arr2.
    -   Return AND.

## Implementation Details
-   Loop.
