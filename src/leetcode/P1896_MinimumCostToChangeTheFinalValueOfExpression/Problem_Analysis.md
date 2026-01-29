# Problem Analysis: Minimum Cost to Change the Final Value of Expression

## Problem Description
Expression `expression` containing '0', '1', '&', '|', '(', ')'.
Evaluate expression. Return min operations to change value (0->1 or 1->0).
Operation: Flip '0' <-> '1', or '&' <-> '|'.

## Analysis

1.  **Parsing + DP**:
    -   Parse expression into tree or postfix. Since precedence is simple (brackets, then operators; actually & and | might have precedence, but usually equal or stated). Problem says `&` takes precedence? No, "evaluate standard way". Usually brackets first, then ops. & and | precedence: & often higher? Or left to right?
    -   LeetCode standard for boolean expression usually has & higher than |.
    -   However, better to parse carefully or use two-stack algorithm to evaluate AND build a "cost structure".
    -   For each sub-expression, we need:
        -   `val`: Current value (0 or 1).
        -   `costToFlip`: Min cost to change its value to `1 - val`.
    -   Base case: '0' -> val=0, cost=1. '1' -> val=1, cost=1.
    -   Recursive Step: `E1 op E2`.
        -   If `op` is '&':
            -   Val = `v1 & v2`.
            -   If `v1=0, v2=0` (Val=0): Need to change result to 1. Need `1 & 1`. Cost `c1 + c2`. Wait. If we change op to '|', `0|0=0` (still 0). So changing op doesn't help if both are 0.
            -   Wait. Op change is allowed.
            -   If op becomes '|', `v1 | v2`.
            -   Cases:
                -   `0 & 0`: Res 0. Target 1.
                    -   Keep `&`: need `1 & 1`. Cost `c1 + c2`.
                    -   Change to `|`: need `1 | 0` or `0 | 1` or `1 | 1`. Current `0 | 0 = 0`. Need to change at least one. Cost `1 + min(c1, c2)`.
                    -   Min cost: `min(c1 + c2, 1 + min(c1, c2))`. Obviously `1 + min` is better? Since `c1, c2 >= 1`.
                -   `0 & 1`: Res 0. Target 1.
                    -   Keep `&`: need `1 & 1`. Cost `c1`.
                    -   Change to `|`: `0 | 1 = 1`. Free! Cost `1` (for op change).
                    -   Min cost: `min(c1, 1)`. (Actually changing op is cost 1).
                -   `1 & 0`: Res 0. Target 1.
                    -   Keep `&`: need `1 & 1`. Cost `c2`.
                    -   Change to `|`: `1 | 0 = 1`. Cost `1`.
                    -   Min cost: `min(c2, 1)`.
                -   `1 & 1`: Res 1. Target 0.
                    -   Keep `&`: need `0 & 1` or `1 & 0`. Cost `min(c1, c2)`.
                    -   Change to `|`: `1 | 1 = 1`. Need `0 | 0`. Cost `1 + c1 + c2`. Which is worse.
                    -   Also change to `|` and `0 | 1`? No.
                    -   So `min(c1, c2)`.
        -   If `op` is '|', symmetric logic.

2.  **Implementation**:
    -   Convert to Postfix or use Recursive Descent.
    -   `Pair {val, cost}`.
    -   Stack of pairs. Stack of ops.

## Implementation Details
-   2 Stacks.
-   Handle precedence: `&` higher than `|`.
