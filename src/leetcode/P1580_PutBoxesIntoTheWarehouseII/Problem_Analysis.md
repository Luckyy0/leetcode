# Problem Analysis: Put Boxes Into the Warehouse II

## Problem Description
You are given two arrays `boxes` and `warehouse`. Boxes can be pushed into the warehouse from either the **left side** or the **right side**.
Room `i` has height `warehouse[i]`.
A box can reach room `i` if its height <= all rooms on the path from left (0 to i) OR if its height <= all rooms on the path from right (n-1 to i).
Return max number of boxes.

## Analysis

1.  **Effective Heights**:
    -   The maximum height box that can be stored in `warehouse[i]` is limited by the bottleneck of the path.
    -   Path Left: `min(w[0]...w[i])`.
    -   Path Right: `min(w[i]...w[n-1])`.
    -   Effectively: `limit[i] = min(w[i], max(min(w[0]...w[i-1]), min(w[i+1]...w[n-1])))`?
    -   Wait, simpler: `limit[i] = max( prefixMin[i], suffixMin[i] )`.
    -   `prefixMin[i]` is min of `w[0]...w[i]`.
    -   `suffixMin[i]` is min of `w[i]...w[n-1]`.
    -   Wait, strictly `w[i]` itself is always part of both paths. So `limit[i] = min(w[i], max(bottleneck_left, bottleneck_right))`.
    -   Actually `prefixMin[i]` already includes `w[i]`. So `prefixMin[i]` IS the capacity from left. `suffixMin[i]` IS capacity from right.
    -   So `capacity[i] = max(prefixMin[i], suffixMin[i])`.

2.  **Greedy matching**:
    -   We have a set of room capacities `capacity[0...n-1]`.
    -   We have a set of `boxes`.
    -   We want to match max boxes.
    -   Sort `boxes` (ascending).
    -   Sort `capacities` (ascending).
    -   Match smallest box to smallest capacity that fits it.
    -   Why? Larger boxes need larger capacities. If we use a large capacity for a small box, we might waste it.
    -   Smallest capacity rooms are the "hardest" to utilize (fewest boxes fit). We should try to fill them with the smallest boxes that fit.
    -   Actually, standard greedy for "Maximize number of pairs":
        -   Sort `boxes` small to large.
        -   Sort `capacity` small to large.
        -   For each `capacity`, check if it can take the current smallest `box`.
        -   If `capacity >= box`: Match! Move both pointers.
        -   If `capacity < box`: Capacity too small for even the smallest remaining box. Discard capacity. `capIdx++`.
    -   Wait. If `capacity < box`, this capacity is useless. Next capacity is larger, might work.
    -   So: Loop `capIdx` from 0 to n-1. Maintain `boxIdx`.
        -   If `capacity[capIdx] >= boxes[boxIdx]`: We filled a room. `boxIdx++`, `count++`.
        -   Always `capIdx++`.
    -   Wait, this is wrong.
    -   Example: Caps [1, 100], Boxes [2, 3].
    -   Cap 1 < Box 2. USeless.
    -   Cap 100 >= Box 2. Match.
    -   Total 1. Correct.
    -   Example: Caps [5, 5], Boxes [4, 6].
    -   Cap 5 >= Box 4. Match.
    -   Cap 5 < Box 6. No match.
    -   Total 1. Correct.

3.  **Complexity**:
    -   Preprocessing: $O(N)$.
    -   Sorting: $O(N \log N + M \log M)$.
    -   Matching: $O(N)$.

## Implementation Details
-   Precompute `prefixMin`, `suffixMin`.
-   Compute `effectiveHeights`.
-   Sort.
-   Greedy loop.
