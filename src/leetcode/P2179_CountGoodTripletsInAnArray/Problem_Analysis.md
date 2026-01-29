# Problem Analysis: Count Good Triplets in an Array

## Problem Description
Two arrays `nums1`, `nums2` (permutations of `0..n-1`).
Good triplet `(x, y, z)` if relative order in both arrays matches.
Count triplets.

## Analysis

1.  **Map to Indices + Fenwick Tree**:
    -   This is equivalent to finding triplets `(i, j, k)` such that `i < j < k` in `nums1` AND `pos[nums1[i]] < pos[nums1[j]] < pos[nums1[k]]` in `nums2`.
    -   Mapping: Replace elements in `nums1` with their positions in `nums2`.
    -   Let `arr[i] = position_in_nums2(nums1[i])`.
    -   We need `i < j < k` from `nums1` (indices) such that `arr[i] < arr[j] < arr[k]` (values).
    -   This is counting increasing subsequences of length 3.
    -   Algorithm:
        -   For each `j` (middle element):
        -   Count `L`: elements before `j` smaller than `arr[j]`.
        -   Count `R`: elements after `j` larger than `arr[j]`.
        -   `Triplets += L * R`.
    -   Use Fenwick Tree (BIT) to count smaller elements efficiently.
    -   `L`: Query BIT for `arr[j] - 1` while iterating forward. Add `arr[j]` to BIT.
    -   `R`: Can be derived. Total elements greater than `arr[j]` overall is `(n - 1 - arr[j])`. Elements greater BEFORE `j` is `(j - L)`. So elements greater AFTER `j` is `(n - 1 - arr[j]) - (j - L)`.
    -   Actually, simpler: use BIT.
        -   `smaller_before[i]`.
        -   `larger_after[i]`.
    -   BIT size `n`.

## Implementation Details
-   `pos` array.
-   `arr` transform.
-   BIT class.
