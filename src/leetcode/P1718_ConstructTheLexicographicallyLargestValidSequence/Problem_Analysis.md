# Problem Analysis: Construct the Lexicographically Largest Valid Sequence

## Problem Description
Distance sequence for `n`. Integers `1` to `n`. `1` occurs once. `2..n` occur twice.
Dist between two occurrences of `i` is `i`. (indices `k` and `k+i` are `i`).
Lexicographically largest sequence.
Sequence length `2n-1`.

## Analysis

1.  **Backtracking**:
    -   We fill from index 0 to `2n-2`.
    -   We want largest vals at earliest indices.
    -   Function `backtrack(index, result, used, n)`.
    -   If index == length, success.
    -   If `result[index]` filled, `backtrack(index + 1)`.
    -   Else, try numbers `n` down to `1`.
    -   If `num` not used:
        -   If `num == 1`: set `res[idx] = 1`. Recurse. Backtrack.
        -   If `num > 1`: check if `idx + num < len` and `res[idx + num] == 0`.
            -   Set `res[idx] = num`, `res[idx+num] = num`. Recurse. Backtrack.
    -   First valid result is optimal.

2.  **Complexity**:
    -   Time: Exponential but heavily pruned. `n` up to 20. Backtracking usually fast enough for constrained solutions.
    -   Space: $O(N)$.

## Implementation Details
-   `boolean[] used`.
-   `int[] res`.
