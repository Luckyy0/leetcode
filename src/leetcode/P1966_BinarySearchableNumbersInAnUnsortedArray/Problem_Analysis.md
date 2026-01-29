# Problem Analysis: Binary Searchable Numbers in an Unsorted Array

## Problem Description
Array `nums` (distinct integers).
A number is "guaranteed to be found" by standard binary search if:
-   During binary search execution (searching for this number), the pivot element logic works correctly to lead to it.
-   Normally BS relies on sorting.
-   For a specific element `x` at index `i` to be found:
    -   For any pivot `k` visited on the path to `x`:
    -   If pivot value `nums[k] < x`, we must go right (meaning `i > k`).
    -   If pivot value `nums[k] > x`, we must go left (meaning `i < k`).
    -   If `nums[k] == x`, found.
-   This logic depends on values encountered.
-   BUT simpler condition for "Binary Searchable":
    -   An element at index `i` is binary searchable if and only if:
        -   All elements to its left are smaller than it.
        -   All elements to its right are larger than it.
    -   Proof: If left max < curr < right min, then BS pivot logic always steers correctly towards it given the random pivoting nature of BS?
    -   Actually, standard LeetCode problem definition usually implies for *any* pivot choice or standard?
    -   Usually means "All elements to the left are smaller AND All elements to the right are larger".
    -   Let's verify. If `nums = [2, 1, 3]`.
        -   Target 2 (index 0). Mid (index 1) = 1. `1 < 2`. Go right. Range `[2, 2]`. Mid (index 2) = 3. `3 > 2`. Go left. Range empty. Not Found.
        -   Left of 2 is empty (ok). Right of 2 has 1 (<2). Fails condition "Right are larger".
        -   Target 3 (index 2). Mid 1 (1 < 3). Go right. Mid 3 (=3). Found.
        -   Left of 3 has 2, 1 (smaller). Right empty. Condition holds.
    -   So condition is: `max(nums[0...i-1]) < nums[i] < min(nums[i+1...n-1])`.

## Analysis

1.  **Prefix Max and Suffix Min**:
    -   Compute `maxLeft[i]` = max of `nums[0...i-1]` (default -inf).
    -   Compute `minRight[i]` = min of `nums[i+1...n-1]` (default +inf).
    -   Check `maxLeft[i] < nums[i] < minRight[i]`.
    -   Count valid indices.

## Implementation Details
-   Two passes.
