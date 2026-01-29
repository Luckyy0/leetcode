-- SQL Solution for P1892
WITH AllFriends AS (
    SELECT user1_id AS user_id, user2_id AS friend_id FROM Friendship
    UNION 
    SELECT user2_id AS user_id, user1_id AS friend_id FROM Friendship
)
SELECT 
    f.user_id,
    l.page_id,
    COUNT(DISTINCT f.friend_id) AS friends_likes
FROM AllFriends f
JOIN Likes l ON f.friend_id = l.user_id
LEFT JOIN Likes user_l ON f.user_id = user_l.user_id AND l.page_id = user_l.page_id
WHERE user_l.page_id IS NULL -- Not liked by user
GROUP BY f.user_id, l.page_id
ORDER BY f.user_id ASC, friends_likes DESC, l.page_id ASC;
