# Problem Analysis: Last Day Where You Can Still Cross

## Problem Description
Grid `row x col`. Initially all land.
`cells` array: `cells[i]` becomes water on day `i+1`.
Find last day `k` such that you can walk from top row to bottom row on land only.
Top: `(0, c)`. Bottom: `(row-1, c)`.

## Analysis

1.  **Binary Search on Day**:
    -   If possible on day `d`, possible on `d-1`. Monotonic.
    -   Check `canCross(day)`:
        -   Mark cells `0` to `day-1` as water.
        -   BFS/DFS from any top cell to any bottom cell on land.
    -   Complexity: $O(\log T \cdot R \cdot C)$.
    -   $R \cdot C \le 2 \cdot 10^4$. Fast enough.

2.  **Union-Find (Iterative)**:
    -   Start from end (full water).
    -   Add land cells backwards from `cells[last]` to `cells[0]`.
    -   Check connectivity of Top and Bottom virtual nodes.
    -   When Top and Bottom connected, that day is the first day we CAN cross.
    -   Wait. Adding land makes it possible. So we find the first day (from end) where crossing is posssible.
    -   Result is that day.
    -   But simpler to implement BS or forward UF?
    -   Backwards UF is standard. "Last day you can still cross" means finding transition from Disconnected to Connected (moving backwards in time).
    -   Forward UF on Water cells? If Water connects Left to Right, then Top to Bottom is cut.
    -   BS is easiest to code and sufficient.

## Implementation Details
-   BS.
-   Grid.
