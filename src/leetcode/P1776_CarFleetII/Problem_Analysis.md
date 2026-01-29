# Problem Analysis: Car Fleet II

## Problem Description
Cars moving right. `cars[i] = [position, speed]`.
If car A catches car B, A joins B's fleet and moves at B's speed.
(Collision time is when A hits B. Velocity becomes min(vA, vB)).
Return array `answer` where `answer[i]` is time when car `i` collides with next car. -1 if never.
Cars sorted by position.

## Analysis

1.  **Stack**:
    -   Process cars from right to left (n-1 to 0).
    -   Maintain a stack of "potential next fleet leaders" (indices).
    -   For car `i`:
        -   We want to find the *first* car `j` to the right (in stack) that `i` collides with.
        -   Conditions for `i` colliding with `j`: `speed[i] > speed[j]`.
        -   Also, if `j` collides with someone else (`k`) *before* `i` catches `j`, then `j` will slow down to `k`'s speed. Or rather, `j` "vanishes" into `k` fleet. We should check if `i` catches `j` *after* `j` catches `k`. If so, we should compare `i` with `k` instead. Or rather, `j` is not the immediate target for the collision duration.
        -   Stack property: Candidate cars `j` are such that their collision times (future) are increasing?
    -   Logic:
        -   Pop from stack if `speed[i] <= speed[stack.peek()]` (Cannot catch a faster/equal car ahead).
        -   Why pop? Because if `i` cannot catch `j`, then any car to left of `i` that might catch `j` would have to go through `i` first? Wait.
        -   Actually, if `speed[i] <= speed[j]`, `i` never catches `j`. And since `i` is to the left of `j`, any car `p` to the left of `i` would hit `i` effectively before `j` (or `i` blocks `p`). Wait, `p` can pass `i`? No, single lane.
        -   So if `i` can't catch `j`, `j` is useless for `i`. Pop `j`.
        -   Also pop `j` if `i` catches `j` AFTER `j` catches its own target `k`. I.e. `collisionTime(i, j) > collisionTime(j, k)`. Because `j` would merge into `k` before `i` hits `j`. Then recursively check `i` vs `k`.
    -   Stack stores indices `j` such that `j` is a valid collision candidate.
    -   Calculate `time = (pos[j] - pos[i]) / (speed[i] - speed[j])`.

2.  **Complexity**:
    -   Time: $O(N)$. Each element pushed/popped once.
    -   Space: $O(N)$.

## Implementation Details
-   Double array for answers.
-   Stack Integer.
