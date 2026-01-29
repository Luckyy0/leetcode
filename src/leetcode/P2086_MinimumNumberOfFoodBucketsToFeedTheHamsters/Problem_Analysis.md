# Problem Analysis: Minimum Number of Food Buckets to Feed the Hamsters

## Problem Description
String `hamsters` ('.' empty, 'H' hamster).
Bucket in '.' feeds adjacent 'H's (left and right).
Min buckets. -1 if impossible (H has no neighbours).

## Analysis

1.  **Greedy**:
    -   Iterate left to right.
    -   If `s[i] == 'H'` and not fed:
        -   Try to place bucket at `i+1` (right) if possible (s[i+1] == '.').
            -   This is better because it might feed `i+2` (if H).
            -   If placed at `i+1`, mark `i` and `i+2` as fed.
        -   If right not possible, place at `i-1` (left).
            -   Must be `s[i-1] == '.'`.
            -   If not possible, impossible (-1).
            -   Mark `i` as fed.
    -   Track `fed` status? Or modify string/array.
    -   Important: If we placed at `i-1` for current `H`, it means `i-1` was a bucket.
    -   Wait. If `H` at `i`. If `i-1` HAS A BUCKET, we are already fed. Skip.
    -   Sequence:
        -   Loop `i`.
        -   If `s[i] == 'H'`:
            -   If already fed (e.g. `i-1` was bucket placed previously), continue.
            -   Try place at `i+1`: if valid (`i+1` in bounds, is `.`), place bucket.
                -   This bucket feeds `i` and potentially `i+2`.
                -   Record `bucket_at = i+1`.
            -   Else try place at `i-1`: if valid, place.
                -   Record `bucket_at = i-1`.
            -   Else return -1.
    -   Wait. How to track?
    -   Use `lastBucketPos`.
    -   For `H` at `i`:
        -   If `lastBucketPos == i - 1`: already fed. Skip.
        -   Else place bucket.
            -   Prioritize right (`i+1`).
                -   If `i+1 < n` and `s[i+1] == '.'`:
                    -   Place at `i+1`. `lastBucketPos = i+1`. `ans++`.
                -   Else check left (`i-1`).
                    -   If `i-1 >= 0` and `s[i-1] == '.'`:
                        -   Place at `i-1`. `lastBucketPos = i-1`. `ans++`.
                    -   Else fail.

## Implementation Details
-   `lastBucketPos = -2`.
-   Loop.
