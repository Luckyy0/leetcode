/*
# 626. Exchange Seats

Table: Seat
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| student     | varchar |
+-------------+---------+
id is the primary key column for this table.
Each row of this table indicates the name and the ID of a student.
id is a continuous increment.

Write an SQL query to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
Return the result table ordered by id in ascending order.
*/

/*
SELECT 
    CASE 
        WHEN id % 2 = 1 AND id != (SELECT MAX(id) FROM Seat) THEN id + 1
        WHEN id % 2 = 0 THEN id - 1
        ELSE id
    END AS id,
    student
FROM 
    Seat
ORDER BY 
    id ASC;
*/

/* Alternative without subquery in CASE for every row?
   Using IF or COALESCE with Self Join?
   Or window function to get next/prev student?
   
   SELECT 
     id,
     COALESCE(
       CASE WHEN id%2=1 THEN LEAD(student) OVER(ORDER BY id)
            WHEN id%2=0 THEN LAG(student) OVER(ORDER BY id)
       END,
       student) as student
   FROM Seat
   
   This swaps student names instead of IDs. It achieves same result set.
   Usually faster than subquery MAX(id).
   
   But problem asks to swap ID? Result table columns: id, student.
   If we swap student names, (1, B), (2, A). Same as swap IDs (2, A), (1, B) then sort.
   
   Wait, if we swap IDs: (2, A), (1, B). Sort by ID: (1, B), (2, A).
   Essentially we want row 1 to have student from row 2.
   And row 2 to have student from row 1.
   
   Let's stick to modifying ID logic as it is standard. The MAX(id) subquery runs once per query usually in good DBs.
*/

/*
SELECT 
    (CASE 
        WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1
        WHEN MOD(id, 2) != 0 AND counts = id THEN id
        ELSE id - 1
    END) AS id,
    student
FROM 
    Seat,
    (SELECT COUNT(*) AS counts FROM Seat) AS seat_counts
ORDER BY id ASC;
*/

/*
SELECT 
    CASE 
        WHEN id % 2 = 1 AND id != (SELECT MAX(id) FROM Seat) THEN id + 1
        WHEN id % 2 = 0 THEN id - 1
        ELSE id
    END AS id,
    student
FROM 
    Seat
ORDER BY 
    id ASC;
*/
