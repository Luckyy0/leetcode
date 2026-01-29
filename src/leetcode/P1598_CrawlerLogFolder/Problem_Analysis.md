# Problem Analysis: Crawler Log Folder

## Problem Description
The file system keeps a log of each of the user's operations:
-   `"../"` : Move to the parent folder. (If already in main folder, remain in same folder).
-   `"./"` : Remain in the same folder.
-   `"x/"` : Move to the child folder named `x`.
Return the minimum number of steps to go back to the main folder after the change folder operations.

## Analysis

1.  **Simulation**:
    -   Maintain a `depth` variable initialized to 0.
    -   Loop through logs.
    -   If `"../"`, `depth = max(0, depth - 1)`.
    -   If `"./"`, do nothing.
    -   Else (child folder), `depth++`.
    
2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   String comparison.
