# Problem Analysis: Game of Nim

## Problem Description
Standard Nim Game.
Input: array `piles`.
Two players take turns removing stones from piles. Last one to remove stones wins.
Return `true` if starting player wins, `false` otherwise.

## Analysis

1.  **Nim Sum**:
    -   The game is impartial. Use Sprague-Grundy theorem.
    -   This is simply XOR sum of all pile sizes.
    -   If XOR sum != 0, first player (Alice) has a winning strategy.
    -   If XOR sum == 0, second player (Bob) wins.

## Implementation Details
-   Loop XOR.
