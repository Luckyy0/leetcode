# Problem Analysis: Finding MK Average

## Problem Description
Stream of integers. `addElement(num)`. `calculateMKAvg()`.
`M` last elements. Remove `K` smallest and `K` largest. Avg rest.
Values up to $10^5$.

## Analysis

1.  **Fenwick Tree (BIT)**:
    -   Since values are up to 100,000, we can use a Frequency BIT and Sum BIT.
    -   `countBIT`: stores frequency of value `v`.
    -   `sumBIT`: stores sum of values `v`.
    -   `totalSize`: number of elements in current window (max M).
    -   `Queue` to track FIFO order.
    -   When adding: insert to queue, update BITs. If size > M, remove old (queue poll, update BITs minus).
    -   `calculate`:
        -   If size < M, return -1.
        -   We need sum of elements from rank `K+1` to `M-K`.
        -   Sum = `getSumOfSmallest(M-K) - getSumOfSmallest(K)`.
        -   `getSumOfSmallest(rank)`: Find value `v` such that count of elements `<= v` is at least `rank`.
        -   This requires searching the BIT (Binary Search on Prefix Sums).
        -   Then calculate partial sum carefully.
        -   Sum = `sumBIT.query(v-1) + (rank - countBIT.query(v-1)) * v`.
        -   Why partial? Because multiple copies of `v` might exist, and we only take some.

2.  **Search on BIT**:
    -   Standard doubling search on BIT to find index `idx` such that `query(idx) >= k`. $O(\log N)$.

3.  **Complexity**:
    -   Add: $O(\log V)$.
    -   Calculate: $O(\log V)$.
    -   $V = 10^5$. Very efficient.

## Implementation Details
-   BIT classes or methods.
-   Queue.
-   Careful with index 0 (BIT 1-based).
