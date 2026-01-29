# Problem Analysis: Fix Names in a Table

## Problem Description
Table `Users` (user_id, name).
Fix names so that only the first character is uppercase and the rest are lowercase.
Return result ordered by `user_id`.

## Analysis

1.  **String Functions**:
    -   `LEFT(name, 1)` or `SUBSTRING(name, 1, 1)`.
    -   `RIGHT(name, LENGTH(name)-1)` or `SUBSTRING(name, 2)`.
    -   `UPPER`, `LOWER`.
    -   `CONCAT`.

2.  **Query**:
    ```sql
    SELECT 
        user_id, 
        CONCAT(
            UPPER(SUBSTR(name, 1, 1)), 
            LOWER(SUBSTR(name, 2))
        ) AS name
    FROM Users
    ORDER BY user_id;
    ```

## Implementation Details
-   Standard SQL.
