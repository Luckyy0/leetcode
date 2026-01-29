/* Write your T-SQL query statement below */
SELECT 
    ad_id,
    ISNULL(ROUND(
        SUM(CASE WHEN action = 'Clicked' THEN 1 ELSE 0 END) * 100.0 / 
        NULLIF(SUM(CASE WHEN action IN ('Clicked', 'Viewed') THEN 1 ELSE 0 END), 0)
    , 2), 0) AS ctr
FROM Ads
GROUP BY ad_id
ORDER BY ctr DESC, ad_id ASC;
