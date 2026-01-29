/*
# 601. Human Traffic of Stadium

Table: Stadium
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
id is the primary key column for this table.
Each row of this table contains the visit date and visit id to the stadium with the number of people during the visit.
No two rows will have the same visit_date, and as the id increases, the dates increase as well.

Write an SQL query to display the records with three or more rows with consecutive id's, and the number of people is greater than or equal to 100 for each.

Return the result table ordered by visit_date in ascending order.
*/

/*
WITH Filtered AS (
    SELECT id, visit_date, people
    FROM Stadium
    WHERE people >= 100
),
Grouped AS (
    SELECT 
        id, 
        visit_date, 
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM 
        Filtered
),
Counted AS (
    SELECT 
        id, 
        visit_date, 
        people,
        COUNT(*) OVER (PARTITION BY grp) AS cnt
    FROM 
        Grouped
)
SELECT 
    id, 
    visit_date, 
    people
FROM 
    Counted
WHERE 
    cnt >= 3
ORDER BY 
    visit_date ASC;
*/
