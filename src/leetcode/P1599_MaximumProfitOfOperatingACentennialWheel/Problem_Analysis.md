# Problem Analysis: Maximum Profit of Operating a Centennial Wheel

## Problem Description
A Centennial Wheel has 4 gondolas, each can hold up to 4 people.
You are given an array `customers` where `customers[i]` is the number of new customers arriving just before the `i-th` rotation.
You are given `boardingCost` (profit per customer) and `runningCost` (cost per rotation).
Return the minimum number of rotations to maximize profit. If max profit is negative, return -1.

## Analysis

1.  **Simulation**:
    -   Keep track of `waitingCustomers`.
    -   Iterate through rotations `i = 0, 1, ...`
    -   At start of rotation `i`:
        -   If `i < customers.length`, add `customers[i]` to `waitingCustomers`.
    -   Board up to 4 customers: `board = min(4, waitingCustomers)`.
    -   `waitingCustomers -= board`.
    -   `currentProfit += board * boardingCost - runningCost`.
    -   If `currentProfit > maxProfit`, update `maxProfit` and `bestRotation`.
    -   Stop when `waitingCustomers == 0` AND no more incoming customers.

2.  **Edge Cases**:
    -   If profit never becomes positive, return -1.
    -   Can stop immediately if no customers.

3.  **Complexity**:
    -   Time: $O(N + \text{Remaining/4})$. Linear in total customers.
    -   Space: $O(1)$.

## Implementation Details
-   Track best rotation (1-indexed).
