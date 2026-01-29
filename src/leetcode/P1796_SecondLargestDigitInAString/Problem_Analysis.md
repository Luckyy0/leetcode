# Problem Analysis: Second Largest Digit in a String

## Problem Description
String `s`. Find second largest numerical digit. If none, return -1.

## Analysis

1.  **Set/Filter**:
    -   Parse string, extract digits.
    -   Store in Set (unique).
    -   Return 2nd largest.

2.  **Implementation**:
    -   Iterate char. If digit, add to set.
    -   Check set size.

## Implementation Details
-   `Set<Integer>`.
