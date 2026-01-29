# Problem Analysis: Furthest Building You Can Reach

## Problem Description
You are given an integer array `heights` representing the heights of buildings, some `bricks`, and some `ladders`.
You start at building 0. You can move from building `i` to `i+1` if:
-   `heights[i] >= heights[i+1]` (no cost).
-   `heights[i] < heights[i+1]`:
    -   Use 1 ladder, OR
    -   Use `diff = h[i+1] - h[i]` bricks.
Return the furthest building index (0-indexed) you can reach.

## Analysis

1.  **Greedy Strategy**:
    -   Ladders are infinitely valuable for large jumps. Bricks are finite.
    -   We should use ladders for the *largest* jumps encountered so far.
    -   Since we process buildings sequentially, we don't know future jumps.
    -   However, we can make a choice and retroactively change it.
    -   Assume we use ladders for the first `L` jumps.
    -   When we encounter the `L+1`-th jump, if we want to use a ladder, we must convert one of the previous ladder-jumps to a brick-jump (the smallest one).
    
2.  **Algorithm**:
    -   Iterate `i` from 0 to `n-2`.
    -   Calculate `diff = heights[i+1] - heights[i]`.
    -   If `diff <= 0`, continue.
    -   Push `diff` to a Min-Heap.
    -   If heap size > `ladders`:
        -   We have more jumps than ladders. We MUST use bricks for the smallest jump currently in the heap (which represents the optimal usage of ladders for the largest ones).
        -   `smallestJump = heap.poll()`.
        -   `bricks -= smallestJump`.
        -   If `bricks < 0`, we cannot make this move (nor could we satisfy the past requirements with remaining bricks). Stop and return `i`.
    -   If loop finishes, return `n-1`.

3.  **Complexity**:
    -   Time: $O(N \log L)$ where L is number of ladders.
    -   Space: $O(L)$.

## Implementation Details
-   `PriorityQueue<Integer>`.
