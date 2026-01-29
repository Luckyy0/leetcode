-- SQL Solution for P2175
WITH OldRanks AS (
    SELECT 
        team_id, 
        name, 
        points,
        ROW_NUMBER() OVER (ORDER BY points DESC, name ASC) AS rnk
    FROM TeamPoints
),
UpdatedPoints AS (
    SELECT 
        tp.team_id, 
        tp.name, 
        tp.points + COALESCE(pc.points_change, 0) AS new_points
    FROM TeamPoints tp
    LEFT JOIN PointsChange pc ON tp.team_id = pc.team_id
),
NewRanks AS (
    SELECT 
        team_id, 
        name,
        ROW_NUMBER() OVER (ORDER BY new_points DESC, name ASC) AS rnk
    FROM UpdatedPoints
)
SELECT 
    old.team_id, 
    old.name, 
    CAST(old.rnk AS SIGNED) - CAST(new.rnk AS SIGNED) AS rank_diff
FROM OldRanks old
JOIN NewRanks new ON old.team_id = new.team_id;
