# Problem Analysis: Magnetic Force Between Two Balls

## Problem Description
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has `n` empty baskets, the $i^{th}$ basket is at `position[i]`, Rick has `m` balls and needs to distribute the balls into the baskets such that the **minimum magnetic force** between any two balls is **maximum**.

Rick states that magnetic force between two different balls at positions `x` and `y` is `|x - y|`.

Given the integer array `position` and the integer `m`. Return the required force.

## Analysis

1.  **Problem Type**:
    This is a classic "Maximize the Minimum" problem, which suggests using **Binary Search on the Answer**.

2.  **Binary Search Strategy**:
    -   **Search Space**: The answer (minimum force) must be between `1` and `(max_position - min_position) / (m - 1)`. A looser upper bound is just `max_position - min_position`.
    -   **Check Function `canPlace(force)`**:
        -   Can we place `m` balls in the baskets such that the distance between every adjacent pair of balls is at least `force`?
        -   This can be checked greedily.
        -   Sort the `position` array.
        -   Place the first ball in the first basket (`position[0]`).
        -   Try to place the next ball in the first basket strictly greater than or equal to `last_placed + force`.
        -   Count how many balls we can place. If `count >= m`, then this `force` is feasible.

3.  **Algorithm**:
    -   Sort input `position`.
    -   Initialize `low = 1`, `high = position[n-1] - position[0]`.
    -   `ans = 0`.
    -   While `low <= high`:
        -   `mid = low + (high - low) / 2`.
        -   If `canPlace(mid)`:
            -   `ans = mid` (this force is possible, try for a larger one).
            -   `low = mid + 1`.
        -   Else:
            -   `high = mid - 1` (force too large, try smaller).
    -   Return `ans`.

4.  **Complexity**:
    -   Sorting: $O(N \log N)$.
    -   Binary Search: $O(N \log (\text{Range}))$, where Range is the max distance ($10^9$). $\log(10^9) \approx 30$.
    -   Total Time Complexity: $O(N \log N + N \log (\text{Range}))$.
    -   Space Complexity: $O(\log N)$ or $O(N)$ for sorting (depending on language implementation, Java usually $O(\log N)$ for primitives or $O(N)$ for objects, but this is `int[]` so Dual-Pivot Quicksort $O(\log N)$ stack depth).

## Implementation Details
-   Sort the `position` array first.
-   Implement the `canPlace` helper function.
