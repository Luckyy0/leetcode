-- SQL Solution for P1635
WITH RECURSIVE Months AS (
    SELECT 1 as month
    UNION ALL
    SELECT month + 1 FROM Months WHERE month < 12
),
MonthlyStats AS (
    SELECT 
        m.month,
        (
            SELECT COUNT(driver_id) 
            FROM Drivers 
            WHERE join_date <= LAST_DAY(CONCAT('2020-', LPAD(m.month, 2, '0'), '-01'))
        ) as active_drivers,
        (
            SELECT COUNT(a.ride_id)
            FROM Rides r
            JOIN AcceptedRides a ON r.ride_id = a.ride_id
            WHERE YEAR(r.requested_at) = 2020 AND MONTH(r.requested_at) = m.month
        ) as accepted_rides
    FROM Months m
)
SELECT 
    month,
    active_drivers,
    accepted_rides
FROM MonthlyStats
ORDER BY month;
