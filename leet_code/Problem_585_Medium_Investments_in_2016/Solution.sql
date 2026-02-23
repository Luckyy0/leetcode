/*
Problem: 585. Investments in 2016
Difficulty: Medium
Description: Sum TIV_2016 for policyholders with shared TIV_2015 but unique (lat, lon).
Approach: Use window functions COUNT(*) OVER(PARTITION BY ...) to identify duplicates/uniques.
*/

WITH PolicyCounts AS (
    SELECT 
        tiv_2016,
        COUNT(*) OVER(PARTITION BY tiv_2015) as count_tiv15,
        COUNT(*) OVER(PARTITION BY lat, lon) as count_loc
    FROM 
        Insurance
)
SELECT 
    ROUND(SUM(tiv_2016), 2) as tiv_2016
FROM 
    PolicyCounts
WHERE 
    -- Same tiv_2015 as one or more other policyholders
    count_tiv15 > 1
    -- Not located in the same city as any other policyholder
    AND count_loc = 1;
