# Problem Analysis: Count Apples

## Problem Description
Tables `Boxes` (box_id, chest_id, apple_count, orange_count) and `Chests` (chest_id, apple_count, orange_count).
A box may contain a chest (`chest_id` is key).
Calculate total apples and oranges.

## Analysis

1.  **Join and Sum**:
    -   Left Join `Boxes` with `Chests`.
    -   Sum `box.apple + chest.apple`.
    -   Handle nulls.

## Implementation Details
-   `IFNULL` or `COALESCE`.
