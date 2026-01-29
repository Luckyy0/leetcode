# 343. Integer Break / Phân Tích Số Nguyên

## Problem Description / Mô tả bài toán
Given an integer `n`, break it into the sum of `k` **positive integers**, where `k >= 2`, and maximize the product of those integers.
Cho một số nguyên `n`, phân tích nó thành tổng của `k` **số nguyên dương**, trong đó `k >= 2`, và tối đa hóa tích của các số nguyên đó.

Return the maximum product you can get.
Trả về tích lớn nhất bạn có thể nhận được.

### Example 1:
```text
Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
```

### Example 2:
```text
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
```

## Constraints / Ràng buộc
- `2 <= n <= 58`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Math / Logic Toán Học
We want to maximize `x1 * x2 * ... * xk` subject to `x1 + ... + xk = n`.
It's known that breaking into parts of value `e` (2.718) is optimal. Since we deal with integers, `2` and `3` are candidates. `3` is closer to `e` than `2`.
Strategy: Use as many `3`s as possible.
Exceptions:
- If remainder is 1 (e.g., 4 = 3+1, prod=3. Or 2+2, prod=4). 4 is better than 3*1. So convert one 3 into 3+1->4 (2+2).
- If remainder is 0: Perfect sum of 3s.
- If remainder is 2: Multiply by 2.

Base cases:
- `n = 2`: 1+1 -> 1.
- `n = 3`: 2+1 -> 2.

Algorithm for `n > 3`:
- While `n > 4`: subtract 3, multiply result by 3.
- Final `n` will be 2, 3, or 4. Multiply it.

### DP Approach (Generic)
`dp[i] = max(j * (i-j), j * dp[i-j])` for `1 <= j < i`.
`j * (i-j)`: split into two numbers only.
`j * dp[i-j]`: split `i-j` further.

### Complexity / Độ phức tạp
- **Time**: O(N) (Math or DP).
- **Space**: O(1) (Math) or O(N) (DP).

---

## Analysis / Phân tích

### Approach: Math (Greedy with 3s)

**Algorithm**:
1.  If `n == 2` return 1.
2.  If `n == 3` return 2.
3.  `product = 1`.
4.  While `n > 4`:
    - `product *= 3`.
    - `n -= 3`.
5.  `product *= n`.
6.  Return `product`.

---
