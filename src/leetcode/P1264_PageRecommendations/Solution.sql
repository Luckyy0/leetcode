/* Write your T-SQL query statement below */
WITH Friends AS (
    SELECT user2_id as friend_id FROM Friendship WHERE user1_id = 1
    UNION
    SELECT user1_id as friend_id FROM Friendship WHERE user2_id = 1
),
PagesUser1Likes AS (
    SELECT page_id FROM Likes WHERE user_id = 1
)
SELECT DISTINCT l.page_id AS recommended_page
FROM Likes l
JOIN Friends f ON l.user_id = f.friend_id
WHERE l.page_id NOT IN (SELECT page_id FROM PagesUser1Likes);
