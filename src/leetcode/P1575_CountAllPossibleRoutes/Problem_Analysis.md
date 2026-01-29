# Problem Analysis: Count All Possible Routes

## Problem Description
You are given an array of distinct positive integers `locations` where `locations[i]` represents the position of city `i`. You are also given integers `start`, `finish` and `fuel`.
At each step, if you are at city `i`, you can pick any city `j` such that `j != i` and `0 <= j < locations.length` and move to city `j`. Moving takes `|locations[i] - locations[j]|` fuel.
Return the count of all possible routes from `start` to `finish`. Since the answer may be too large, return it modulo $10^9 + 7$.

## Analysis

1.  **State**:
    -   `dp[city][remaining_fuel]`: Number of ways to reach `finish` from `city` with `remaining_fuel`.

2.  **Transitions**:
    -   If `city == finish`, we count 1 way (stopping here). But we can also continue to other cities and come back. So we initialize `res = (city == finish ? 1 : 0)`.
    -   For every `nextCity != city`:
        -   `cost = |locations[city] - locations[nextCity]|`.
        -   If `fuel >= cost`:
            -   `res += dp(nextCity, fuel - cost)`.

3.  **Memoization**:
    -   Use a 2D array `memo[n][fuel + 1]`. `n` up to 100, `fuel` up to 200.
    -   Initialize with -1.

4.  **Complexity**:
    -   States: $N \times Fuel$.
    -   Transitions per state: $N$.
    -   Total Time: $O(N^2 \cdot Fuel)$.
    -   $100^2 \cdot 200 = 2 \times 10^6$. Well within limits.

## Implementation Details
-   Recursive function with memoization.
-   Modulo arithmetic at each addition.
