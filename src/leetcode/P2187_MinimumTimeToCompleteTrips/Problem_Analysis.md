# Problem Analysis: Minimum Time to Complete Trips

## Problem Description
Array `time` (time per trip). Total trips `totalTrips`.
Buses run independently.
Find minimum total time.

## Analysis

1.  **Binary Search on Answer**:
    -   Range `[1, min(time) * totalTrips]`.
    -   `check(T)`: `long trips = 0`. For each bus, `trips += T / bus_time`.
    -   If `trips >= totalTrips` return true.
    -   Optimization: `T` can be large ($10^7 \cdot 10^7 = 10^{14}$). Fits in long.
    -   Iterating array takes $O(N)$. Total $O(N \log T)$.

## Implementation Details
-   Binary search logic.
-   Upper bound carefully chosen (use `min_time` to avoid overshoot or just $10^{14}$).
