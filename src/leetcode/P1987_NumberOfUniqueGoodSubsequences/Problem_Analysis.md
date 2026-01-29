# Problem Analysis: Number of Unique Good Subsequences

## Problem Description
Binary string `binary`.
Good subsequence:
-   Is non-empty.
-   Does not have leading zeros (except "0" itself).
Count unique good subsequences mod $10^9 + 7$.

## Analysis

1.  **DP**:
    -   `dp0`: Count of unique subsequences ending with '0'.
    -   `dp1`: Count of unique subsequences ending with '1'.
    -   Transitions:
        -   If char is '0': We can append '0' to any existing subsequence.
        -   New subsequences ending in '0': `dp0_new = dp0 + dp1`.
        -   Wait. We append '0' to all existing unique subsequences.
        -   Total unique ending in '0' becomes `(dp0 + dp1) + 1`?
        -   Usually: `dp0 = dp0 + dp1`. But is '0' alone counted?
        -   Logic:
            -   Initially 0.
            -   Found '1': `dp1 = dp0 + dp1 + 1` (append to existing, plus new "1").
            -   Found '0': `dp0 = dp0 + dp1` (append to existing; "0" handled separately?).
            -   Usually: `dp[k]` count of unique subseq ending in digit `k`.
            -   If `x == 1`: `dp[1] = dp[0] + dp[1] + 1` (The +1 is for the subsequence "1").
            -   If `x == 0`: `dp[0] = dp[0] + dp[1]` (We don't add +1 because "0" with leading zero is not good? Wait).
            -   The problem says "No leading zeros except '0'".
            -   If we form "1...0", valid.
            -   If we form "0...0", invalid (leading zero).
            -   So effectively, we only count subsequences starting with '1'.
            -   Plus the single subsequence "0" if '0' exists in string.
            -   So let `dp0`, `dp1` count subsequences starting with '1'.
            -   If `x == 1`: `dp[1] = dp[0] + dp[1] + 1` (Append '1' to valid ones, plus start new "1").
            -   If `x == 0`: `dp[0] = dp[0] + dp[1]` (Append '0' to valid starting with '1'). "0" alone is not counted here because it doesn't start with '1'.
            -   Result: `dp0 + dp1 + (hasZero ? 1 : 0)`.

## Implementation Details
-   `hasZero` flag.
-   Modulo.
