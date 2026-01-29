# Problem Analysis: Sum of All Odd Length Subarrays

## Problem Description
Given an array of positive integers `arr`, calculate the sum of all possible odd-length subarrays.

## Analysis

1.  **Iterative Approach ($O(N^3)$)**:
    -   Iterate length `len` (1, 3, 5...).
    -   Iterate start index `i`.
    -   Sum subarray.

2.  **Optimized Prefix Sum ($O(N^2)$)**:
    -   Compute prefix sums. Subarray sum is $O(1)$.
    -   Outer loops remain.

3.  **Frequency Contribution Approach ($O(N)$)**:
    -   Consider element at index `i`. In how many odd-length subarrays does it participate?
    -   A subarray including `i` starts at `l` and ends at `r`, where `0 <= l <= i <= r < n`.
    -   Length = `r - l + 1`. We need length to be odd.
    -   This means `r - l` is even.
    -   `r` and `l` must have the same parity (both even or both odd), or `r - l` even means... wait.
    -   Example: `l=0, r=0`. Length 1 (odd). `0-0` even. Correct.
    -   `l=0, r=1`. Length 2 (even). `1-0` odd.
    -   So we need `r` and `l` to have such `r - l` is even => `r` and `l` have SAME parity? No.
    -   If `l` is odd, `r` must be odd -> `r-l` even -> length odd.
    -   If `l` is even, `r` must be even -> `r-l` even -> length odd.
    -   Total subarrays including `i`: Start choices `[0...i]`, End choices `[i...n-1]`.
    -   Let `L = i + 1` (choices for start), `R = n - i` (choices for end).
    -   Total subarrays = `L * R`.
    -   How many are odd length?
    -   Roughly half.
    -   Exact formula: `((L * R) + 1) / 2`.
    -   Why?
        -   Total combinations of `(start, end)` is `L*R`.
        -   Let `total = L * R`.
        -   If `total` is even, exactly `total / 2` are odd length.
        -   If `total` is odd, `(total + 1) / 2` are odd length.
    -   This formula is a known property for this problem.
    -   Proof Sketch:
        -   We need `r - l` to be even.
        -   Parity of length depends on parity of `l` vs `r`.
        -   It turns out the count is always `ceiling(Total / 2)`.

4.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Loop `i`.
-   `startOptions = i + 1`.
-   `endOptions = n - i`.
-   `totalCount = startOptions * endOptions`.
-   `oddCount = (totalCount + 1) / 2`.
-   `sum += arr[i] * oddCount`.
