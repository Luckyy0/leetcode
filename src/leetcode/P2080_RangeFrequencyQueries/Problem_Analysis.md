# Problem Analysis: Range Frequency Queries

## Problem Description
Array `arr`.
`query(left, right, value)`: count occurrences of `value` in `arr[left...right]`.

## Analysis

1.  **Map of Indices + Binary Search**:
    -   Store positions of each value in a list. `Map<Value, List<Integer>>`.
    -   Query: Get list for `value`.
    -   Count indices in `[left, right]`.
    -   `upper_bound(right) - lower_bound(left)`.
    -   `upper_bound(right)`: first index > right.
    -   `lower_bound(left)`: first index >= left.
    -   Difference gives count.

## Implementation Details
-   `HashMap<Integer, ArrayList<Integer>>`.
-   `Collections.binarySearch`.
