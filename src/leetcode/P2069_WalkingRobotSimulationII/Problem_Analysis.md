# Problem Analysis: Walking Robot Simulation II

## Problem Description
Robot in grid `width x height`.
Start (0, 0), facing East.
`step(num)`: Move num steps. If hit wall, turn left and continue.
`getPos()`: `[x, y]`.
`getDir()`: String.
Note: Robot moves around the perimeter.

## Analysis

1.  **Perimeter Optimization**:
    -   Total perimeter `P = 2 * (width + height) - 4` (corner shared adjustment? No, 2W + 2H - 4).
    -   Positions are 0 to `P-1` in counter-clockwise (or whatever direction) loop.
    -   Wait. Start (0,0) East -> (w-1, 0) -> North -> (w-1, h-1) -> West -> (0, h-1) -> South -> (0, 0).
    -   This is counter-clockwise. Directions: East, North, West, South.
    -   The path is simply modulo `P`.
    -   Maintain current distance `dist` from start (0 to P-1).
    -   `step(num)`: `dist = (dist + num) % P`.
    -   Special Case: `(0, 0)`.
        -   Initially facing East.
        -   If we complete a loop and return to (0, 0), we face SOUTH (coming from North, hit wall/end -> turn?).
        -   Wait. Robot "stays in boundary".
        -   If moves exactly `P`, returns to (0,0). Direction?
        -   If num > 0: Resulting direction depends on position EXCEPT (0,0).
        -   For (0,0): if moved, direction is South (end of cycle). If initial, East.
        -   So need boolean `moved`.
    -   Map `dist` to `(x, y)` and direction.
    -   Ranges:
        -   Bottom (East): `0` to `w-1`. `x = dist`, `y = 0`. Dir East.
        -   Right (North): `w-1` to `w-1+h-1`. `x = w-1`, `y = dist - (w-1)`. Dir North.
        -   Top (West): `w+h-2` to `w+h-2+w-1`. `x = w-1 - (dist - (w+h-2))`, `y = h-1`. Dir West.
        -   Left (South): `2w+h-3` to `P-1`. Dist ... `y = h-1 - ...`. Dir South.
    -   Corner handling:
        -   At `w-1` (Bottom Right). If stopping there, direction is East.
        -   Basically direction is based on the *segment* the point lands on.
        -   Except corners?
        -   Usually direction is preserved "unless collision causes turn".
        -   Rule: "It moves ... if out of bounds ... rotates 90 degrees CCW ... continues".
        -   When stopping exactly at corner, it faces the direction it ARRIVED from.
        -   It only turns if it TRIES to move but can't.
        -   Wait. "If it tries to move forward and is out of bound... it turns...".
        -   If it steps exactly onto corner and STOPS. It did NOT try to move further out of bounds. So it keeps current dir.
        -   Example: `(0,0)` to `(w-1, 0)`. Faces East.
        -   But wait. If moves `P`, returns to `(0,0)`.
        -   Last move was `(0, 1) -> (0, 0)` Southward.
        -   Arrived facing South. Stops.
        -   So (0,0) after move is South. Initial is East.
        -   What about non-corners?
        -   Segments logic works.
        -   Corners: `w-1` (East), `w+h-2` (North), ...

## Implementation Details
-   Perimeter `P`.
-   `pos` int.
-   `moved` boolean.
