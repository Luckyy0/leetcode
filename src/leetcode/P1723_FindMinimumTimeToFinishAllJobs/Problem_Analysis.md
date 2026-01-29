# Problem Analysis: Find Minimum Time to Finish All Jobs

## Problem Description
`jobs`, `k` workers. Assign jobs to minimize max working time of any worker.

## Analysis

1.  **Binary Search + Backtracking**:
    -   Binary Search on Answer `limit`.
    -   `check(limit)`: Can we distribute jobs such that no worker exceeds `limit`?
    -   `check` uses backtracking.
    -   Sort `jobs` descending for better pruning.
    
2.  **Backtracking Optimization**:
    -   `backtrack(jobIdx, workloads, k, limit)`.
    -   Try assigning `jobs[jobIdx]` to each worker `i`.
    -   If `workloads[i] + job <= limit`, recurse.
    -   Pruning:
        -   If `workloads[i] == 0`, and we assign and fail, DON'T try assigning to other empty workers (symmetry). Break loop.
        -   If `backtrack` returns true, return true instantly.
    
3.  **Complexity**:
    -   $N \le 12$. Small enough.

## Implementation Details
-   Binary search range `[max(jobs), sum(jobs)]`.
