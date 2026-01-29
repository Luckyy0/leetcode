# Problem Analysis: The Number of the Smallest Unoccupied Chair

## Problem Description
`times` array (`arrival`, `leaving`). Target friend `targetFriend` index.
Friends arrive, sit in smallest indexed empty chair.
When they leave, chair becomes empty.
Find chair number of `targetFriend`.

## Analysis

1.  **Event Processing**:
    -   Sort events by time.
    -   Events: `Arrive(friend_idx)`, `Leave(friend_idx)`.
    -   Need to process `Leave` before `Arrive` if times are same? "When a friend arrives... they sit". "When they leave...".
    -   Usually: Leavers vacate at `t`. Arrivers sit at `t`. Vacated chairs available.
    -   Maintain:
        -   `PrioQueue` of `emptyChairs` (min heap). Initially 0 to N.
        -   Map or Array mapping `friend_idx -> chair_occupied`.
        -   Map `leave_time -> List<friends>` or use Events.
        -   Events: `(time, type, friend_idx)`. Type: Leave should be processed before Arrive. So Leave type < Arrive type in sort.
    -   Since we only care about target, we can simulate until target arrives.
    -   Optimization: `times[i][0]` are distinct.
    
2.  **Implementation**:
    -   Events list.
    -   Sort.
    -   `PriorityQueue` available chairs.
    -   Since chairs are recycled, keep track max chair index used if PQ empty.

## Implementation Details
-   `PriorityQueue<Integer> available`.
-   `PriorityQueue<int[]> leaving` (time, chair). Or handle by sorting events.
-   Sorting events is easier. But matching arrival/departure is needed.
-   Store original index to identify target.
