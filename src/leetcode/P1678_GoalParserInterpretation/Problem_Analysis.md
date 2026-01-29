# Problem Analysis: Goal Parser Interpretation

## Problem Description
Interpret string `command`:
-   "G" -> "G"
-   "()" -> "o"
-   "(al)" -> "al"

## Analysis

1.  **String Replacement**:
    -   Replace "()" with "o".
    -   Replace "(al)" with "al".
    -   Order matters? "()" is prefix of "(al)"? No. "()" vs "(...". Distinct.
    -   Wait, simple linear scan or `replace`.

2.  **Algorithm**:
    -   Loop `i`.
    -   If `c == 'G'`, append 'G'.
    -   If `c == '('`:
        -   If next is `)`: append 'o', skip 1.
        -   Else if next is `a`: append 'al', skip 3.

3.  ** Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `StringBuilder`.
