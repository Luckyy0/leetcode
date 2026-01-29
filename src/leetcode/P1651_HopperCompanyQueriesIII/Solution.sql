-- SQL Solution for P1651
WITH RECURSIVE Months AS (
    SELECT 1 as month UNION ALL SELECT month + 1 FROM Months WHERE month < 12
),
MonthlyStats AS (
    SELECT 
        m.month,
        IFNULL(SUM(a.ride_distance), 0) as dist,
        IFNULL(SUM(a.ride_duration), 0) as dur,
        COUNT(a.ride_id) as rides
    FROM Months m
    LEFT JOIN Rides r ON MONTH(r.requested_at) = m.month AND YEAR(r.requested_at) = 2020
    LEFT JOIN AcceptedRides a ON r.ride_id = a.ride_id
    GROUP BY m.month
),
WindowStats AS (
    SELECT 
        month,
        SUM(dist) OVER w as win_dist,
        SUM(dur) OVER w as win_dur,
        SUM(rides) OVER w as win_rides
    FROM MonthlyStats
    WINDOW w AS (ORDER BY month ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING)
)
SELECT 
    month,
    ROUND(IFNULL(win_dist / NULLIF(win_rides, 0), 0), 2) as average_ride_distance,
    ROUND(IFNULL(win_dur / NULLIF(win_rides, 0), 0), 2) as average_ride_duration
FROM WindowStats
WHERE month <= 10
ORDER BY month;
