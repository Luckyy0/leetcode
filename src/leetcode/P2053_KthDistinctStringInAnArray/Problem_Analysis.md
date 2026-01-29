# Problem Analysis: Kth Distinct String in an Array

## Problem Description
Array `arr`. Return `k`-th distinct string (appearing exactly once). Unique order based on appearance.

## Analysis

1.  **Frequency Map**:
    -   Count occurences.
    -   Iterate `arr`, check if count is 1. Increment counter.
    -   Return if counter matches k.

## Implementation Details
-   `Map<String, Integer>`.
