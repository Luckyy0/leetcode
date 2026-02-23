/*
Problem: 602. Friend Requests II: Who Has the Most Friends
Difficulty: Medium
Description: Find the user with the most friends (sum of requester and accepter counts).
Approach: UNION ALL all IDs into one column, group, count, and order.
*/

WITH AllFriends AS (
    -- Collect all requesters
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
    -- Collect all accepters
    SELECT accepter_id AS id FROM RequestAccepted
)
SELECT 
    id, 
    COUNT(*) AS num
FROM 
    AllFriends
GROUP BY 
    id
ORDER BY 
    num DESC
LIMIT 1;

/*
-- Follow up: To find all people who tie for the most friends:
-- Giải pháp mở rộng: Tìm tất cả những người cùng đứng đầu:

SELECT id, num
FROM (
    SELECT id, COUNT(*) as num, RANK() OVER(ORDER BY COUNT(*) DESC) as rk
    FROM (
        SELECT requester_id AS id FROM RequestAccepted
        UNION ALL
        SELECT accepter_id AS id FROM RequestAccepted
    ) t
    GROUP BY id
) t2
WHERE rk = 1;
*/
