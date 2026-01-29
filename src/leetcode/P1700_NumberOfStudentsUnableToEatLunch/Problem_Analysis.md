# Problem Analysis: Number of Students Unable to Eat Lunch

## Problem Description
Circular sandwiches (0/1). Students (0/1).
Queue of students. Stack of sandwiches.
If student at front likes stack top, they take it and leave.
Else they go to back of queue.
Continues until no one can eat.

## Analysis

1.  **Count Based**:
    -   Order of students in queue doesn't matter for their preferences *distribution*. Any student who likes '0' can eventually reach the front if we cycle enough times, UNLESS the stack top requires '0' and there are NO '0' students left.
    -   So, count `students` preferences: `count0`, `count1`.
    -   Iterate `sandwiches`:
        -   If sandwich is `0`: check `count0`. If > 0, decrement. Else stop (nobody wants it).
        -   If sandwich is `1`: check `count1`. If > 0, decrement. Else stop.
    -   Remaining students = `count0 + count1`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Simple counters.
