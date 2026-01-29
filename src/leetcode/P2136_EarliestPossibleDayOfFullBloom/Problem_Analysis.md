# Problem Analysis: Earliest Possible Day of Full Bloom

## Problem Description
`plantTime[i]`: days to plant seed `i`. Can't overlap planting.
`growTime[i]`: days to grow after planting.
Full bloom happens at `end_plant + growTime`.
Minimize max full bloom day.

## Analysis

1.  **Greedy**:
    -   We must perform all planting sequentially. Total planting time is sum(`plantTime`).
    -   Growing happens in parallel.
    -   We want to plant seeds with LONGER grow time EARLIER.
    -   Why? Because they run in background while we plant others.
    -   Strategy: Sort by `growTime` descending.
    -   Plant in that order.
    -   Calculate `currentPlantEnd` and `maxBloom`.

## Implementation Details
-   Sort indices.
-   Loop.
