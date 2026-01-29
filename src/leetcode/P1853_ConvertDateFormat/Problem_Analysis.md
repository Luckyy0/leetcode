# Problem Analysis: Convert Date Format

## Problem Description
Table `Days` (day date).
Convert to "Day, Month Year". e.g. "Tuesday, April 12, 2022".
Wait, Example: "2022-04-12" -> "Tuesday, April 12, 2022".
Format `W, M D, Y`.
Wait, SQL DATE_FORMAT.
Format specifiers:
-   `%W`: Weekday name (Sunday..Saturday)
-   `%M`: Month name (January..December)
-   `%e`: Day of the month (numeric)
-   `%Y`: Year (4 digits)
-   String: "%W, %M %e, %Y".

## Analysis

1.  **DATE_FORMAT**:
    -   `DATE_FORMAT(day, "%W, %M %e, %Y")`.

## Implementation Details
-   SQL.
