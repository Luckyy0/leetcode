# Problem Analysis: Minimum Operations to Convert Number

## Problem Description
Array `nums`. Integers `start`, `goal`. All `0 <= x <= 1000`.
Ops: `x + nums[i]`, `x - nums[i]`, `x ^ nums[i]`.
Goal can be outside range, but intermediate values must be in `0..1000`.
Min ops.

## Analysis

1.  **BFS**:
    -   States: `0` to `1000`.
    -   Target `goal`.
    -   Transition: For each `n` in `nums`, try `x+n`, `x-n`, `x^n`.
    -   If result `== goal`: return steps + 1.
    -   If result in `0..1000` and not visited: push to queue.
    -   If result outside `0..1000`: discard (cannot proceed from there).
    -   Special check: If `goal` outside range, we can reach it in 1 step from valid range. `x + n` could equal `goal`.
    -   So: Apply op. Check if `== goal`. If yes, done. Else if in range, queue.

## Implementation Details
-   `boolean[] visited` size 1001.
-   Queue.
