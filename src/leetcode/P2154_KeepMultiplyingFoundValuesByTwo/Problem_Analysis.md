# Problem Analysis: Keep Multiplying Found Values by Two

## Problem Description
Array `nums`. Start `original`.
If `original` in `nums`, `original *= 2`. Repeat.
Return final `original`.

## Analysis

1.  **HashSet Simulation**:
    -   Add all to set.
    -   While `set.contains(original)`: `original *= 2`.

## Implementation Details
-   `HashSet`.
