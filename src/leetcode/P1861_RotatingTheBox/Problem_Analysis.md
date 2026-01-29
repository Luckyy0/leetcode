# Problem Analysis: Rotating the Box

## Problem Description
`m x n` character matrix `box` representing a side-view of a box.
- `'#'`: Stone.
- `'*'`: Obstacle.
- `'.'`: Empty.
The box is rotated 90 degrees clockwise.
Gravity affects stones: they fall down (which was right in original view) until they hit an obstacle, another stone, or the bottom (right edge).

## Analysis

1.  **Simulation Step-by-Step**:
    -   **Gravity Logic**: Operate on rows of the original box.
        -   Stones fall to the right.
        -   Iterate row from right to left (`col = n-1` down to 0).
        -   Maintain `empty` index (initially `n-1` or last non-obstacle pos).
        -   If cell is `*`, it's fixed. `empty` resets to `col - 1`.
        -   If cell is `#`, move it to `empty` slot. Then `empty--`.
            -   If `empty` was same as `col`, just `empty--`.
        -   If cell is `.`, do nothing (it's potentially an empty slot).
            -   Actually, if we see `.`, we just ensure `empty` tracks it.
        -   Correct logic:
            -   Iterate `j` from `n-1` down to 0.
            -   Keep `target` index for falling stone. initialize `n-1`.
            -   If `box[i][j] == '*'`: `target = j - 1`.
            -   If `box[i][j] == '#'`:
                -   If `target > j`, move stone: `box[i][target] = '#'`, `box[i][j] = '.'`.
                -   `target--`.
            -   If `box[i][j] == '.'`: Just continue (it's available space, provided `target` isn't updated? No).
                -   Actually, `target` is the rightmost empty position.
                -   If `box[i][j]` is `#`, we place at `target`.
                -   If `box[i][j]` is `.`, `target` stays as is? NO.
                -   Let's trace: `target` starts at `n-1`.
                -   Scan `j` from `n-1`.
                -   If `box[i][j] == '*'`: `target` becomes `j-1`. (Obstacle blocks everything to its right).
                -   If `box[i][j] == '#'`: `box[i][target] = '#'`, and if `target != j`, `box[i][j] = '.'`. `target--`.
                -   If `box[i][j] == '.'`: (It contributes to emptiness, effectively skip, but `target` stays pointing to this or right of this).
                -   Wait. If we encounter `.` at `n-1`, `target` is `n-1`. Correct.
                -   If we encounter `#` at `n-2`, we move to `n-1`. `target` becomes `n-2`.
                -   Correct.

    -   **Rotation Logic**:
        -   Create `res` of size `n x m`.
        -   `res[j][m - 1 - i] = box[i][j]`.

2.  **Implementation**:
    -   Apply gravity in-place or on a temporary row.
    -   Map to rotated matrix.

## Implementation Details
-   2D array loops.
