# Problem Analysis: Closest Dessert Cost

## Problem Description
`baseCosts`, `toppingCosts`. Pick one base. Pick any set of toppings (each topping at most 2 times).
Target `target`. Cost closest to `target`.
Tie breaker: smaller cost.

## Analysis

1.  **Backtracking / DFS**:
    -   For each base `b`, start DFS with `currentCost = b`.
    -   DFS(index, currentCost):
        -   If `index == toppingCosts.length`, compare with best.
        -   Options at `index`:
            -   Take 0: `DFS(index + 1, cost)`
            -   Take 1: `DFS(index + 1, cost + topping[index])`
            -   Take 2: `DFS(index + 1, cost + 2 * topping[index])`
    -   Pruning: if `cost` already exceeding target significantly?
        -   Yes, if `cost - target > abs(best - target)`, further additions only make it worse. (All costs positive).

2.  **Complexity**:
    -   $M$ toppings $\le 10$. $3^{10} \approx 59000$. Small.
    -   Bases $\le 10$. Total states approx $10 \times 3^{10}$. Feasible.

## Implementation Details
-   `closest` variable. Update logic.
