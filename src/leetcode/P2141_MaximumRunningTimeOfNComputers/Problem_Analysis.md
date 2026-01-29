# Problem Analysis: Maximum Running Time of N Computers

## Problem Description
`n` computers. `batteries` array.
Run all `n` computers simultaneously.
Batteries can be swapped.
Maximize running time.

## Analysis

1.  **Binary Search on Time OR Greedy**:
    -   Sort batteries descending.
    -   Assume we want to run for time `T`.
    -   We need `n * T` total energy.
    -   BUT a single battery cannot provide more than `T` energy (it can only power one computer at a time, for max duration T).
    -   So for each battery `b`: valid contribution is `min(b, T)`.
    -   Condition: `sum(min(b, T)) >= n * T`.
    -   Binary Search `T` in range `[0, sum(all) / n]`.
    -   Check takes $O(m)$. Total $O(m \log S)$.

2.  **Optimized approach**:
    -   Sort batteries.
    -   Sum total energy.
    -   If largest battery `b` > average energy required (`sum / n`), then this battery can fully power one computer for the average Duration.
    -   Actually, if `b > target_avg`, `b` is overkill. But it guarantees covering 1 computer for `target_avg`.
    -   If we assign `b` to Computer 1, we are left with `n-1` computers and `sum - b` energy.
    -   Check if the new average `(sum - b) / (n - 1)` is greater than what `b` provided? No, simply reduce problem.
    -   Algorithm:
        -   Sort `batteries`. Sum `total`.
        -   While `batteries[last] > total / n`:
            -   `total -= batteries[last]`.
            -   `n--`.
            -   `last--` (remove largest battery).
        -   Return `total / n`.
    -   Why? If `b > total/n`, this battery can handle one PC entirely for the bottleneck duration. Removing it improves/maintains the average for the rest.
    -   If all `b <= total/n`, then `sum(min(b, target)) = sum(b) = total >= n * target`.
    -   So `target` is exactly `total/n`.

## Implementation Details
-   Sort. Long sum.
-   Loop top down.
