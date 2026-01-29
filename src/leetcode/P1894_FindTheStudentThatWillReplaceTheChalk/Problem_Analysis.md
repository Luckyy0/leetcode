# Problem Analysis: Find the Student that Will Replace the Chalk

## Problem Description
`chalk` array. `k` initial chalk.
Students consume chalk cyclically.
Find who runs out.

## Analysis

1.  **Modulo**:
    -   Calculate `sum`.
    -   `k %= sum`.
    -   Iterate array. Subtract `chalk[i]` from `k`.
    -   If `k < 0`, index `i` is the answer.

## Implementation Details
-   `long` sum.
