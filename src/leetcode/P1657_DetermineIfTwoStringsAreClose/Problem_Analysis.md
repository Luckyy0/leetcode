# Problem Analysis: Determine if Two Strings Are Close

## Problem Description
Two strings are close if you can attain one from the other using the following operations:
1.  Swap any two existing characters. (Standard reordering).
2.  Transform every occurrence of one existing character into another existing character, and do the same with the other character. (Swap frequencies).

Return `true` if `word1` and `word2` are close, and `false` otherwise.

## Analysis

1.  **Conditions**:
    -   Operation 1 means order doesn't matter (Anagram property).
    -   Operation 2 means the specific assignment of counts to characters can be swapped.
    -   This implies:
        1.  The **set of unique characters** present must be identical. (You can't introduce a new char or remove one).
        2.  The **multiset of frequencies** must be identical. (e.g. if word1 has {a:2, b:3} and word2 has {a:3, b:2}, counts are {2, 3} and {3, 2}. Sorted they match).

2.  **Algorithm**:
    -   Length check.
    -   Count frequencies for both.
    -   Check if `freq1[i] > 0` iff `freq2[i] > 0` for all chars.
    -   Collect frequencies into lists, sort, and compare.

3.  **Complexity**:
    -   Time: $O(N)$. Sorting takes constant time (26 elements).
    -   Space: $O(1)$.

## Implementation Details
-   `int[26]` frequency arrays.
