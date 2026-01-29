# Problem Analysis: Average Height of Buildings in Each Segment

## Problem Description
Segments `[start, end)` with `height`.
Union all segments.
For each continuous interval where the set of covering segments is identical, calculate average height.
Merge adjacent intervals if average is same.
Return `[start, end, avg]`.

## Analysis

1.  **Line Sweep (Events)**:
    -   Events at `start` and `end`.
    -   `start`: count++, heightSum += h.
    -   `end`: count--, heightSum -= h.
    -   Sort events by coordinate.
    -   Iterate events. Between event `i` and `i+1`:
        -   If `count > 0`: `avg = sum / count`.
        -   Interval `[pos[i], pos[i+1])`.
        -   If `avg` same as previous interval and they touch, merge.
        -   Else add new.

## Implementation Details
-   `TreeMap<Integer, List<Integer>> events`. Key: pos, Val: list of +/- heights?
-   Actually we need both count and sum delta.
-   Just store deltaSum and deltaCount.
-   `TreeMap<Integer, int[]>`: `[0]` sum delta, `[1]` count delta.
