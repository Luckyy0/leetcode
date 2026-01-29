# Problem Analysis: Subsequence of Size K With the Largest Even Sum

## Problem Description
Array `nums`. `k`.
Largest Even Sum of subsequence of size `k`. -1 if impossible.

## Analysis

1.  **Greedy + Adjustment**:
    -   Sort `nums` descending.
    -   Take largest `k` numbers. Calculate sum.
    -   If sum is Even: return sum.
    -   If sum is Odd:
        -   We have odd number of odd elements in the selection.
        -   To make sum Even, we must either:
            1.  Remove smallest selected ODD, add largest unselected EVEN.
            2.  Remove smallest selected EVEN, add largest unselected ODD.
        -   Try both options, take best valid one.
        -   If neither possible, return -1.

## Implementation Details
-   Sort.
-   Sum first k.
-   Track `minSelectedOdd`, `minSelectedEven`.
-   Track `maxUnselectedOdd`, `maxUnselectedEven`.
-   Candidates.
