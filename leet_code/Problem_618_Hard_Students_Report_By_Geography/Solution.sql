/*
Problem: 618. Students Report By Geography
Difficulty: Hard
Description: Pivot the Student table to show names by continent in alphabetical order.
Approach: Use ROW_NUMBER() over each continent to create a linkage key, then MAX(CASE WHEN) to pivot.
*/

SELECT 
    MAX(CASE WHEN continent = 'America' THEN name END) AS America,
    MAX(CASE WHEN continent = 'Asia' THEN name END) AS Asia,
    MAX(CASE WHEN continent = 'Europe' THEN name END) AS Europe
FROM (
    SELECT 
        name, 
        continent, 
        -- Assign row ID to align names across continents
        ROW_NUMBER() OVER(PARTITION BY continent ORDER BY name) AS row_id
    FROM 
        Student
) t
GROUP BY 
    row_id;
