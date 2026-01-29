# Problem Analysis: Largest Merge Of Two Strings

## Problem Description
`word1`, `word2`. Merge to form lexicographically largest string.
At each step, take first char of `word1` or `word2`.
If `word1[0] > word2[0]`, take `word1[0]`.
If `word1[0] == word2[0]`, look ahead to break ties properly.

## Analysis

1.  **Greedy with Lookahead**:
    -   If start chars differ, pick larger.
    -   If same, compare remaining suffix of `word1` vs `word2`.
    -   If `word1` suffix > `word2` suffix, pick `word1[0]`. Else `word2[0]`.
    -   Why comparison works? Because we want largest chars as early as possible.

2.  **String Comparison**:
    -   Java `String.compareTo` works on full suffix.
    -   $O((N+M)^2)$ because string comparison takes linear time.
    -   $N, M \le 3000$. $3000^2 \approx 9 \cdot 10^6$, acceptable.

## Implementation Details
-   Pointers `i`, `j`.
-   Use `substring` for comparison (might be heavy if new string created).
-   Better: Custom comparison function to avoid allocation? Or just `string.substring` if constraints allow. Java substring creates new string in modern versions (O(N) copy).
-   Use `String.compareTo` on substrings.

3.  **Optimization**:
    -   If needed, character comparison loop.
    -   Constraints N=3000, complexity ok.

## Implementation Details
-   `StringBuilder`.
