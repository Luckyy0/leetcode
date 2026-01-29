# Problem Analysis: Maximum Units on a Truck

## Problem Description
`boxTypes[i] = [numberOfBoxes, unitsPerBox]`. Truck size `truckSize` (max boxes).
Maximize total units.

## Analysis

1.  **Greedy**:
    -   Take boxes with highest units first.
    -   Sort `boxTypes` by `unitsPerBox` desc.
    -   Iterate and fill truck.

2.  **Complexity**:
    -   Time: $O(N \log N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Sort.
