/*
# 613. Shortest Distance in a Line

Table: Point
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
+-------------+------+
x is the primary key column for this table.
Each row of this table indicates the position of a point on the X-axis.

Write an SQL query to report the shortest distance between any two points from the Point table.
*/

/*
SELECT 
    MIN(ABS(p1.x - p2.x)) AS shortest
FROM 
    Point p1
JOIN 
    Point p2
ON 
    p1.x != p2.x;
*/
