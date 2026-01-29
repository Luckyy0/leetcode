# Problem Analysis: Maximum Number of Coins You Can Get

## Problem Description
There are `3n` piles of coins of varying sizes. You and your friends (Alice and Bob) will take piles of coins as follows:
- In each step, you will choose any 3 piles of coins (not necessarily adjacent).
- Of your choice, Alice will pick the pile with the maximum number of coins.
- You will pick the next pile with the maximum number of coins.
- Your friend Bob will pick the last pile.
- Repeat until there are no more piles of coins.

Given an array of integers `piles`, return the maximum number of coins that you can have.

## Analysis

1.  **Game Strategy**:
    -   Alice always takes the max.
    -   You take the 2nd max.
    -   Bob takes the min.
    -   To maximize your coins, you want to pick triplets such that the "2nd max" is as large as possible.
    -   This means you should pair the Largest and 2nd Largest available piles with the Smallest available pile.
    -   Example: `[9, 8, 1]`. Alice 9, You 8, Bob 1. This is better than `[9, 2, 1]` where you get 2.

2.  **Algorithmic Approach**:
    -   Sort the `piles` array in descending (or ascending) order.
    -   In each round, take the largest available and the second largest available. Pair them with the smallest available.
    -   You keep the 2nd largest.
    -   If sorted Ascending: `S, S, ... M, L, M, L`.
    -   You take indices: `3n-2`, `3n-4`, ... down to `n`.
    -   Effectively, you take the elements at indices `n, n+2, ..., 3n-2` from the sorted array (0-indexed). Or simply, discard the first `n` smallest elements, then pick every second element from the remaining `2n` elements starting from the end.

3.  **Example**:
    -   `[2,4,1,2,7,8]` -> Sorted: `[1, 2, 2, 4, 7, 8]`. `n` (pairs) = 2. Total piles = 6.
    -   We need to pick `n=2` triplets.
    -   Triplet 1: `(8, 7, 1)` -> You get 7.
    -   Triplet 2: `(4, 2, 2)` -> You get 2.
    -   Total = 9.
    -   Indices in sorted array to pick: Index 4 (7) and Index 2 (2). (0-indexed).
    -   General formula: Iterate `i` from `length / 3` to `length - 2` with step 2.

4.  **Complexity**:
    -   Time: $O(N \log N)$ for sorting.
    -   Space: $O(log N)$ or $O(1)$ depending on sort implementation.

## Implementation Details
-   Sort array.
-   Loop loop.
