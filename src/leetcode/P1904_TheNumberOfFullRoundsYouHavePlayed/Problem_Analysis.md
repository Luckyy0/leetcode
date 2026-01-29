# Problem Analysis: The Number of Full Rounds You Have Played

## Problem Description
`loginTime`, `logoutTime` ("HH:MM").
Game rounds 15 mins. (00:00-00:15, 00:15-00:30 ...).
Played ONLY full rounds.
If `logout < login`, it means next day.

## Analysis

1.  **Minute Conversion**:
    -   Convert times to total minutes from start of day.
    -   `start = H*60 + M`.
    -   `finish = H*60 + M`.
    -   If `finish < start`, `finish += 24*60`.
    -   Rounds start at multiples of 15.
    -   First full round starts at `ceil(start / 15) * 15`.
    -   Last full round ends at `floor(finish / 15) * 15`.
    -   Let `s` be adjusted start (rounded up to nearest 15).
    -   Let `f` be adjusted finish (rounded down to nearest 15).
    -   Duration `diff = f - s`.
    -   `rounds = diff / 15`.
    -   If `rounds < 0`, return 0. (Can happen if start > finish effectively in small interval).

## Implementation Details
-   `toMinutes` helper.
