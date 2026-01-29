# Problem Analysis: Decode XORed Array

## Problem Description
`encoded[i] = arr[i] XOR arr[i+1]`. `first`.
Return `arr`.

## Analysis

1.  **XOR Property**:
    -   `a ^ b = c` => `b = a ^ c`.
    -   `arr[i+1] = arr[i] ^ encoded[i]`.
    -   Iterate.

## Implementation Details
-   Array size `n+1`.
