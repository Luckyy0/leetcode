# Problem Analysis: Maximum Product of the Length of Two Palindromic Substrings

## Problem Description
String `s`. Find two **non-intersecting** palindromic substrings. Max product of lengths.
Lengths must be odd.

## Analysis

1.  **Manacher's Algorithm + Prefix/Suffix Max**:
    -   Use Manacher to find max palindrome length centered at each index. `P[i]`.
    -   We need two disjoint substrings. Split point `i`.
    -   Left part `s[0...i]`. Right part `s[i+1...n-1]`.
    -   Find max odd palindrome in Left and max odd palindrome in Right.
    -   Let `maxLeft[i]` be the length of the longest odd palindrome strictly inside `s[0...i]`.
    -   Let `maxRight[i]` be the length of the longest odd palindrome strictly inside `s[i...n-1]`.
    -   Then ans = `max(maxLeft[i] * maxRight[i+1])` over `i`.
    
2.  **Calculating maxLeft/maxRight**:
    -   Manacher gives radius `P[i]` for center `i`. Palindrome range `[i - P[i], i + P[i]]`. Length `2*P[i] + 1`.
    -   For `maxLeft`:
    -   We have intervals `[L, R]`. For each `i` (end of prefix), we want max length of interval contained in `[0, i]`.
    -   Interval `[l, r]` updates `maxLeft` for `k >= r`.
    -   Specifically, a palindrome centered at `c` with radius `r` covers `[c-r, c+r]`. It has length `2r+1`.
    -   It is valid for `maxLeft[x]` where `x >= c+r`.
    -   Using a queue/scan:
        -   For each center `c`, `R = c + P[c]`. Length `len = 2*P[c] + 1`.
        -   This `len` is valid for indices `x >= R`. Update `maxLeft[R] = max(maxLeft[R], len)`.
        -   But smaller radius palindromes centered at `c` end earlier. `c + (P[c]-1)` covers length `2(P[c]-1)+1`...
        -   We need to propagate `maxLeft[x] = max(maxLeft[x], maxLeft[x-1])`.
        -   However, strictly speaking, just setting `maxLeft[R]` is not enough because we might have a very long palindrome ending very late, but a slightly shorter one ending earlier that is needed for earlier splits.
        -   Actually, we can simply say: For center `c` and radius `r`, the palindrome `[c-r, c+r]` ends at `c+r`.
        -   Update `maxLeft[c+r] = max(maxLeft[c+r], 2*r+1)`.
        -   BUT, we must not miss "sub-palindromes". E.g. if radius is 5, we implicitly have radius 4 ending at `c+4`, radius 3 ending at `c+3`, etc.
        -   So for each center `c`, we update `maxLeft[c+r]` with `2r+1` for ALL `0 <= r <= P[c]`. This is slow ($O(N^2)$).
        -   Optimization: Notice `maxLeft[x]` only increases.
        -   We can iterate `c`. `r = P[c]`. Update `maxLeft[c+r]` with `2r+1`.
        -   Also, `maxLeft[x]` should be at least `maxLeft[x-1]`.
        -   Also, `maxLeft[x]` should be at least (value from center `c` ending at `x`).
        -   Actually, just using the maximal radius is sufficient if we propagate backwards? No.
        -   Work from right to left with a queue?
        -   Alternative: Iterate `x` from 0 to `n-1`. Maintain a "best center" or check relevant centers.
        -   Better:
            -   Init `maxLeft` array with 0.
            -   For each `c`, `r = P[c]`. `endTime = c + r`. Update `maxLeft[endTime] = max(maxLeft[endTime], 2*r+1)`.
            -   Now iterate `x` from `n-2` down to `0`. `maxLeft[x] = max(maxLeft[x], maxLeft[x+1] - 2)`.
                -   Why? If a palindrome of length `L` ends at `x+1`, then a palindrome of length `L-2` ends at `x` (by stripping chars). (Unless center is `x` itself? No, center is inside, stripping ends makes it smaller concentric palindrome).
                -   So `maxLeft[x]` can inherit from `maxLeft[x+1] - 2`.
            -   Then iterate `x` from `1` to `n-1`. `maxLeft[x] = max(maxLeft[x], maxLeft[x-1])`.
            -   This covers all cases.
    -   Same for `maxRight` (symmetric).

## Implementation Details
-   Manacher algo.
-   Propagation logic.
