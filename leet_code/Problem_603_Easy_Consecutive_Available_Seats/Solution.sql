/*
Problem: 603. Consecutive Available Seats
Difficulty: Easy
Description: Find all seats with at least 2 consecutive free seats.
Approach: Use LAG and LEAD to check neighbors.
*/

SELECT 
    seat_id
FROM (
    SELECT 
        seat_id,
        free,
        -- Status of previous seat
        LAG(free) OVER(ORDER BY seat_id) as prev_free,
        -- Status of next seat
        LEAD(free) OVER(ORDER BY seat_id) as next_free
    FROM 
        Cinema
) t
WHERE 
    free = 1 
    AND (prev_free = 1 OR next_free = 1)
ORDER BY 
    seat_id ASC;

/*
-- Alternative Approach (Self Join):
-- Useful if the environment does not support window functions.
-- Giải pháp thay thế (Tự nối): Hữu ích nếu môi trường không hỗ trợ hàm cửa sổ.

SELECT DISTINCT 
    c1.seat_id
FROM 
    Cinema c1
JOIN 
    Cinema c2 ON ABS(c1.seat_id - c2.seat_id) = 1
WHERE 
    c1.free = 1 AND c2.free = 1
ORDER BY 
    c1.seat_id;
*/
