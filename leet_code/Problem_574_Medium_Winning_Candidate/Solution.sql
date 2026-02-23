/*
Problem: 574. Winning Candidate
Difficulty: Medium
Description: Find the name of the candidate with the most votes.
Approach: Group votes by candidateId, sort by count, limit 1, and join with Candidate table.
*/

SELECT 
    name
FROM 
    Candidate
WHERE 
    id = (
        -- Subquery to find the ID with the maximum votes
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
