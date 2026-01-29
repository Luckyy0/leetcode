# Problem Analysis: Minimum Deletions to Make Character Frequencies Unique

## Problem Description
A string `s` is called **good** if there are no two different characters in `s` that have the same frequency.
Given a string `s`, return the minimum number of characters you need to delete to make `s` good.
The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

## Analysis

1.  **Frequency Count**:
    -   Count occurences of each char a-z.
    
2.  **Greedy Adjustment**:
    -   Collect non-zero frequencies.
    -   Sort frequencies or use a HashSet to track used frequencies.
    -   Using HashSet:
        -   Iterate through each frequency `f`.
        -   While `f > 0` and `seen.contains(f)`:
            -   Decrement `f`.
            -   `deletions++`.
        -   If `f > 0`, add `f` to `seen`.
    -   Sorting approach (to optimize avoiding trying same collisions multiple times):
        -   Sort frequencies desc.
        -   Maintain `maxAllowed`.
        -   For each `f`:
            -   If `f >= maxAllowed`:
                -   Target = `max(0, maxAllowed - 1)`.
                -   Deletions += `f - Target`.
                -   `maxAllowed = Target`.
            -   Else:
                -   `maxAllowed = f`.

3.  **Complexity**:
    -   Time: $O(N)$ (to count) + $O(26 \log 26)$ (sort). Practically $O(N)$.
    -   Space: $O(1)$ (26 chars).

## Implementation Details
-   `freq` array.
-   Simple HashSet loop logic is clean.
