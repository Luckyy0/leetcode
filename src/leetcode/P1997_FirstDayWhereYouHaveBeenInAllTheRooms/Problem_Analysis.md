# Problem Analysis: First Day Where You Have Been in All the Rooms

## Problem Description
Rooms `0` to `n-1`. Start at `0` on day 0.
Visit new room `i` on day `d`.
Next day `d+1` move:
-   If `nextVisit[i]` (count) is ODD: Move to `nextRoom[i]`.
-   If `nextVisit[i]` (count) is EVEN: Move to `(i + 1) mod n`.
`nextVisit` counts how many times you have visited room `i` **including today**.
`nextRoom[i]` array given. `0 <= nextRoom[i] <= i`.
Return first day number (mod $10^9+7$) you visit room `n-1`.

## Analysis

1.  **Dynamic Programming**:
    -   We only move to `i+1` when we have visited `i` an even number of times.
    -   Generally, we arrive at `i`, visit it (becomes odd count 1), go back to `nextRoom[i]`.
    -   We traverse from `nextRoom[i]` back to `i` eventually. Visit `i` again (becomes even count 2).
    -   Then we move to `i+1`.
    -   So to cross from `i` to `i+1`, we must have:
        -   Arrived at `i`.
        -   Gone back to `nextRoom[i]`.
        -   Re-traversed everything from `nextRoom[i]` to `i`.
        -   Arrived at `i` again.
        -   Moved to `i+1`.
    -   `dp[i]` = Number of days to reach room `i` **for the first time**.
    -   `dp[0] = 0`.
    -   To calculate `dp[i+1]`:
        -   We arrive at `i` at day `dp[i]`.
        -   Count becomes odd (1st visit effectively for *this cycle*? No, cumulative).
        -   Wait, "first day...". The process is deterministic.
        -   First arrival at `i` always has count 1 (odd).
        -   So from `i`, we go to `nextRoom[i]`. This takes 1 day.
        -   Then we need to travel from `nextRoom[i]` back to `i`.
        -   The time taken to go from `u` to `u+1` is `(dp[u+1] - dp[u])`.
        -   So time from `k` to `i` is `dp[i] - dp[k]`.
        -   So we spend `dp[i] - dp[nextRoom[i]]` days generally to get back to `i`? Yes.
        -   Once we return to `i`, we have visited `i` twice (even).
        -   Then we take 1 day to go to `i+1`.
        -   Formula: `dp[i+1] = dp[i] + 1 (jump back) + (dp[i] - dp[nextRoom[i]]) (re-traverse) + 1 (move forward)`.
        -   `dp[i+1] = 2 * dp[i] - dp[nextRoom[i]] + 2`.
        -   Modulo arithmetic necessary.
    
2.  **Implementation**:
    -   Loop `i` from 0 to `n-2`.
    -   Compute `dp[i+1]`.
    -   Handle negative using `+ MOD`.

## Implementation Details
-   `long` array.
