# Problem Analysis: Sort Features by Popularity

## Problem Description
`features` array. `responses` array (strings with space-separated words).
Sort `features` by popularity (occurrences in responses) descending.
If tie, preserve original order.
Response counts feature at most once (set).

## Analysis

1.  **Count**:
    -   Map `feature -> count`.
    -   Iterate responses.
    -   For each response, split words, add to HashSet (deduplicate within response).
    -   Increment counts.
    -   Sort features.

2.  **Implementation**:
    -   `Map<String, Integer> count`.
    -   `Map<String, Integer> order`.
    -   Comparator: `b.count - a.count`, then `a.index - b.index`.

## Implementation Details
-   `Arrays.sort`.
