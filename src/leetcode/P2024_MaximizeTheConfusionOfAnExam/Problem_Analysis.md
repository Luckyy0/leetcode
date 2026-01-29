# Problem Analysis: Maximize the Confusion of an Exam

## Problem Description
String `answerKey` ('T', 'F'). `k` operations (flip T/F).
Maximize consecutive identical answers (all T or all F).

## Analysis

1.  **Sliding Window**:
    -   Two subproblems:
        1.  Maximize consecutive 'T's (flip at most k 'F's).
        2.  Maximize consecutive 'F's (flip at most k 'T's).
    -   Take max of both.
    -   Window `[L, R]`.
    -   Expand R. If `count(flip_target) > k`, shrink L.
    -   Max window size.

## Implementation Details
-   Helper function.
