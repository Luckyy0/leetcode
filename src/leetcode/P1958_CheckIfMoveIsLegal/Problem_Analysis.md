# Problem Analysis: Check if Move is Legal

## Problem Description
Grid `8x8`. `board`. Place `color` at `(rM, cM)`.
Legal if it forms a "good line":
-   Starts at `(rM, cM)`.
-   Next is `opposite` color.
-   Then sequence of `opposite` colors.
-   Ends with `color`.
-   Length $\ge 3$ (including start and end).

## Analysis

1.  **Direction Scan**:
    -   Check all 8 directions from `(rM, cM)`.
    -   Traverse. First cell must be opposite.
    -   Keep traversing as long as opposite.
    -   If hit `color`, valid! (Length is automatically $\ge 3$ since we ensured first was opposite).
    -   If hit empty or boundary before `color`, invalid in that direction.
    -   Return `true` if any direction valid.

## Implementation Details
-   Loop directions.
