# Problem Analysis: Unique Substrings With Equal Digit Frequency

## Problem Description
Count unique substrings where all digits in substring have same frequency.

## Analysis

1.  **Brute Force with Set**:
    -   Iterate start `i`.
    -   Iterate end `j`.
    -   Update counts array.
    -   Check condition.
    -   Add to Set.
    -   Constraint `N=1000`. $N^2 = 10^6$. Set ops string hashing... feasible?
    -   Average length 500. $500 * 10^6$ ops is high.
    -   Wait. $10^9$ ops is TLE.
    -   Rolling Hash for set insertion?
    -   Actually distinct substrings usually not too many. But can be $N^2$.
    -   We can check "Same Frequency" quickly.
    -   Using a Trie? Or just `Set<String>`.
    -   Java `substring` creates new String. Total characters in all substrings $\sum L \approx N^3/6$. $10^9/6 \approx 1.6 \cdot 10^8$. Might be slow.
    -   Optimization: Use Rolling Hash for unique check.
    -   Generate Hash for `s[i..j]`. Store `Long` hash in set. If conflict, check?
    -   Use double hash or standard 64-bit sufficient for LC?
    -   Or simply `Set<String>` passes if test cases weak?
    -   Standard solution for N=1000 is usually $O(N^2)$ with simple check.
    -   Check validity: maintain `maxFreq`, count of digits with `maxFreq`.
    -   If `cnt_of_digits * maxFreq == length`, valid.

## Implementation Details
-   `Set<String>`.
-   Outer `i`, Inner `j`.
-   `counts` array.
-   Check logic.
