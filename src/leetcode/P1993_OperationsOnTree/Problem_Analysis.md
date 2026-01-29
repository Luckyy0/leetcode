# Problem Analysis: Operations on Tree

## Problem Description
`LockingTree(parent)`.
Operations:
-   `lock(num, user)`: Locks node `num` if not locked.
-   `unlock(num, user)`: Unlocks if locked by `user`.
-   `upgrade(num, user)`: Locks `num` IF:
    1.  `num` is unlocked.
    2.  It has at least one locked descendant.
    3.  It has NO locked ancestors.
    4.  If conditions met, unlock ALL descendants, and lock `num` by `user`.

## Analysis

1.  **Data Structures**:
    -   `parent` array.
    -   `children` list (adjacency) for traversal.
    -   `lockedBy[node]` stores user (0 if unlocked). Since user >= 1.
    -   `upgrade` logic:
        -   Check state of `num`.
        -   Check ancestors (climb up `parent`).
        -   Check descendants (BFS/DFS). Need to know if ANY locked, and collect them to unlock. Use BFS.
    -   Concurrency? Problem doesn't specify threaded. Assume single thread logic.

2.  **Implementation**:
    -   `lock`: check array.
    -   `unlock`: check array.
    -   `upgrade`:
        -   Check unlocked.
        -   Check ancestors (loop up).
        -   BFS descendants. Keep list of locked descendants found.
        -   If `ancestorClean` and `lockedDescendants > 0`:
            -   Unlock all found locked descendants.
            -   Lock `num`.
            -   Return true.

## Implementation Details
-   `ArrayList[] children`.
