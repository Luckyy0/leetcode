# Problem Analysis: Maximum Number of People That Can Be Caught in Tag

## Problem Description
Array `team` (0 or 1). 1: "IT" (catcher). 0: "Not IT".
`dist`.
Person `i` (IT) can catch `j` (Not IT) if `|i - j| <= dist`.
Each IT catches at most 1. Each Not IT caught at most 1.
Maximize caught.

## Analysis

1.  **Greedy**:
    -   Process left to right.
    -   We have list of available ITs and available NotITs.
    -   Actually, match the leftmost available IT with the leftmost available NotIT that is in range.
    -   Use two pointers or queue.
    -   Pointers `i` (IT) and `j` (Not IT).
    -   Advance `min(i, j)` if out of range?
    -   Logic:
        -   Find next IT `i`.
        -   Find next Not IT `j`.
        -   If `|i - j| <= dist`, catch! `ans++`, `i++`, `j++`.
        -   Else if `i < j` (IT too far left), IT cannot catch `j` (nor any future `j'` > `j`). So `i` is useless. `i++`.
        -   Else (`j < i` and `i - j > dist`), Not IT too far left. `j` cannot be caught by `i` (nor any future `i'` > `i`). So `j` is lost. `j++`.

## Implementation Details
-   Loops.
