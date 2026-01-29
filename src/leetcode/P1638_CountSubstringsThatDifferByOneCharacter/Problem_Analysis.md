# Problem Analysis: Count Substrings That Differ by One Character

## Problem Description
Given two strings `s` and `t`, find the number of ways you can choose a non-empty substring of `s` and replace a single character by a different character such that the resulting substring is a substring of `t`.
In other words, find the number of pairs `(s_substr, t_substr)` such that they are the same length and differ by exactly one character.

## Analysis

1.  **Brute Force ($O(N^3)$)**:
    -   Iterate all substrings of `s` and `t`. Compare. Too slow ($100^3 \times 100 \approx 10^8$). Constraints $N, M \le 100$. Actually $100^4$ is $10^8$. Might be pass-able in C++, risky in Java.
    
2.  **Better Approach ($O(N^2 \cdot \min(N, M))$)**:
    -   Fix starting points `i` in `s` and `j` in `t`.
    -   Iterate length `k`.
    -   Count diffs. If diff == 1, `ans++`. If diff > 1, break.
    -   Complexity: $100 \cdot 100 \cdot 100 = 10^6$. Very fast.

3.  **Algorithm**:
    -   Loop `i` from 0 to `s.length`.
    -   Loop `j` from 0 to `t.length`.
    -   Loop `k` while valid.
    -   `diffCount`.
    -   If `s[i+k] != t[j+k]`, `diffCount++`.
    -   If `diffCount == 1`, `res++`.
    -   If `diffCount > 1`, break.

4.  **Complexity**:
    -   Time: $O(N \cdot M \cdot \min(N, M))$.
    -   Space: $O(1)$.

## Implementation Details
-   Triple loop. simple.
