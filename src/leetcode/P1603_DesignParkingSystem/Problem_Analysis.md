# Problem Analysis: Design Parking System

## Problem Description
Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the `ParkingSystem` class:
-   `ParkingSystem(int big, int medium, int small)`
-   `bool addCar(int carType)` Checks whether there is a parking space of `carType` for the car that wants to get into the parking lot. `carType` can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. Return `true` if there is space available, else `false`.

## Analysis

1.  **State**:
    -   Store remaining capacities for Big, Medium, Small.
    -   Use an array `count` of size 4 (1-indexed for convenience).

2.  **Logic**:
    -   `addCar(type)`:
        -   If `count[type] > 0`, decrement and return `true`.
        -   Else return `false`.

3.  **Complexity**:
    -   Time: $O(1)$.
    -   Space: $O(1)$.

## Implementation Details
-   Array `slots`.
