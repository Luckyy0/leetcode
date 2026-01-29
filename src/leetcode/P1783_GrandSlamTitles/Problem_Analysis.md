# Problem Analysis: Grand Slam Titles

## Problem Description
Tables `Players` (player_id, player_name) and `Championships` (year, Wimbledon, Fr_open, US_open, Au_open).
Columns in Championships store player_id of winner.
Result: player_id, player_name, grand_slams_count.

## Analysis

1.  **Unpivot and Count**:
    -   `UNION ALL` the 4 columns: `SELECT Wimbledon AS id FROM ... UNION ALL SELECT Fr_open ...`.
    -   Query `T` has all winning IDs.
    -   `SELECT id, COUNT(*) FROM T GROUP BY id`.
    -   Join with `Players`.

## Implementation Details
-   SQL.
