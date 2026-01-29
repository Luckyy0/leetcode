# Problem Analysis: Number of Single Divisor Triplets

## Problem Description
Triplets `(nums[i], nums[j], nums[k])` such that `sum = nums[i] + nums[j] + nums[k]` is divisible by exactly one of `nums[i], nums[j], nums[k]`.
`nums` elements up to 100.

## Analysis

1.  **Frequency Count + Bruteforce on Values**:
    -   `nums` length up to $10^5$, but values distinct up to 100.
    -   Count frequencies of each number 1..100.
    -   Iterate `x` from 1..100.
    -   Iterate `y` from x..100.
    -   Iterate `z` from y..100. (Distinct values logic).
    -   Check condition:
        -   `S = x + y + z`.
        -   `divisibleCount = (S%x==0 ? 1 : 0) + (S%y==0 ? 1 : 0) + (S%z==0 ? 1 : 0)`.
        -   If `divisibleCount == 1`, valid triplet type.
    -   Calculate permutations:
        -   Case 1: `x == y == z`. Valid? `S = 3x`. `3x % x == 0`. So always divisible by all 3. Count is 3. Fails (needs exactly 1). Never happens.
        -   Case 2: `x == y != z`. If valid: `count[x] * (count[x]-1) / 2 * count[z]`. Permutations? Order distinct indices?
            -   "Number of triplets (indices)". Order `i < j < k`? Problem says `(nums[i], nums[j], nums[k])` implies distinct indices. Order usually distinct indices `i<j<k`.
            -   Formula: `C(count[x], 2) * count[z]`. (Assuming `i, j` have val `x`, `k` val `z`).
        -   Case 3: `x != y != z`. If valid: `count[x] * count[y] * count[z]`.
    -   Add to total.

## Implementation Details
-   `counts`.
-   Loops.
