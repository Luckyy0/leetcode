# Problem Analysis: Find Unique Binary String

## Problem Description
Array `nums` containing `n` unique binary strings of length `n`.
Return a binary string of length `n` that does NOT appear in `nums`.

## Analysis

1.  **Cantor's Diagonalization**:
    -   We need a string different from `nums[0]`, `nums[1]`, ..., `nums[n-1]`.
    -   Construct `ans` such that `ans[i]` differs from `nums[i][i]`.
    -   Since `ans[i] != nums[i][i]`, `ans` cannot equal `nums[i]`.
    -   This guarantees uniqueness.

## Implementation Details
-   Loop `i` from 0 to n-1.
-   If `nums[i].charAt(i) == '0'`, append '1', else append '0'.
