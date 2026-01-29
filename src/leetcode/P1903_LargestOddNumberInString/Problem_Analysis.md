# Problem Analysis: Largest Odd Number in String

## Problem Description
String `num`.
Return largest-valued odd integer substring.

## Analysis

1.  **Suffix Scan**:
    -   An odd number must end with an odd digit.
    -   To maximize value, we want the substring to start as early as possible (at index 0).
    -   So, find the LAST odd digit at index `i`.
    -   Return `num.substring(0, i+1)`.
    -   If no odd digit, return "".

## Implementation Details
-   Loop backwards.
