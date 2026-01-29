# Problem Analysis: Two Furthest Houses With Different Colors

## Problem Description
Array `colors`.
Max distance `abs(i - j)` such that `colors[i] != colors[j]`.

## Analysis

1.  **Greedy Check**:
    -   The max distance is likely involving endpoints 0 or n-1.
    -   Why? For any `i, j`, if we move `i` to 0 or `j` to n-1, distance increases.
    -   Unless color matches.
    -   Candidate 1: Fixed `i=0`, find largest `j` such that `colors[j] != colors[0]`.
    -   Candidate 2: Fixed `j=n-1`, find smallest `i` such that `colors[i] != colors[n-1]`.
    -   Max of these two candidates covers the optimal solution.
    -   Proof: Let optimal be `i, j`.
        -   If `colors[0] != colors[j]`, then `dist(0, j) >= dist(i, j)`.
        -   If `colors[0] == colors[j]`, then `colors[i] != colors[0]` implies `colors[i] != colors[n-1]`? No.
        -   But generally one endpoint logic is robust.
        -   Wait. If `colors[0] == colors[n-1] == Red`.
        -   Optimal is `Red` at `i` and `Blue` at `j`.
        -   Either `i` can slide to `0`? No, if `colors[i]` is Red.
        -   Basically, if optimal pair is `(i, j)` with colors `A, B`.
        -   If `colors[0]` is not `B`, then `(0, j)` is valid and potentially larger.
        -   If `colors[0]` is `B`, then `colors[0] != A`.
        -   Actually, just iterate `i` from 0 to n. Max `(n-1-i)` if diff?
        -   Correct Approach:
            -   Max `abs(i - j)` where `colors[i] != colors[j]`.
            -   Iterate `i` from 0 to `n-1`. Check `dist(i, 0)` if diff. Check `dist(i, n-1)` if diff.
            -   Actually, standard solution is just:
                -   `res = 0`.
                -   For `x` in 0..n: if `colors[x] != colors[0]`, `res = max(res, x)`.
                -   For `x` in 0..n: if `colors[x] != colors[n-1]`, `res = max(res, n - 1 - x)`.
            -   This covers all cases.

## Implementation Details
-   Two loops.
