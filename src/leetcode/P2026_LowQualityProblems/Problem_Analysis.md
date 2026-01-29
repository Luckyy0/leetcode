# Problem Analysis: Low Quality Problems

## Problem Description
Table `Problems` (problem_id, likes, dislikes).
Low quality if `likes / (likes + dislikes) < 0.6`.
Return problem_id ordered ascending.

## Analysis

1.  **Calculation and Filtering**:
    -   `likes / (likes + dislikes) < 0.6`.
    -   Or `likes < 0.6 * (likes + dislikes)`.
    -   Or `likes * 10 < 6 * (likes + dislikes)`.
    -   Avoid division by zero (desc says likes + dislikes > 0?). If not, handle. Usually "total votes positive".

## Implementation Details
-   SQL.
