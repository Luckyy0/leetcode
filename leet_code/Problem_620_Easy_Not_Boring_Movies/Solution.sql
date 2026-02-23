/*
Problem: 620. Not Boring Movies
Difficulty: Easy
Description: Find movies with odd-numbered IDs and a non-boring description, sorted by rating.
Approach: Use MOD or % for odd check, and standard inequality for description filter.
*/

SELECT 
    id, 
    movie, 
    description, 
    rating
FROM 
    cinema
WHERE 
    id % 2 = 1 
    AND description != 'boring'
ORDER BY 
    rating DESC;
