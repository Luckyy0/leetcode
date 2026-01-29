-- SQL Solution for P1783
SELECT 
    p.player_id,
    p.player_name,
    COUNT(*) AS grand_slams_count
FROM Players p
JOIN (
    SELECT Wimbledon AS id FROM Championships
    UNION ALL
    SELECT Fr_open AS id FROM Championships
    UNION ALL
    SELECT US_open AS id FROM Championships
    UNION ALL
    SELECT Au_open AS id FROM Championships
) t ON p.player_id = t.id
GROUP BY p.player_id, p.player_name;
