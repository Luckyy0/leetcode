# Problem Analysis: Maximize the Beauty of the Garden

## Problem Description
Array `flowers`. Beauty is sum of elements in subarray.
Constraint: First and last elements of subarray must be equal.
Negative values allowed.
Max beauty.

## Analysis

1.  **Prefix Sum + Map**:
    -   We need `max(prefix[j] - prefix[i-1])` where `flowers[i] == flowers[j]`.
    -   Also, since we keep `flowers[i]` and `flowers[j]` (even if negative), the sum includes them.
    -   Subarray `flowers[i...j]` sum is `P[j+1] - P[i]`.
    -   Wait, prefix indexing. Let `P[x]` be sum `0..x-1`.
    -   Sum `i..j` `(0-indexed)` = `P[j+1] - P[i]`.
    -   Condition: `flowers[i] == flowers[j]`.
    -   For each value `val` in `flowers`, we only care about the first occurrence `i_first` and any later occurrence `j`.
    -   If `flowers[i] == flowers[j]`, candidate beauty is sum `i..j`.
    -   However, if `flowers[i] < 0`, maybe we should start later?
    -   Actually, for a fixed pair `(i, j)` with same val, the sum is fixed.
    -   To maximize, for each `j`, we want `i < j` with `flowers[i] == flowers[j]` that minimizes `P[i]`.
    -   Store `min_prefix[val]` for each value encountered.
    -   We want to maximize `P[j+1] - min_prefix[val]`.
    -   Wait, `flowers[i]` must be included. `P[i]` excludes `flowers[i]`.
    -   Correct. `P[j+1]` includes `flowers[j]`. `P[i]` excludes `flowers[i]`. `flowers[i] == flowers[j]`.
    -   Keep track of `min_P[val]` where `min_P[val]` stores the smallest `P[i]` seen for an index `i` with `flowers[i] == val`.

2.  **Negative values logic**:
    -   Does having intermediate negative values matter? No, simple sum.
    -   Does having multiple occurrences of `val` matter? Yes.
    -   If we have indices `i1, i2, i3` with value `V`.
    -   Candidates: `(i1, i2), (i1, i3), (i2, i3)`.
    -   Sum `i1..i2`: `P[i2+1] - P[i1]`.
    -   Sum `i1..i3`: `P[i3+1] - P[i1]`.
    -   Sum `i2..i3`: `P[i3+1] - P[i2]`.
    -   Since we want to Maximize `P[end] - P[start]`, for a fixed `end`, we want minimum `P[start]`.
    -   So just track min `P[i]` for each value seen so far.
    -   But must satisfy `start < end` (at least length 2? Subarray length $\ge 2$ implied by "remove some flowers... making remaining...valid"? Wait, problem asks for "valid garden" subsequence? Or subarray?
    -   Problem text: "You can remove flowers... non-empty... remaining flowers ... start and end equal".
    -   Wait. Subsequence or Subarray?
    -   "select a set of flowers... they must form a contiguous part of the garden". -> Subarray.
    -   BUT "you can remove flowers". Wait.
    -   "You want to remove flowers... such that... remaining flowers... valid".
    -   "Valid": length >= 2, first == last.
    -   This implies we can take a subarray `flowers[i...j]` (where `flowers[i] == flowers[j]`) and remove any negative values inside to increase sum?
    -   "The beauty... is sum of values of remaining flowers".
    -   So we pick a range `[i, j]` with `flowers[i] == flowers[j]`.
    -   Inside `[i+1, j-1]`, we should keep all positive numbers and Discard all negative numbers.
    -   So "Beauty" is `flowers[i] + flowers[j] + sum(max(0, x) for x in flowers[i+1...j-1])`.
    -   Modified Prefix Sum: `MP[k] = sum(max(0, flowers[x]) for x < k)`.
    -   Sum `i..j` = `flowers[i] + flowers[j] + (MP[j] - MP[i+1])`. (Note indices).
    -   Eq: `2*val + MP[j] - MP[i+1]`.
    -   `MP[j] + val + (val - MP[i+1])`.
    -   For fixed `j`, we max `MP[j] + val + K` where `K = max(val - MP[i+1])` over previous `i`.
    -   Let's rewrite: `Beauty = MP[j] + flowers[j] + (flowers[i] - MP[i+1])`.
    -   Since `flowers[i] == flowers[j] == val`.
    -   Track `max(flowers[i] - MP[i+1])` for each value encountered.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$ (Map).

## Implementation Details
-   `Map<Integer, Integer> maxPrev`. Stores max `(val - MP[i+1])`.
-   `MP` array not needed fully, just current prefix sum of positives.
-   Be careful: `MP[i+1]` is sum of `max(0, flower)` up to `i`.
-   Current logic: Iterate `j`. Acc `currentMP`.
-   Check if `flowers[j]` in map. If so, `maxBeauty = max(maxBeauty, currentMP + flowers[j] + map.get(flowers[j]))`.
-   Update map: `map.put(flowers[j], max(existing, flowers[j] - (currentMP + max(0, flowers[j]))))`.
-   Wait. `MP[i+1]` includes `i` if positive.
-   Let's trace:
    -   `MP[k]`: sum of `max(0, x)` for `0..k-1`.
    -   At index `j`: `currentMP` is `MP[j]`.
    -   We want matching `i < j`.
    -   Term: `flowers[i] + flowers[j] + (MP[j] - MP[i+1])`.
    -   `= flowers[j] + MP[j] + (flowers[i] - MP[i+1])`.
    -   When processing `i`:
        -   Store `flowers[i] - MP[i+1]`.
        -   `MP[i+1] = MP[i] + max(0, flowers[i])`.
