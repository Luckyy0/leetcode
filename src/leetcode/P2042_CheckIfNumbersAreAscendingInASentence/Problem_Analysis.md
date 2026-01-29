# Problem Analysis: Check if Numbers Are Ascending in a Sentence

## Problem Description
String `s`. Words separated by spaces. Some words are numbers.
Check if numbers appear in strictly increasing order.

## Analysis

1.  **Parsing**:
    -   Split by space.
    -   Check if token is number.
    -   Keep `prev` number.
    -   If `curr <= prev`, return false.
    -   Update `prev`.

## Implementation Details
-   `split(" ")`.
-   `Integer.parseInt`.
-   `try-catch` or regex check for number. (Tokens are either valid numbers or words).
-   Constraint: numbers don't contain other chars.
