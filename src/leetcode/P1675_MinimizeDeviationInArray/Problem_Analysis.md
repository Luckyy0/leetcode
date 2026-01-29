# Problem Analysis: Minimize Deviation in Array

## Problem Description
Array `nums`.
Ops:
-   If even, `x -> x / 2`.
-   If odd, `x -> x * 2`.
Minimize `max(nums) - min(nums)`.

## Analysis

1.  **Normalization**:
    -   Observation: Odd numbers can be multiplied once (to become even). Even numbers can be divided multiple times.
    -   Specifically, `odd -> 2*odd` (even) -> `odd` (back). It basically toggles.
    -   To simplify direction, increase all numbers to their maximum potential value?
        -   If `x` is odd, max val is `2x`.
        -   If `x` is even, max val is `x`.
        -   Wait, if `x` is even, we can reduce it. We cannot increase it.
    -   So: Transform all odd numbers `x` to `2x`. Now all numbers are even.
    -   We can only perform "divide by 2" operation on numbers.
    -   This turns problem into: Given list of evens, we can reduce any of them (as long as even). Minimize deviation.
    -   This is similar to "Smallest Range" or tracking dynamic max/min.

2.  **Algorithm**:
    -   Convert all odd `n` to `2n`. Even `n` stays `n`. Store in `PriorityQueue` (Max Heap).
    -   Track `minVal` of elements in PQ.
    -   Loop:
        -   `maxVal = pq.poll()`.
        -   `diff = maxVal - minVal`.
        -   `ans = min(ans, diff)`.
        -   If `maxVal` is even:
            -   `newVal = maxVal / 2`.
            -   `pq.offer(newVal)`.
            -   `minVal = min(minVal, newVal)`.
        -   If `maxVal` is odd:
            -   Stop. We cannot reduce the maximum anymore to check smaller deviations. (Since we can only reduce, and max is odd, impossible to go lower).

3.  **Complexity**:
    -   Time: $O(N \log N \cdot \log(\text{MaxVal}))$. The inner loop runs $\log(\text{MaxVal})$ times per element.
    -   Space: $O(N)$.

## Implementation Details
-   `PriorityQueue`. Initial tracking of min.
