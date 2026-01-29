# 479. Largest Palindrome Product / Tích Số Đối Xứng Lớn Nhất

## Problem Description / Mô tả bài toán
Given an integer `n`, return the **largest palindromic integer** that can be represented as the product of two `n`-digit integers. Since the answer can be very large, return it **modulo 1337**.
Cho một số nguyên `n`, hãy trả về **số nguyên đối xứng (palindrome) lớn nhất** có thể được biểu diễn dưới dạng tích của hai số nguyên có `n` chữ số. Vì kết quả có thể rất lớn, hãy trả về nó **chia dư cho 1337**.

### Example 1:
```text
Input: n = 2
Output: 987
Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
```

### Example 2:
```text
Input: n = 1
Output: 9
```

## Constraints / Ràng buộc
- `1 <= n <= 8`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force with Palindrome Generation / Duyệt trâu kết hợp Tạo số đối xứng
We want the product of two numbers `a, b` where $10^{n-1} \le a, b < 10^n$.
The maximum product is approximately $(10^n)^2 = 10^{2n}$.
Instead of trying all pairs (which is $O(10^{2n})$), we can **generate** candidates for the palindrome in descending order and check if they can be factored into two $n$-digit numbers.

Algorithm:
1. Corner case: `n=1`, return `9`.
2. Determine the upper and lower bounds for $n$-digit numbers: `upper = 10^n - 1`, `lower = 10^{n-1}`.
3. Iterate `left` from `upper` down to `lower`:
   - Construct a palindrome using `left` as the first half. (e.g., if `left = 90`, palindrome is `9009`).
   - Check if this `palindrome` has a factor `f` such that `upper >= f >= sqrt(palindrome)` and `palindrome / f` is also an $n$-digit number.
   - If found, that's our largest palindrome. Return `palindrome % 1337`.

### Complexity / Độ phức tạp
- **Time**: Difficult to bounded precisely, but for $n \le 8$, the search space is small enough because the largest palindrome is usually close to the upper bound.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Half-to-Full Palindrome Generation

**Algorithm**:
1.  Initialize upper/lower bounds.
2.  Nested loop: outer for first half prefix, inner for divisors.
3.  Check factorization efficiency.

---
