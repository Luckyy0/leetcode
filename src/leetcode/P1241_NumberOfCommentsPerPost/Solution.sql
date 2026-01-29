/* Write your T-SQL query statement below */
WITH Posts AS (
    SELECT DISTINCT sub_id as post_id
    FROM Submissions
    WHERE parent_id IS NULL
),
Comments AS (
    SELECT DISTINCT sub_id, parent_id
    FROM Submissions
    WHERE parent_id IS NOT NULL
)
SELECT 
    p.post_id,
    COUNT(c.sub_id) AS number_of_comments
FROM Posts p
LEFT JOIN Comments c ON p.post_id = c.parent_id
GROUP BY p.post_id
ORDER BY p.post_id;
