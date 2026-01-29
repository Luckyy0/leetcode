# Problem Analysis: Watering Plants

## Problem Description
Array `plants`. `capacity`.
River at -1. Plants at 0, 1, 2...
Steps:
-   Start at -1.
-   Go to i (steps += i - currPosition).
-   If enough water, water plant (capacity -= needed).
-   If not enough, go back to river (curr -> -1), refill (capacity = max), go to i (-1 -> i). Steps += (curr - (-1)) + (i - (-1)).
-   Water.

## Analysis

1.  **Simulation**:
    -   Track current capacity `currCap`.
    -   Steps.
    -   Iterate `i` from 0 to n-1.
    -   Move from `i-1` to `i` (1 step).
    -   If `currCap < plants[i]`:
        -   Go back to river: `i` steps.
        -   Refill.
        -   Come back: `i` steps. (Total + 2*i + 1? No).
        -   Wait logic cleanly:
            -   Initially at -1.
            -   Process plant 0.
            -   Cost `1` step to reach 0.
            -   If can water: water.
            -   If cannot: go back (`1`), come back (`1`). Total `+2`. Then water.
            -   Move to next.
    -   Actually:
        -   Steps = 0.
        -   For `i` 0 to n-1:
            -   If `currCap >= plants[i]`:
                -   Steps += 1 (move from i-1 to i).
                -   currCap -= plants[i].
            -   Else:
                -   Steps += i (move from i-1 to -1) + (i + 1) (move from -1 to i).
                -   Wait. Distance from `i-1` to `-1` is `i`.
                -   Distance from `-1` to `i` is `i+1`.
                -   So add `2*i + 1`.
                -   currCap = capacity - plants[i].
     
## Implementation Details
-   Loop.
