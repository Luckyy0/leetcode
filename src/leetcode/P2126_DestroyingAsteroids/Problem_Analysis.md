# Problem Analysis: Destroying Asteroids

## Problem Description
Planet mass `mass`. Asteroids array `asteroids`.
If mass >= asteroid[i], destroy and mass += asteroid[i]. Else explode.
Can rearrange asteroids.
Check if satisfy all.

## Analysis

1.  **Greedy**:
    -   Sort asteroids ascending.
    -   Process smallest first. If mass >= ast, eat it (mass increases).
    -   Smallest gives best chance to grow mass for larger ones.

## Implementation Details
-   Sort.
-   Loop.
-   Use `long` for mass.
