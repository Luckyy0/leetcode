-- SQL Solution for P2173
WITH OrderedMatches AS (
    SELECT 
        player_id, 
        match_day, 
        result,
        ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY match_day) AS rn
    FROM Matches
),
WinGroups AS (
    SELECT 
        player_id,
        match_day,
        rn - ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY match_day) AS grp
    FROM OrderedMatches
    WHERE result = 'Win'
),
Streaks AS (
    SELECT 
        player_id, 
        COUNT(*) AS streak_len
    FROM WinGroups
    GROUP BY player_id, grp
)
SELECT 
    DISTINCT m.player_id,
    COALESCE(MAX(s.streak_len), 0) AS longest_streak
FROM Matches m
LEFT JOIN Streaks s ON m.player_id = s.player_id
GROUP BY m.player_id;
