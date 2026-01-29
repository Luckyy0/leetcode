# Problem Analysis: Append K Integers With Minimal Sum

## Problem Description
Array `nums` (unique?). Sort `nums`.
Append `k` unique positive integers NOT in `nums`.
Minimize sum.

## Analysis

1.  **Sum of Ranges**:
    -   Sort `nums`. And duplicate removal.
    -   Range `[1, nums[0]-1]`. Count `nums[0]-1`. Take min(k, count). Sum AP.
    -   Range `[nums[i]+1, nums[i+1]-1]`. Count. Take min(k, count). Sum AP.
    -   If `k` still > 0 after passing last element, take `k` starting from `last+1`.

2.  **Logic Update**:
    -   Sort unique `nums`. Add `0` at start?
    -   Or just loop.
    -   Handle large numbers (sum uses long).

## Implementation Details
-   `Arrays.sort`. Skip duplicates logic.
-   `long sum`. `k` decrement.
