/*
Problem: 626. Exchange Seats
Difficulty: Medium
Description: Swap student names for every two consecutive seats.
Approach: Calculate a new ID for each student using CASE and MOD logic.
*/

SELECT 
    -- Calculate the new ID for each student
    CASE 
        -- If ID is even, it moves back to the previous odd position
        WHEN id % 2 = 0 THEN id - 1
        -- If ID is odd and it's NOT the very last seat, it moves forward to even
        WHEN id % 2 = 1 AND id != (SELECT COUNT(*) FROM Seat) THEN id + 1
        -- If ID is odd and it IS the last seat (in an odd-sized table), stay put
        ELSE id 
    END AS id,
    student
FROM 
    Seat
ORDER BY 
    id;
