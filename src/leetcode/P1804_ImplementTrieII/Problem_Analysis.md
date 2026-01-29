# Problem Analysis: Implement Trie II (Prefix Tree)

## Problem Description
Implement Trie with:
- `insert(word)`
- `countWordsEqualTo(word)`
- `countWordsStartingWith(prefix)`
- `erase(word)`

## Analysis

1.  **Trie Node Structure**:
    -   `children[26]`
    -   `countEnds`: number of words ending here.
    -   `countPrefix`: number of words passing through here.
    
2.  **Operations**:
    -   `insert`: Increment `countPrefix` along path. Increment `countEnds` at end.
    -   `erase`: Decrement `countPrefix` along path. Decrement `countEnds` at end.
    -   `countWordsEqualTo`: traverse, return `countEnds`.
    -   `countWordsStartingWith`: traverse, return `countPrefix`.

## Implementation Details
-   Node class.
