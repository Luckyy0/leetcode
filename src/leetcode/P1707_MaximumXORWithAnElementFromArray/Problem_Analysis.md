# Problem Analysis: Maximum XOR With an Element From Array

## Problem Description
Array `nums`. Queries `(x, m)`. Find element `e` in `nums` such that `e <= m` and `e XOR x` is maximized.

## Analysis

1.  **Offline Processing**:
    -   Sort `nums`.
    -   Sort `queries` by `m`.
    -   Use a Trie to store numbers inserted so far.
    -   Iterate sorted queries.
    -   While `nums[i] <= m`, insert `nums[i]` into Trie.
    -   Query Trie for max XOR with `x`.

2.  **Trie Logic**:
    -   Insert: standard binary trie.
    -   Query: try to go opposite bit. If not possible, go same bit.
    -   Handle empty trie (-1).

3.  **Complexity**:
    -   Time: $O(N \log N + Q \log Q + (N+Q) \cdot 30)$.
    -   Space: $O(N \cdot 30)$.

## Implementation Details
-   TrieNode class.
