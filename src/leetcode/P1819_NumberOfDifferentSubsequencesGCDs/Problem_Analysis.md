# Problem Analysis: Number of Different Subsequences GCDs

## Problem Description
`nums`.
Return count of distinct GCDs of all possible non-empty subsequences.

## Analysis

1.  **Math Property**:
    -   A number `g` is a GCD of some subsequence if and only if the GCD of all multiples of `g` present in the array is exactly `g`.
    -   Why? Let subset be $S$. `gcd(S) = g`. Every element in $S$ is multiple of `g`.
    -   If `gcd(all multiples of g) = G`, then `G` must divide `gcd(S)`. So `G` divides `g`.
    -   Also `g` divides `G` (since `G` is gcd of multiples of `g`).
    -   Thus `G == g`.
    -   Algorithm: Iterate `g` from 1 to `max(nums)`.
    -   Compute GCD of all `x` in `nums` where `x % g == 0`.
    -   If GCD is `g`, count it.

2.  **Implementation**:
    -   `exists` boolean array for quick lookup.
    -   Loop `g` from 1 to 200000.
    -   Inner loop `j` from `g` to max step `g`.
    -   Complexity: $N(1/1 + 1/2 + ...) = N \log N$.
    -   GCD takes logarithmic time. Total $O(N \log N \cdot \log(\text{Max}))$.

## Implementation Details
-   `gcd` function.
