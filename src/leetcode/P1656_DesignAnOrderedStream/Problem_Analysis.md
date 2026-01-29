# Problem Analysis: Design an Ordered Stream

## Problem Description
Design a stream that takes `(idKey, value)` pairs in any order, and returns a chunk of values strictly increasing from the current pointer.
-   `OrderedStream(int n)`
-   `List<String> insert(int idKey, String value)`: Stores `(idKey, value)`. If `idKey` matches `ptr`, returns longest consecutive chunk starting from `ptr` and increments `ptr`. Otherwise returns empty list.

## Analysis

1.  **Impl**:
    -   Array `buffer` of String.
    -   Index `ptr` initialized to 1.
    -   `insert`:
        -   `buffer[id] = value`.
        -   Loop while `ptr <= n` and `buffer[ptr] != null`:
            -   Add `buffer[ptr]` to result.
            -   `ptr++`.
        -   Return list.

2.  **Complexity**:
    -   Insert: Amortized $O(1)$ (because `ptr` only moves forward $N$ times total). Worst case $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `String[] stream`.
