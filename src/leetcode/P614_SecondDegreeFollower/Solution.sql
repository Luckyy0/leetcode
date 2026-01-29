/*
# 614. Second Degree Follower

Table: Follow
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| followee    | varchar |
| follower    | varchar |
+-------------+---------+
(followee, follower) is the primary key column for this table.
Each row of this table indicates that the user follower follows the user followee.

Write an SQL query to report the second-degree followers of each user.
A user's second-degree follower is a user who follows a user who follows them?
Actually checking LeetCode 614 specific definition:
"Report the number of followers of each user who also follows someone else."
Columns: follower, num.
Here 'follower' column in output refers to the person having followers (who is a followee in table).
So we want to list Name X, Count(followers of X).
Condition: X must follow someone (X must be in `follower` column of Follow table).

Wait, the nomenclature is confusing.
Output columns: `follower`, `num`.
Usually `follower` in output means the user name.
Let's assume we want to list users (let's call them User U) such that:
1. User U follows someone (U in `follower` column).
2. User U has followers (U in `followee` column).
Count is number of people following U.

Example:
A follows B (B is followee, A is follower).
B follows C (C is followee, B is follower).
B is in follower column (follows C).
B is in followee column (A follows B).
So B is reported. Count = 1 (A).

*/

/*
SELECT 
    f1.followee AS follower, 
    COUNT(DISTINCT f1.follower) AS num
FROM 
    Follow f1
WHERE 
    f1.followee IN (SELECT follower FROM Follow)
GROUP BY 
    f1.followee
ORDER BY 
    f1.followee;
*/
