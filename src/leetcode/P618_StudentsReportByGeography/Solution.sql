/*
# 618. Students Report By Geography

Table: Student
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| name        | varchar |
| continent   | varchar |
+-------------+---------+
There is no primary key for this table. It may contain duplicate rows.
Each row of this table indicates the name of a student and the continent they came from.

Write an SQL query to pivot the continent column in the Student table so that each name is sorted alphabetically and displayed underneath its corresponding continent.
The output headers should be America, Asia, and Europe, respectively.
*/

/*
SELECT
    MAX(CASE WHEN continent = 'America' THEN name END) AS America,
    MAX(CASE WHEN continent = 'Asia' THEN name END) AS Asia,
    MAX(CASE WHEN continent = 'Europe' THEN name END) AS Europe
FROM (
    SELECT 
        name, 
        continent, 
        ROW_NUMBER() OVER(PARTITION BY continent ORDER BY name) AS rn
    FROM 
        Student
) t
GROUP BY 
    rn;
*/
