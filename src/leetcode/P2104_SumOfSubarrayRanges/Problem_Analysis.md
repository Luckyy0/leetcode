# Problem Analysis: Sum of Subarray Ranges

## Problem Description
Array `nums`.
Range of subarray = `max - min`.
Sum of ranges of all subarrays.

## Analysis

1.  **Contribution Technique**:
    -   Sum(Max) - Sum(Min).
    -   Sum(Max): For each element `x`, in how many subarrays is it the Maximum?
        -   Find previous greater element (PGE) index `L`.
        -   Find next greater (or equal) element (NGE) index `R`.
        -   Contribution `x * (i - L) * (R - i)`.
    -   Sum(Min): Similar logic with PLE and NLE.
    -   Use Monotonic Stacks to find bounds.
    -   Use strict/non-strict inequality on one side to handle duplicates without double counting.

## Implementation Details
-   `long res`.
-   Monotonic stacks.
