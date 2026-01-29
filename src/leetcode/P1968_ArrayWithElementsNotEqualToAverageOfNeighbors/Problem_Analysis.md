# Problem Analysis: Array With Elements Not Equal to Average of Neighbors

## Problem Description
Array `nums` (distinct).
Rearrange such that `nums[i] != (nums[i-1] + nums[i+1]) / 2` for all internal `i`.
This means no arithmetic progression of length 3 subsequence (contiguous).
`(a + c) / 2 == b` iff `a + c == 2b`.

## Analysis

1.  **Wiggle Sort**:
    -   Sort the array.
    -   Interleave small and large elements. `Small, Large, Small, Large...`
    -   Property: `Small < Large`.
    -   Look at `Large`. Neighbors are Small. `S1 < L > S2`.
    -   Average of `S1, S2` is definitely `< L`. So `(S1+S2)/2 != L`.
    -   Look at `Small`. Neighbors are Large. `L1 > S < L2`.
    -   Average of `L1, L2` is definitely `> S`. So `(L1+L2)/2 != S`.
    -   Thus, `Small, Large, Small, Large...` satisfies condition.
    -   Unless equality? `nums` are distinct.
    -   If `S1 < L > S2`:
        -   `avg(S1, S2) <= max(S1, S2) < L`. Condition holds.
    -   If `L1 > S < L2`:
        -   `avg(L1, L2) >= min(L1, L2) > S`. Condition holds.
    -   So any wiggle arrangement works.

2.  **Implementation**:
    -   Sort.
    -   Two pointers or new array.
    -   `0, 1` -> `0, n/2, 1, n/2+1, ...`?
    -   Usually: `1st half` at even indices (0, 2...), `2nd half` at odd indices (1, 3...)?
    -   Wait. If `mid` elements overlap?
    -   Just fill: `ans[0] = A[0]`, `ans[1] = A[mid]`, `ans[2] = A[1]`, `ans[3] = A[mid+1]`.
    -   Ensure indices don't overflow.

## Implementation Details
-   Sort.
-   Reorder.
