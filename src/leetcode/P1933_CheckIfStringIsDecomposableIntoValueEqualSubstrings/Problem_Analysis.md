# Problem Analysis: Check if String Is Decomposable Into Value-Equal Substrings

## Problem Description
String `s`.
Decomposable if it can be split into substrings `s1, s2, ... sn`.
Each `si` consists of ONLY one distinct character (e.g., "aaa", "bb").
Lengths of substrings: EXACTLY ONE substring has length 2. ALL OTHERS have length 3.
Return true/false.

## Analysis

1.  **Run Length Encoding**:
    -   Parse string into blocks of identical characters.
    -   Ex: "aaabbbaaccc" -> (a, 3), (b, 3), (a, 2), (c, 3).
    -   Check each run length `len`.
    -   We need `len % 3 == 0` for most.
    -   We need exactly one run where splitting gives one valid 2-length piece.
    -   Valid splits for length `L`:
        -   `L = 3k`: Standard.
        -   `L = 3k + 2`: Contains one length-2. (e.g. 2, 5, 8...).
        -   `L = 3k + 1`: Impossible to form from 3s and one 2?
            -   3k+1 -> 3(k-1) + 4? (2+2 is two 2s. Not allowed).
            -   Only ONE length-2 in TOTAL.
            -   So if a run has length `3k+1`, it requires TWO 2s (since $1 \equiv 2+2 \pmod 3$ or similar)?
            -   Wait. `1 = 4 = 2+2`. Two 2s. We are only allowed ONE 2 in the WHOLE decomposition.
            -   So if we encounter any run of form `3k+1`, it forces at least two 2s (or one 1 which is invalid). So `3k+1` is valid ONLY if we can't do it. Actually 1 is invalid (min length 2?).
            -   Value-equal substrings: "The substrings must be ... value-equal".
            -   Are lengths restricted to {2, 3}? "All others have length 3". "Exactly one has length 2".
            -   So every run must be decomposed into one 2 and multiple 3s, OR just multiple 3s.
            -   Run `L`.
            -   If `L % 3 == 0`: Only 3s. (0 '2's).
            -   If `L % 3 == 1`: Requires e.g. `2+2` or `1`. Neither fits "exactly one 2". It requires two 2s or invalid. So impossible. Immediate False.
                -   Wait. 1 is invalid? Implicitly yes, "substrings need to be value-equal", usually implies from the list {2, 3}.
                -   Constraint: "Exactly one substring of length 2". Others length 3.
                -   So we sum the number of 2s needed.
                -   If `L % 3 == 0`: 0 twos.
                -   If `L % 3 == 2`: 1 two. ($L = 3k + 2$).
                -   If `L % 3 == 1`: $L = 3(k-1) + 4 = 3(k-1) + 2 + 2$. 2 twos.
                -   Wait. $7 = 3+2+2$. Two 2s.
                -   Basically `L % 3 == 1` contributes > 1 twos.
                -   So if we see `L % 3 == 1`, return False.
            -   So we iterate runs. Count occurrences of `L % 3 == 2`.
            -   Must equal EXACTLY 1.

2.  **Implementation**:
    -   Loop through string. Count run lengths.
    -   Check conditions.

## Implementation Details
-   `twoCount`.
