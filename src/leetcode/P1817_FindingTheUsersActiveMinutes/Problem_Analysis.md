# Problem Analysis: Finding the Users Active Minutes

## Problem Description
`logs`: `[ID, time]`.
UAM: number of unique minutes user performed actions.
`k`: size of result.
Result `answer` (1-indexed meaning answer[j] is count of users with UAM j+1).

## Analysis

1.  **HashSet + Map**:
    -   Map `ID -> Set<Integer> (times)`.
    -   Iterate logs, populate sets.
    -   Iterate map, get size of each set (UAM).
    -   Increment corresponding index in `answer`.

## Implementation Details
-   `HashMap<Integer, Set<Integer>>`.
-   `usersUAM`.
