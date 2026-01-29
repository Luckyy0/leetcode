/*
# 585. Investments in 2016

Table: Insurance
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
pid is the primary key column for this table.
Each row of this table contains information about one policy where:
pid is the Policyholder's policy ID.
tiv_2015 is the total investment value in 2015 and tiv_2016 is the total investment value in 2016.
lat is the latitude of the policy holder's city.
lon is the longitude of the policy holder's city.

Write an SQL query to report the sum of all total investment values in 2016 (tiv_2016), for all policyholders who:
1. Have the same tiv_2015 value as one or more other policyholders.
2. Are not located in the same city as any other policyholder (i.e., the (lat, lon) attribute pairs must be unique).

Round tiv_2016 to two decimal places.
*/

/*
WITH Frequency AS (
    SELECT 
        tiv_2015,
        COUNT(*) AS count_2015
    FROM 
        Insurance
    GROUP BY 
        tiv_2015
),
Location AS (
    SELECT 
        lat, 
        lon,
        COUNT(*) AS count_loc
    FROM 
        Insurance
    GROUP BY 
        lat, lon
)
SELECT 
    ROUND(SUM(I.tiv_2016), 2) AS tiv_2016
FROM 
    Insurance I
JOIN 
    Frequency F ON I.tiv_2015 = F.tiv_2015
JOIN 
    Location L ON I.lat = L.lat AND I.lon = L.lon
WHERE 
    F.count_2015 > 1 
    AND L.count_loc = 1;
*/
