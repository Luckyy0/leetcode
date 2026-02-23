/*
Problem: 619. Biggest Single Number
Difficulty: Easy
Description: Find the largest number that appears exactly once. Return null if none.
Approach: Use GROUP BY and HAVING to find single numbers, then MAX() on a subquery.
*/

SELECT 
    MAX(num) AS num
FROM (
    SELECT 
        num
    FROM 
        MyNumbers
    GROUP BY 
        num
    HAVING 
        COUNT(*) = 1
) AS single_nums;
