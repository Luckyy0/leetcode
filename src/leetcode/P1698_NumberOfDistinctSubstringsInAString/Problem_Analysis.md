# Problem Analysis: Number of Distinct Substrings in a String

## Problem Description
Return number of distinct substrings in `s`.

## Analysis

1.  **Trie Approach**:
    -   Insert every suffix into a Trie.
    -   Count total number of nodes in Trie.
    -   Complexity: $O(N^2)$. If $N$ is small (1000 - 2000), typically sufficient.
    
2.  **Rolling Hash**:
    -   Compute hashes for all substrings. Store in HashSet.
    -   Complexity: $O(N^2)$ (checking collisions).

3.  **Suffix Automaton / Suffix array**:
    -   $O(N)$. Complex to implement.
    -   Given this problem often appears in contexts allowing $N^2$, we check constraints. Usually $N \le 500$ or similar.
    -   Let's check standard. Actually this is "Number of Distinct Substrings in a String". Constraints are usually $N \le 1000$ or $2000$.
    -   Trie is safe.

## Implementation Details
-   TrieNode.
-   Iterate start index `i`. Iterate `j` from `i`.
-   Walk down Trie. Create new nodes if needed. Count new nodes.
