-- SQL Solution for P2112
WITH Traffic AS (
    SELECT departure_airport AS airport_id, flights_count FROM Flights
    UNION ALL
    SELECT arrival_airport AS airport_id, flights_count FROM Flights
),
TotalTraffic AS (
    SELECT airport_id, SUM(flights_count) AS total
    FROM Traffic
    GROUP BY airport_id
)
SELECT airport_id
FROM TotalTraffic
WHERE total = (SELECT MAX(total) FROM TotalTraffic);
