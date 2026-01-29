# Problem Analysis: Maximum Number of Eaten Apples

## Problem Description
`apples[i]` grow on day `i`, rot on `i + days[i]`.
Eat 1/day. Max eaten.

## Analysis

1.  **Greedy**:
    -   Eat apple that rots soonest.
    -   PQ stores `[rotDay, count]`.
    -   On day `i`:
        -   Add new apples: `[i + days[i], apples[i]]`.
        -   Remove rotten: `pq.peek().rotDay <= i`.
        -   Eat: `pq.poll()`, decrement, re-add.
        -   `ans++`.
    -   After day `n-1`:
        -   Continue strictly eating from PQ.
        -   Advance time. `curr` day.
        -   Can jump: If top has `k` apples rotting at `D`, we can eat `min(k, D - curr)`.
        -   `ans += num`. `curr += num`.

2.  **Complexity**:
    -   Time: $O(N \log N)$.
    -   Space: $O(N)$.

## Implementation Details
-   PQ logic.
