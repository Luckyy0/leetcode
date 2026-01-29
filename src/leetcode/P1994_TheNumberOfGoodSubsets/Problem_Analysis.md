# Problem Analysis: The Number of Good Subsets

## Problem Description
Array `nums`. Subset `good` if product of elements is square-free (product of distinct primes).
Return count mod $10^9 + 7$.
Values in `nums` up to 30.

## Analysis

1.  **Primes and Mask**:
    -   Values $\le 30$. Primes: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 (10 primes).
    -   We need subset product to be square-free.
    -   This means:
        -   No element can have square factor (e.g. 4, 8, 9, 12, 16, 18, 20, 24, 25, 27, 28 are BAD).
        -   All chosen elements must be pairwise coprime (share no prime factors).
    -   `1`s are special: Can include any number of 1s in any valid subset. If subset S is good, adding `k` 1s keeps it good.
    -   Filter BAD numbers.
    -   Count frequencies of numbers 2..30.
    -   DP with bitmask (length 10). `dp[mask]`: Number of subsets with prime factor usage `mask`.
    -   Iterate distinct numbers `x` (2 to 30).
    -   For each `x`: calculate its prime mask `x_mask`. If valid (square free).
    -   Update `dp`: `new_dp[mask | x_mask] += dp[mask] * count[x]` if `mask & x_mask == 0`.
    
2.  **Implementation**:
    -   `primes` array.
    -   `count[31]`.
    -   `ones = count[1]`.
    -   `dp` array size 1024. `dp[0] = 1`.
    -   Multiply final result by $2^{ones}$. Note: result requires non-empty subset.
    -   Actually `dp[0]` corresponds to empty.
    -   Sum `dp[1...1023]`.
    -   Result = `sum * 2^ones`.
    -   Wait. If only 1s are picked? The product is 1. 1 is square-free.
    -   So non-empty subsets of only ones are valid.
    -   Logic:
        -   Calculate `total` valid ways using 2..30. (Includes empty set way = 1).
        -   `total * 2^ones - 1`? No.
        -   Any valid subset of {2..30} (say prime mask M) can be combined with any subset of {1s}.
        -   Total valid = `(Sum(dp)) * 2^ones`.
        -   Subtract empty set (which corresponds to empty mask 0 and 0 ones)?
        -   Yes, "non-empty subset". So we must exclude the ONLY case where nothing picked.
        -   Wait. `Sum(dp)` includes `dp[0]=1` (empty set of 2..30).
        -   `Sum(dp) * 2^ones` includes empty set of 2..30 coupled with empty set of 1s.
        -   So yes, result `(Sum(dp) * 2^ones) - 1`.

## Implementation Details
-   Primes map to bits.
-   Filter numbers divisible by 4, 9, 25.
