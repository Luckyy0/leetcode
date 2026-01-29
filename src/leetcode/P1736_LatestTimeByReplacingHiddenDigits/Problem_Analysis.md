# Problem Analysis: Latest Time by Replacing Hidden Digits

## Problem Description
String `time` in format "HH:MM". Some digits are '?'.
Replace '?' to get latest valid time (max valid HH:MM).
Valid times: 00:00 to 23:59.

## Analysis

1.  **Greedy Replacement**:
    -   We want to maximize each digit from left to right, subject to validity constraints.
    -   `time[0]`:
        -   If `?`:
            -   If `time[1]` is `?` or `time[1] <= '3'`, max is '2'.
            -   Else (if `time[1] >= '4'`), max must be '1' (since '2' would allow at most '23', but '24' is invalid).
    -   `time[1]`:
        -   If `?`:
            -   If `time[0]` is '2', max is '3'.
            -   Else (`time[0]` is '0' or '1'), max is '9'.
    -   `time[3]` (tens of minutes):
        -   If `?`: max is '5'.
    -   `time[4]` (units of minutes):
        -   If `?`: max is '9'.

2.  **Complexity**:
    -   Time: $O(1)$.
    -   Space: $O(1)$.

## Implementation Details
-   Convert to char array.
-   Check conditions carefully. Note dependencies (index 0 depends on index 1).
