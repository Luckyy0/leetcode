# Problem Analysis: Cat and Mouse II

## Problem Description
Grid 8x8. Checks win conditions. Max 1000 turns.
Moves limit `catJump`, `mouseJump`.
Walls.
Returns true if M wins.

## Analysis

1.  **Minimax with Memoization**:
    -   State `(mx, my, cx, cy, turn)`.
    -   `turn` goes 0..limit.
    -   Memo results: `Boolean[][][][][]`.
    -   Base cases:
        -   `turn >= MAX`: Mouse loses (Cat wins).
        -   `M == F`: Mouse wins.
        -   `C == F`: Cat wins.
        -   `M == C`: Cat wins.
    -   Recursion:
        -   If Turn % 2 == 0 (Mouse):
            -   Try all valid moves (distances 0 to `mouseJump` in 4 dirs).
            -   If path blocked by wall, stop direction.
            -   If any move leads to `canWin` (returns True for Mouse), then return True.
            -   Else False.
        -   If Turn % 2 == 1 (Cat):
            -   Try all valid moves.
            -   If all moves lead to `canWin` (True for Mouse), then Mouse wins (Cat loses).
            -   If Cat can find a move that leads to False (Mouse loses), Cat wins (return False).
    
2.  **Complexity**:
    -   State space: $8^4 \times 100 \approx 409,600$. (Relax turn limit to ~100 since grid is small).
    -   Max turns 1000 is generous. 70 turns usually enough to cover 64 cells.

## Implementation Details
-   `MAX_TURNS` constant.
-   Grid string array.
