/*
Problem: 595. Big Countries
Difficulty: Easy
Description: Select name, population, and area for countries meeting size criteria.
Approach: Use a simple WHERE clause with an OR operator.
*/

SELECT 
    name, 
    population, 
    area
FROM 
    World
WHERE 
    area >= 3000000 
    OR population >= 25000000;

/*
-- Alternative Approach (UNION):
-- Can be faster on large tables with indexes on both area and population.

SELECT name, population, area FROM World WHERE area >= 3000000
UNION
SELECT name, population, area FROM World WHERE population >= 25000000;
*/
