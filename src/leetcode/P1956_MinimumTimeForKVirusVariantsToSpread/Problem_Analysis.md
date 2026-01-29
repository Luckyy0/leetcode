# Problem Analysis: Minimum Time For K Virus Variants to Spread

## Problem Description
2D Grid. Infinite. `points` (locations of variants). `k`.
Start at `time = 0`. Each variant spreads to adjacent cells (1 step per second).
Find min time `t` such that there exists a cell infected by at least `k` variants.
(They all start spreading simultaneously).
Cell `(x, y)` is infected by variant `i` at `(xi, yi)` if `|x - xi| + |y - yi| <= t`.

## Analysis

1.  **Binary Search on Time**:
    -   Range `0` to large val ($10^9$ or max possible). Max coordinate $100$. So range is small.
    -   Wait, constraint `points[i]` in range `[1, 100]`.
    -   Max time can be around 100-200.
    -   Check function `canInfect(t)`:
        -   Does there exist `(x, y)` such that it is covered by $\ge k$ diamonds defined by `points[i]` with radius `t`.
        -   A diamond (L1 circle) centered at `(xi, yi)` with radius `t` is defined by $|x - xi| + |y - yi| \le t$.
        -   This is equivalent to a square rotated by 45 degrees.
        -   Coordinate transformation: $u = x + y, v = x - y$.
        -   Inequality becomes: $\max(|u - (xi+yi)|, |v - (xi-yi)|) \le t$.
        -   This is a square in $(u, v)$ coordinates:
            -   $xi+yi - t \le u \le xi+yi + t$
            -   $xi-yi - t \le v \le xi-yi + t$
        -   So for each point `i`, we get a rectangle in $(u, v)$ plane.
        -   We need to check if there is a point $(u, v)$ covered by $\ge k$ rectangles.
        -   Since $x, y$ must be integers, $u, v$ must be integers with same parity (since $u+v = 2x$, $u-v = 2y$).
    
2.  **Plane Sweep or Discretization**:
    -   Since coords are small (1 to 100), range of $u, v$ is roughly 0 to 200.
    -   With time `t`, range expands. But we can just iterate possible $x, y$ in valid range?
    -   Valid range for intersection might be slightly outside `[1, 100]`. Maybe `[-50, 150]`.
    -   Since $N$ (points) is small ($N \le 50$), and coords small.
    -   We can literally iterate all integer points in bounding box?
    -   Or just sweep line on $(u, v)$ rectangles.
    -   Given small range, sweep line or 2D difference array is feasible.
    -   However, binary search overhead.
    -   Actually, we can iterate $x$ from $\min(x)-t$ to $\max(x)+t$ (bounded roughly -100 to 200), same for $y$.
    -   Check for each point $(x, y)$ how many sources cover it. $O(Range^2 \times N)$.
    -   With $N=50$, Range=100. $100^2 \times 50 = 500,000$.
    -   Binary Search adds $\log(200) \approx 8$.
    -   Total $4 \times 10^6$ ops. Very fast.

## Implementation Details
-   BS range `0` to `200`.
-   Helper `check(t)`:
    -   Loop x from `min_x - t` to `max_x + t`.
    -   Loop y from `min_y - t` to `max_y + t`.
    -   Count coverage.
    -   Optimization: Determine tighter bounding box of the intersection area of size K?
    -   Actually, just scan the bounding box of all points. Since optimum is usually within the convex hull or close.
    -   Wait. If points are at (1,1) and (100,100), intersection is around (50,50).
    -   Range 1 to 100.
    -   Let's check points `1` to `100`. (Actually maybe extend boundary? No, intersection must be within [min, max]).
    -   Wait. If we have (1,1) and (3,1), intersection is (2,1).
    -   Any optimal point must be "between" sources.
    -   So iterate `x` from `min(points.x)` to `max(points.x)`, `y` from `min` to `max`.
