# Problem Analysis: Alert Using Same Key-Card Three or More Times in a One Hour Period

## Problem Description
Company workers use key-cards to unlock office doors. When a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an **alert** if any worker uses the key-card **three or more times** in a one-hour period.
You are given a list of strings `keyName` and `keyTime` where `[keyName[i], keyTime[i]]` corresponds to a person's name and the time the key-card was used **in a single day**. Access time represented as "HH:MM".
Return a list of unique worker names who received an alert for frequent keycard use. Sort the result in ascending order.

## Analysis

1.  **Parsing**:
    -   Convert "HH:MM" to minutes: $H \times 60 + M$.
    
2.  **Grouping**:
    -   Use a map: `Map<String, List<Integer>>` to group usage times by name.

3.  **Checking Alert**:
    -   For each worker, sort their usage times list.
    -   We need to find if there exist `i` such that `time[i+2] - time[i] <= 60`.
    -   This corresponds to usages `i`, `i+1`, `i+2`, and if `i+2` is within 60 mins of `i`, then we have 3 times in <= 60 mins.

4.  **Result**:
    -   Collect names, deduplicate (Set or implicit if processing per user), sort.

5.  **Complexity**:
    -   Time: $O(N \log N)$ (due to sorting of times for each user).
    -   Space: $O(N)$.

## Implementation Details
-   `TreeMap` to keep names sorted, or sort `ArrayList` of results at end.
-   Be careful parsing minutes.
