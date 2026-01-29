# Problem Analysis: Seat Reservation Manager

## Problem Description
Manage `n` seats 1 to `n`.
`reserve()`: fetch smallest-numbered unreserved seat.
`unreserve(seatNumber)`: add back seat.

## Analysis

1.  **Min-Heap**:
    -   Initially all seats 1 to `n` are available.
    -   But `n` can be large ($10^5$).
    -   However, we only need to store *unreserved* seats that were previously reserved?
    -   Actually, we track the boundary of conceptual available seats?
    -   Approach 1: `nextAvailable` counter. Min-Heap stores `unreserved` seats (holes).
    -   If heap not empty, pop smallest. Else use `nextAvailable++`.
    -   `unreserve`: push to heap.
    -   Complexity: `reserve` O(log K) or O(1). `unreserve` O(log K).

2.  **Implementation**:
    -   `PriorityQueue`.
    -   `nextSeat` int.

## Implementation Details
-   `nextSeat = 1`.
-   `pq` for returned seats.
