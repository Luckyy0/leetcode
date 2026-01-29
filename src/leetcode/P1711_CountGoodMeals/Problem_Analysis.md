# Problem Analysis: Count Good Meals

## Problem Description
Array `deliciousness`. Count pairs `(i, j)` where `i < j` and `nums[i] + nums[j]` is a power of 2.

## Analysis

1.  **Map Approach**:
    -   Store frequencies of each number.
    -   Possible sums: powers of 2. Since `nums[i] <= 2^20`, max sum is `2^21`.
    -   Powers: 1, 2, 4, ..., $2^{21}$.
    -   Iterate `nums`. For `num`, check every power `p`. `target = p - num`.
    -   If `target` in map, `count += freq`.
    -   Careful not to double count.
    -   Usually: iterate map keys.
        -   For each `val`, `freq`.
        -   For `p` in powers:
            -   `target = p - val`.
            -   If `target < val`, skip (covered when processed target).
            -   If `target == val`: `freq * (freq - 1) / 2`.
            -   If `target > val`: `freq * map.get(target)`.
    
2.  **Complexity**:
    -   Time: $O(N \cdot 22)$.
    -   Space: $O(N)$.

## Implementation Details
-   `HashMap<Integer, Integer>`.
-   Mod result $10^9+7$.
