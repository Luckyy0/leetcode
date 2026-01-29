# Problem Analysis: Count Pairs With XOR in a Range

## Problem Description
Array `nums`. Count Pairs `(i, j)` where `low <= nums[i] ^ nums[j] <= high`.

## Analysis

1.  **Trie Based Approach**:
    -   We can calculate `countPairsLess(k)`: count pairs with XOR < `k`.
    -   Answer = `countPairsLess(high + 1) - countPairsLess(low)`.
    -   How to implement `countPairsLess(K)` efficiently?
    -   Iterate `nums[i]`. Count how many `nums[j]` (already in Trie) satisfy `nums[i] ^ nums[j] < K`.
    -   Insert `nums[i]` into Trie.
    
2.  **Querying Trie**:
    -   Traverse Trie bits from MSB (usually 14 bits for 20000).
    -   Current `val` bit `b`. `K` bit `kb`.
    -   We want `val ^ node_val < K`.
    -   Case 1: `kb == 1`.
        -   If we pick `node_val` such that bit matches `b` (XOR bit 0), then result bit is 0, which is < `1`. So ALL numbers in the matching branch are valid (strictly smaller). Add count.
        -   Then proceed to the other branch (bit differs from `b`, XOR bit 1) to check if we can satisfy remaining bits.
    -   Case 2: `kb == 0`.
        -   We MUST pick `node_val` such that bit matches `b` (XOR bit 0) to match `kb`. If we picked the other, XOR bit would be 1, which > 0.
        -   Proceed to matching branch.

3.  **Complexity**:
    -   Time: $O(N \cdot \text{Bits})$. Bits $\approx 15$.
    -   Space: $O(N \cdot \text{Bits})$.

## Implementation Details
-   Trie class.
-   `count` at each node.
