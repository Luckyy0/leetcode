# Problem Analysis: Maximize Number of Nice Divisors

## Problem Description
`primeFactors`.
Product of nice divisors. Modulo 10^9+7.
Nice divisor: divisible by same prime factors? No.
"A positive integer n is called nice if it is divisible by every prime factor of itself."
"You are given ... primeFactors. Construct n having exactly `primeFactors` prime factors (counting multiplicity)."
"Maximize the number of nice divisors of n."

Rephrase:
We have `sum(a_i) = primeFactors` where `n = p1^a1 * p2^a2 ...`.
Number of nice divisors?
Definition: Divisible by every prime factor.
So divisor `d = p1^b1 * ...` must have `b1 >= 1` if `p1` is a factor?
Wait. "Divisible by every prime factor of itself".
Wait, `d` itself has prime factors. If `d` has factor `p`, then `d` must be divisible by `p`. This is trivial.
Wait, "divisible by every prime factor of n".
Ah. `n` has prime factors `p1...pk`. `d` is nice if `d % p1 == 0` AND ... AND `d % pk == 0`.
So `d` must be a multiple of `p1 * p2 * ... * pk`.
Number of nice divisors is total divisors of `n / (p1*...*pk)`.
`n = p1^a1 ...`. `rad(n) = p1...`.
`n/rad(n) = p1^(a1-1) * ...`.
Number of divisors of `m = p1^(a1-1)...` is `(a1-1+1) * (a2-1+1)... = a1 * a2 * ...`.
So we need to maximize `product(a_i)` subject to `sum(a_i) = primeFactors`.
This is a classic problem: maximize product of integers summing to `S`.
Break `S` into as many 3s as possible.
If remainder 1, use 2+2 (because 4 > 3*1 and 2*2 > 3*1? No, 4 = 2+2, 4 > 3). Actually 4 vs 3+1 -> 4.
If remainder 2, use 2.
Standard `integer break` logic. `3`s are optimal.

1.  **Algorithm**:
    -   If `primeFactors <= 4`: return `primeFactors` (except 1 -> 1? Wait, sum ai = 1 -> product 1. Yes).
    -   Actually `primeFactors <= 3` is just `primeFactors`.
    -   Quotient `q = N / 3`, Rem `r = N % 3`.
    -   If `r == 0`: result `3^q`.
    -   If `r == 1`: result `3^(q-1) * 4`.
    -   If `r == 2`: result `3^q * 2`.
    -   Use modular exponentiation.

2.  **Implementation Details**:
    -   `power(base, exp)`.

