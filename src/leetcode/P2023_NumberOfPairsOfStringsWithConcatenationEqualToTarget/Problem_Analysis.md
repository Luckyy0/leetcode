# Problem Analysis: Number of Pairs of Strings With Concatenation Equal to Target

## Problem Description
Array `nums` (strings). String `target`.
Count `(i, j)` where `i != j` and `nums[i] + nums[j] == target`.

## Analysis

1.  **Frequency Map**:
    -   Store frequency of each string in `nums`.
    -   Iterate possible split points of `target`.
    -   `prefix = target[0...k]`, `suffix = target[k+1...]`.
    -   Count `pairs += count(prefix) * count(suffix)`.
    -   If `prefix == suffix`, `pairs += count(prefix) * (count(prefix) - 1)`.

## Implementation Details
-   Loop `k` 1 to `target.length - 1`.
-   Wait. `nums[i]` might not be splits of target?
-   Yes, we check if `nums` entries match prefix/suffix.
-   Constraints: `nums` length 100. `target` length 100.
-   Brute force $N^2$ is fine ($100^2 = 10000$).
-   Better: Iterate `i`, `j` and check. Simple and robust.

## Implementation Details
-   Bruteforce $O(N^2 * L)$.
