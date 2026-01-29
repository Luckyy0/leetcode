/* Write your T-SQL query statement below */
WITH PersonCountry AS (
    SELECT 
        p.id, 
        c.name AS country_name
    FROM Person p
    JOIN Country c ON LEFT(p.phone_number, 3) = c.country_code
),
CallDurations AS (
    SELECT caller_id AS pid, duration FROM Calls
    UNION ALL
    SELECT callee_id AS pid, duration FROM Calls
),
CountryStats AS (
    SELECT 
        pc.country_name, 
        AVG(CAST(cd.duration AS FLOAT)) AS avg_duration
    FROM CallDurations cd
    JOIN PersonCountry pc ON cd.pid = pc.id
    GROUP BY pc.country_name
),
GlobalStat AS (
    SELECT AVG(CAST(duration AS FLOAT)) AS global_avg FROM Calls
)
SELECT cs.country_name
FROM CountryStats cs, GlobalStat gs
WHERE cs.avg_duration > gs.global_avg;
