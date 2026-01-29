# Problem Analysis: Create Sorted Array through Instructions

## Problem Description
Given an integer array `instructions`, you are asked to create a sorted array from the elements in `instructions`. You start with an empty container `nums`. For each element `instructions[i]`, insert it into `nums` such that:
-   The cost is minimum of (count of elements strictly less than `instructions[i]`) and (count of elements strictly greater than `instructions[i]`).
-   Insert `instructions[i]` into `nums` while maintaining sorted order (though sorted order is implicit for cost calculation).
Return total cost modulo $10^9 + 7$.

## Analysis

1.  **Logic**:
    -   We process elements one by one.
    -   We need `count(x < val)` and `count(x > val)`.
    -   Note that `count(x > val) = total_elements_so_far - count(x <= val)`.
    -   `count(x <= val) = count(x < val) + count(x == val)`.
    -   So effectively we need a data structure that supports:
        -   `update(val, 1)`: Add occurrence.
        -   `query(val)`: Count elements $\le val$. (Prefix Sum).
    -   Fenwick Tree (BIT) is perfect. Max value is $10^5$.

2.  **Algorithm**:
    -   Initialize BIT size 100001 (or 100002).
    -   Loop `x` in `instructions`:
        -   `less = query(x - 1)`.
        -   `lessEqual = query(x)`.
        -   `greater = i - lessEqual` (where `i` is current index 0..N-1, count so far).
        -   `cost += min(less, greater)`.
        -   `update(x, 1)`.
    -   Modulo arithmetic for sum.

3.  **Complexity**:
    -   Time: $O(N \log M)$ where $M = 10^5$.
    -   Space: $O(M)$.

## Implementation Details
-   Standard BIT implementation.
