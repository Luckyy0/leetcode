# Problem Analysis: Sum of Floored Pairs

## Problem Description
Array `nums`.
Calculate `sum(floor(nums[i] / nums[j]))` for all pairs `(i, j)`.
Result modulo $10^9 + 7$.
Constraints: $N \le 10^5$, $nums[i] \le 10^5$.

## Analysis

1.  **Optimization**:
    -   Comparing every pair is $O(N^2) \approx 10^{10}$, too slow.
    -   Value range is small ($M = 10^5$).
    -   Group `nums` by frequency.
    -   Iterate denominator `y` from distinct values in `nums`.
    -   For a fixed `y`, sum of `floor(x / y)` for all `x` in `nums`.
    -   `floor(x / y) = k` when `k*y <= x < (k+1)*y`.
    -   We can count how many `x` are in range `[k*y, (k+1)*y - 1]` efficiently using Prefix Sums of frequencies.
    -   Let `RangeCount(L, R)` be count of `x` such that `L <= x <= R`.
    -   Contribution for denominator `y` and multiplier `k`: `k * RangeCount(k*y, min((k+1)*y - 1, MAX_VAL))`.
    -   Multiply this by `freq[y]` (since `y` appears `freq[y]` times).
    -   Sum over all `k` such that `k*y <= MAX_VAL`.
    -   Total complexity: $\sum_{y} (M/y) = M \log M$. With $M=10^5$, operations $\approx 10^5 \times 12 \approx 1.2 \times 10^6$. Very fast.

2.  **Algorithm**:
    -   Compute frequency array `counts`.
    -   Compute prefix sum of counts `prefix`.
    -   Loop `y` from 1 to `MAX`. If `counts[y] > 0`:
        -   Loop `j` starting `y`, step `y`. `k = j / y`.
        -   Range `[j, j + y - 1]`.
        -   Count `c = prefix[min(j + y - 1, MAX)] - prefix[j - 1]`.
        -   Sum += `c * k * counts[y]`.
    -   Modulo arithmetic.

## Implementation Details
-   `long` for sum.
-   `counts` size 100001.
