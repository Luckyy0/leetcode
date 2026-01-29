# Problem Analysis: Time Needed to Buy Tickets

## Problem Description
Array `tickets`. Person `k`.
Line processes 1 ticket per second per person in order.
Time for person `k` to finish.

## Analysis

1.  **Simulation / Math**:
    -   Person `k` needs `tickets[k]`.
    -   Everyone before `k` (index `i < k`): buys `min(tickets[i], tickets[k])`.
    -   Everyone after `k` (index `i > k`): buys `min(tickets[i], tickets[k] - 1)`.
        -   Because when `k` finishes, queue stops immediately. People after `k` didn't get chance for last round.
    -   Sum these up.

## Implementation Details
-   Loop `i` from 0 to n.
