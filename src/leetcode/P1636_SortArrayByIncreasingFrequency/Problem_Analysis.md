# Problem Analysis: Sort Array by Increasing Frequency

## Problem Description
Given an array of integers `nums`, sort the array in **increasing** order based on the frequency of the values. If multiple values have the same frequency, sort them in **decreasing** order.
Return the sorted array.

## Analysis

1.  **Count Frequencies**:
    -   Use a `HashMap` to store counts of each number.
    
2.  **Sort**:
    -   Since `int[]` cannot be sorted with a custom Comparator directly in Java (requires boxing), we convert to `Integer[]`.
    -   Comparator: `(a, b) -> count(a) != count(b) ? count(a) - count(b) : b - a`.
    -   Convert back to `int[]`.

3.  **Complexity**:
    -   Time: $O(N \log N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `Arrays.stream(nums).boxed().....toArray()`.
