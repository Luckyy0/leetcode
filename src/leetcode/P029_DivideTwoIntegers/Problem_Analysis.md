# 29. Divide Two Integers / Chia Hai Số Nguyên

## Problem Description / Mô tả bài toán
Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division, and mod operator.
Cho hai số nguyên `dividend` và `divisor`, hãy chia hai số nguyên mà không sử dụng phép nhân, phép chia và phép mod.

The integer division should truncate toward zero, which means losing its fractional part. For example, `8.345` would be truncated to `8`, and `-2.7335` would be truncated to `-2`.
Phép chia số nguyên nên cắt bỏ phần thập phân về 0, nghĩa là mất phần thập phân. Ví dụ, `8.345` sẽ bị cắt thành `8`, và `-2.7335` sẽ bị cắt thành `-2`.

Return the quotient after dividing `dividend` by `divisor`.
Trả về thương số sau khi chia `dividend` cho `divisor`.

**Note**: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: `[-2^31, 2^31 - 1]`. For this problem, if the quotient is strictly greater than `2^31 - 1`, then return `2^31 - 1`, and if the quotient is strictly less than `-2^31`, then return `-2^31`.
**Lưu ý**: Giả sử chúng ta đang xử lý trong môi trường chỉ có thể lưu trữ số nguyên trong phạm vi số nguyên 32-bit có dấu: `[-2^31, 2^31 - 1]`. Đối với vấn đề này, nếu thương số lớn hơn hẳn `2^31 - 1`, thì trả về `2^31 - 1`, và nếu thương số nhỏ hơn hẳn `-2^31`, thì trả về `-2^31`.

### Example 1:
```text
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
```

### Example 2:
```text
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
```

## Constraints / Ràng buộc
- `-2^31 <= dividend, divisor <= 2^31 - 1`
- `divisor != 0`

---

## Analysis / Phân tích

### Approach: Bit Manipulation (Subtraction with Powers of 2) / Thao Tác Bit (Trừ với Lũy Thừa của 2)
- **Idea**: Since we can't use division, we can use subtraction. Naive subtraction (`dividend - divisor` repeatedly) is too slow (O(n)).
- **Ý tưởng**: Vì không thể dùng phép chia, ta có thể dùng phép trừ. Phép trừ ngây thơ (`dividend - divisor` liên tục) quá chậm (O(n)).
- **Optimized**: We can look for the largest multiple of `divisor` (e.g., `divisor * 2^k`) that fits in `dividend`.
    - `10 / 3`.
    - `3 * 2^1 = 6` (fits). `10 - 6 = 4`. Quotient += 2.
    - `4 >= 3`. `3 * 2^0 = 3` (fits). `4 - 3 = 1`. Quotient += 1.
    - Result = 3.
- **Handling Overflow**: The result might overflow if `dividend = -2147483648` and `divisor = -1`.
- **Handling Sign**: Use arithmetic or tracking logic for signs.
- **Time Complexity**: O(log n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Min Int Overflow**: `Integer.MIN_VALUE / -1` -> `Integer.MAX_VALUE`.
2.  **Zero**: `0 / x = 0`.
