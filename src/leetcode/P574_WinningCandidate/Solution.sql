/*
# 574. Winning Candidate

Table: Candidate
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
+-------------+----------+
id is the primary key column for this table.
Each row of this table contains information about the id and the name of a candidate.

Table: Vote
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| candidateId | int      |
+-------------+----------+
id is the auto-increment primary key.
candidateId is the foreign key to id from the Candidate table.
Each row of this table determines that which candidate got the ith vote in the elections.

Write an SQL query to report the name of the winning candidate (i.e., the candidate who got the largest number of votes).
*/

/*
SELECT 
    name
FROM 
    Candidate
WHERE 
    id = (
        SELECT 
            candidateId
        FROM 
            Vote
        GROUP BY 
            candidateId
        ORDER BY 
            COUNT(*) DESC
        LIMIT 1
    );
*/
