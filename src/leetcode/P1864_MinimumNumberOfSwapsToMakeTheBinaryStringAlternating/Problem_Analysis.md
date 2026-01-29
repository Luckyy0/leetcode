# Problem Analysis: Minimum Number of Swaps to Make the Binary String Alternating

## Problem Description
Binary string `s`.
Allowed: Swap any two characters.
Make string "0101..." or "1010...".

## Analysis

1.  **Count Mismatches**:
    -   Two possible target patterns: start with '0' or start with '1'.
    -   Possibility check: Count(0) and Count(1) must differ by at most 1.
    -   If `n` is even, counts must be equal. Both patterns possible.
    -   If `n` is odd, counts differ by 1. Only the pattern starting with the more frequent char is possible.
    -   For a valid target pattern:
        -   Compare `s` with `target`.
        -   Count `mismatches`.
        -   Number of swaps = `mismatches / 2`.
        -   Why? A swap fixes 2 mismatched positions (one 0->1, one 1->0). Mismatch count will verify that misplaced 0s equal misplaced 1s.

2.  **Implementation**:
    -   Count 0s and 1s.
    -   If `abs(count0 - count1) > 1` return -1.
    -   Calculate swaps for possible targets. Return min.

## Implementation Details
-   Helper `countSwaps(s, startChar)`.
