# Problem Analysis: Number of Unique Flavors After Sharing K Candies

## Problem Description
Array `candies`. Give `k` candies to sister.
Return max unique flavors remaining.
Candies given are a contiguous subarray of length `k`? Or any k?
"Give k candies ... she wants ... contiguous ... sub-array." ?
Problem usually: "share k candies ... contiguous subarray". Since optimal usually implies contiguous removal?
Description: "She wants you to give her `k` candies. You want to keep as many unique flavors...".
Usually implied or stated: "subarray". LeetCode problem titles often imply context. Let's assume contiguous subarray.
Actually, if "any k", we just remove duplicates.
But "Sharing K Candies" usually refers to removing a window.
Re-check constraint details or similar problems (e.g. Card Points).
P2107 specific: "contiguous subarray".
Algorithm: Sliding Window of size `k` to REMOVE.
Remainder: Count unique.

## Analysis

1.  **Sliding Window (Removal)**:
    -   Total length `n`. Window `k`.
    -   Initial state: Count freq of ALL candies. `uniqueCount`.
    -   Remove first `k` (index 0 to k-1). Update `uniqueCount` (if freq drops to 0, decrement unique).
    -   This is the result for window at 0.
    -   Slide window:
        -   Add `candies[i-1]` (left out). Update freq/unique.
        -   Remove `candies[i + k - 1]` (new in removal window). Update freq/unique.
        -   Track `max(uniqueCount)`.

## Implementation Details
-   `HashMap` (or Array if strictly integer flavors, usually 10^5).
-   Constraint: flavors up to $10^5$. Start with Map.
-   Optimization: If values small, array is faster.
-   Assume values fit in array or use Map.
