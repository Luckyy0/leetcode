# Problem Analysis: Split a String Into the Max Number of Unique Substrings

## Problem Description
Given a string `s`, return the maximum number of unique substrings that the given string can be split into.
You can split string `s` into any list of non-empty substrings `s1, s2, ..., sn` such that the concatenation of the substrings forms `s` and all `si` are unique.

## Analysis

1.  **Constraints**:
    -   `s.length <= 16`.
    -   Backtracking is viable.

2.  **Backtracking Strategy**:
    -   Maintain a `HashSet<String>` of used substrings.
    -   `backtrack(startIdx)`:
        -   Iterate `end` from `startIdx` to `s.length()`.
        -   Substring `sub = s.substring(startIdx, end + 1)`.
        -   If `!set.contains(sub)`:
            -   `set.add(sub)`.
            -   `max = Math.max(max, 1 + backtrack(end + 1))`.
            -   `set.remove(sub)`.
    -   Base case: `startIdx == s.length()`, return 0.
    
3.  **Optimization**:
    -   Pruning: If `currentCount + (remainingLen) <= maxSoFar`, stop? Yes.
    -   Though N=16 is small enough for standard DFS.

4.  **Complexity**:
    -   Roughly $2^{16}$ possibilities of splits (worst case partitions). $16 \cdot 2^{16} \approx 10^6$ ops.

## Implementation Details
-   `Set<String>`.
