# Problem Analysis: Count Ways to Make Array With Product

## Problem Description
Queries `[n, k]`. Array length `n`, product `k`.
Count ways.

## Analysis

1.  **Prime Factorization**:
    -   For each query `(n, k)`, factor `k`.
    -   `k = p1^a1 * p2^a2 ...`.
    -   For each prime factor with exponent `a`, we distribute `a` copies of prime `p` into `n` bins (positions in array).
    -   Stars and Bars: `ways = C(n + a - 1, a) = C(n + a - 1, n - 1)`.
    -   Total ways = product of ways for each prime factor.
    
2.  **Implementation**:
    -   Precompute primes or factor on fly `k <= 10^4` is fast.
    -   Precompute Factorials for Combinations. Max `n+a`?
    -   `a` for $10^4$ at most $\log_2(10^4) \approx 13$. `n` up to $10^4$.
    -   Max $N \approx 10000 + 13$.
    -   Need modular inverse for combinations.

3.  **Complexity**:
    -   Time: $Q \cdot \sqrt{K}$ or $Q \cdot \log K$.
    -   Space: For factorials.

## Implementation Details
-   `MOD = 10^9 + 7`.
-   `nCr`.
