# Problem Analysis: Maximum Length of Subarray With Positive Product

## Problem Description
Given an array of integers `nums`, find the maximum length of a subarray where the product of all its elements is positive.
A subarray of an array is a consecutive sequence of zero or more values taken out of that array. Return the maximum length.

## Analysis

1.  **State Tracking**:
    -   We need to track the length of the longest subarray ending at index `i` with:
        -   Positive product (`pos[i]`)
        -   Negative product (`neg[i]`)
    
2.  **Transitions**:
    -   If `nums[i] > 0`:
        -   `pos[i] = pos[i-1] + 1`
        -   `neg[i] = (neg[i-1] > 0) ? neg[i-1] + 1 : 0` (Only extends previous negative sequence if it exists)
    -   If `nums[i] < 0`:
        -   `pos[i] = (neg[i-1] > 0) ? neg[i-1] + 1 : 0` (Previous negative * current negative = positive)
        -   `neg[i] = pos[i-1] + 1` (Previous positive * current negative = negative)
    -   If `nums[i] == 0`:
        -   Reset both to 0. `pos[i]=0`, `neg[i]=0`.

3.  **Optimization**:
    -   We only need values from `i-1`. Use variables `pos`, `neg` instead of full arrays.

4.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Variables `pos` and `neg` initialized to 0.
-   Loop `nums`. Update temp variables to avoid overwriting before read.
