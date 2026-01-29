# Problem Analysis: Partition Array According to Given Pivot

## Problem Description
Array `nums`, pivot.
Rearrange so:
1.  Elements < pivot come before elements = pivot.
2.  Elements = pivot come before elements > pivot.
3.  Relative order of elements < pivot maintained.
4.  Relative order of elements > pivot maintained.

## Analysis

1.  **3-Pass or Auxiliary Arrays**:
    -   Pass 1: Collect elements < pivot.
    -   Pass 2: Collect elements = pivot.
    -   Pass 3: Collect elements > pivot.
    -   Concat. Max time $O(N)$, Space $O(N)$.
    -   Can be done in one pass with 3 lists.

## Implementation Details
-   3 List/Builder.
-   Combine.
