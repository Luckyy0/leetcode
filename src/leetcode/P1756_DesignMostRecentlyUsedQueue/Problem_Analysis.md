# Problem Analysis: Design Most Recently Used Queue

## Problem Description
Design queue like MRU.
`fetch(k)`: moves k-th element (1-indexed) to end of queue and returns it.

## Analysis

1.  **Data Structures**:
    -   `ArrayList`: `remove(k)` is $O(N)$, `add` is $O(1)$. Total $O(N)$.
    -   If $N$ is small ($2000$), this is acceptable.
    -   If $N$ is large, maybe Sqrt Decomposition or Fenwick Tree?
    -   Constraints: `n <= 2000`. `fetch` calls `2000`. Total operations $4 \cdot 10^6$. Simple ArrayList fine.

2.  **Implementation**:
    -   `List<Integer>`.
    -   `index = k - 1`.
    -   `val = list.remove(index)`.
    -   `list.add(val)`.
    -   Return `val`.

## Implementation Details
-   Check bounds.
