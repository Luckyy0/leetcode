# Problem Analysis: Minimum Speed to Arrive on Time

## Problem Description
Trains `dist`. `hour` (double).
Travel `i`-th train covering `dist[i]`.
Must wait for next integer hour to depart for next train (except last one).
Return min integer speed `s` to finish within `hour`. -1 if impossible.
Impossible if `n-1 > hour`? Yes, since each train (except last) takes at least 1 hour.

## Analysis

1.  **Binary Search on Answer**:
    -   Speed range `[1, 10^7]`. Maybe $10^9$ if `dist` large? `dist[i] <= 10^5`.
    -   Wait, if `hour` is `2.01` and `dist` `[1, 1, 100]`.
    -   First takes 1 hr (at any speed >= 1). Second takes 1 hr. Total 2.
    -   Last takes `100/s` hours. Needs `100/s <= 0.01` => `s >= 10000`.
    -   Limit `10^7` given in problem? Constraint `dist[i] <= 10^5`. `n <= 10^5`.
    -   Speed can be high. Up to $10^7$ or maybe $10^9$.
    -   Check function:
        -   Time = 0.
        -   For `i` from 0 to `n-2`: Time += `ceil(dist[i] / s)`.
        -   For `last`: Time += `dist[n-1] / s`.
        -   Return `Time <= hour`.

2.  **Edge Cases**:
    -   Max speed usually `10^7` is enough?
    -   If `dist=10^5` and time allowed `0.01` (e.g. `n-1` integer hours used up). `10^5 / s <= 0.01` -> `s >= 10^7`.
    -   Max dist is $10^5$. Max possible speed needed is when remaining time is tiny. `k` digits after decimal. `hour` has 2 decimal places. Min delta `0.01`.
    -   So max speed $\approx 10^7$.
    -   Use `10^7` as upper bound. Safe to use `2 * 10^7` or `10^9` if performance ok.
    -   Helper: `ceil(a/b) = (a + b - 1) / b` for integers.

## Implementation Details
-   Binary search loop.
-   `calculateTime(speed)`.
