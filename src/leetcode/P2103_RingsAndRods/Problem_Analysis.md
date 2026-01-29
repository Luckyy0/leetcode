# Problem Analysis: Rings and Rods

## Problem Description
10 rods (0-9). `rings` string (e.g., "R3G2B1").
Count rods with all three colors (R, G, B).

## Analysis

1.  **Bitmask or Arrays**:
    -   10 rods. Flag for R, G, B.
    -   `state[10]`.
    -   Masks: R=1, G=2, B=4.
    -   Loop string pairs. Update state.
    -   Count states == 7.

## Implementation Details
-   `int[] rods`.
