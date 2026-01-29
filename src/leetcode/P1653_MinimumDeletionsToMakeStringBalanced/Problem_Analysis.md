# Problem Analysis: Minimum Deletions to Make String Balanced

## Problem Description
You are given a string `s` consisting only of characters 'a' and 'b'.
You want to delete minimum characters to make `s` balanced.
`s` is balanced if there is no pair of indices `(i, j)` such that `i < j` and `s[i] = 'b'` and `s[j] = 'a'`.
Essentially, `s` must look like `aaaa...bbbb`.

## Analysis

1.  **Split Point Strategy**:
    -   We need to find a split point `p` such that all characters before `p` should be 'a' (so delete 'b's) and all characters at/after `p` should be 'b' (so delete 'a's).
    -   Iterate `p` from `0` to `n`.
    -   `Cost(p) = Count('b' in 0..p-1) + Count('a' in p..n-1)`.
    -   Optimize:
        -   Precompute total 'a's.
        -   Iterate `p`. Maintain running count of 'b's encountered so far.
        -   Running 'a's remaining = `TotalA - A_so_far`.
        -   `Cost = b_so_far + (TotalA - A_so_far)`. Or more precisely if `p` is the start of `b` block:
            -   Indices `0` to `p-1`: become 'a'. Delete 'b's in this range.
            -   Indices `p` to `n-1`: become 'b'. Delete 'a's in this range.
   
2.  **DP Approach (Stack)**:
    -   Iterate characters.
    -   If char is 'b', push to stack (or count).
    -   If char is 'a':
        -   If we have a 'b' before it (count_b > 0), we have a conflict "ba".
        -   We can either delete this 'a' OR delete the 'b'.
        -   Greedily, we pair them up and say "one deletion required".
        -   Wait, stack approach:
            -   Count `b` so far.
            -   If `c == 'a'`: we can delete this `a` (cost + 1) or keep it.
            -   Actually, DP:
            -   `dp[i]` min deletions for prefix `i`.
            -   Use split point approach ($O(N)$), it's global and simple.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Count total 'a'.
-   Loop through string. Update cost.
