# Problem Analysis: Maximum Genetic Difference Query

## Problem Description
Tree rooted at -1 (or array of parents).
Nodes have values.
Queries: `(node, val)`.
Find max `val XOR node_ancestor_value`.
Ancestor check includes node itself.

## Analysis

1.  **Offline Queries + Trie**:
    -   We need to query XOR max on the path from root to `node`.
    -   Process queries offline.
    -   DFS traversal of the tree.
    -   Maintain a Trie containing values of nodes in the current path (from root to current).
    -   When entering node `u`: Insert `u.val` into Trie.
    -   Process all queries for `u`: For `(u, val)`, find max XOR in Trie.
        -   Max XOR query in Trie is standard greedy (go opposite bit if possible).
    -   When leaving node `u`: Remove `u.val` from Trie to backtrack.
    -   Complexity: $Q \times \log(MaxVal) + N \times \log(MaxVal)$.
    -   MaxVal = $2 \cdot 10^5$, $\approx 18$ bits.
    -   Efficient enough.

## Implementation Details
-   `TrieNode` with count (to support removal).
-   Adjacency list. Query list.
