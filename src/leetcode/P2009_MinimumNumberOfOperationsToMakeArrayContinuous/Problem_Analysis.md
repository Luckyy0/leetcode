# Problem Analysis: Minimum Number of Operations to Make Array Continuous

## Problem Description
Array `nums`. Replace elements to make it "continuous".
Continuous:
-   All elements unique.
-   Difference between max and min is `n - 1` (where `n` is `nums.length`).
Minimize operations. Operations = replacements.
Equivalent to: Find max number of existing elements that can fit into a window of size `n-1`.

## Analysis

1.  **Sort + Sliding Window**:
    -   Sort `nums` and remove duplicates (duplicates must be replaced anyway).
    -   Let unique sorted array be `uniq`.
    -   Sliding window `[L, R]`.
    -   Condition: `uniq[R] - uniq[L] <= n - 1`.
    -   Maximize window size `R - L + 1`.
    -   Max preserved elements = max window size.
    -   Ans = `n - max_preserved`.

## Implementation Details
-   `Arrays.sort`.
-   Dedup.
-   Window.
