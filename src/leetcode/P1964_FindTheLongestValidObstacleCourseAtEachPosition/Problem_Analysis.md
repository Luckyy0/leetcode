# Problem Analysis: Find the Longest Valid Obstacle Course at Each Position

## Problem Description
Array `obstacles`.
For each `i`, find length of longest subsequence of `obstacles[0...i]` such that:
-   Subsequence ends at `obstacles[i]`.
-   Subsequence is non-decreasing (valid obstacle course).
Basically: LIS (Longest Increasing Subsequence) ending at `i`, but **non-decreasing** allowed (`<=`).

## Analysis

1.  **Patience Sorting / LIS (N log N)**:
    -   Standard LIS algorithm using a list `tails`.
    -   Since we need result for *every* position, the standard algorithm actually gives that.
    -   `tails[k]` stores the smallest tail of all non-decreasing subsequences of length `k+1`.
    -   For current `x = obstacles[i]`:
    -   Find largest index `idx` in `tails` such that `tails[idx] <= x`.
    -   Actually, we want to extend a subsequence. We look for first element in `tails` that is `> x`.
        -   Start LIS logic: We want to append `x`.
        -   If `x >= tails.last`, append.
        -   Else, replace finding `> x` with `x`.
        -   Wait, standard LIS (strictly increasing): find first element `>= x` and replace.
        -   Here **non-decreasing**: find first element `> x` (strictly greater) and replace.
        -   Why? Because `x` can extend a sequence ending with `x`. So we don't replace `x` itself. We find something strictly bigger to replace, meaning `x` is a better (smaller) tail for that length.
    -   Algorithm:
        -   List `tails`. (Sorted).
        -   For each `x`:
        -   Binary Search (upper bound) for `x` in `tails`.
        -   Let insertion index be `idx`.
        -   If `idx == tails.size()`, add `x`.
        -   Else, `tails.set(idx, x)`.
        -   Length ending at `i` is `idx + 1`.

2.  **Implementation**:
    -   `List<Integer>`. Or array size `n`.

## Implementation Details
-   Binary Search `upperBound`.
