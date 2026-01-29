# Problem Analysis: Hopper Company Queries III

## Problem Description
Compute the **average_ride_distance** and **average_ride_duration** of every 3-month window starting from January 2020 to October 2020.
Round to two decimal places.
The window for month `i` includes months `i`, `i+1`, and `i+2`.
Only include months 1 to 10 in the output (since 10+2=12, which is the limit of 2020 data available usually).
Average = (Sum of metrics in window) / (Count of metrics in window). Not average of averages.

## Analysis

1.  **Recursive Months**: Generate 1-12.
2.  **Monthly Aggregates**:
    -   Join `Rides` and `AcceptedRides` based on `requested_at` month.
    -   Calculate `SUM(distance)` and `SUM(duration)` for each month.
    -   Also need `COUNT(rides)` for denominator? No, average ride distance is `TotalDist / TotalRides`? Or average of individual ride distances? Mathematically `Sum(Dist) / Count`.
3.  **Window Functions**:
    -   Use `SUM() OVER (ORDER BY month ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING)`.
    -   This sums the sums.
    -   Wait, we need the total number of rides in the window too to calculate average.
    -   Calculate `MonthlyDist`, `MonthlyDur`, `MonthlyCount`.
    -   Apply rolling sum on all three.
    -   Compute average.
    
4.  **Query**:
    ```sql
    WITH RECURSIVE Months AS (
        SELECT 1 as month UNION ALL SELECT month + 1 FROM Months WHERE month < 12
    ),
    MonthlyStats AS (
        SELECT 
            m.month,
            COALESCE(SUM(a.ride_distance), 0) as tot_dist,
            COALESCE(SUM(a.ride_duration), 0) as tot_dur,
            COUNT(a.ride_id) as tot_rides
        FROM Months m
        LEFT JOIN Rides r ON MONTH(r.requested_at) = m.month AND YEAR(r.requested_at) = 2020
        LEFT JOIN AcceptedRides a ON r.ride_id = a.ride_id
        GROUP BY m.month
    ),
    WindowStats AS (
        SELECT 
            month,
            SUM(tot_dist) OVER w as win_dist,
            SUM(tot_dur) OVER w as win_dur,
            SUM(tot_rides) OVER w as win_rides
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
    ```

## Implementation Details
-   Ensure `LEFT JOIN` correctly counts 0 for months with no rides.

