/*
Problem: 614. Second Degree Follower
Difficulty: Medium
Description: Find users who both follow and are followed. Show their follower count.
Approach: Group by followee to get counts, then filter for those who also appear in the follower column.
*/

SELECT 
    followee AS follower, 
    COUNT(DISTINCT follower) AS num
FROM 
    Follow
WHERE 
    followee IN (SELECT follower FROM Follow)
GROUP BY 
    followee
ORDER BY 
    follower;
