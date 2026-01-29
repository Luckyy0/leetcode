# Problem Analysis: Longest Nice Substring

## Problem Description
String `s`. Substring is nice if for every char in it, both uppercase and lowercase appear in it.
Longest nice substring. If multiple, earliest.
Constraints length small ($N \le 100$).

## Analysis

1.  **Divide and Conquer**:
    -   Check if `s` is nice.
        -   Collect all chars. Identify bad chars (exist but partner doesn't).
    -   If nice, return `s`.
    -   If bad chars exist:
        -   Split `s` by bad chars. Recursively call on parts.
        -   Return longest result from parts.
    
2.  **Complexity**:
    -   Depth 26 (each split removes at least one char type).
    -   $O(N \cdot 26)$.

## Implementation Details
-   Set for checking.
