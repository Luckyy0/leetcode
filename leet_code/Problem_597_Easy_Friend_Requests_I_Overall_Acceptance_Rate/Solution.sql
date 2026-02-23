/*
Problem: 597. Friend Requests I: Overall Acceptance Rate
Difficulty: Easy
Description: Calculate unique accepted requests / unique total requests.
Approach: Use subqueries to count distinct pairs and handle division by zero.
*/

SELECT 
    ROUND(
        IFNULL(
            (SELECT COUNT(*) FROM (SELECT DISTINCT requester_id, accepter_id FROM RequestAccepted) AS t1) / 
            (SELECT COUNT(*) FROM (SELECT DISTINCT sender_id, send_to_id FROM FriendRequest) AS t2), 
            0
        ), 
        2
    ) AS accept_rate;
