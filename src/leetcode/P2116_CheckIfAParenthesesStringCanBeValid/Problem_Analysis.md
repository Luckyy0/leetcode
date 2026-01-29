# Problem Analysis: Check if a Parentheses String Can Be Valid

## Problem Description
String `s`, locked status `locked`.
If `locked[i] == '0'`, `s[i]` can be '(' or ')'.
If `locked[i] == '1'`, `s[i]` fixed.
Check if valid.

## Analysis

1.  **Greedy Range Check / Left-Right Scan**:
    -   To be valid:
        1.  Total length even.
        2.  Scan Left to Right: Ensure we don't have too many `)`.
            -   Count `balance` treating potentially open as `(`.
            -   Or track `minOpen` and `maxOpen`.
            -   `locked '1'`:
                -   `(`: `min++, max++`.
                -   `)`: `min--, max--`.
            -   `locked '0'`:
                -   `min--` (treat as `)`).
                -   `max++` (treat as `(`).
            -   `min = max(min, 0)`.
            -   If `max < 0`, impossible (too many closed).
    -   After loop, check `min == 0`.
    -   Wait. Standard check for "Can be valid" usually involves ensuring `max >= 0` always and finally `min == 0`.
    -   Actually, simpler approach:
        -   Left to Right: Check if we can cover all `)` with available `(`.
            -   Track `open` count + `unlocked` count.
            -   If `closed` > `open + unlocked`, fail.
            -   (This ensures no prefix has too many closed).
        -   Right to Left: Check if we can cover all `(` with available `)`.
            -   Track `closed` count + `unlocked` count.
            -   If `open` > `closed + unlocked`, fail.
            -   (This ensures no suffix has too many open).
    -   Why two passes?
        -   `unlocked` can be anything.
        -   Left-Right ensures `)` doesn't exceed potential `(`.
        -   Right-Left ensures `(` doesn't exceed potential `)`.
        -   Length parity check handles global count.

## Implementation Details
-   Length check.
-   Loop 1 (L->R). `bal`. If `locked '1'` and `)` -> `bal--`. Else `bal++`. If `bal < 0` return false.
-   Loop 2 (R->L). `bal`. If `locked '1'` and `(` -> `bal--`. Else `bal++`. If `bal < 0` return false.
