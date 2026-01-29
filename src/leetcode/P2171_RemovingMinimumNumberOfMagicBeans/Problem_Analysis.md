# Problem Analysis: Removing Minimum Number of Magic Beans

## Problem Description
Array `beans`.
Remove beans so that for remaining non-empty bags, all have EQUAL number of beans.
Minimize removed beans.
Equivalent to maximizing remaining beans.

## Analysis

1.  **Sorting + Prefix Sum**:
    -   If we decide the final size of non-empty bags is `X`.
    -   Any bag with `< X` must be emptied (0 beans).
    -   Any bag with `> X` must be reduced to `X`.
    -   Total kept = `count_of_bags_ge_X * X`.
    -   We want to maximize `Total kept`.
    -   Candidates for `X`? `X` must be one of the values present in `beans`.
    -   Why? If we pick `X` not in array, picking the next smaller value from array as `X'` allows keeping more beans (same count of bags, but larger size? No, smaller size).
    -   Wait. If `X` is between `beans[i]` and `beans[i+1]`:
        -   Bags `0..i` emptied. Bags `i+1..n-1` reduced to `X`.
        -   Kept = `(n - (i+1)) * X`.
        -   If we increase `X` to `beans[i+1]`, count is same. Kept increases.
        -   So optimal `X` is always one of `beans[i]`.
    -   Sort `beans`: `b_0, b_1, ..., b_{n-1}`.
    -   Try each `b_i` as the target size `X`.
    -   Count bags $\ge b_i$ is `n - i`.
    -   Total Kept = `(n - i) * b_i`.
    -   Total Removed = `TotalSum - Kept`.
    -   Maximize Kept.

## Implementation Details
-   Sort.
-   Calculate Total Sum.
-   Loop `i`.
