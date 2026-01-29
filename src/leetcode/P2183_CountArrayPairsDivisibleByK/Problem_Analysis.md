# Problem Analysis: Count Array Pairs Divisible by K

## Problem Description
Count pairs `(i, j)` where `(nums[i] * nums[j]) % k == 0`.

## Analysis

1.  **GCD Approach**:
    -   Condition `(a * b) % k == 0` equivalent to `(gcd(a, k) * gcd(b, k)) % k == 0`.
    -   Compute `g = gcd(val, k)` for each val.
    -   Store counts of each `g` in a map. keys are divisors of `k`.
    -   Iterate pairs of keys `(g1, g2)`.
    -   If `(g1 * g2) % k == 0`, add `count[g1] * count[g2]`.
    -   If `g1 == g2`, add `count[g1] * (count[g1] - 1) / 2`.
    -   Else (g1 < g2) add `count[g1] * count[g2]`.

2.  **Complexity**:
    -   Divisors of `k` can be large? `k <= 10^5`. Max divisors is 128 (for highly composite).
    -   128^2 is small (~16000). Feasible.

## Implementation Details
-   GCD function.
-   Map or array for frequencies of GCDs.
-   Nested loop over keys.
