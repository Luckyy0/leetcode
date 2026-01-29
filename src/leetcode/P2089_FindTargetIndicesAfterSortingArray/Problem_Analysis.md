# Problem Analysis: Find Target Indices After Sorting Array

## Problem Description
Array `nums`, target `target`.
Sort `nums`. Return indices where `nums[i] == target`.

## Analysis

1.  **Count and Sort**:
    -   Or just Count elements `< target` and `== target`.
    -   `countLess`: start index.
    -   `countEqual`: how many.
    -   Indices: `countLess` to `countLess + countEqual - 1`.

## Implementation Details
-   Loop nums.
