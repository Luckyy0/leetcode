# Problem Analysis: Step-By-Step Directions From a Binary Tree Node to Another

## Problem Description
Binary Tree `root`. Start `startValue`, Dest `destValue`.
Find shortest path string (U/L/R).
Start to LCA is 'U'. LCA to Dest is 'L'/'R'.

## Analysis

1.  **LCA + Path Finding**:
    -   Find LCA of Start and Dest.
    -   Find path from LCA to Start. Convert all steps to 'U'.
        -   Actually, find Path `Root -> Start` and `Root -> Dest`.
        -   Find common prefix (path to LCA).
        -   Remove common prefix.
        -   Remaining path to Start: replace each char with 'U'. Reverse? No, path from LCA *down* to Start has steps. Reversing that path's *directions*? No.
        -   Path `LCA -> Start`: `L, R, L`. Directions `U, U, U`.
        -   Path `LCA -> Dest`: `L, R`. Directions `L, R`.
        -   Result: `U U U L R`.
    -   Algorithm:
        -   `getPath(root, val, sb)`. Returns boolean. Appends path 'L'/'R'.
        -   Get path `P_S` (root to start) and `P_D` (root to dest).
        -   Find first index `i` where `P_S[i] != P_D[i]`. (That's where they diverge from LCA).
        -   For `k` from `i` to `P_S.length`: Append 'U'.
        -   Append `P_D.substring(i)`.

## Implementation Details
-   `findPath` DFS.
-   StringBuilder.
