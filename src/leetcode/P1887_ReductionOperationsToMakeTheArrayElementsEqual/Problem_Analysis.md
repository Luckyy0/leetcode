# Problem Analysis: Reduction Operations to Make the Array Elements Equal

## Problem Description
Array `nums`.
Op: Pick largest elements `max`. Reduce them to next strictly smaller value `nextMax`.
Return operation count to make all equal.

## Analysis

1.  **Sort and Accumulate**:
    -   Sort `nums` ascending.
    -   We want to reduce all elements to `nums[0]`.
    -   Iterate from `1` to `n-1`.
    -   If `nums[i] > nums[i-1]`, it implies `nums[i]` is a step higher than `nums[i-1]`.
    -   The number of distinct levels increases.
    -   Wait. If we have `1, 2, 2, 3`.
    -   Step 1: 3 -> 2. Array `1, 2, 2, 2`. (1 op).
    -   Step 2: 2, 2, 2 -> 1. Array `1, 1, 1, 1`. (3 ops). Total 4.
    -   Logic:
        -   Value `3` needs 2 steps (3->2->1).
        -   Value `2` needs 1 step (2->1).
        -   Value `1` needs 0 steps.
    -   Sort array. `1, 2, 2, 3`.
    -   Values: `v_0 < v_1 < ... < v_k`.
    -   `v_i` needs `i` reductions.
    -   Count how many elements are at each level.
    -   Actually, simpler loop:
        -   Sort `nums`.
        -   `ops = 0`. `count = 0` (current "height" or number of previous strict jumps).
        -   Loop `i` from 1. If `nums[i] != nums[i-1]`, `count++`.
        -   `ops += count`.
        -   Wait.
        -   `1, 2, 2, 3`.
        -   i=1 (2 != 1). count=1. ops+=1 (for this 2).
        -   i=2 (2 == 2). count=1. ops+=1 (for this 2).
        -   i=3 (3 != 2). count=2. ops+=2 (for this 3).
        -   Total 4. Correct.

2.  **Complexity**:
    -   Sort: $N \log N$.
    -   Loop: $N$.

## Implementation Details
-   `Arrays.sort`.
-   Loop.
