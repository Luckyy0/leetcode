-- SQL Solution for P2153
WITH RECURSIVE OrderedBuses AS (
    SELECT 
        bus_id, 
        arrival_time, 
        capacity,
        ROW_NUMBER() OVER (ORDER BY arrival_time) AS rn
    FROM Buses
),
PassengerCounts AS (
    SELECT 
        b.rn,
        COUNT(p.passenger_id) AS total_arrived
    FROM OrderedBuses b
    LEFT JOIN Passengers p ON p.arrival_time <= b.arrival_time
    GROUP BY b.rn
),
BusBoarding AS (
    -- Base case: First bus
    -- Need total_arrived from PassengerCounts
    -- boarded = MIN(capacity, total_arrived)
    SELECT 
        b.bus_id,
        b.rn,
        b.capacity,
        pc.total_arrived,
        LEAST(b.capacity, pc.total_arrived) AS boarded,
        LEAST(b.capacity, pc.total_arrived) AS total_boarded_so_far
    FROM OrderedBuses b
    JOIN PassengerCounts pc ON b.rn = pc.rn
    WHERE b.rn = 1
    
    UNION ALL
    
    -- Recursive step
    SELECT 
        b.bus_id,
        b.rn,
        b.capacity,
        pc.total_arrived,
        LEAST(b.capacity, pc.total_arrived - bb.total_boarded_so_far) AS boarded,
        bb.total_boarded_so_far + LEAST(b.capacity, pc.total_arrived - bb.total_boarded_so_far) AS total_boarded_so_far
    FROM OrderedBuses b
    JOIN PassengerCounts pc ON b.rn = pc.rn
    JOIN BusBoarding bb ON b.rn = bb.rn + 1
)
SELECT bus_id, boarded AS passengers_cnt 
FROM BusBoarding 
ORDER BY bus_id;
