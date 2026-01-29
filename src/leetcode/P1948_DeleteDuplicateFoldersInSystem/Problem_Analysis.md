# Problem Analysis: Delete Duplicate Folders in System

## Problem Description
File system paths.
Two folders are duplicate if they have the same set of subfolders (names) and the subfolders' structures are identical.
Delete all duplicate folders. (Actually delete all folders that ARE duplicates of another).
If multiple folders have same structure, delete ALL of them.
Return remaining paths.

## Analysis

1.  **Trie + Serialization**:
    -   Build a Trie from paths.
    -   To identify identical structures, serialize each subtree.
    -   Serialization of a node: `"(" + name + children_serialization + ")"`.
    -   To be canonical, sort children by name.
    -   Traverse Trie (post-order). Compute serialization for each node.
    -   Store frequency of each serialization string in a Map.
    -   If frequency > 1, mark involved nodes for deletion.
    -   Actually, if a subtree structure appears > 1 times, ALL roots of such subtrees are deleted.
    -   Note: Leaf nodes (empty subfolders) have empty structure?
    -   "Two folders... identical structure... non-empty?" No, "structure".
    -   Usually leaves are not duplicates? "Two folders are identical if same non-empty set of subfolders".
    -   If subfolders empty, structure is empty?
    -   Assume leaves don't count or problem specific: "Two folders... same structure...".
    -   Actually: "If two or more folders have the same non-empty structure, mark them as removal".
    -   So leaves (empty structure) are NOT removed? Yes.
    -   Step 1: Build Trie.
    -   Step 2: Serialize. `String serialize(Node u)`.
        -   If leaf, return "".
        -   `builder = ""`
        -   For child v in sorted order:
        -   `builder.append('(').append(v.name).append(childSerial).append(')')`
        -   Full serial = builder.toString().
        -   Map update.
    -   Step 3: Mark nodes.
        -   Pass 2 or store nodes in map list.
        -   If count > 1 and serial not empty, node.deleted = true.
    -   Step 4: Collect paths.
        -   DFS. If node deleted, stop (don't add it or its children).
        -   Otherwise continue.
    
2.  **Implementation**:
    -   TrieNode class.
    -   Recursive serialization.

## Implementation Details
-   `Map<String, Integer> counts`.
-   `TrieNode` has `startDeleted` flag? No, if marked, prune.
