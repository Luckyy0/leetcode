/* Write your T-SQL query statement below */
WITH PlayerScores AS (
    SELECT player, SUM(score) as total_score
    FROM (
        SELECT first_player as player, first_score as score FROM Matches
        UNION ALL
        SELECT second_player as player, second_score as score FROM Matches
    ) RawScores
    GROUP BY player
),
UnscoredPlayers AS ( -- Include players with 0 matches
    SELECT player_id, ISNULL(total_score, 0) as total_score, group_id
    FROM Players p
    LEFT JOIN PlayerScores ps ON p.player_id = ps.player
),
Ranked AS (
    SELECT 
        group_id, 
        player_id, 
        ROW_NUMBER() OVER (PARTITION BY group_id ORDER BY total_score DESC, player_id ASC) as rn
    FROM UnscoredPlayers
)
SELECT group_id, player_id
FROM Ranked
WHERE rn = 1;
