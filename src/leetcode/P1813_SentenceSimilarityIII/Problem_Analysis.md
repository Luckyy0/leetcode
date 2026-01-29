# Problem Analysis: Sentence Similarity III

## Problem Description
Two sentences `sentence1`, `sentence2`.
Check if one can be constructed by inserting a sentence into the other.
Inserting means appending to start, end, or in between words.
Essentially: `shorter` matches a prefix and a suffix of `longer`.

## Analysis

1.  **Deque / Pointers**:
    -   Split sentences into word arrays.
    -   Identify shorter and longer arrays.
    -   Match words from the start (prefix match). Points `l` increments.
    -   Match words from the end (suffix match). Points `r` decrements.
    -   Valid condition: `prefix_matches + suffix_matches >= length_of_shorter`.
    -   Specifically, the unmatched middle part of the longer sentence corresponds to the insertion. The shorter sentence must be fully covered by the prefix and suffix matches.
    -   Indices:
        -   `l` matches from 0. `while words1[l] == words2[l]`...
        -   `r` matches from ends. `while words1[end1] == words2[end2]`...
        -   But must ensure `l` and `r` don't cross in a way that counts words twice in "shorter".
        -   Actually, simpler condition: After matching max prefix and max suffix, the remaining part of the shorter sentence must be empty.

2.  **Implementation**:
    -   `String[] w1, w2`.
    -   `l` count prefix match.
    -   `r` count suffix match.
    -   Must handle overlapping case carefully?
    -   Look at shorter length `n1`.
    -   `while (l < n1 && w1[l].equals(w2[l])) l++;`
    -   `while (r < n1 && w1[n1-1-r].equals(w2[n2-1-r])) r++;` (Check bounds and overlap).
    -   Wait, if `l` covers the whole string, return true.
    -   If we match from right, we must ensure we don't match indices already matched by `l`.
    -   Simpler: Use Deques for both. Pop front while equal. Pop back while equal. One deque should be empty.

## Implementation Details
-   Split. Use Deque or just range pointers.
