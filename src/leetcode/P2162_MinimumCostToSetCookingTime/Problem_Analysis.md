# Problem Analysis: Minimum Cost to Set Cooking Time

## Problem Description
Format time `targetSeconds` as `mm:ss`.
Enter on microwave.
Num pad movements cost `moveCost`.
Push cost `pushCost`.
Start at `startAt`.
Rules:
-   `mm:ss` represents `mm * 60 + ss`.
-   `mm` up to 99, `ss` up to 99.
-   Example: target 600s. Can be `10:00` or `09:60`?
    -   Microwaves usually accept `9:60` (equals 10 min).
    -   Valid `mm`, `ss` in `[0, 99]`.
-   Minimize cost of typing sequence. "Trailing zeros" logic: just type digits. e.g. "900" is 9 minutes. But format is 4 digits max.
-   Sequence: non-zero prefix. Leading zeros skipped? No, user types digits.
-   BUT we only type meaningful digits. E.g. `00:30` -> type `3`, `0`.
-   Or `10:00` -> type `1`, `0`, `0`, `0`.

## Analysis

1.  **Exhaustive Search (Few candidates)**:
    -   `target` seconds.
    -   Represent as `(m, s)` such that `m*60 + s == target` and `0 <= m, s <= 99`.
    -   Possibilities for `m`: `target / 60`.
    -   Also `m-1` if `s` can be `target % 60 + 60` (<= 99).
    -   So at most 2 valid representations.
    -   For each valid representation (e.g. `1 0 0 0` or `0 9 6 0`):
        -   Convert to string.
        -   Format: Remove leading zeros? Actually microwave logic is just digits.
        -   Interpret as string logic: `m` is 2 digits, `s` is 2 digits. Concat.
        -   If string is "1000", cost = simple.
        -   If string is "0960", remove leading zero -> "960".
        -   Cost calculation:
            -   Initial pos `curr = startAt`.
            -   For each char `c`:
                -   If `c != curr`: cost += move.
                -   cost += push.
                -   `curr = c`.
    -   Compare costs.

## Implementation Details
-   Candidate 1: `m = target / 60`, `s = target % 60`.
-   Candidate 2: `m = target / 60 - 1`, `s = target % 60 + 60`.
-   Check validity (`0 <= m, s <= 99`).
-   Format string: `String.format("%02d%02d", m, s)`. Strip leading zeros. (Wait. `00:05` -> `5`. `00:00` -> invalid usually but target > 0? No, target >= 1).
-   Loop calculate cost.
