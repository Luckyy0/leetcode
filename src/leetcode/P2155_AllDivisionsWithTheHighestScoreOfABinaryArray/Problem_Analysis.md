# Problem Analysis: All Divisions With the Highest Score of a Binary Array

## Problem Description
`nums` (0s and 1s).
Split at `i` (0 to n).
Score = (0s in `left`) + (1s in `right`).
Return all `i` with max score.

## Analysis

1.  **One Pass / Prefix Sum**:
    -   Total 1s (`totalOnes`).
    -   When split at `i=0`: Left empty (0 zeros), Right full (totalOnes). Score = `totalOnes`.
    -   Iterate `i` from 0 to `n`.
    -   Move `nums[i]` from right to left.
    -   If `nums[i] == 0`: `zerosLeft++`.
    -   If `nums[i] == 1`: `onesRight--`.
    -   Score at `i+1` = `zerosLeft + onesRight`.
    -   Track max.

## Implementation Details
-   Initial calculation.
-   Loop updates.
