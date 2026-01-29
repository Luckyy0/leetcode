# Problem Analysis: Detect Pattern of Length M Repeated K or More Times

## Problem Description
Given an array of positive integers `arr`, find a pattern of length `m` that is repeated `k` or more times.
A pattern is a subarray (consecutive sequence of integers) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.

Return `true` if there exists a pattern of length `m` that is repeated `k` or more times, otherwise return `false`.

## Analysis

1.  **Constraints**:
    -   `arr.length` <= 100.
    -   `m` * `k` <= `arr.length`.

2.  **Brute Force / Optimized Check**:
    -   A pattern of length `m` repeating `k` times means we have `k` contiguous blocks of size `m` that are identical.
    -   Let the pattern start at index `i`.
    -   The sequence is `arr[i...i+m-1]`, followed by `arr[i+m...i+2m-1]`, ..., up to `arr[i+(k-1)m...i+km-1]`.
    -   This implies that for every `j` in `0` to `m*k - 1`: `arr[i+j] == arr[i + j + m]`? No, that's slightly incorrect.
    -   Condition: `arr[x] == arr[x + m]` for all `x` in the range `[i, i + (k-1)m - 1]`.
    -   Basically, checking if elements spaced `m` apart are equal for a sufficiently long stretch.
    -   We need `(k-1) * m` pairs of `(x, x+m)` to be equal consecutively?
    -   Actually, simpler: Just count consecutive matches of `arr[i] == arr[i+m]`.
    -   If `arr[i] == arr[i+m]`, increment counter.
    -   If not, reset counter.
    -   If counter reaches `m * (k - 1)`, return true.
    -   Why `m * (k - 1)`? 
        -   To repeat `k` times, we need `k` blocks.
        -   Block 1 matches Block 2 (size m comparison).
        -   Block 2 matches Block 3 (size m comparison).
        -   ...
        -   Block k-1 matches Block k.
        -   Total `k-1` transitions, each involving `m` element comparisons. Total `m(k-1)` checks.

3.  **Algorithm**:
    -   Iterate `i` from 0 to `n - m - 1`.
    -   Check if `arr[i] == arr[i+m]`.
    -   Increment `count`. If `count == m * (k-1)`, return true.
    -   If mismatch, `count = 0`.
    -   Wait, we must handle the "consecutive" logic carefully. A simple loop is:
        ```java
        int count = 0;
        for (int i = 0; i + m < n; i++) {
            if (arr[i] == arr[i+m]) {
                count++;
                if (count == m * (k - 1)) return true;
            } else {
                count = 0;
            }
        }
        ```
    -   This works because `arr[i] == arr[i+m]` ensures periodicity.

4.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Implement the sliding check.
