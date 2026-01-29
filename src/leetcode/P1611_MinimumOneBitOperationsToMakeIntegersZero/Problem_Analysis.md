# Problem Analysis: Minimum One Bit Operations to Make Integers Zero

## Problem Description
Given an integer `n`, you must transform it into `0` using the following operations any number of times:
1.  Change the rightmost ($0^{th}$) bit in the binary representation of `n`.
2.  Change the $i^{th}$ bit in the binary representation of `n` if the $(i-1)^{th}$ bit is set to `1` and the $(i-2)^{th}$ through $0^{th}$ bits are set to `0`.

Return the minimum number of operations to transform `n` into `0`.

## Analysis

1.  **Relation to Gray Code**:
    -   The operations described are exactly the transitions allowed in Gray Codes.
    -   In Gray Code sequence $G(k)$, adjacent elements differ by exactly one bit according to these rules.
    -   Problem asks to find the index of `n` in the Gray Code sequence if $G(0) = 0$.
    -   Essentially converting Gray Code to Binary (inverse Gray Code).

2.  **Recursive Formula**:
    -   Let `f(n)` be the cost to turn `n` to `0`.
    -   Consider the most significant bit $k$ ($2^k \le n < 2^{k+1}$).
    -   To turn the $k$-th bit to 0, we must first reach state $2^{k-1}$ (i.e., $100\dots0$ in positions $k-1 \dots 0$). Wait.
    -   The rule says we can flip bit $k$ if bit $k-1$ is 1 and others 0.
    -   So to flip bit $k$ (which is 1) to 0, we need the lower bits to be exactly $2^{k-1}$ ($100\dots0$).
    -   Then we flip bit $k$: $110\dots0 \to 010\dots0$.
    -   Then we need to turn $2^{k-1}$ to 0.
    -   This recursive definition is slightly complex because we need to go *to* $2^{k-1}$ from current lower bits.
    -   Alternative Observation: The cost to turn $2^k$ to 0 is $2^{k+1} - 1$.
    -   To turn `n` (which has bit $k$) to 0:
        -   First, we ignore bit $k$ and consider the rest: $n' = n - 2^k$.
        -   It costs `f(n')` to turn $n'$ to 0.
        -   However, we actually want to turn $n'$ to $2^{k-1}$?
        -   Let's check the property: $f(n) = (2^{k+1} - 1) - f(n \oplus 2^k)$.
        -   Example: `n=3` (11). $k=1$. $f(3) = (2^2 - 1) - f(3-2) = 3 - f(1)$.
            -   $f(1) = 1$. So $f(3) = 2$.
            -   Ops: 11 -> 01 -> 00 (wait). Rules: 11 -> 10 (flip 0th) -> 11?
            -   Rule 2 on 11: bit 1 is 1, bit 0 is 1. Flip bit 1 requires bit 0=1. 11->01. Correct.
            -   Then 01->00. Total 2. Correct.
        -   Example: `n=6` (110). $k=2$.
            -   $f(6) = (2^3-1) - f(6-4) = 7 - f(2)$.
            -   $f(2)=10_2$. $k=1$. $f(2) = (4-1) - f(0) = 3$.
            -   So $f(6) = 7 - 3 = 4$.
    -   This formula works perfectly.

3.  **Algorithm**:
    -   Recursively apply $f(n) = (2^{k+1} - 1) - f(n \oplus 2^k)$ where $2^k$ is the MSB of $n$.
    -   Base case: $f(0) = 0$.

4.  **Complexity**:
    -   Time: $O(\log n)$ (number of bits).
    -   Space: $O(\log n)$ recursion stack.

## Implementation Details
-   MSB calculation.
