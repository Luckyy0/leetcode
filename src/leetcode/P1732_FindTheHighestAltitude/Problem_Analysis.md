# Problem Analysis: Find the Highest Altitude

## Problem Description
Starts at 0. `gain[i]` height change. Max height.

## Analysis

1.  **Simulation**:
    -   `curr = 0, max = 0`.
    -   Loop `g` in `gain`: `curr += g`, `max = Math.max(max, curr)`.

## Implementation Details
-   Variable.
