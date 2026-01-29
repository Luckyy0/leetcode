# Problem Analysis: Minimum Non-Zero Product of the Array Elements

## Problem Description
`p`. Range `[1, 2^p - 1]`.
Swap bits between any two numbers.
Minimize product of array elements.
Product must be non-zero (so no element can be 0).
Actually "You can swap any corresponding bit... Min product".
Basically we can change the numbers freely as long as column bit counts are preserved.
Greedy strategy to min product:
Maximize the difference between numbers. Make some numbers 1, others large?
We cannot make 0. Minimum non-zero is 1.
Total range is $1 \dots 2^p-1$.
Largest value possible is $2^p-1$ (all 1s). It exists.
We want to pair small `1` with large `2^p-2`.
Actually, notice sum is constant? No, bit swaps preserve column counts, implies SUM is constant? Yes. `Sum(val) = Sum(Sum(bits * 2^k))`.
To minimize product with constant sum: Make elements as far apart as possible.
We have values $1 \dots 2^p-1$.
The largest value is $MAX = 2^p-1$. Keep it (can't make it larger).
The pair logic: $a, b \to 1, a+b-1$?
We can pair $(x, \bar{x})$ (complement).
Usually we can transform pairs to $(1, x+\bar{x}-1) = (1, MAX-1)$.
We have $2^{p-1}-1$ pairs of $(x, \bar{x})$ excluding $MAX$.
Wait, range size $2^p-1$. There is one single $MAX$.
Rest split into pairs summing to $MAX$.
Example `p=3`. Range 1..7.
7. Pairs: (1,6), (2,5), (3,4).
Transform (2,5) -> (1, 6).
Transform (3,4) -> (1, 6).
Result: 1, 1, 1, 6, 6, 6, 7.
Product: $1^3 \times 6^3 \times 7$.
Formula: $MAX = 2^p-1$. Pair count $K = 2^{p-1}-1$.
Ans: $(MAX-1)^K \times MAX \pmod{10^9+7}$.

## Analysis

1.  **Formula**:
    -   $N = 2^p$.
    -   $MAX = N - 1$.
    -   $CNT = (N - 2) / 2$.
    -   Result: $(MAX-1)^{CNT} \times MAX$.

## Implementation Details
-   Modular exponentiation.
-   `long`.
