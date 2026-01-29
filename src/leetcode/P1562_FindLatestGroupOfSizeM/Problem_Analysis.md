# Problem Analysis: Find Latest Group of Size M

## Problem Description
Given an array `arr` that represents a permutation of numbers from 1 to `n`. You have a binary string of size `n` that initially consists of all `0`s. At each step `i` (1-indexed), you transform the bit at position `arr[i]` from `0` to `1`.

Return the **latest** step at which there exists a group of ones of length exactly `m`. A group of ones is a contiguous substring of 1s such that it cannot be extended in either direction. If no group of size `m` exists at any step, return -1.

## Analysis

1.  **Simulation & Tracking**:
    -   We need to track contiguous segments of 1s.
    -   When we flip a bit at `pos` to 1, it might:
        -   Create a new interval of length 1.
        -   Merge with a left interval.
        -   Merge with a right interval.
        -   Merge both left and right intervals.
    -   We need to know the length of the interval ending at `pos-1` and the length of the interval starting at `pos+1`.

2.  **Data Structure**:
    -   An array `length` of size `n+2` where `length[x]` stores the length of the interval that has `x` as endpoint (either start or end).
    -   Wait, storing at *endpoints* is key.
    -   When we turn `pos` to 1:
        -   `left = length[pos - 1]` (length of group ending at pos-1)
        -   `right = length[pos + 1]` (length of group starting at pos+1)
        -   `newLen = left + right + 1`
        -   We update the new endpoints:
            -   `length[pos - left] = newLen` (Update the start of the combined group)
            -   `length[pos + right] = newLen` (Update the end of the combined group)
    
3.  **Tracking Counts**:
    -   We also need to know if a group of size `m` exists.
    -   Maintain a count array `count` where `count[len]` is the number of groups of length `len`.
    -   Update counts during merge:
        -   `count[left]--`
        -   `count[right]--`
        -   `count[newLen]++`
    -   Check if `count[m] > 0`. If yes, update `result = step`.

4.  **Complexity**:
    -   Time: $O(N)$ - One pass through `arr`.
    -   Space: $O(N)$ - For `length` and `count` arrays.

## Implementation Details
-   `length` array size `n+2` to handle boundaries safely (0 and n+1 index).
-   `count` array size `n+1`.
-   Result initialized to -1.
