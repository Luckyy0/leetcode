# Problem Analysis: Strings Differ by One Character

## Problem Description
Given a list of strings `dict` where all the strings are of the same length. Return `true` if there are 2 strings that differ by exactly one character. Otherwise, return `false`.

## Analysis

1.  **Constraints**:
    -   Number of strings `n` up to $10^5$? Actually standard constraints might be smaller or larger.
    -   Length of strings `m`.
    -   Typically $N \times M$ is within reasonable bounds (e.g., $10^5 - 10^6$ total characters).
    -   Brute force: Compare every pair. $O(N^2 \cdot M)$. Too slow if $N$ is large.

2.  **Hashing Strategy**:
    -   For each string, we can generate all possible "wildcard" strings by replacing one character with a placeholder (e.g., '*').
    -   Store these wildcard strings in a Set.
    -   If we encounter a wildcard string that is already in the Set, it means another string reduced to the same pattern, so they differ by exactly that one replaced character.
    -   Total complexity: $O(N \cdot M)$.

3.  **Optimized Hashing (Rolling Hash)**:
    -   Instead of storing full strings (which takes space and time), we can use rolling hashes.
    -   Compute the hash of the full string.
    -   For each index $j$, subtract the contribution of `S[j]` to get the hash of the string with `S[j]` removed (or replaced by 0).
    -   Check if this partial hash exists in a set for position $j$.
    -   To avoid collisions, use a large prime modulus or double hashing.

    Algorithm:
    1. Precompute `powers` of base (e.g., 26 or 31) modulo `MOD`.
    2. Compute full hash for each string.
    3. For each column `j` (0 to m-1):
       - Create a HashSet `seen`.
       - For each string `i` (0 to n-1):
         - Calculate `newHash = (fullHash[i] - charVal * powers[m-1-j]) % MOD`. (Handle negative logic).
         - If `seen` contains `newHash`, return true.
         - Else `seen.add(newHash)`.
    
    Wait, iterating column by column is better because we reset the HashSet, reducing memory usage (though total operations are same). Or we can just use one HashSet if we include the index in the hash, but that's complicated. Actually, we just need to know if two strings become equal when removing char at index `j`.
    
    Hash Collision Risk:
    -   With a single 64-bit hash (Java `long`), collisions are rare but possible.
    -   Standard LeetCode logic usually accepts this. Double hashing is safer.

4.  **Complexity**:
    -   Time: $O(N \cdot M)$.
    -   Space: $O(N)$ (reusing set for each column).

## Implementation Details
-   Base: 26 (since lowercase English letters).
-   Mod: Large prime (e.g., $10^{11} + 7$ or similar long prime).
-   Be careful with negative results after subtraction in modulo arithmetic.
