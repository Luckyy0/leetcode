# Problem Analysis: Minimum Number of Flips to Make the Binary String Alternating

## Problem Description
String `s` (binary).
Op 1: Type-1. Move first char to end. (Cyclic shift).
Op 2: Type-2. Flip char.
Min Type-2 ops to make `s` alternating ("0101..." or "1010...").
Allow ANY number of Type-1 ops. This means we can match ANY cyclic shift of `s` to the target.

## Analysis

1.  **Sliding Window**:
    -   Targets are patterns like `0101...` and `1010...`.
    -   Since we can cyclically shift `s`, we are essentially looking for a substring of length `n` in the infinite alternating string that matches `s` (or a cyclic shift of `s`) with min flips.
    -   Or equivalently, match `s` (or shifts) to fixed `0101...` of length `n`.
    -   Consider `s` concatenated with itself `s + s`. A window of size `n` in `s + s` represents every cyclic shift.
    -   Targets: `T1 = 010101...` (len 2n). `T2 = 101010...` (len 2n).
    -   Compare `(s+s)` with `T1`. Count mismatches in sliding window of size `n`.
    -   Compare `(s+s)` with `T2`. Count mismatches.
    -   Maintain mismatch count.
        -   Initialize count for first `n`.
        -   Slide: remove `(s+s)[i-n]` contribution, add `(s+s)[i]` contribution.
        -   Record min count.

2.  **Optimization**:
    -   We don't need to physically construct strings.
    -   Indices logic: `(s+s)[i]` corresponds to `s[i % n]`.
    -   Targets logic: T1[i] = (i % 2 == 0 ? '0' : '1'). T2[i] = ...

## Implementation Details
-   Loop `0` to `2*n - 1`.
-   Window checking for `i >= n`.
