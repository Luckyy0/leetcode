# Problem Analysis: The Number of Passengers in Each Bus II

## Problem Description
P2153. `Buses` (id, time, capacity), `Passengers` (id, time).
Passengers queue.
Must handle capacity. Passengers roll over to next bus.

## Analysis

1.  **Recursive CTE**:
    -   Standard pattern for "Carry over" problems.
    -   Order buses by time.
    -   CTE calculates:
        -   `bus_id`
        -   `passengers_arrived_by_now`: Total passengers arriving <= bus.time.
        -   `capacity`
        -   `passengers_boarded`: min(capacity, passengers_waiting).
        -   `passengers_waiting` depends on PREVIOUS row's `passengers_remaining`.
    -   Wait. `passengers_waiting` = `passengers_arrived_by_now` - `total_boarded_previously`.
    -   Logic for CTE row `n`:
        -   `total_passengers_available` = Count(`p.time <= bus_n.time`).
        -   `total_boarded_previous` = Sum(`boarded` of buses `1..n-1`). (Recursive sum).
        -   `waiting` = `total_passengers_available` - `total_boarded_previous`.
        -   `boarded` = `LEAST(capacity, waiting)`.
    -   Output: `bus_id`, `boarded`.

## Implementation Details
-   Recursive CTE.
-   Ordering `ROW_NUMBER()`.
