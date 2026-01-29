-- SQL Solution for P1841
WITH MatchStats AS (
    SELECT 
        home_team_id AS team_id,
        home_team_goals AS goals_for,
        away_team_goals AS goals_against,
        CASE 
            WHEN home_team_goals > away_team_goals THEN 3
            WHEN home_team_goals = away_team_goals THEN 1
            ELSE 0 
        END AS points
    FROM Matches
    UNION ALL
    SELECT 
        away_team_id AS team_id,
        away_team_goals AS goals_for,
        home_team_goals AS goals_against,
        CASE 
            WHEN away_team_goals > home_team_goals THEN 3
            WHEN away_team_goals = home_team_goals THEN 1
            ELSE 0 
        END AS points
    FROM Matches
)
SELECT 
    t.team_name,
    COUNT(*) AS matches_played,
    SUM(m.points) AS points,
    SUM(m.goals_for) AS goal_for,
    SUM(m.goals_against) AS goal_against,
    SUM(m.goals_for) - SUM(m.goals_against) AS goal_diff
FROM MatchStats m
JOIN Teams t ON m.team_id = t.team_id
GROUP BY t.team_id, t.team_name
ORDER BY points DESC, goal_diff DESC, team_name ASC;
