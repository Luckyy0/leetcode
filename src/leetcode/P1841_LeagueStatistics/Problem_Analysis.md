# Problem Analysis: League Statistics

## Problem Description
Table `Teams` (team_id, team_name).
Table `Matches` (home_team_id, away_team_id, home_team_goals, away_team_goals).
Calculate stats:
- Points: Win=3, Draw=1, Loss=0.
- Goal Difference: For - Against.
- Matches Played.
Order by Points Desc, Goal Diff Desc, Name Asc.

## Analysis

1.  **Unpivot and Aggregate**:
    -   Select home stats and away stats separately, then UNION ALL.
    -   Home side: team_id = home_team_id. Goals For = home_goals. Goals Against = away_goals. Points logic.
    -   Away side: team_id = away_team_id. Goals For = away_goals. Goals Against = home_goals. Points logic.
    -   Aggregate by team_id.
    -   Join with Teams for name.

## Implementation Details
-   CTE or subquery.
