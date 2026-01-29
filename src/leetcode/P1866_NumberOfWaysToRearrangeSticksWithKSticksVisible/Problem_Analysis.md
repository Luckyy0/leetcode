# Problem Analysis: Number of Ways to Rearrange Sticks With K Sticks Visible

## Problem Description
`n` sticks with distinct heights 1 to `n`.
Permutation of length `n`.
Count permutations where exactly `k` sticks are visible from the left.
A stick is visible if all sticks to its left are strictly smaller.
Modulo $10^9 + 7$.

## Analysis

1.  **DP / Stirling Numbers**:
    -   Consider constructing the permutation by placing sticks from right to left (positions `n-1` to 0)?
    -   Or consider placing the **tallest** remaining stick among `i` sticks.
    -   Let `dp[i][j]` be ways to arrange `i` sticks such that `j` are visible.
    -   Consider the stick at the last position (index `i-1`).
    -   **Case 1**: The stick at the end is the **tallest** (height `i`).
        -   Since it's at the end, it is visible from left IF all previous are smaller. But it's tall.
        -   Wait, "Visible from Left".
        -   If `Tallest` is at the very LAST position, is it visible?
        -   Yes, if looking from left, if we encounter `Tallest`, we see it.
        -   Wait. Example `[1, 3, 2]`. Visible: 1, 3. (2 is hidden by 3).
        -   If `3` (Tallest) is at index 1. Visible.
        -   If `3` is at index 2 (last). `[1, 2, 3]`. Visible: 1, 2, 3. All visible.
        -   If `Tallest` is at last position, it is ALWAYS visible because it's taller than everything before it.
        -   So, if we put `Tallest` at `i-1`, we need `j-1` visible sticks in the prefix of `i-1` sticks.
        -   Number of ways: `dp[i-1][j-1]`.
    -   **Case 2**: The stick at the end is **NOT** the tallest.
        -   The tallest stick is somewhere in the first `i-1` positions.
        -   Thus, the stick at the end (whatever it is) is SMALLER than the tallest stick which is to its left.
        -   Therefore, the stick at the end is **HIDDEN**.
        -   There are `i-1` choices for the stick at the end (any of the `i-1` non-tallest sticks).
        -   The remaining `i-1` sticks (including the tallest) must form an arrangement with `j` visible sticks.
        -   Number of ways: `(i-1) * dp[i-1][j]`.
    -   **Recurrence**: `dp[i][j] = dp[i-1][j-1] + (i-1) * dp[i-1][j]`.
    -   Base Cases: `dp[0][0] = 1` (or `dp[1][1] = 1`).
    
2.  **Implementation**:
    -   Iterative DP. Space optimization to 1D array.
    -   Modulo arithmetic.

## Implementation Details
-   2D array `int[n+1][k+1]` or 1D rolling.
-   Values can be large, modulo required.
