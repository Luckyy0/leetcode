# 279. Perfect Squares / Các Số Chính Phương Hoàn Hảo

## Problem Description / Mô tả bài toán
Given an integer `n`, return the least number of perfect square numbers that sum to `n`.
Cho một số nguyên `n`, hãy trả về số lượng ít nhất các số chính phương hoàn hảo có tổng bằng `n`.

A **perfect square** is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
Một **số chính phương hoàn hảo** là một số nguyên là bình phương của một số nguyên; nói cách khác, nó là tích của một số nguyên với chính nó. Ví dụ, 1, 4, 9 và 16 là các số chính phương hoàn hảo trong khi 3 và 11 thì không.

### Example 1:
```text
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
```

### Example 2:
```text
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

## Constraints / Ràng buộc
- `1 <= n <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming / Quy Hoạch Động
We want to find `dp[n]`, the min squares sum to `n`.
`dp[i] = min(dp[i - j*j]) + 1` for all `j` such that `j*j <= i`.
Base case: `dp[0] = 0`.

**Complexity**:
- Outer loop `i` from 1 to `N`.
- Inner loop `j` from 1 to `sqrt(N)`.
- Total: O(N * sqrt(N)). For N=10000 -> 10^6 ops. Fast enough.

### Mathematical Approach (Lagrange's Four Square Theorem)
Any positive integer can be written as the sum of at most 4 squares.
Result is 1, 2, 3, or 4.
- Return 1 if `n` is a perfect square.
- Return 4 if `n` is of the form `4^a * (8b + 7)` (Legendre's 3-square theorem).
- Return 2 if `n = a^2 + b^2`.
- Else return 3.

I'll implement DP as it's the more general algorithmic approach expected in interviews, though Math is optimal. I will mention Math in comments.

---

## Analysis / Phân tích

### Approach: Dynamic Programming

**Algorithm**:
1.  `dp` array size `n+1`. Fill with `max_int` (or `n`, since 1+1+... is max).
2.  `dp[0] = 0`.
3.  Loop `i` 1 to `n`.
4.  Loop `j` 1 while `j*j <= i`:
    - `dp[i] = min(dp[i], dp[i - j*j] + 1)`.
5.  Return `dp[n]`.

---

## Edge Cases / Các trường hợp biên
1.  **n=1**: 1.
2.  **Square**: Returns 1.
