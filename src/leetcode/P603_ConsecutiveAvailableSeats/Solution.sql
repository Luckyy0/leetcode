/*
# 603. Consecutive Available Seats

Table: Cinema
+-------------+------+
| Column Name | Type |
+-------------+------+
| seat_id     | int  |
| free        | bool |
+-------------+------+
seat_id is an auto-increment primary key column for this table.
Each row of this table indicates whether the ith seat is free or not. 1 means free while 0 means occupied.

Write an SQL query to report all the consecutive available seats.
Return the result table ordered by seat_id in ascending order.
*/

/*
SELECT DISTINCT 
    a.seat_id
FROM 
    Cinema a 
JOIN 
    Cinema b 
ON 
    ABS(a.seat_id - b.seat_id) = 1
WHERE 
    a.free = 1 
    AND b.free = 1
ORDER BY 
    a.seat_id;
*/
