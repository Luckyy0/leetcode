# Problem Analysis: Kth Smallest Subarray Sum

## Problem Description
Array `nums`. Intege `k`.
Return `k`-th smallest subarray sum.

## Analysis

1.  **Binary Search on Answer**:
    -   Range of sums: `min(nums)` to `sum(nums)`.
    -   `low = 0`, `high = sum(all positive nums)`. (If nums can be negative? "nums are positive" usually. Problem constraint?)
    -   Assuming positive `nums`.
    -   `check(val)`: Count number of subarrays with sum `<= val`.
    -   Counting is done with Sliding Window in $O(N)$ because element are positive.
        -   `currentSum`, `left`.
        -   For each `right`, expand window. While `currentSum > val`, shrink `left`.
        -   Count += `right - left + 1`.
    -   Complexity: $O(N \log S)$.

2.  **Implementation**:
    -   BS range.
    -   `countSubarrays` helper.

## Implementation Details
-   `int` for sum if small, `long` if large? Constraints usually allow int sums or need long?
-   Usually sums can exceed $2^{31}$. Use `long`?
-   "The length of the array is at most 2 * 10^4". "sums <= 2 * 10^4 * 10^4". Probably int is fine if max is small.
-   Constraint `nums[i] <= 50000`, `n <= 20000`. Sum $\approx 10^9$. Fits in int.
