# Problem Analysis: Removing Minimum and Maximum From Array

## Problem Description
Array `nums`. Distinct integers.
Remove min and max elements.
Op: remove from front or back.
Min deletions.

## Analysis

1.  **Case Analysis**:
    -   Identify indices of min (`idx1`) and max (`idx2`).
    -   Ensure `idx1 <= idx2` (swap if needed).
    -   Possibilities:
        1.  Both from Front: `idx2 + 1` deletions.
        2.  Both from Back: `n - idx1` deletions.
        3.  One Front, One Back: `(idx1 + 1) + (n - idx2)` deletions.
    -   Take minimum of these three.

## Implementation Details
-   Loop to find indices.
-   Calculate logic.
