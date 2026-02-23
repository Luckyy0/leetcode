/*
Problem: 612. Shortest Distance in a Plane
Difficulty: Medium
Description: Find the shortest distance between any two points in 2D.
Approach: Self-join the table, exclude self-comparison, and calculate distance.
*/

SELECT
    ROUND(
        MIN(
            SQRT(
                POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2)
            )
        ), 
        2
    ) AS shortest
FROM
    Point2D p1
JOIN
    Point2D p2 ON p1.x != p2.x OR p1.y != p2.y;
