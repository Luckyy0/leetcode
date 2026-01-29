# Problem Analysis: Split Two Strings to Make Palindrome

## Problem Description
You are given two strings `a` and `b` of the same length. Choose an index `split` and split both strings at the same index, separating them into two parts: `prefix` and `suffix`.
Check if `a_prefix + b_suffix` or `b_prefix + a_suffix` forms a palindrome.

## Analysis

1.  **Logic**:
    -   We need to check two cases: `A_prefix + B_suffix` and `B_prefix + A_suffix`. They are symmetric, so we can write a helper function `check(s1, s2)` that checks if `s1_prefix + s2_suffix` works.
    -   For `s1_prefix + s2_suffix` to be a palindrome:
    -   The characters at the beginning of `s1` (`s1[0], s1[1]...`) must match the characters at the end of `s2` (`s2[n-1], s2[n-2]...`) as much as possible.
    -   Suppose `s1[i] == s2[n-1-i]` for all `0 <= i < k`. We greedily find the maximal `k`.
    -   After matching the outer layers, the remaining middle part must be a palindrome itself.
    -   The middle part will come entirely from `s1` OR entirely from `s2` (because the split point can be anywhere in the "matched" region or further).
    -   Specifically, if we split at index `k`, the result is `s1[0...k-1] + s2[k...n-1]`.
    -   If we matched `k` chars, the required palindrome condition is on `s1[k ... n-1-k]` OR `s2[k ... n-1-k]`.
    -   Why? Because the split can happen effectively "after" the prefix `s1[0...k-1]` (so we take `s1` middle), OR "before" the suffix `s2[n-k...n-1]` (so we take `s2` middle).
    -   Wait, if we split inside the matched prefix region (index $< k$), say at `j < k`, then `s1[0...j] + s2[j...n-1]`. Since `s1[0...j]` matches `s2[n-1-j...n-1]`, we effectively need `s2`'s remainder to be palindrome?
    -   Actually simpler:
        -   Expand match `s1[i] == s2[n-1-i]` starting from `i=0`. Let it match up to `i < k`.
        -   We need either `s1[k ... n-1-k]` to be a palindrome OR `s2[k ... n-1-k]` to be a palindrome.
        -   If either is true, valid.

2.  **Algorithm**:
    -   `check(a, b)`:
        -   Find maximal `k` where `a[i] == b[n-1-i]`.
        -   If `k >= n/2`, it means they matched fully or crossed. Return true.
        -   Check if `isPalindrome(a, k, n-1-k)` OR `isPalindrome(b, k, n-1-k)`.
    -   Return `check(a, b) || check(b, a)`.

3.  **Complexity**:
    -   Time: $O(N)$ (scanning).
    -   Space: $O(1)$.

## Implementation Details
-   Helper `isPalindrome`.
