# Problem Analysis: Find Substring With Given Hash Value

## Problem Description
String `s`, `power`, `modulo`, `k`, `hashValue`.
Hash function: $H(s, p, m) = (\sum_{i=0}^{k-1} val(s[i]) \cdot p^i) \mod m$.
Find the **first** substring of length `k` with hash equal to `hashValue`.

## Analysis

1.  **Reverse Sliding Window (Rolling Hash)**:
    -   The hash formula uses increasing powers of `p` from index 0 to `k-1` (relative to substring).
    -   Window moves from Left to Right.
        -   Current: $s[i] \cdot p^0 + s[i+1] \cdot p^1 + \dots$
        -   Next: $s[i+1] \cdot p^0 + s[i+2] \cdot p^1 + \dots$
        -   Relation: $H_{next} = (H_{curr} - s[i]) \cdot p^{-1} + s[i+k] \cdot p^{k-1}$.
        -   Requires modular inverse of `p` modulo `m`. `m` is not necessarily prime, so inverse might not exist.
    -   Alternative: **Right to Left**.
        -   Window ending at `j` (indices `j-k+1` to `j`).
        -   Move to `j-1` (indices `j-k` to `j-1`).
        -   Current (at `j-k+1`): $val(s[j-k+1]) \cdot p^0 + \dots + val(s[j]) \cdot p^{k-1}$.
        -   Previous (at `j-k`): $val(s[j-k]) \cdot p^0 + val(s[j-k+1]) \cdot p^1 + \dots + val(s[j-1]) \cdot p^{k-1}$.
        -   Notice $H_{prev} = val(s[j-k]) + p \cdot (val(s[j-k+1]) \cdot p^0 + \dots + val(s[j-1]) \cdot p^{k-2})$.
        -   Wait. If we take $H_{curr}$ (window `j-k+1` to `j`), remove `s[j]`:
            -   $H' = H_{curr} - s[j] \cdot p^{k-1}$.
            -   This represents $s[j-k+1] \cdot p^0 + \dots + s[j-1] \cdot p^{k-2}$.
            -   Then $H_{prev} = s[j-k] + H' \cdot p$.
        -   Relationship:
            -   $H_{new} = (H_{old} \times p + val(s[added\_char]) - val(s[removed\_char]) \times p^k) \mod m$.
            -   Wait.
            -   Let's trace:
                -   Old (indices `i+1` to `i+k`): $h = s[i+1]p^0 + \dots + s[i+k]p^{k-1}$.
                -   New (indices `i` to `i+k-1`): $h' = s[i]p^0 + s[i+1]p^1 + \dots + s[i+k-1]p^{k-1}$.
                -   $h' = s[i] + p \times (s[i+1]p^0 + \dots + s[i+k-1]p^{k-2})$.
                -   Note that the term inside parenthesis is NOT exactly `h`.
                -   `h` has an extra term $s[i+k]p^{k-1}$.
                -   So, Term = $h - s[i+k]p^{k-1}$.
                -   Usually we perform calculation modulo m.
                -   $h' = (s[i] + p \times (h - s[i+k] \cdot p^{k-1})) \mod m$.
                -   $h' = (s[i] + h \cdot p - s[i+k] \cdot p^k) \mod m$.
        -   This allows calculating hash of window `i` using window `i+1`.
        -   So we iterate from $n-1$ down to 0.
        -   We maintain hash of current window of length `k`.
        -   When we reach index 0, we have checked all windows.
        -   Since we want the **first** substring (smallest index), traversing R->L allows us to update `resultIndex` every time we find a match. The last match found (which is the one with smallest index) is the answer.

## Implementation Details
-   `long` for hash arithmetic to avoid overflow before modulo.
-   Precompute $p^{k-1}$ or $p^k$.
-   Loop `i` from `n-1` down to `0`.
-   Maintain window. Fill initially? No, easier to just add characters and when count >= k remove the tail.
-   Be careful with negative modulo results in Java (`%` can return negative). Add `m` before taking mod.
