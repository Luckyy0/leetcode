# Problem Analysis: Parallel Courses III

## Problem Description
`n` courses. `relations` (prereq). `time` for each course.
DAG.
Find min time to complete all.

## Analysis

1.  **Longest Path in DAG**:
    -   Completion time of `u` = `time[u] + max(completion time of prerequisites)`.
    -   This is essentially finding the longest path weighted by node times.
    -   Topological Sort (Kahn's) or DFS with Memoization.
2.  **Kahn's Algorithm**:
    -   `dist[u]` = max time to finish `u`.
    -   Initialize `dist[u] = time[u]` for sources.
    -   Process queue. For edge `u -> v`: `dist[v] = max(dist[v], dist[u] + time[v])`.
    -   Return `max(dist)`.

## Implementation Details
-   `inDegree`.
-   `Queue`.
