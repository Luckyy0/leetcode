-- SQL Solution for P1990
WITH Platforms AS (
    SELECT 'Android' AS platform UNION SELECT 'IOS' UNION SELECT 'Web'
),
Names AS (
    SELECT 'Reading' AS experiment_name UNION SELECT 'Sports' UNION SELECT 'Programming'
),
AllPairs AS (
    SELECT p.platform, n.experiment_name
    FROM Platforms p CROSS JOIN Names n
)
SELECT 
    ap.platform,
    ap.experiment_name,
    COUNT(e.experiment_id) AS num_experiments
FROM AllPairs ap
LEFT JOIN Experiments e 
    ON ap.platform = e.platform 
    AND ap.experiment_name = e.experiment_name
GROUP BY ap.platform, ap.experiment_name
ORDER BY ap.platform, ap.experiment_name;
