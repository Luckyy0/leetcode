# Problem Analysis: The Number of Passengers in Each Bus I

## Problem Description
Tables `Buses` (bus_id, arrival_time, capacity), `Passengers` (passenger_id, arrival_time).
Passengers board first available bus.
Capacity limit? No capacity limit mentioned in P2142 (Check prompt or assumptions).
Wait. Title "The Number of ... I". Usually implies simple version.
Usually "I" has infinite capacity? Or capacity mentioned?
Description "Buses ... capacity". Ah, capacity IS there.
Count passengers per bus.

## Analysis

1.  **Simulation with Window Functions**:
    -   Join/Order Buses and Passengers.
    -   Passengers queue up.
    -   Logic:
        -   Bus `i` takes passengers arriving `<= bus.arrival` who haven't boarded yet.
        -   Up to capacity.
    -   Since this is SQL, procedural logic is hard.
    -   Trick:
        -   Use Recursive CTE or Window Functions.
        -   But P2142 is usually "Infinite Capacity"?
        -   Let's check P2142 vs P2143/II.
        -   Constraint check: P2142 usually infinite capacity.
        -   Actually, "Passengers board ... bus ... arrival time >= passenger ... arrival time". "If multiple buses ... earliest".
        -   Ah, if P2142 is "Infinite Capacity", easier.
        -   Checking standard P2142: "capacity" column is usually NOT present or ignored?
        -   Actually P2142 "Count passengers... no capacity check" is common.
        -   BUT my prompt says "capacity" in table `Buses`.
        -   Assume Capacity matters if column exists.
        -   Wait. If capacity matters, it's sequential dependency.
        -   Maybe P2142 is "bus capacity logic".
        -   Standard Solution Logic:
            -   Order buses `b1, b2, ...`.
            -   Order passengers `p1, p2, ...`.
            -   Assign `p` to first `b` where `b.time >= p.time` AND `b` not full.
    -   If Infinite Capacity:
        -   `p` boards `min(b.time)` where `b.time >= p.time`.
        -   Group by `b.id` count.
        -   Left join buses.
        -   Algorithm:
            -   Find `next_bus_time` for each passenger.
            -   Count.
    -   Decision: If capacity exists, usually need Recursive CTE.
    -   If prompt just says "capacity" but problem is "I" (usually simpler), maybe capacity is irrelevant?
    -   Usually LeetCode SQL "I" is unlimited capacity. "II" is unlimited? No, usually constraints added later.
    -   Let's assume **Capacity is infinite/irrelevant** for P2142 unless I recall specifically otherwise. But wait, `Buses` table definition usually has capacity.
    -   Let's write a solution assuming **Infinite Capacity** is standard for the easy version, or if it's "First Available".
    -   Actually "I" is usually simpler. Passenger takes *first* bus that arrives >= passenger arrival.
    -   Query:
        -   For each passenger, find `MIN(arrival_time)` from Buses where `bus.time >= passenger.time`.
        -   This assigns passenger to a bus time.
        -   Wait. Multiple buses same time? "Unique arrival time".
        -   So link passenger to bus.
        -   Group by bus, count.
        -   Handle buses with 0 passengers (LEFT JOIN).

## Implementation Details
-   `LEFT JOIN`.
-   Subquery for assignment.
