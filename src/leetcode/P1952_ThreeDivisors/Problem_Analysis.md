# Problem Analysis: Three Divisors

## Problem Description
Int `n`. Check if `n` has exactly 3 positive divisors.

## Analysis

1.  **Properties**:
    -   A number has exactly 3 divisors iff it is the square of a prime number.
    -   Divisors: 1, p, p^2.
    -   Algorithm:
        -   `root = sqrt(n)`.
        -   If `root * root != n`, return false.
        -   Check if `root` is prime.

2.  **Implementation**:
    -   `isPrime` helper.
    -   Edge case: n=1 (1 divisor). n=4 (1, 2, 4 - ok).

## Implementation Details
-   `isPrime`.
