# Problem Analysis: Remove All Occurrences of a Substring

## Problem Description
String `s`, `part`.
Repeatedly remove leftmost occurrence of `part` from `s` until no longer present.

## Analysis

1.  **Iterative String Replacement**:
    -   While `s.contains(part)`: `s = s.replaceFirst(part, "")`.
    -   Since $N \le 1000$, $O(N^2)$ is acceptable.
    -   Java `String` is immutable, so this creates new strings. `StringBuilder` manipulation involves finding index and `delete`.

2.  **Stack Method (Optimization - Optional here)**:
    -   Iterate char by char. Push to stack.
    -   If matches last char of `part`, check stack top for full match.
    -   Pop if matched.
    -   This is $O(N \cdot M)$. Efficient.

3.  **Chosen Approach**:
    -   `StringBuilder` approach with `indexOf` loop is simple and fast enough for 1000.

## Implementation Details
-   `StringBuilder`.
