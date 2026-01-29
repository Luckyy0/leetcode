# Problem Analysis: Maximum Sum Obtained of Any Permutation

## Problem Description
We have an array of integers `nums` and an array of `requests` where `requests[i] = [start, end]`. The sum of a request is the sum of `nums` from `start` to `end`.
We want to permute `nums` such that the total sum of all requests is maximized.
Return sum modulo $10^9 + 7$.

## Analysis

1.  **Strategy**:
    -   Some indices are requested more often than others.
    -   To maximize sum, we should place the largest numbers from `nums` into the indices that are requested the most frequently.
    -   This is a greedy approach + frequency counting.

2.  **Frequency Counting**:
    -   We need to count how many times each index $0 \dots n-1$ is covered by the ranges in `requests`.
    -   Since $N$ is up to $10^5$, naive Iteration ($O(N \cdot R)$) is too slow.
    -   Use **Difference Array / Sweep Line**:
        -   `count[start]++`
        -   `count[end+1]--`
    -   Compute prefix sums of `count` array to get actual frequency for each index.

3.  **Matching**:
    -   Sort the `frequency` array.
    -   Sort the `nums` array.
    -   Match `frequency[i]` with `nums[i]` (both sorted).
    -   Sum `freq * num`.

4.  **Complexity**:
    -   Time: $O(N \log N)$ due to sorting. Difference array is $O(N + R)$.
    -   Space: $O(N)$ for count array.

## Implementation Details
-   Modulo arithmetic for the final sum.
-   Use `long` for sum accumulation.
