# Problem Analysis: Sort Linked List Already Sorted Using Absolute Values

## Problem Description
Linked list `head`, already sorted by `abs(val)`.
Re-sort by actual value.
$O(N)$ time, $O(1)$ space.

## Analysis

1.  **Two Pointers / Splitting**:
    -   Since sorted by abs, negative values are in reverse order of magnitude (e.g. -10, -5, -2, 0, 1, 3, 5).
    -   Actually, input: `[0, -1, 3, -10]`. Abs: `0, 1, 3, 10`. Sorted by abs.
    -   Negatives appear as: small magnitude -> large magnitude. So values: decreasingly negative. e.g. -1, -5, -10.
    -   Positives appear as: small magnitude -> large magnitude. e.g. 0, 3, 5.
    -   So the list is a mix of `Pos (increasing)` and `Neg (decreasing)`.
    -   We can traverse the list.
    -   If node is negative, move it to the head of the list?
    -   Since absolute values are non-decreasing:
        -   Sequence of positives: $p_1, p_2, p_3 \dots$ where $p_1 \le p_2 \le \dots$.
        -   Sequence of negatives: $n_1, n_2, n_3 \dots$ where $|n_1| \le |n_2| \le \dots \implies n_1 \ge n_2 \ge \dots$.
        -   Actually, the negatives appear later in the list as magnitude grows.
        -   Example: `0, -1, -5, 10`. Abs: `0, 1, 5, 10`.
        -   Values: `0` (Pos), `-1` (Neg), `-5` (Neg), `10` (Pos).
        -   We need to extract negatives and positives separately.
        -   Positives are already in correct relative order (0, 10).
        -   Negatives are in reverse correct order (-1, -5). Needs to be -5, -1.
        -   Wait. If we extract negatives: `-1, -5`. We want `-5, -1`.
        -   If we just move every negative node to the FRONT of the result list as we iterate?
        -   Iterate `head` to end.
        -   If `curr` is negative: Remove from current position, Insert at Head.
        -   If `curr` is positive: Keep it.
        -   Example `0, -1, -5, 10`.
            -   `0` (Pos). List `0`. Curr `@0`. Next is `-1`.
            -   Process `-1`. Negative. Move to head. List `-1, 0`. Tail of positives is `0`. Next is `-5`.
            -   Process `-5`. Negative. Move to head. List `-5, -1, 0`. Tail `0`. Next `10`.
            -   Process `10`. Positive. Keep. List `-5, -1, 0, 10`.
            -   Result sorted.
    -   Wait. Is order of negatives preserved correctly?
    -   We encounter `-1` first, then `-5`.
    -   Insert `-1` at head. Then Insert `-5` at HEAD.
    -   Result starts `-5, -1`. Correct.
    -   Complexity: Iterate once. Move nodes. $O(N)$. Space $O(1)$.

## Implementation Details
-   `head`, `prev`.
-   Handle head updates.
