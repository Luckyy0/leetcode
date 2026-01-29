# Problem Analysis: The Change in Global Rankings

## Problem Description
`TeamPoints` (team_id, name, points). `PointsChange` (team_id, points_change).
Update points. Calculate rank change.
Rank rules: Points DESC, Name ASC.
Return `team_id, name, rank_diff` (old - new ? or signed change).
Usually positive if rank improved (index decreases). Wait. "Rank Diff" ?
Usually LeetCode specifies. "Rank Diff = old_rank - new_rank".
(If old was 10, new is 5. Diff = 5).

## Analysis

1.  **CTE**:
    -   `OldRanks`: Rank over original points.
    -   `NewPoints`: `points + change`.
    -   `NewRanks`: Rank over new points.
    -   Join and subtract.

## Implementation Details
-   `RANK()` or `ROW_NUMBER()`.
-   Left Join `PointsChange` (some teams might not have change, treat as 0).
