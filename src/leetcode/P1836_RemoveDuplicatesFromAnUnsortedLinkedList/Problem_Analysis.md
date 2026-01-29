# Problem Analysis: Remove Duplicates From an Unsorted Linked List

## Problem Description
Linked list. Remove all nodes with duplicate values.
Note: Remove *all* occurrences, leaving only unique values.
(e.g., 1->2->3->2. Result 1->3).

## Analysis

1.  **Two Pass**:
    -   1st pass: Count frequencies in `HashMap`.
    -   2nd pass: Build new list (or modify pointers) keeping only nodes with count 1.
    -   Use a dummy head.

## Implementation Details
-   `HashMap<Integer, Integer>`.
-   `ListNode`.
