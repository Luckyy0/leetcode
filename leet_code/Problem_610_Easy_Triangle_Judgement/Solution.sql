/*
Problem: 610. Triangle Judgement
Difficulty: Easy
Description: Determine if three lengths can form a triangle.
Approach: Use Triangle Inequality Theorem (x+y > z AND x+z > y AND y+z > x).
*/

SELECT 
    x, 
    y, 
    z,
    CASE 
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM 
    Triangle;
