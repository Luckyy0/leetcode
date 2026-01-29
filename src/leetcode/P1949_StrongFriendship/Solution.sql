-- SQL Solution for P1949
WITH AllFriends AS (
    SELECT user1_id AS u, user2_id AS f FROM Friendship
    UNION
    SELECT user2_id AS u, user1_id AS f FROM Friendship
)
SELECT 
    f.user1_id,
    f.user2_id,
    COUNT(af1.f) AS common_friend_count
FROM Friendship f
JOIN AllFriends af1 ON f.user1_id = af1.u
JOIN AllFriends af2 ON f.user2_id = af2.u AND af1.f = af2.f
GROUP BY f.user1_id, f.user2_id
HAVING count(af1.f) >= 3;
