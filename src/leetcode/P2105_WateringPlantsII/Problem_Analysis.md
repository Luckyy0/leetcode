# Problem Analysis: Watering Plants II

## Problem Description
Plants array. Alice (start 0) and Bob (start n-1).
Capacities `cA`, `cB`.
Process simultaneously.
If not enough water, refill (count 1).
If meet at middle: One with *more* water processes it. If equal, Alice. Need refill if not enough.

## Analysis

1.  **Two Pointers**:
    -   `l = 0`, `r = n-1`.
    -   `curA`, `curB`.
    -   While `l < r`:
        -   Alice: check `curA >= plants[l]`. If no, refill `curA=cA`, ans++. `curA -= plants[l]`.
        -   Bob: check `curB >= plants[r]`. If no, refill `curB=cB`, ans++. `curB -= plants[r]`.
        -   `l++`, `r--`.
    -   If `l == r`:
        -   Check logic `curA >= curB ? Alice : Bob`.
        -   Actually "Alice waters if curA >= curB".
        -   If chosen one needs refill, ans++.

## Implementation Details
-   Loop.
