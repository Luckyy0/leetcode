# Problem Analysis: Decode XORed Permutation

## Problem Description
`encoded[i] = perm[i] XOR perm[i+1]`. `perm` is permutation of `1..n` ($n$ odd).
Return `perm`.

## Analysis

1.  **Total XOR**:
    -   `T = 1 ^ 2 ^ ... ^ n`.
    
2.  **Odd Index XOR**:
    -   `encoded[1] = p[1] ^ p[2]`.
    -   `encoded[3] = p[3] ^ p[4]`.
    -   ...
    -   `encoded[n-2] = p[n-2] ^ p[n-1]`.
    -   XOR of all these = `p[1] ^ ... ^ p[n-1]`.
    
3.  **Recover First**:
    -   `p[0] = T ^ (encoded[1] ^ encoded[3] ^ ...)`.
    -   Then recover rest: `p[i+1] = p[i] ^ encoded[i]`.

## Implementation Details
-   Loop logic. `encode` length is `n-1`.
