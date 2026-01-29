# Problem Analysis: Hopper Company Queries I

## Problem Description
Tables: `Drivers` (driver_id, join_date), `Rides` (ride_id, user_id, requested_at), `AcceptedRides` (ride_id, driver_id, ride_distance, ride_duration).
Report for each month of 2020:
-   `month` (1 to 12).
-   `active_drivers`: Number of drivers currently with the company by the end of the month.
-   `accepted_rides`: Number of rides accepted in that month (based on `requested_at`).

## Analysis

1.  **Generate Months**:
    -   Recursive CTE or simple `SELECT 1 UNION SELECT 2...` to get table `Months`.

2.  **Active Drivers**:
    -   For Month `m`, drivers joined on `join_date` such that `YEAR(join_date) < 2020` OR `(YEAR(join_date) = 2020 AND MONTH(join_date) <= m)`.
    -   Can be done with a subquery or join condition.

3.  **Accepted Rides**:
    -   Rides requested in 2020/`m`.
    -   Check if `ride_id` in `AcceptedRides`.
    -   Sum/Count them.

4.  **Query Structure**:
    ```sql
    WITH RECURSIVE Months AS (
        SELECT 1 as month
        UNION ALL
        SELECT month + 1 FROM Months WHERE month < 12
    ),
    MonthDrivers AS (
        SELECT 
            m.month,
            COUNT(d.driver_id) as active_drivers
        FROM Months m
        LEFT JOIN Drivers d ON 
            (YEAR(d.join_date) < 2020) OR 
            (YEAR(d.join_date) = 2020 AND MONTH(d.join_date) <= m.month)
        GROUP BY m.month
    ),
    MonthRides AS (
        SELECT 
            MONTH(r.requested_at) as month,
            COUNT(a.ride_id) as accepted_rides
        FROM Rides r
        JOIN AcceptedRides a ON r.ride_id = a.ride_id
        WHERE YEAR(r.requested_at) = 2020
        GROUP BY MONTH(r.requested_at)
    )
    SELECT 
        m.month,
        md.active_drivers,
        IFNULL(mr.accepted_rides, 0) as accepted_rides
    FROM MonthDrivers m
    LEFT JOIN MonthRides mr ON m.month = mr.month
    ORDER BY m.month;
    ```
    - Note on drivers: The count logic might duplicate if join is not careful.
    - Better:
        - `JOIN Drivers WHERE join_date <= '2020-01-31'`?
        - Subquery: `(SELECT COUNT(*) FROM Drivers WHERE join_date <= LAST_DAY(CONCAT('2020-', month, '-01')))`.

## Implementation Details
-   Using subquery for drivers is safer and cleaner than joining and grouping on inequality.
-   Recursive CTE for months.
