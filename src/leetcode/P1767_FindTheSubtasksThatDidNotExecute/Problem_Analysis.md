# Problem Analysis: Find the Subtasks That Did Not Execute

## Problem Description
Table `Tasks` (task_id, subtasks_count).
Table `Executed` (task_id, subtask_id).
Find pairs `(task_id, subtask_id)` that exist (1 <= subtask_id <= subtasks_count) but NOT in Exectued.

## Analysis

1.  **Recursive CTE**:
    -   Generate all subtasks `1..subtasks_count` for each task.
    -   `EXCEPT` Executed.
    -   Recursive CTE to generate numbers.

## Implementation Details
-   SQL.
