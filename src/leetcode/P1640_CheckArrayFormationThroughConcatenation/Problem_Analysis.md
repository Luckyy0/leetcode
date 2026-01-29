# Problem Analysis: Check Array Formation Through Concatenation

## Problem Description
You are given an array of distinct integers `arr` and an array of integer arrays `pieces`, where the integers in `pieces` are distinct. Your goal is to form `arr` by concatenating the arrays in `pieces` in any order. However, you are not allowed to reorder the integers in each array `pieces[i]`.
Return `true` if valid, otherwise `false`.

## Analysis

1.  **Matching**:
    -   Since all integers are distinct, the first element of a piece uniquely determines where it fits in `arr`.
    -   Create a Map `startVal -> piece`.
    -   Iterate `arr` index.
    -   Look up `arr[i]` in map. If not found, return false (can't cover this element).
    -   If found, retrieve `piece`. Check if `piece` matches `arr` starting at `i`.
    -   If matches, advance `i` by `piece.length`.
    -   If mismatch inside piece, return false.

2.  **Complexity**:
    -   Time: $O(N)$ (Each element visited once).
    -   Space: $O(N)$ (Map).

## Implementation Details
-   `HashMap<Integer, int[]>`.
