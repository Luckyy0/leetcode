# Problem Analysis: Minimum Incompatibility

## Problem Description
You are given an integer array `nums` and an integer `k`. You are asked to distribute this array into `k` subsets of equal size.
The incompatibility of a k-subset is the sum of the difference between the maximum and minimum elements in each subset.
However, a subset is invalid if it contains duplicate elements.
Return the minimum possible sum of incompatibilities, or -1 if impossible.

## Analysis

1.  **Bitmask DP**:
    -   $N \le 16$. `size = n / k`.
    -   Precompute all valid subsets of size `size`.
        -   Valid means no duplicates.
        -   Value = `max - min`.
    -   `dp[mask]` = min incompatibility for elements in `mask`.
    -   We fill subsets one by one. Or rather, we consider the state "completed subsets".
    -   `dp[mask]` is valid only if `popcount(mask)` is a multiple of `size`.
    -   Transition:
        -   From `dp[mask]`, try to add a valid subset `sub` s.t. `(mask & sub) == 0`.
        -   To force unique order/path: `sub` must contain the smallest index NOT in `mask`.
        -   Let `u` be the lowest bit index not set in `mask`. Iterate all valid subsets `sub` that include `u`.
        -   `dp[mask | sub] = min(dp[mask | sub], dp[mask] + cost[sub])`.
    
2.  **Algorithm**:
    -   Calculate `size`. Count frequencies to check possibility early (if freq > k, impossible, return -1).
    -   Generate valid subsets (as bitmasks) of size `size`.
        -   Store in map/list indexed by lowest bit? Or just iterate.
        -   Or store `validSubsets` list.
    -   Initialize `dp` array size $2^n$ with Infinity. `dp[0] = 0`.
    -   Better: Iterate current mask `m` from 0 to `(1<<n)-2`.
        -   If `dp[m]` is Inf, continue.
        -   Also strictly we only care about `popcount(m) % size == 0`.
        -   Find first unset bit `u` in `m`.
        -   Iterate all valid subsets `sub` that contain `u` and don't overlap `m`.
        -   Wait, how to efficiently query "subsets containing u"?
        -   We can group precomputed subsets by their lowest bit index? Assuming we always pick the lowest unset bit, the `sub` must actually have `u` as its lowest bit? No, `sub` just needs to contain `u`. But for `sub` to be valid with `m`, `sub` consisting of `u` and other bits > `u` is efficient.
        -   Actually, if we iterate mask `m` and want to extend, we MUST cover `u`. If we just say "pick sub disjoint from m", we permit permutations. By forcing `sub` to contain `u` (lowest unset), we enforce canonical order.
        -   So we can precompute `subsetsByLowestBit[bit]`. Wait, `sub`'s lowest bit *relative to the whole array* might not be `u`?
        -   No. If `m` covers `0..u-1`, then `u` is the lowest available. Any valid `sub` disjoint from `m` containing `u` will have `u` as its minimal element (index-wise).
        -   So yes, we can precompute `validSubsets` grouped by their lowest set bit.
    
3.  **Complexity**:
    -   $N=16$. Max subsets of size $S$.
    -   If $S=2, K=8$: $\binom{16}{2}$ subsets.
    -   States $2^{16}$.
    -   Very manageable.

## Implementation Details
-   `counts` check.
-   Precompute values for valid masks.
-   DP loop.
