# Problem Analysis: The Score of Students Solving Math Expressions

## Problem Description
String `s` (digits, +, *). Length $\le 31$.
Correct answer: Standard operator precedence.
Students' answers: `answers` array.
Score:
-   5 points if `ans == correct`.
-   2 points if `ans` could be produced by evaluating `s` with *any* order of operations.
-   0 otherwise.
Total score.

## Analysis

1.  **Correct Answer**:
    -   Evaluate standard. `Stack`.

2.  **All Possible Values (DP)**:
    -   Interval DP `dp[i][j]` = Set of all possible values for substring `s[i...j]`.
    -   Split at operator `k`. `dp[i][k-1]` op `dp[k+1][j]`.
    -   Since length is small (31 chars -> ~15 numbers), DP is feasible.
    -   Values can be up to 1000. Any value > 1000 can be ignored (since student answers $\le 1000$).
    -   Set size limited to 1001.

## Implementation Details
-   `Stack` for correct.
-   `Set<Integer>[][] dp`.
