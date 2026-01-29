# Problem Analysis: Number of Visible People in a Queue

## Problem Description
Queue `heights` (right to left? "0 is front").
Person `i` can see `j` if `i < j` and `min(heights[i+1...j-1]) < heights[j]`. (Actually everyone strictly between must be shorter than BOTH i and j? No).
Constraint: `min(heights[i+1...j-1]) < min(heights[i], heights[j])`.
Wait, simpler rule:
Person `i` looks to the right. They see `j` if everyone between `i` and `j` is shorter than `heights[j]`.
Usually this means `j` is the next person taller or equal? Or sequence of increasing heights?
Specifically: `i` looks right. They see the first person taller than `i`, plus everyone in between who was not blocked by someone taller in between.
Logic:
Monotonic Stack.
Iterate from right to left (n-1 to 0).
Maintain a stack of people visible to the left (which is "right" in iteration direction).
Stack stores indices/heights of people to the right that are potential blockers.
Stack elements are sorted increasing height (top is smallest).
When processing `i`:
-   Pop elements from stack that are smaller than `heights[i]`. These are visible to `i`.
-   If stack not empty after popping, the stack top (which is > `i`) is also visible (the first taller person).
-   `count = popped_count + (stack not empty ? 1 : 0)`.
-   Push `i` to stack.

Rationale:
-   Elements smaller than `i` are visible because no one between `i` and them blocks (since we process right to left, we've essentially handled closer ones).
-   Actually, `i` sees a sequence of increasing heights `h1, h2, ...` to the right until `hk >= heights[i]`.
-   Those `h1...` are exactly the elements we pop (since they are smaller). `hk` is the one remaining on stack.
-   Correct.

## Implementation Details
-   Monotonic Stack.
-   Loop right to left.
