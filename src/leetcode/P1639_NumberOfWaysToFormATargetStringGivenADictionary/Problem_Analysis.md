# Problem Analysis: Number of Ways to Form a Target String Given a Dictionary

## Problem Description
You are given a list of strings of the same length `words` and a string `target`.
Your task is to form `target` using the given `words` under the following rules:
-   `target` should be formed from left to right.
-   To form the $i^{th}$ character (0-indexed) of `target`, you can choose the $k^{th}$ character of the $j^{th}$ string in `words` if `target[i] = words[j][k]`.
-   Once you use the $k^{th}$ character of the $j^{th}$ string of `words`, you cannot use the $x^{th}$ character of any string in `words` where $x \le k$. In other words, all characters to the left of or at index `k` become unusable for every string.
-   Repeat this process until you form the string `target`.

Return the number of ways to form the target string modulo $10^9 + 7$.

## Analysis

1.  **Dynamic Programming**:
    -   We need to pick characters for `target[0]`, `target[1]`, etc. in order.
    -   The column indices we pick from must strictly increase.
    -   Let `dp[i][k]` be the number of ways to form `target[0 \dots i]` using columns `0 \dots k`.
    -   Actually, simpler state:
        -   Precompute frequency of each char in each column of `words`. `freq[col][char]`.
        -   `dp[i][k]` = ways to form `target[0 \dots i]` using a subset of columns ending at or before `k`.
    -   Transitions for `dp[i][k]` (where `i` is target index, `k` is current column index):
        1.  Don't use column `k`: `dp[i][k-1]`.
        2.  Use column `k` for `target[i]`: `dp[i-1][k-1] * freq[k][target[i]]`.
        -   `dp[i][k] = dp[i][k-1] + dp[i-1][k-1] * freq[k][target[i]]`.
    -   Optimize space:
        -   `dp[i]` stores ways to form `target[0 \dots i]` using columns processed so far.
        -   Iterate columns `k` from 0 to `width-1`.
        -   Update `dp` array.
        -   Update need to be backwards to avoid using same column for multiple target chars (actually impossible since target grows, but standard 0/1 knapsack logic applies).
        -   If we iterate `i` downwards from `target.length-1` to 0:
        -   `dp[i] = dp[i] + dp[i-1] * freq[k][target[i]]`.
        -   Base case: `dp[-1] = 1` (conceptually). So `dp[0] += 1 * freq`.

2.  **Complexity**:
    -   Precompute freq: $O(M \cdot L)$ where M is number of words, L is word length.
    -   DP: $O(L \cdot T)$ where L is word length, T is target length.
    -   Space: $O(T)$ + $O(L \times 26)$.

## Implementation Details
-   `long` for modulo arithmetic.
-   `dp` array size `target.length`.
-   Initialize `dp[-1]` logic carefully. Can validly start with `dp` size `T+1`, `dp[0]=1`.
