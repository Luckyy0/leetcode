# Problem Analysis: Minimum Adjacent Swaps to Reach the Kth Smallest Number

## Problem Description
Number string `num`. `k`.
Find `k`-th smallest "Wonderful" number larger than `num`.
"Wonderful" means permutation of `num`.
Then find min adjacent swaps to transform `num` to that target.

## Analysis

1.  **K-th Next Permutation**:
    -   `num` is a permutation.
    -   Find the k-th next lexicographical permutation. `target`.
    -   Since `k` is small (up to 1000? No, `k <= 1000`. Constraints: `n <= 1000`).
    -   Just call `nextPermutation` function `k` times. This gives target string.
    
2.  **Min Swaps to Transform**:
    -   We have `original` and `target`.
    -   Calculate min adjacent swaps to rearrange `original` to `target`.
    -   Since original and target have same digits, this is well-defined.
    -   Greedy Approach:
        -   Iterate `i` from 0.
        -   At index `i`, we need `target[i]`.
        -   Find first occurrence of `target[i]` in `original` starting at `i`. Let it be at `j`.
        -   Shift `original[j]` to `i` using adjacent swaps.
        -   Cost `j - i`.
        -   Bubble the character at `j` to `i`.
        -   Repeat for next `i`.

3.  **Correctness**:
    -   Does picking the *first* occurrence matter?
    -   For identical characters, order in original must be preserved to minimize swaps?
    -   Example: `A1 B A2` -> `target ... A ... A ...`.
    -   If we match `target[0]=A` with `original[0]=A1`, or `original[2]=A2`?
    -   Actually, to minimize swaps, we should match the `target` character with the *nearest* available matching character in `original`?
    -   Actually, the standard result for min swaps between permutations is number of inversions relative to position mapping.
    -   However, simpler greedy just works: Scan left to right. Matched characters never move again. Unmatched chars available.
    -   Find first `target[i]` in `current_original[i...]`. Pick the first one found.
    -   Why? Because if there are multiple same chars left, the one closest to `i` is cheapest to move to `i`. And crossing over other identical chars would just add swaps without benefit.
    
## Implementation Details
-   `nextPermutation`.
-   Greedy swap counting.

