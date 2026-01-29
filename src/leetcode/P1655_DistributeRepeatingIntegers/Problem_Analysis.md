# Problem Analysis: Distribute Repeating Integers

## Problem Description
Array `nums` of integers. `quantity` array of `m` integers (orders). `quantity[i]` is requested amount.
Can you distribute `nums` such that the `i-th` order gets `quantity[i]` integers of the **same** value?
Return true if possible.

## Analysis

1.  **Constraints**:
    -   `n` up to $10^5$. `m` up to 10.
    -   The constraint `m <= 10` is key.

2.  **Frequency Analysis**:
    -   We simply need frequency counts of `nums`.
    -   Let `counts` be the list of frequencies.
    -   We need to partition `quantity` into subsets, where each subset sums up to $\le$ some `count` in `counts`.

3.  **Bitmask DP**:
    -   Mask of size $2^m$ represents the subset of orders fulfilled.
    -   `dp[i][mask]` = True if first `i` counts can satisfy mask `mask`.
    -   Transitions:
        -   Iterate `submask` of `mask`.
        -   If `dp[i-1][mask ^ submask]` is true and `counts[i] >= sum(submask)`, then `dp[i][mask] = true`.
    -   Optimization:
        -   `dp` size `[counts.length + 1][1 << m]`.
        -   Precompute sums of all masks.
        -   Sort `counts` descending and truncate? We usually don't need more than `m` counts (at most one count per order, essentially). However, one count can satisfy multiple orders. So we need at most `m` counts? No, but typically constraints allow reducing counts.
        -   If `counts.length > m`, just take largest `m`? Not necessarily true but highly likely sufficient if total sum allows. But strictly, DP on all counts.
        -   Since `n` is large, counts array can be large, but non-zero counts limited by `N`.
        -   Wait, actually, with $N=10^5$ and $M=10$. We can have many small counts.
        -   Processing 1000 counts with $3^{10}$ is too slow ($6 \times 10^7$).
        -   Optimization: Try to fill mask using counts.
        -   Just use the largest `m` counts? No, e.g. orders `[2, 2]`. counts `[1, 1, 1, 1, 1]`. Largest fail.
        -   But generally, we can filter counts: if `count > max(quantity)`, treat as `max(sum(quantity))`.
        -   Wait, simple optimization: `counts` size is limited to `N` but we only really care about `50` (distincts) in some constraints? Here `nums[i] <= 1000`. So at most 1000 counts.
        -   Java might TLE with $3^{10} \times 1000$ if not careful.
        -   Iterate `i` (counts). If `dp[i]` reaches `(1<<m)-1`, break.
        -   Also, `submask` iteration can be efficient: `for (int s = mask; s > 0; s = (s-1) & mask)`.

4.  **Complexity**:
    -   $O(K \cdot 3^M)$ where K is number of counts.

## Implementation Details
-   Map to get freqs.
-   Values of map -> List.
-   `dp[mask]` boolean array (1D optimized, update in place / new array).
-   `sums[mask]` precalculation.
