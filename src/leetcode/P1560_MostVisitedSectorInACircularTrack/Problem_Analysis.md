# Problem Analysis: Most Visited Sector in a Circular Track

## Problem Description
Given an integer `n` and an integer array `rounds`. We have a circular track which consists of `n` sectors labeled from 1 to `n`. A marathon will be held on this track, the marathon consists of `m` rounds. The $i^{th}$ round starts at sector `rounds[i-1]` and ends at sector `rounds[i]`. For example, round 1 starts at `rounds[0]` and ends at `rounds[1]`.

Return an array of the most visited sectors sorted in ascending order.

## Analysis

1.  **Key Observation**:
    -   The path is continuous: Start -> ... -> End.
    -   The intermediate values in `rounds` (`rounds[1], rounds[2], ...`) act as checkpoints, but since we simply traverse from `rounds[i-1]` to `rounds[i]` in a counter-clockwise direction (increasing sector numbers), the entire race is just a single continuous path from `rounds[0]` wrapping around the track multiple times until it reaches `rounds[m-1]`.
    -   Any "full loop" (1 through n) adds exactly 1 visit count to EVERY sector. This does not change which sectors are "most" visited (it just increases the baseline for everyone).
    -   The only counts that create a difference are the ones from the partial loop starting at `rounds[0]` and ending at `rounds[m-1]`.

2.  **Simplified Logic**:
    -   We only care about `start = rounds[0]` and `end = rounds[m-1]`.
    -   If `start <= end`:
        -   The most visited sectors are simply `[start, start+1, ..., end]`.
        -   Example: n=4, start=1, end=3. Path: 1->2->3. Sectors 1, 2, 3 visited extra.
    -   If `start > end`:
        -   The marathon wrapped around the end of the track.
        -   The most visited sectors are `[1, ..., end]` AND `[start, ..., n]`.
        -   Example: n=4, start=3, end=1. Path: 3->4->1. Sectors 3, 4, 1 visited extra.

3.  **Algorithm**:
    -   Get `S = rounds[0]` and `E = rounds[rounds.length - 1]`.
    -   If `S <= E`: Return list `[S, ..., E]`.
    -   If `S > E`: Return list `[1, ..., E]` concatenated with `[S, ..., n]`.

4.  **Complexity**:
    -   Time: $O(N)$ to build the result.
    -   Space: $O(N)$ for the result.

## Implementation Details
-   Just check `start` and `end`.
