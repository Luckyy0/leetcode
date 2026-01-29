/*
# 597. Friend Requests I: Overall Acceptance Rate

Table: FriendRequest
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| sender_id      | int     |
| send_to_id     | int     |
| request_date   | date    |
+----------------+---------+
There is no primary key for this table, it may contain duplicates.
This table contains the ID of the user who sent the request, the ID of the user who received the request, and the date of the request.

Table: RequestAccepted
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
There is no primary key for this table, it may contain duplicates.
This table contains the ID of the user who sent the request, the ID of the user who received the request, and the date when the request was accepted.

Write an SQL query to report the overall acceptance rate of requests rounded to 2 decimal places.
*/

/*
SELECT 
    ROUND(
        IFNULL(
            (SELECT COUNT(DISTINCT requester_id, accepter_id) FROM RequestAccepted) /
            NULLIF((SELECT COUNT(DISTINCT sender_id, send_to_id) FROM FriendRequest), 0),
        0), 
    2) AS accept_rate;
*/
