# Problem Analysis: Faulty Sensor

## Problem Description
Two integer arrays `sensor1`, `sensor2` of size `n`.
One sensor works perfectly covering all data points.
The other dropped ONE value and the rest shifted left, with the last value being arbitrary (but usually irrelevant for validation, wait, problem says "random" or "arbitrary"?).
Usually last value is not part of the shifted sequence.
Return `1` if sensor 1 is faulty, `2` if sensor 2 is faulty, or `-1` if ambiguous.
Ambiguous means it could be either (e.g., they are identical, or the dropped value doesn't distinguish).

## Analysis

1.  **Comparison**:
    -   Iterate `i` from 0. Find first index where `sensor1[i] != sensor2[i]`.
    -   If loop finishes without mismatch, return -1 (Ambigious/Values same).
    -   If mismatch at `i`:
        -   Check possibility 1: Sensor 1 is faulty (dropped `sensor1[i]`, or rather dropped something before?). No, "dropped a value".
        -   If Sensor 1 is faulty, then `sensor1` is the one with missing val. So `sensor1` content starting `i` effectively matches `sensor2` starting `i+1`.
        -   Check if `sensor1[i...n-2] == sensor2[i+1...n-1]`.
        -   Check possibility 2: Sensor 2 is faulty. `sensor2` content starting `i` matches `sensor1` starting `i+1`.
        -   Check if `sensor2[i...n-2] == sensor1[i+1...n-1]`.
    -   Comparison range: from mismatch `i` up to `n-2` (length constraint).
    -   Note: The last element of the faulty sensor is 'garbage/random' so we don't check it?
    -   Wait, "dropped one value". The array size is same. So one value is missing, and one new value appeared at end?
    -   Yes, typically last value is irrelevant.
    -   So compare shifted subarrays of length `n - 1 - i`? No, compare until `n-2`.
    -   Logic:
        -   `is1Faulty`: `sensor1[k] == sensor2[k+1]` for all `k` from `i` to `n-2`.
        -   `is2Faulty`: `sensor2[k] == sensor1[k+1]` for all `k` from `i` to `n-2`.
        -   If `is1Faulty` and `!is2Faulty` -> 1.
        -   If `!is1Faulty` and `is2Faulty` -> 2.
        -   If both -> -1.
        -   If neither -> Impossible logic based on problem constraints (one IS faulty), but could return -1.

2.  **Implementation**:
    -   Loop to find `i`.
    -   Helper to verify shift.

## Implementation Details
-   Loop `i`.
