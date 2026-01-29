# Problem Analysis: Minimum Interval to Include Each Query

## Problem Description
Intervals `[left, right]`. Queries `q`.
For each query, find the **size** of the smallest interval that contains `q`.
Size = `right - left + 1`.

## Analysis

1.  **Sorting + Min-Heap**:
    -   Offline Idea: Sort queries? Yes.
    -   Sort intervals by start time.
    -   Sort queries by value (store valid index).
    -   Iterate sorted queries. For query `q`:
        -   Add all intervals starting `<= q` to a Min-Heap.
        -   Heap stores `(size, end)`. Prioritize small size.
        -   Remove invalid intervals from heap: if `end < q`, it's expired.
        -   The top of the heap is the smallest valid interval covering `q`.
    -   Since queries are sorted increasing and intervals added by start increasing, once an interval is added, it stays valid until `end < current_q`.
    
2.  **Complexity**:
    -   Sorting: $N \log N + Q \log Q$.
    -   Heap operations: Each interval added once, removed once. $N \log N$.
    -   Total $O(N \log N + Q \log Q)$.

## Implementation Details
-   `PriorityQueue` of `int[]{size, end}`.
-   Store query indices.
