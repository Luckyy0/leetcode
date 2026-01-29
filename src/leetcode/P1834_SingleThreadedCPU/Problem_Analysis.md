# Problem Analysis: Single-Threaded CPU

## Problem Description
Tasks `[enqueueTime, processingTime]`.
CPU processes 1 task at a time.
Non-preemptive.
If CPU idle, pick task with minimum processing time from available.
If tie, smallest index.
Return order.

## Analysis

1.  **Simulation with Two Queues**:
    -   Sort tasks by Enqueue Time. (Keep original index).
    -   Global `time`.
    -   `taskIndex` pointer in sorted tasks.
    -   `PriorityQueue` for available tasks (ProcessingTime, Index).
    -   Loop until all tasks processed.
    -   If PQ empty and `time < tasks[taskIndex].enqueue`, jump `time` to next enqueue.
    -   Add all tasks with `enqueue <= time` to PQ.
    -   Poll PQ, process (time += procTime), add index to result.

2.  **Complexity**:
    -   Sorting: $N \log N$.
    -   PQ ops: $N \log N$.

## Implementation Details
-   Task class or array. {enq, proc, index}.
