# Problem Analysis: Invalid Tweets

## Problem Description
Select `tweet_id` where content length > 15.

## Analysis

1.  **Query**:
    `SELECT tweet_id FROM Tweets WHERE CHAR_LENGTH(content) > 15`.
    Note: `LENGTH` returns bytes, `CHAR_LENGTH` returns characters. For standard ASCII/UTF8 usually safer to specific `CHAR_LENGTH` if instructions imply character count.

## Implementation Details
-   `CHAR_LENGTH`.
