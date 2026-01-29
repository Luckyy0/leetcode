/*
# 602. Friend Requests II: Who Has the Most Friends

Table: RequestAccepted
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
(requester_id, accepter_id) is the primary key for this table.
This table contains the ID of the user who sent the request, the ID of the user who received the request, and the date when the request was accepted.

Write an SQL query to find the people who have the most friends and the most friends number.
The friend request could be accepted two ways, either by the sender or the receiver.
*/

/*
WITH AllFriends AS (
    SELECT requester_id AS id FROM RequestAccepted
    UNION ALL
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
*/
