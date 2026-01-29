/*
# 612. Shortest Distance in a Plane

Table: Point2D
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
| y           | int  |
+-------------+------+
(x, y) is the primary key column for this table.
Each row of this table indicates the position of a point on the 2D plane.

Write an SQL query to report the shortest distance between any two points from the Point2D table. Round the result to 2 decimal places.
*/

/*
SELECT 
    ROUND(SQRT(MIN(POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2))), 2) AS shortest
FROM 
    Point2D p1
JOIN 
    Point2D p2
ON 
    p1.x != p2.x OR p1.y != p2.y;
*/

/* Correction: MIN aggregation should be outside SQRT?
SQRT is monotonic. MIN(SQRT(...)) == SQRT(MIN(...)). Both work.
But usually MIN(dist) is conceptually clearer.
Wait, if table is empty or 1 row? Result NULL.
*/

/*
SELECT 
    ROUND(MIN(SQRT(POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2))), 2) AS shortest
FROM 
    Point2D p1
JOIN 
    Point2D p2
ON 
    p1.x != p2.x OR p1.y != p2.y;
*/
