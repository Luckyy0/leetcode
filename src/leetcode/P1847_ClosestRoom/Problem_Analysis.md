# Problem Analysis: Closest Room

## Problem Description
Rooms `rooms[i] = [id, size]`.
Queries `queries[j] = [preferred_id, min_size]`.
Find room with `size >= min_size` and `id` closest to `preferred_id`. If tie, smaller id.

## Analysis

1.  **Sorting + TreeSet**:
    -   Offline Queries approach.
    -   Sort rooms by size descending.
    -   Sort queries by min_size descending.
    -   Iterate queries. For a query with `min_size`, add all rooms with `size >= min_size` into a data structure that supports closest ID search.
    -   Since we iterate descending, we add rooms progressively.
    -   Data structure: `TreeSet` of room IDs.
    -   Search: `floor(id)` and `ceiling(id)`. Pick closest.

2.  **Complexity**:
    -   Sorting: $N \log N + Q \log Q$.
    -   Processing: $Q \log N$ (TreeSet operations).
    -   Total efficient.

## Implementation Details
-   `TreeSet<Integer>`.
-   Index array for queries to store answer in correct order.
