/*
Problem: 613. Shortest Distance in a Line
Difficulty: Easy
Description: Find the shortest distance between any two points on a 1D line.
Approach: Use self-join with p1.x < p2.x to calculate positive differences.
*/

SELECT
    MIN(p2.x - p1.x) AS shortest
FROM
    Point p1
JOIN
    Point p2 ON p1.x < p2.x;

/*
-- Alternative Approach (Window Function):
-- More efficient for large datasets (O(N log N)).
-- Giải pháp thay thế (Hàm cửa sổ): Hiệu quả hơn đối với tập dữ liệu lớn.

SELECT MIN(diff) as shortest
FROM (
    SELECT x, LEAD(x) OVER (ORDER BY x) - x AS diff
    FROM Point
) t
WHERE diff IS NOT NULL;
*/
