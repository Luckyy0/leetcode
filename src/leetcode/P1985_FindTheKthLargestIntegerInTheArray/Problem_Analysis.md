# Problem Analysis: Find the Kth Largest Integer in the Array

## Problem Description
Array of strings `nums` (integers). Find k-th largest.
Strings can be very long (large integers).

## Analysis

1.  **Sorting with Custom Comparator**:
    -   Compare strings as numbers.
    -   If lengths differ, longer is larger.
    -   If lengths equal, lexicographical comparison.

## Implementation Details
-   `Arrays.sort` or `PriorityQueue`.
-   Return `nums[k-1]`? No, k-th LARGEST. `nums[n-k]`.
