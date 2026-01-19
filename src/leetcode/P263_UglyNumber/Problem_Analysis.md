# 263. Ugly Number / Số Xấu

## Problem Description / Mô tả bài toán
An **ugly number** is a positive integer whose prime factors are limited to `2`, `3`, and `5`.
Một **số xấu** là một số nguyên dương có các thừa số nguyên tố chỉ giới hạn trong `2`, `3`, và `5`.

Given an integer `n`, return `true` if `n` is an **ugly number**.
Cho một số nguyên `n`, hãy trả về `true` nếu `n` là một **số xấu**.

### Example 1:
```text
Input: n = 6
Output: true
Explanation: 6 = 2 * 3
```

### Example 2:
```text
Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
```

### Example 3:
```text
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
```

## Constraints / Ràng buộc
- `-2^31 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Prime Factorization / Phân Tích Thừa Số Nguyên Tố
Any number `n` can be written as `n = 2^a * 3^b * 5^c * K`.
If `n` is ugly, `K` must be 1.
If `K > 1`, it means `n` has prime factors other than 2, 3, 5.

**Algorithm**:
1.  Check `n <= 0`: Not positive, so False.
2.  While `n % 2 == 0`, `n /= 2`.
3.  While `n % 3 == 0`, `n /= 3`.
4.  While `n % 5 == 0`, `n /= 5`.
5.  If `n == 1`, return True, else False.

### Complexity / Độ phức tạp
- **Time**: O(log N) - Dividing by 2, 3, 5 reduces the number logarithmically.
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: Infinite loop if checked incorrectly (0 is divisible by everything). Need initial check.
2.  **n = 1**: Loop doesn't run, returns `1 == 1` -> True. Correct.
3.  **Negative numbers**: Return False.
