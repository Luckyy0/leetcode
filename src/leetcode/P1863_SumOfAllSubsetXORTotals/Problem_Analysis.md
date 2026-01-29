# Problem Analysis: Sum of All Subset XOR Totals

## Problem Description
Array `nums`.
Sum of XORs of every subset.
Subsets include empty (XOR 0), but usually not counted in sum anyway.

## Analysis

1.  **Math Approach**:
    -   Consider each bit position `i`.
    -   If there is at least one number in `nums` with the `i`-th bit set, then in the set of all subsets, exactly half will have the `i`-th bit set in their XOR sum.
    -   Why? Let `x` be a number with `i`-th bit set. For any subset `S` NOT containing `x`, `S` and `S U {x}` have opposite values for the `i`-th bit (one 0, one 1). Thus, we can pair all subsets into (has bit, doesn't have bit).
    -   So if `OR(nums)` has `i`-th bit set, it contributes `2^{N-1} * 2^i` to the sum.
    -   Total Sum = `OR(all nums) * 2^(N-1)`.
    
2.  **Brute Force/Recursion**:
    -   For small N (12), simple recursion works too. $2^{12} = 4096$.
    -   Math is O(N). Brute force O(2^N). Both fine. Math is optimal.

## Implementation Details
-   Compute OR sum.
-   Shift left `N-1`.
