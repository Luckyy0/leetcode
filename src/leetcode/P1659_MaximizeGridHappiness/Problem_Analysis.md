# Problem Analysis: Maximize Grid Happiness

## Problem Description
Grid `m x n` ($1 \le m \le 5, 1 \le n \le 5$). You have `introvertsCount` and `extrovertsCount`.
Happiness rules:
-   Introvert: Starts with 120. Loses 30 for each neighbor.
-   Extrovert: Starts with 40. Gains 20 for each neighbor.
Maximize total happiness.

## Analysis

1.  **Dynamic Programming with Profile**:
    -   Process cells one by one (row-major: `idx = r * n + c`).
    -   State needs to capture:
        -   Current index (0 to `m*n`).
        -   Remaining introverts.
        -   Remaining extroverts.
        -   The state of the "boundary" relevant for neighbor checks.
    -   Since we process cell `i`, we need to know its 'Up' neighbor (which is at `i - n`) and 'Left' neighbor (at `i - 1`).
    -   To support this for all future cells, we need the state of the last `n` cells.
    -   `mask`: integer representing states of previous `n` cells using Base 3 (0: Empty, 1: Intro, 2: Extro).
    -   Transitions: For cell `idx`, try placing Empty, Intro (if available), Extro (if available).
    -   Update happiness:
        -   Calculate interaction with `Left` (from mask lowest trit/bit?).
        -   Calculate interaction with `Up` (from mask highest trit/bit?).
        -   Actually, standard profile DP:
            -   `mask` stores row above.
            -   When moving from `(r, c)` to `(r, c+1)`, we shift mask.
            -   Oldest value (Up neighbor for current) is popped, new value (Current) is pushed.
            -   Wait, standard lag:
                -   `mask` represents `(r-1, c)`... `(r, c-1)`.
                -   Specifically, `mask` usually holds the last `n` decisions.
                -   The cell at `idx` interacts with `idx-1` (if same row) and `idx-n` (if valid row).
                -   `mask` contains values for `idx-n, ..., idx-1`.
                -   `mask % 3` is value at `idx-1` (Left). `mask / 3^(n-1)` is value at `idx-n` (Up).
                -   Wait, shift logic: Push new value to LSB, pop MSB.
                -   Then `mask` effectively acts as a queue.
                -   Correct Check:
                    -   Up neighbor state: `(mask / 3^(n-1)) % 3`.
                    -   Left neighbor state: `mask % 3`. (Assuming appropriate shift, actually `mask` usually stores `col 0` to `col n-1` of previous frontier?)
                    -   Assume `mask` stores `[cell_{i-n}, cell_{i-n+1}, ..., cell_{i-1}]`.
                    -   Then `up` is `cell_{i-n}`, i.e. MSB (in ternary).
                    -   `left` is `cell_{i-1}`, i.e. LSB.
                    -   When adding current `v`, new mask becomes `(mask % 3^(n-1)) * 3 + v`.
                    -   We add happiness for current placement + interaction adjustments.

2.  **Memoization**:
    -   `memo[25][7][7][243]`.
    -   Size: $25 \times 7 \times 7 \times 243 \approx 3 \times 10^5$.
    -   Fits in memory and time.

3.  **Cost Calculations**:
    -   Precompute interactions.
    -   Adjust both neighbors (current loses/gains + neighbor loses/gains).
    -   Only check Left neighbor if `c > 0`.
    -   Only check Up neighbor if `r > 0` (this is implicit if `mask` initialized 0 and `up` is 0 for first row). Actually `idx >= n`.

## Implementation Details
-   Recursive function `dfs(index, intro, extro, mask)`.
-   Powers of 3 precomputed.
