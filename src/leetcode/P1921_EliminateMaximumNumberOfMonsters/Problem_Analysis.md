# Problem Analysis: Eliminate Maximum Number of Monsters

## Problem Description
`dist` array, `speed` array.
Weapon charges in 1 minute.
Shoot one monster per minute.
Game over if monster reaches city (dist <= 0). (Start at min 0).
Note: You shoot at time 0, monster moves. Shoot at time 1, monster moves.
Wait, you shoot at start of minute.
Monster reaches city if it arrives <= time_of_shoot?
Actually, monsters arrive at times $t_i = dist[i] / speed[i]$.
You shoot at time $0, 1, 2, \dots$.
You can eliminate monster $i$ if $t_i > k$ (shoot time).
Sort arrival times.
If $k$-th monster (in sorted order) arrives at time $t \le k$, you lose.
(Strictly greater required? "If monster reaches...").
If time to reach is exactly $k$, it means at minute $k$ it is AT city.
You shoot at minute $k$.
If it moves BEFORE you shoot: game over.
Usually turn order: shoot, move.
If you shoot at 0, monster at dist D. It moves D-S.
If arrival time is 1.0 (reaches at min 1). You shoot at 0. Ok.
If arrival time is 0.5 (reaches at 0.5). You shoot at 0. Ok.
Problem says: "The weapon is fully charged at the start of the game."
You fire at $t=0$, then reload (1 min). Fire at $t=1$.
Monster reaches if dist <= 0.
So if dist > 0 at time $k$, you can shoot.
Let $arrival[i] = dist[i] / speed[i]$.
If $arrival[i] <= k$, you can't shoot it at time $k$?
Example: dist=1, speed=1. arr=1.
t=0: shoot it. Ok.
Example: dist=0, speed=1. arr=0.
t=0: already there? "Monsters start at distances ... > 0".
If arr <= k, you lose.
Check boundary:
arr[i] > k (strictly).
So sort `times`. Iterate `i` from 0.
If `times[i] <= i`: game over. return `i`.
Else continue.

## Analysis

1.  **Sort Arrival Times**:
    -   Double `time = (double) dist[i] / speed[i]`.
    -   Sort.
    -   Check condition.

2.  **Implementation**:
    -   Double array.
    -   Loop.

## Implementation Details
-   `Arrays.sort`.
