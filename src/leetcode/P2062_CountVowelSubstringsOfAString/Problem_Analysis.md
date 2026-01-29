# Problem Analysis: Count Vowel Substrings of a String

## Problem Description
String `word`.
Vowel substring: Contains **only** vowels ('a', 'e', 'i', 'o', 'u') AND contains **all five** vowels.
Count them.

## Analysis

1.  **Sliding Window / Two Pointers**:
    -   Iterate `start`.
    -   Expand `end`.
    -   Check if chars are vowels. If consonant, break (substring invalid).
    -   Maintain set of vowels seen.
    -   If set size is 5, increment count.
    -   Optimization?
        -   Can be $O(N^2)$ for small N. Given constraints usually small?
        -   If N large ($10^5$), need $O(N)$.
        -   Usually "Count Subarrays with exact K distinct" logic.
        -   Here "All 5 vowels".
        -   Split string by consonants. Process each only-vowel segment.
        -   For a segment: Count "substrings strictly containing all 5".
        -   Use sliding window `AtLeastK(5)`. Substrings with >= 5 distinct. (Actually here exactly 5).
        -   For vowel segment:
            -   Count subarrays with 5 distinct chars.
            -   Map `count`.
            -   `atLeast5` - `atLeast6`? (No, max 5 vowels).
            -   Wait. Substring must have size at least 5.
            -   Sliding window: `[L, R]`.
            -   For each `R`: find smallest `L` such that `s[L...R]` has all 5.
            -   Then all valid `start` indices are `segment_start` to `L`.
            -   So valid substrings ending at `R` is `L - segment_start + 1`.
            -   Logic:
                -   Iterate `R`. Add `s[R]` to map.
                -   While `s[L...R]` valid (all 5 present), increment L. (Actually finding largest L such that `s[L...R]` valid? No).
                -   Finding *smallest* window? No.
                -   Valid starts: `start0, start1 ... L`.
                -   Actually if `s[i...R]` is valid (all 5), then `s[i-1...R]` is valid (if i-1 is in segment).
                -   So we want to find the largest index `k` such that `s[k...R]` has all 5.
                -   Then valid starts are `segment_start` ... `k`.
                -   Wait. No. The substring must ONLY contain vowels. We are inside a vowel segment.
                -   So `s[segment_start ... R]` is all vowels.
                -   If `s[k...R]` has all 5, any `j <= k` within segment implies `s[j...R]` has all 5.
                -   So count += `k - segment_start + 1`.
                -   We need to maintain `k`.
                -   `k` is the rightmost start index such that window has all 5.
                -   Actually, simpler: maintain a window `[k, R]` that has all 5. Since we want max `k`.
                -   We shrink from left while valid?
                -   Actually we shrink from left *until* invalid.
                -   Wait. If we shrink until invalid, the last VALID start was `L`.
                -   So `L` (just before becoming invalid) is the max start index.
                -   So while `map` has 5 and `count[s[L]] > 1`: remove `s[L]`, L++.
                -   Wait, we can remove until we hit count 1? That makes it minimal valid window ending at R.
                -   Let minimal valid start be `L_opt`.
                -   Then any `j` in `[segment_start, L_opt]` is valid start.
                -   So add `L_opt - segment_start + 1`.

## Implementation Details
-   `Map<Character, Integer>`.
-   Handle segments separated by consonants.
