-- SQL Solution for P1767
WITH RECURSIVE AllSubtasks AS (
    SELECT task_id, subtasks_count, 1 AS subtask_id
    FROM Tasks
    UNION ALL
    SELECT task_id, subtasks_count, subtask_id + 1
    FROM AllSubtasks
    WHERE subtask_id < subtasks_count
)
SELECT task_id, subtask_id
FROM AllSubtasks
WHERE (task_id, subtask_id) NOT IN (SELECT task_id, subtask_id FROM Executed);
