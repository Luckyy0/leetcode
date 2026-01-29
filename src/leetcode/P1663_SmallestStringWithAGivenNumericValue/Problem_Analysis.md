# Problem Analysis: Smallest String With A Given Numeric Value

## Problem Description
The numeric value of a lowercase character is its 1-based index (a=1, b=2, z=26).
Return the lexicographically smallest string with length `n` and numeric value equal to `k`.

## Analysis

1.  **Greedy Construction**:
    -   To be lexicographically smallest, we want 'a's at the beginning.
    -   Initialize char array of length `n` with 'a' (value 1).
    -   Current Sum = `n`.
    -   Target Sum = `k`.
    -   Remaining to add: `diff = k - n`.
    -   We fill from the end (index `n-1` to `0`) to maximize trailing characters, keeping prefix minimal.
    -   At each position from end, we can add `min(diff, 25)` to the character ('a' becomes 'z' add 25).
    -   Subtract from `diff`. continue left.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `char[]`. Fill 'a'. Iterate backwards.
