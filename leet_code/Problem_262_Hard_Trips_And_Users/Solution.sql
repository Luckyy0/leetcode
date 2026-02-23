/*
 * Solution for Trips and Users
 * Giải pháp cho bài toán Chuyến đi và Người dùng
 *
 * 1. Filter trips by date range [2013-10-01, 2013-10-03].
 * 2. Exclude trips where client or driver is banned.
 * 3. Group by day.
 * 4. Calculate cancellation rate using conditional sum.
 */

SELECT 
    t.request_at AS Day,
    ROUND(
        SUM(CASE WHEN t.status != 'completed' THEN 1 ELSE 0 END) / COUNT(*), 
        2
    ) AS "Cancellation Rate"
FROM 
    Trips t
WHERE 
    t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND t.client_id NOT IN (
        SELECT users_id FROM Users WHERE banned = 'Yes'
    )
    AND t.driver_id NOT IN (
        SELECT users_id FROM Users WHERE banned = 'Yes'
    )
GROUP BY 
    t.request_at;
