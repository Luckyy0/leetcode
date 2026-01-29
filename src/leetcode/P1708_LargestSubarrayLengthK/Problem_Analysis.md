# Problem Analysis: Largest Subarray Length K

## Problem Description
Array `nums`. Return largest subarray of length `k`.
"Largest" means lexicographically largest. Integers are distinct.

## Analysis

1.  **Lexicographical**:
    -   We need `sub[0]` to be as large as possible.
    -   Valid start indices for subarray of length `k`: `0` to `n-k`.
    -   Find `max(nums[0 \dots n-k])`. Let index be `maxIdx`.
    -   Subarray starts at `maxIdx`.

2.  **Algorithm**:
    -   Iterate `0` to `n-k`. Find max.
    -   `Arrays.copyOfRange`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(K)$.

## Implementation Details
-   `Arrays.copyOfRange`.
