# Problem Analysis: Number of Valid Move Combinations On Chessboard

## Problem Description
Chess pieces `pieces` (rook, queen, bishop) at `positions`.
Determine number of valid "move combinations".
Rules:
-   Each piece chooses a direction (or stays).
-   Each piece chooses a number of steps >= 1 (or 0 if staying).
-   All pieces move **simultaneously** from $t=1$ to $t=steps$.
-   Collision occurs if:
    -   Two pieces occupy same cell at same time `t`.
    -   Wait. Problem says "move until they stop".
    -   "At each second, every piece that has not stopped moves one step."
    -   Condition: Two pieces occupy same cell at same time. (Includes stopping time? Yes).
    -   This effectively means paths must not collide in time-space.
    -   If one stops at $(r, c)$ at time $T$, it stays there for all $t > T$. No other piece can be at $(r, c)$ at any time $t \ge T$. (Unless it's the same piece).
    -   Basically paths shouldn't cross or end at same square if timing aligns.
    -   Actually "No two pieces occupy the same cell at the same time."
    -   This includes when one piece is stopped and extends indefinitely.

## Analysis

1.  **Simulation / Backtracking**:
    -   Number of pieces `n` small (prob 1-4?). Max 4. Board 8x8.
    -   For each piece, generate all possible "Moves" (Direction + Distance).
    -   Since each piece moves independently in terms of *generating* moves, but jointly for *validity*.
    -   Backtracking:
        -   Start with Piece 0. Pick a valid move (Dir, Steps).
        -   Go to Piece 1. Pick a valid move. Check collision with Piece 0.
        -   ...
        -   If all pieces picked validly, count++.
    -   Collision Check:
        -   Given Move A and Move B.
        -   Simulate second by second.
        -   Pos A(t), Pos B(t).
        -   If A(t) == B(t), invalid.
        -   Note: Pos(t) stops updating after steps reached.
    -   Directions:
        -   Rook: 4 dirs.
        -   Bishop: 4 dirs (diag).
        -   Queen: 8 dirs.
        -   "Stay" is a special move (0 steps, any dir is same).
    -   Possible moves per piece:
        -   Dir: up to 8. Steps: 1 to 7. ~56 moves + Stay.
        -   For 4 pieces: $57^4 \approx 10^7$. Feasible?
        -   A bit high. But board limits valid steps.
        -   Average moves much lower.
    -   Implementation:
        -   List all valid (dx, dy, steps) for each piece.
        -   DFS combination.

## Implementation Details
-   `directions`.
-   `checkCollision`.
-   DFS.
