# Problem Analysis: Finding the Topic of Each Post

## Problem Description
Tables `Posts` (post_id, content), `Keywords` (topic_id, word).
Post has topic if it contains word (case insensitive).
Concatenate topics (distinct, ordered by id). 'Ambiguous!' if no topic.

## Analysis

1.  **String Matching**:
    -   Join Posts and Kywords.
    -   Condition: `INSTR(CONCAT(' ', LOWER(p.content), ' '), CONCAT(' ', LOWER(k.word), ' ')) > 0`.
    -   Or regex/like.
    -   Group by post. `GROUP_CONCAT` topic_id.

## Implementation Details
-   `GROUP_CONCAT`.
-   `COALESCE`.
-   Handling "no topic".
