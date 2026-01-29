# Problem Analysis: Maximum Number of Groups Getting Fresh Donuts

## Problem Description
`batchSize`. `groups`.
Shop sells donuts in batches of `batchSize`.
Start with 0 donuts.
For each group `i` size `g_i`:
-   If `curr_donuts == 0`, serve fresh (happy).
-   Else serve from `curr_donuts`.
-   Remainder of batch becomes `curr_donuts`?
-   Actually: `curr_donuts` tracks how many are LEFT OVER.
-   We make a batch at start if needed.
-   Exact condition: "Returns to 0 remainder".
-   We want to order groups to maximize number of times we start with remainder 0.

## Analysis

1.  **Modulo Arithmetic**:
    -   Only `groups[i] % batchSize` matters.
    -   Groups with rem 0 always happy. Count them and remove.
    -   Remaining groups have rem 1 to `batchSize-1`.
    -   Greedy matching?
        -   Pairs adding to `batchSize` (e.g. 1 and `batchSize-1`) work perfectly together. They take us from rem 0 -> rem 1 -> rem 0.
        -   Is it always optimal to pair them immediately? Yes. If we have a sequence involving `1` and `k-1`, putting them adjacent `0 -> 1 -> 0` is better or equal to `0 -> 1 -> ... -> 0`.
        -   Pair up `i` and `batchSize-i` as much as possible.
        -   For `batchSize/2` (if even), pair them up.
    -   Leftovers: Need optimal ordering. Use DP with state.

2.  **DP / Memoization**:
    -   State: Counts of remaining remainders `[cnt1, cnt2, ..., cnt8]`.
    -   Current Remainder is derived?
    -   It's simpler to pass `currentRemainder` in recursion, but note `currentRemainder = (InitialSum - SumRemaining) % batchSize`. So it's determined by the state.
    -   Memoization: Encode counts array to a single Long/String key.
    -   Constraints: `groups.length <= 30`. `batchSize <= 9`.
    -   Counts array size is small (batchSize-1). Each count is small.
    -   Key encoding: since each count <= 30, use 5 bits per count? Or just distinct string.

3.  **Complexity**:
    -   Greedy pairing reduces problem size significantly.
    -   Remaining items solved via Backtracking with memoization.

## Implementation Details
-   Count frequencies.
-   Process 0s.
-   Process pairs `(i, k-i)`.
-   Process `k/2`.
-   DFS for rest.

