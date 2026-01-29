# Problem Analysis: Sell Diminishing-Valued Colored Balls

## Problem Description
You have an `inventory` of different colored balls where there are `inventory[i]` balls of the `i-th` color.
The value of a ball is equal to the number of balls of that color currently in your inventory.
When you sell a ball, the number of balls of that color decreases by 1, and the value of the next ball of that color decreases by 1.
Determine the maximum total value that you can attain after selling `orders` balls. Return modulo $10^9 + 7$.

## Analysis

1.  **Greedy Strategy**:
    -   Always sell from the color buckets that have the maximum count.
    -   Imagine a histogram. We want to "shave off" the top layers.
    -   Sort `inventory` descending.
    -   We process the inventory level by level.
    -   Current highest level `currentVal = inventory[i]`. Next highest level `nextVal = inventory[i+1]` (or 0 if end).
    -   Count of colors with `currentVal` items: `width = i + 1`.
    -   Number of balls available to sell in range `(nextVal, currentVal]` across `width` columns: `total = width * (currentVal - nextVal)`.
    
2.  **Selling Logic**:
    -   If `total <= orders`:
        -   We sell ALL balls from `currentVal` down to `nextVal + 1` for all `width` colors.
        -   Sum of arithmetic progression: `Sum(k from nextVal+1 to currentVal)`.
        -   Total Value += `width * Sum`.
        -   `orders -= total`.
    -   If `total > orders`:
        -   We cannot go all the way to `nextVal`. We go down partially.
        -   `numFullRows = orders / width`.
        -   `remaining = orders % width`.
        -   Sell `numFullRows` full layers. Sum from `currentVal` down to `currentVal - numFullRows + 1`.
        -   This leaves `remaining` balls to sell at value `currentVal - numFullRows`.
        -   Value += `width * SumFullRows + remaining * (currentVal - numFullRows)`.
        -   `orders = 0`. Break.

3.  **Arithmetic Sum**:
    -   Sum from $A$ to $B$ (inclusive): $(A+B) \cdot (B-A+1) / 2$.

4.  **Complexity**:
    -   Time: $O(N \log N)$ (Sort).
    -   Space: $O(1)$ (if sorting in place) or $O(N)$.

## Implementation Details
-   `long` for calculations.
-   Modulo arithmetic at each addition.
-   Handle `inventory` length carefully (append 0 conceptually).
