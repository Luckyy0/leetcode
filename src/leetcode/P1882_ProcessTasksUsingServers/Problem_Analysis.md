# Problem Analysis: Process Tasks Using Servers

## Problem Description
Servers (weight, index). Tasks (time).
Task `j` available at `j`.
Assign to smallest weight (then index).
Server busy for `task[j]` seconds.

## Analysis

1.  **Priority Queues**:
    -   `available`: Min-heap order by `{weight, index}`. Initially all servers.
    -   `busy`: Min-heap order by `{freeTime, weight, index}`.
    -   `time` variable.

2.  **Simulation**:
    -   Iterate tasks `j` from 0 to `m-1`.
    -   Update `time = max(time, j)`.
    -   Move servers from `busy` to `available` if `freeTime <= time`.
    -   If `available` is empty:
        -   Fast-forward `time` to `busy.peek().freeTime`.
        -   Process free servers again.
    -   Poll from `available` (best server).
    -   `result[j] = server.index`.
    -   Push to `busy` with `freeTime = time + tasks[j]`.

## Implementation Details
-   `PriorityQueue`. Classes or int arrays.
