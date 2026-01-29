# Problem Analysis: Maximum Binary String After Change

## Problem Description
You are given a binary string `binary`. You can perform two operations:
1.  `00` -> `10`
2.  `10` -> `01`
Return the max binary string (lexicographically).

## Analysis

1.  **Observations**:
    -   The operation `10 -> 01` allows moving a `0` to the right through `1`s.
    -   This means all `0`s can be shifted together.
    -   The operation `00 -> 10` allows combining two `0`s into a `1` and a `0`. Specifically, the left `0` becomes `1`.
    -   So if we have `k` zeros in a cluster, we can turn `k-1` of them into `1`s (on the left) and keep one `0` (on the right).
    -   Essentially, we can gather all `0`s in the array to the index of the **first** `0` encountered (because we can shift `0`s from right to left past `1`s using reverse of op 2? No. Op 2 is `10 -> 01` (1 moves left, 0 moves right).
    -   Wait.
        -   `10 -> 01`: `0` moves Right. `1` moves Left.
        -   This means we can move `1`s to the left and `0`s to the right? Or `0`s to right?
        -   If we want max string, we want `1`s at start.
        -   Leading `1`s stay leading `1`s.
        -   The first `0` we encounter: can we move `1`s from AFTER it to BEFORE it? `10 -> 01`. No, `1` moves left only if it is to the left of `0`. Wait.
        -   `10 -> 01`: `1` at `i`, `0` at `i+1` becomes `0` at `i`, `1` at `i+1`. `0` moved Left. `1` moved Right.
        -   WAIT, problem says `10 -> 01`. `1` at left, `0` at right. Becomes `0` at left, `1` at right.
        -   So we can move `0`s to the LEFT. And we can move `1`s to the RIGHT.
        -   This means we can bubble `0`s.
        -   Wait, we want MAX string, so we want `1`s at left.
    -   Re-read:
        -   Op 2: `10` -> `01`. `1` goes right, `0` goes left.
        -   This lets us move any `0` arbitrarily to the left past `1`s.
        -   So, effectively, all `0`s can be grouped together block.
        -   Once grouped as `00...0`, we use Op 1: `00 -> 10`.
        -   We process `00` -> `10`. The `0` shifts right.
        -   E.g. `000` -> `100` -> `110`.
        -   With `k` zeros, we can produce `k-1` ones and `1` zero.
        -   The single remaining `0` will be at the rightmost position of the `0` block.
    -   BUT, leading `1`s cannot be passed by `0`s moving left?
    -   Op 2 requires `10`. So if we have `00...`, we can use Op 1.
    -   If we have `11...`, we ignore.
    -   The first `0` we see defines the start of the modifiable region. Any `0`s after it can be moved left to join it (using `10->01` on intermediate 1s).
    -   So: Count total zeros `cnt`. Find index of first zero `first`.
    -   If `cnt <= 1`, we can't do `00->10`. Just return string?
        -   If `cnt == 0`, return `binary`.
        -   If `cnt == 1`, return `binary`? Note we can move this `0` left?
        -   Max string means `1`s at left. If `cnt == 1`, we should move the `0` as far RIGHT as possible?
        -   Wait, op `10 -> 01` moves `0` LEFT. NOT RIGHT.
        -   So `0`s tend to bubble left.
        -   We want `1`s at left.
        -   Op 1 `00 -> 10` creates `1`s.
        -   So we want to group `0`s and convert them.
        -   Actually, we want `11...11011...1`.
    -   Algorithm:
        -   Leading `1`s are untouched (let's say `L` of them).
        -   The first `0` is at index `L`.
        -   All subsequent `0`s can be moved to be adjacent to this first `0` (bubble left through `1`s).
        -   Total zeros `Z`.
        -   We form a block of `Z` zeros at index `L`.
        -   We convert `Z-1` zeros to `1`s using `00->10` repeatedly.
        -   This leaves `Z-1` ones and one `0`. The `0` ends up at index `L + (Z-1)`.
        -   The rest of the string is filled with the `1`s that were displaced or existed.
        -   Actually simply: Result is all `1`s except for a single `0` at index `L + Z - 1`.
        -   Exception: if `Z=0` or `Z=1`? If `Z=1`, we can't do `00->10`. `0` stays at `L`. Wait, can we move it right? No, `10->01` moves 0 left. We can't move 0 right.
        -   So if `Z=1`, the answer is `1...101...1` where `0` is at `L`.
        -   Actually `L + Z - 1` covers `Z=1` (index `L`).
        -   So logic holds.

2.  **Algorithm**:
    -   Find first `0`. If return -1, return `binary`.
    -   Count total zeros `zeros`.
    -   Result string has length `n`.
    -   Set all to `1`.
    -   Set char at `first + zeros - 1` to `0`.

3.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `indexOf('0')`. `chars` array.
