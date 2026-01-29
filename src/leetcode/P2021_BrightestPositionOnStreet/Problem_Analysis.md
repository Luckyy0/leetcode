# Problem Analysis: Brightest Position on Street

## Problem Description
Lights at `position` with `range`. Light covers `[position - range, position + range]`.
Find position with max overlaps. Return smallest position if ties.

## Analysis

1.  **Line Sweep**:
    -   Intervals `[start, end]`.
    -   Events: `start` (+1), `end` (-1? No, `end + 1` is -1? Or handle closed intervals).
    -   Intervals `[p - r, p + r]`.
    -   Events: `p - r` type +1. `p + r + 1` type -1. (Or `p+r` with priority if closed).
    -   Sort events. Tie breaking: Process +1 before -1?
    -   Usually: To cover point `X`, interval `[S, E]` contributes if `S <= X <= E`.
    -   Event at `S`: `count++`.
    -   Event at `E`: `count` remains valid at E. Drops AFTER E.
    -   So event at `E+1`: `count--`.
    -   Wait. Coordinate range can be large. Use event points sorting.
    -   Iterate sorted events. `curr += type`. `max_brightness`.
    -   Tie breaking: If multiple events at same coordinate?
    -   Process all +1 before -1? No, logic depends on definition.
    -   With `E+1` logic, `E+1` is strictly greater than `S`.
    -   Events map `TreeMap<Integer, Integer>`. Key: pos, Val: delta.
    -   Accumulate.

## Implementation Details
-   `TreeMap` or List of Arrays sort.
