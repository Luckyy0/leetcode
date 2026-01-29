# Problem Analysis: Two Best Non-Overlapping Events

## Problem Description
Events `[start, end, value]`.
Pick at most 2 non-overlapping. Max value.
Overlapping: `end_1 >= start_2`. (Basically distinct if `end_1 < start_2`).
Wait, "non-overlapping events are events that do not intersect at any point".
Common edge allowed? "Intervals [s1, e1] and [s2, e2] are non-overlapping if e1 < s2 or e2 < s1". (Strict inequality?)
Usually standard definition.
Problem says: "start time ... end time. inclusive".
Usually max two.

## Analysis

1.  **Sorting + Max Suffix / TreeMap**:
    -   Sort events by `start`.
    -   For each event `i` (as first event):
        -   Value `v1`.
        -   We can pick a second event `j` such that `start[j] > end[i]`.
        -   We want max value among such valid `j`.
        -   Precompute `max_suffix[t]`: max value of event starting at or after `t`.
        -   We can do this by iterating backwards on sorted events.
        -   Or use `TreeMap<StartTime, MaxVal>`.
    -   Algorithm:
        -   Sort by `start`.
        -   `suffixMax[i]` = max value of events from index `i` to `n-1`.
        -   Iterate `i` (as first event).
        -   Find first index `j` where `start[j] > end[i]` using Binary Search.
        -   If found, `candidate = value[i] + suffixMax[j]`.
        -   Also consider picking just 1 event (handled by suffix logic: pick best single event).
        -   Result `max(candidate, best_single)`.
        
2.  **Implementation**:
    -   `Arrays.sort`.
    -   `suffixMax` array.
    -   `binarySearch`.

## Implementation Details
-   `suffixMax` int array.
