# Problem Analysis: Find Array Given Subset Sums

## Problem Description
Array `sums` (length $2^n$). Contains all subset sums of an unknown array `arr` (length `n`).
Reconstruct `arr`.

## Analysis

1.  **Recursive Decomposition**:
    -   Sort `sums`. Step: Smallest two are `0` (empty) and `min(|x|)`. Wait.
    -   Actually `sums` sorted: `sums[0]` is clearly sum of negative numbers (if any). `sums[last]` is sum of positive numbers.
    -   Let `d = sums[1] - sums[0]`. `d` must be absolute value of one element in `arr`.
    -   Why? Because `sums[0]` corresponds to some subset. `sums[1]` corresponds to same subset + `x` or something.
    -   Actually, if `sums` are valid, `d = sums[1] - sums[0]` is a candidate element absolute value.
    -   Let `x = d`. Elements in `sums` can be paired `(s, s+x)`.
    -   We can split `sums` into two halves: `S0` (sums without `x`) and `S1` (sums with `x`).
    -   We need to decide if the element was `+x` or `-x`.
    -   If `+x`: `S0` are the subset sums of `arr \ {x}`. `0` must be in `S0`.
    -   If `-x`: `S1` are the subset sums of `arr \ {x}` (shifted). In this case `0` must be in `S1`. This happens if original valid sums are shifted so that `sums[0]` is negative.
    -   Algorithm:
        -   Sort `sums`.
        -   `d = sums[1] - sums[0]`.
        -   Split `sums` into pairs `(s, s+d)`. (Use frequency map or two pointers).
        -   Construct `left` (the `s` components) and `right` (the `s+d` components).
        -   One of `left` or `right` corresponds to subset sums of remaining `n-1` elements.
        -   Check if `0` is in `left`. If so, element is `+d`, recurse with `left`.
        -   Else (i.e. `0` is in `right`), element is `-d`, recurse with `right`.
        -   Base case: `n=0`. Return empty.
    -   Complexity: $O(2^n \cdot n)$. $n=15$. Fast.

2.  **Logic Logic**:
    -   Wait. Since `sums` contains ALL subset sums. `0` MUST be present in `sums`.
    -   At sorted index 0, `sums[0]` is min sum.
    -   `d = sums[1] - sums[0]`. `d` is positive.
    -   Partition into `S` and `S+d`.
    -   If `0` is in `S`, then `+d` is correct choice, `d` was added to `S` to form `S+d`. So `S` is the base.
    -   If `0` is not in `S` (meaning it's in `S+d`), then `-d` is correct choice. The base was `S+d`, and we subtracted `d` (added `-d`) to get `S`. So `S+d` is base.
    -   Actually, `0` is always in the valid subset sums.
    -   Checking containment is efficient.

## Implementation Details
-   `Arrays.sort`.
-   Recursion.
