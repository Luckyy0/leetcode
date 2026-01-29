# Problem Analysis: Maximum Good People Based on Statements

## Problem Description
`statements[i][j]`. 0: bad, 1: good, 2: ?
Logic:
-   Good person's statements are TRUE.
-   Bad person's statements can be ANYTHING (True or False, doesn't matter, we don't use them to constrain?). Wait.
-   "A bad person might tell the truth or lie." -> Their statements imply nothing about others.
-   BUT: "A good person tells the truth".
    -   If `i` is Good, and `stm[i][j] == 0` -> `j` MUST be Bad.
    -   If `i` is Good, and `stm[i][j] == 1` -> `j` MUST be Good.
-   Maximize number of Good people.

## Analysis

1.  **Bitmask Iteration**:
    -   `n` is small (usually <= 15 for bitmask problems).
    -   Iterate all $2^n$ subsets. Each subset represents "These people are Good".
    -   Check validity:
        -   For each person `i` assumed Good:
            -   Check their statements against the assumption.
            -   For all `j`, if `stm[i][j] != 2`, check if `stm[i][j] == (j is Good ? 1 : 0)`.
            -   If conflict, invalid subset.
        -   (We don't check Bad people's statements).
    -   If valid, update max.
    -   Optimization: Iterate masks from high cardinality to low? Or just all. $2^{15} = 32768$. Fast.

## Implementation Details
-   Outer loop `mask` 0 to `1<<n`.
-   Inner loops.
