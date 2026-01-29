# Problem Analysis: Count Unhappy Friends

## Problem Description
You are given a list of `preferences` for `n` friends, where `n` is always even.
`preferences[i]` contains a list of friends sorted in the order of preference.
You are also given a list of `pairs`, where `pairs[j] = [xi, yi]` denotes that friend `xi` is paired with friend `yi`.
A friend `x` is unhappy if `x` is paired with `y` and there exists a friend `u` who is paired with `v` but:
-   `x` prefers `u` over `y`, and
-   `u` prefers `x` over `v`.

Return the number of unhappy friends.

## Analysis

1.  **Preprocessing**:
    -   Preferences are given as lists. Looking up preference rank takes $O(N)$ linearly.
    -   Optimize: Convert `preferences` to a rank matrix `rank[n][n]`. `rank[i][j]` = index of `j` in `i`'s preference list.
    -   Also store partners in an array `partner[n]`.

2.  **Algorithm**:
    -   Iterate through each person `x` from 0 to `n-1`.
    -   Let `y = partner[x]`.
    -   Iterate through `preferences[x]`. Let the current candidate be `u`.
    -   Stop iterating if `u == y` (since `u` after `y` are less preferred).
    -   For each `u` (partnered with `v`):
        -   Check if `u` prefers `x` over `v`.
        -   `if (rank[u][x] < rank[u][v])`:
            -   `x` is unhappy. Count++ and break (don't recount `x`).

3.  **Complexity**:
    -   Preprocessing: $O(N^2)$.
    -   Checking: $O(N^2)$ (Outer loop N, inner loop up to N).
    -   Given N <= 500, $250,000$ operations is trivial.

## Implementation Details
-   `rank` matrix is essential for O(1) checks.
