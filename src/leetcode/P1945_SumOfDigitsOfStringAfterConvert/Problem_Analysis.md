# Problem Analysis: Sum of Digits of String After Convert

## Problem Description
String `s`, int `k`.
Convert `s` to number string: 'a'->1, 'b'->2 ... 'z'->26. Concat them.
Then transform `k` times.
Transform: Sum of digits.

## Analysis

1.  **Simulation**:
    -   Phase 1: Build string. `StringBuilder`.
    -   Phase 2: Loop `k` times.
    -   Convert string/number to sum of digits.
    -   Store as number (int logic usually suffices after one iteration, as sum of digits reduces rapidly. even max string length 100 -> ~200 digits -> sum ~1800 -> fits in int).

## Implementation Details
-   `StringBuilder`.
-   Loop.
