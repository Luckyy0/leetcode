# Problem Analysis: GCD Sort of an Array

## Problem Description
Array `nums`. Can swap `nums[i], nums[j]` if `gcd(nums[i], nums[j]) > 1`.
Can you sort the array?

## Analysis

1.  **Union-Find on Factors**:
    -   Swap connectivity is transitive.
    -   If `a` connects to `b` and `b` connects to `c`, `a` can swap to `c`.
    -   We can sort if for every index `i`, the element `nums[i]` belongs to the same connected component as the element `sorted_nums[i]`.
    -   Build graph: Connect each number to its prime factors.
    -   Connect factors.
    -   If `x` has factor `p`, union `x` and `p`.
    -   All numbers sharing a factor get connected.
    -   After building components, check: Does `nums[i]` component == `sorted[i]` component?
    
2.  **Implementation**:
    -   Sieve/Factor precompute up to MaxVal ($10^5$).
    -   For each `x` in `nums`: factorize and union `x` with factors.
    -   Also just union all `x` that share a factor?
    -   Optimized: Union `x` with its factors. Factors are nodes too.
    -   Then check using `find`.

## Implementation Details
-   `parent` array size `MAX_VAL + 1`.
-   Sieve.
-   Sort copy.
