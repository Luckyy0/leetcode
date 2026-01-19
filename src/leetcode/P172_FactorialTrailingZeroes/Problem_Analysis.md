# 172. Factorial Trailing Zeroes / Số Số 0 Ở Cuối Giai Thừa

## Problem Description / Mô tả bài toán
Given an integer `n`, return the number of trailing zeroes in `n!`.
Cho một số nguyên `n`, hãy trả về số lượng số không ở cuối của `n!`.

Note that `n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1`.
Lưu ý rằng `n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1`.

### Example 1:
```text
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
```

### Example 2:
```text
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
```

### Example 3:
```text
Input: n = 0
Output: 0
```

## Constraints / Ràng buộc
- `0 <= n <= 10^4`

**Follow up**: Could you write an algorithm that runs in logarithmic time complexity?

---

## Theoretical Foundation / Cơ sở lý thuyết

### How are trailing zeroes formed? / Số 0 ở cuối được tạo ra như thế nào?
A trailing zero is created by the factor `10`, which is `2 * 5`.
In `n!`, there are always more factors of `2` than factors of `5`. Therefore, the number of trailing zeroes is determined by the number of times `5` is a factor in `1! * 2! * ... * n!`.

**Counting factors of 5**:
1. Every multiple of 5 contributes one factor of 5.
2. Every multiple of 25 contributing an *extra* factor of 5 (since 25 = 5 * 5).
3. Every multiple of 125 contributing yet another factor, and so on.

**Formula**:
`Trailing Zeroes = floor(n/5) + floor(n/25) + floor(n/125) + ...`

---

## Analysis / Phân tích

### Approach: Logarithmic Counting

**Algorithm**:
1. Initialize `count = 0`.
2. While `n > 0`:
    - `count += n / 5`.
    - `n /= 5`.
3. Return `count`.

### Complexity / Độ phức tạp
- **Time**: O(log5(N)) - the number of times we can divide by 5.
- **Space**: O(1) - constant memory.

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: Returns 0.
2.  **Small n**: n < 5 returns 0.
3.  **n is a power of 5**: (e.g., 25) Should count 5 (from 5, 10, 15, 20) + 1 (extra from 25) = 6. Correct.
4.  **Large n**: Constraint 10^4 is small, logic holds.
