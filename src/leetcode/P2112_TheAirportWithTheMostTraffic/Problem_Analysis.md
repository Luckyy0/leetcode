# Problem Analysis: The Airport With the Most Traffic

## Problem Description
Table `Flights` (departure_airport, arrival_airport, flights_count).
Traffic = departures + arrivals.
Find airport(s) with max traffic.

## Analysis

1.  **Union + Aggregation**:
    -   Select `departure_airport` as id, `flights_count`.
    -   Union All
    -   Select `arrival_airport` as id, `flights_count`.
    -   Sum groupBy id.
    -   Find max.
    -   Return all matching max.

## Implementation Details
-   `WITH` CTE for total traffic.
-   `RANK()` or `MAX()`.
