# Problem Analysis: Maximum Average Pass Ratio

## Problem Description
Classes `classes[i] = [pass, total]`.
`extraStudents` to assign. Each adds to pass and total.
Maximize average pass ratio of all classes.

## Analysis

1.  **Greedy with Heap**:
    -   Average pass ratio = sum(pass/total) / N.
    -   Maximize sum(pass/total).
    -   We add 1 student at a time. Pick the class that gives maximum *increase* (gain) in ratio.
    -   Gain `G(p, t) = (p+1)/(t+1) - p/t`.
    -   Use Max Heap storing `(gain, pass, total)`.
    -   Extract max, add student, recompute gain, push back.
    -   Repeat `extraStudents` times.

## Implementation Details
-   PriorityQueue.
-   Double calculations.
