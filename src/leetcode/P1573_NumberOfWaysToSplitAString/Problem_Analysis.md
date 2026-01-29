# Problem Analysis: Number of Ways to Split a String

## Problem Description
Given a binary string `s` (a string consisting only of '0's and '1's), we can split `s` into 3 non-empty strings `s1, s2, s3` such that `s1 + s2 + s3 = s`.
Return the number of ways `s` can be split such that the number of ones is the same in `s1`, `s2`, and `s3`.
Since the answer may be too large, return it modulo $10^9 + 7$.

## Analysis

1.  **Count Ones**:
    -   First, count total ones in `s`. Let this be `totalOnes`.
    -   If `totalOnes % 3 != 0`, return 0 (impossible to split equally).

2.  **Case: totalOnes == 0**:
    -   All characters are '0'.
    -   We need to place 2 cuts in `n-1` possible positions.
    -   Number of ways = $\binom{n-1}{2} = \frac{(n-1)(n-2)}{2}$.

3.  **Case: totalOnes > 0**:
    -   Target ones per part = `k = totalOnes / 3`.
    -   We need to find the ranges of zeros between the `k`-th 1 and `(k+1)`-th 1 (First Cut Zone), and between `2k`-th 1 and `(2k+1)`-th 1 (Second Cut Zone).
    -   Let `oneIndices` be the list of indices where `s[i] == '1'`.
    -   The first part must contain `oneIndices[0]` through `oneIndices[k-1]`.
    -   The split can happen anywhere between `oneIndices[k-1]` and `oneIndices[k]`.
    -   Number of valid positions for first cut = `oneIndices[k] - oneIndices[k-1]`.
    -   Similarly, second cut must be between `oneIndices[2k-1]` and `oneIndices[2k]`.
    -   Number of valid positions for second cut = `oneIndices[2k] - oneIndices[2k-1]`.
    -   Total ways = (Ways for Cut 1) * (Ways for Cut 2).

4.  **Complexity**:
    -   Time: $O(N)$ scan to find indices.
    -   Space: $O(N)$ used to store indices (or count logic).

## Implementation Details
-   Use `long` for multiplication to avoid overflow before modulo.
