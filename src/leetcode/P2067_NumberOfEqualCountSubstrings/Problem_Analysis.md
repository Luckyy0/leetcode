# Problem Analysis: Number of Equal Count Substrings

## Problem Description
String `s`. `count`.
Return number of substrings where **every** character in the substring appears exactly `count` times. (Or 0 times, implied by "chars in substring").
Substring involves non-zero distinct characters.
Constraint `n <= 3 * 10^4`. `count <= n`.

## Analysis

1.  **Enumeration on Distinct Count**:
    -   A valid substring must have length `L = k * count`, where `k` is number of distinct characters.
    -   Since `s` has only 26 lowercase chars, `k` is $1 \dots 26$.
    -   Total possible lengths are `1*count, 2*count, ..., 26*count`.
    -   For each number of unique characters `u` (1 to 26):
        -   Length required `len = u * count`.
        -   Start sliding window of size `len`.
        -   Check if valid.
        -   Window valid if: `u` chars have `count`. All others `0`.
        -   Check: `distinct == u` AND `all_freqs == count`.
        -   Actually check: iterate freq array (26). Count how many have freq `count`. Should be `u`. Total non-zero should be `u`.
    -   Time Complexity: $26 \times N \times (26$ check? No, O(1) update).
    -   Total $O(26 \cdot N)$. Feasible.

## Implementation Details
-   Loop `u` from 1 to 26.
-   Window `len = u * count`.
-   If `len > s.length`, break.
-   Maintain frequency array in window.
