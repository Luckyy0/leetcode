# Problem Analysis: Average Waiting Time

## Problem Description
Customers arrive at `customers[i][0]` and order takes `customers[i][1]`.
Chef prepares one by one.
Waiting time = finish time - arrival time.
Return average waiting time.

## Analysis

1.  **Simulation**:
    -   `currentTime` initialized to 0.
    -   Total wait time `totalWait` (long).
    -   Loop customers:
        -   `arrival = c[0]`, `time = c[1]`.
        -   Chef can start at `Math.max(currentTime, arrival)`.
        -   `finish = start + time`.
        -   `wait = finish - arrival`.
        -   `totalWait += wait`.
        -   `currentTime = finish`.
    
2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Use `double` for result.
