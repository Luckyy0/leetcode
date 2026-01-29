# Problem Analysis: Delete Characters to Make Fancy String

## Problem Description
String `s`. Fancy if no three consecutive chars are equal.
Delete minimum characters.

## Analysis

1.  **Iterative Construction**:
    -   Iterate char `c`. Make `StringBuilder`.
    -   If `c` equals last char AND last char equals second last char: Skip.
    -   Else append.

## Implementation Details
-   `StringBuilder`.
