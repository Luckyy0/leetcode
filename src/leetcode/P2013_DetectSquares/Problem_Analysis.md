# Problem Analysis: Detect Squares

## Problem Description
Data stream of points `(x, y)`. `add((x, y))`.
`count((x, y))`: Count ways to form axis-aligned square with `(x, y)` as one point and other 3 points from data stream. Note: duplicates in stream are distinct points (if added twice, use them distinctly).

## Analysis

1.  **Frequency Map**:
    -   Store counts of points `map[x][y]`. Or `Map<Integer, Map<Integer, Integer>>`. `Map<Point, count>`.
    -   `count(px, py)`:
        -   Iterate all existing points `(x, y)` in the data structure.
        -   Constraint: `x != px` or `y != py`. But must form square.
        -   Actually, iterate all points `(x, y)` that share same `x` OR same `y`?
        -   Better: Iterate through all points `(x, y)` that are diagonal to `(px, py)`?
        -   Method: Iterate all `y` for `px` (points `(px, y)`). These are potential corners.
        -   Or iterate all stored points? Max points 3000 calls.
        -   If we iterate all stored points `(x3, y3)` as the **diagonal** opposite.
        -   Then check if `(x3, py)` and `(px, y3)` exist.
        -   Condition: `|x3 - px| == |y3 - py| > 0`.
        -   Count += `count(x3, y3) * count(x3, py) * count(px, y3)`.
    -   Coordinates up to 1000. `int[1001][1001]` feasible.

## Implementation Details
-   `counts[1001][1001]`.
-   `List<int[]> points`. Store unique or all?
-   To optimize iteration: Store `points` as list of coordinates (distinct or all). Since duplicate points matter, `points` list should store unique coordinates effectively and lookup counts, OR store all.
-   If we store ALL added points in a list, complexity of `count` is $O(N)$. Total $O(N^2)$.
-   Given `add` and `count` up to 5000 calls. $5000^2 = 2.5 \times 10^7$. OK.
-   Optimization: Store distinct points in list to reduce iterations, accessing frequency map.

## Implementation Details
-   `int[][] freq`.
-   `List<int[]> distinctPoints`.
