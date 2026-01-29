# Problem Analysis: Minimum Number of Operations to Make String Sorted

## Problem Description
Operations:
1. Find largest index `i` s.t. `s[i-1] < s[i]`.
2. Find largest index `j` s.t. `s[i-1] < s[j]`.
3. Swap `s[i-1], s[j]`.
4. Reverse suffix `s[i:]`.

This is exactly the "previous permutation" algorithm in reverse? Or finding next permutation?
Actually, the operation describes reversing the state to the previous lexicographical permutation.
`find largest i` such that `s[i-1] < s[i]` -> identifies the peak. This is "Next Permutation" step (usually `i-1` and `i` where `i` is break of descending suffix?).
Wait, `Next Permutation` looks for `s[i-1] < s[i]` where `s[i:]` is weakly decreasing.
The operation performs reverse of Next Permutation?
Actually, the question is: Count operations to make string sorted.
Sorted state is the *first* lexicographical permutation (e.g. "abc").
If the operations move us *backwards* in lexicographical order (to previous permutation), then the answer is literally the **Rank** of the permutation (0-indexed).
Yes, standard "Previous Permutation" steps:
Find `i` where `s[i-1] > s[i]`? No.
The description matches Next Permutation algorithm steps?
Reverse suffix?
Let's check:
"Make String Sorted". Sorted is min.
So likely we are reducing rank.
Yes, count how many permutations are strictly smaller than `s`.
Combinatorics.

## Analysis

1.  **Permutation Rank with Duplicates**:
    -   Length `n`.
    -   Iterate `i` from 0 to `n-1`.
    -   We want to count how many permutations start with a character smaller than `s[i]`.
    -   Let `c` be a char smaller than `s[i]` available in suffix `s[i:]`.
    -   If we pick `c` as first char of suffix, remaining `n-1-i` chars can form `(n-1-i)! / (freq!)` permutations.
    -   Sum this for all valid `c`.
    -   Update frequencies (remove `s[i]`).
    -   Formula:
        -   Total count += `sum(freq[c] where c < s[i]) * (remaining!) / (product of all freqs!)`.
    -   Optimization:
        -   `prod = (remaining!) / (product of all freqs!)`.
        -   The contribution is `count_smaller * prod`.
        -   But `prod` is basically `TotalPermutations / (n - i)`. No.
        -   `Rank(suffix)` formula:
            -   Term at `i`: `(Count of chars < s[i] in suffix) * Factorial(len-1) / (Product of Factorials of Counts in suffix)`.
    -   We need efficient updates for counts. Fenwick tree for `Count of chars < s[i]`?
        -   Alphabet size 26. Just loop 26.
    -   Modular Arithmetic Inverse for division.

2.  **Algorithm**:
    -   Calculate factorials.
    -   Frequency array for suffix (initially whole string).
    -   Iterate `i` from 0 to `n-1`.
    -   Calculate `combinations`.
    -   `term = smaller_count * fact[n - 1 - i] * modInverse(product_fact)`.
    -   Wait, we can maintain the denominator.
    -   Initially `denom = prod(freq[x]!)`.
    -   When moving from `i` to `i+1`, we remove `s[i]`.
    -   `freq[s[i]]` decreases.
    -   Denominator changes: divide by `old_count!`, multiply by `new_count!`.
    -   Since indices allow, just update modular inverse.

3.  **Complexity**:
    -   Precompute Factorials: $O(N)$.
    -   Loop N times. Inside loop 26 chars.
    -   Total $O(26N)$.
    -   Space $O(N)$.

## Implementation Details
-   `modPow` for inverse.
-   `long` for modulo ops. `10^9 + 7`.
