-- SQL Solution for P1645
WITH RECURSIVE Months AS (
    SELECT 1 as month
    UNION ALL
    SELECT month + 1 FROM Months WHERE month < 12
),
Stats AS (
    SELECT 
        m.month,
        (
            SELECT COUNT(driver_id) 
            FROM Drivers 
            WHERE join_date <= LAST_DAY(CONCAT('2020-', LPAD(m.month, 2, '0'), '-01'))
        ) as active_drivers,
        (
            SELECT COUNT(DISTINCT a.driver_id)
            FROM Rides r
            JOIN AcceptedRides a ON r.ride_id = a.ride_id
            WHERE YEAR(r.requested_at) = 2020 AND MONTH(r.requested_at) = m.month
        ) as working_drivers
    FROM Months m
)
SELECT 
    month,
    ROUND(IFNULL(working_drivers * 100.0 / NULLIF(active_drivers, 0), 0), 2) as working_percentage
FROM Stats
ORDER BY month;
