# 415. Add Strings / Cộng Chuỗi Số

## Problem Description / Mô tả bài toán
Given two non-negative integers, `num1` and `num2`, represented as string, return the sum of `num1` and `num2` as a string.
Cho hai số nguyên không âm `num1` và `num2` được biểu diễn dưới dạng chuỗi, hãy trả về tổng của chúng dưới dạng một chuỗi.

You must solve the problem without using any built-in library for handling large integers (such as `BigInteger`). You must also not convert the inputs to integers directly.
Bạn phải giải quyết bài toán này mà không sử dụng bất kỳ thư viện có sẵn nào để xử lý các số nguyên lớn (như `BigInteger`). Bạn cũng không được phép chuyển đổi trực tiếp các đầu vào thành số nguyên.

### Example 1:
```text
Input: num1 = "11", num2 = "123"
Output: "134"
```

### Example 2:
```text
Input: num1 = "456", num2 = "77"
Output: "533"
```

### Example 3:
```text
Input: num1 = "0", num2 = "0"
Output: "0"
```

## Constraints / Ràng buộc
- `1 <= num1.length, num2.length <= 10^4`
- `num1` and `num2` consist of only digits.
- `num1` and `num2` don't have any leading zeros except for the zero itself.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Simulation / Mô phỏng phép cộng
We can simulate the manual addition process we learned in school:
1. Start from the rightmost digits (the least significant place).
2. Sum the digits along with any carry from the previous step.
3. The new digit for the result is `(sum % 10)` and the new carry is `(sum / 10)`.
4. Move one position to the left and repeat until all digits are processed and the carry is zero.

### Complexity / Độ phức tạp
- **Time**: O(max(N, M)) where N and M are lengths of the two strings.
- **Space**: O(max(N, M)) for the result string.

---

## Analysis / Phân tích

### Approach: Two Pointers Simulation

**Algorithm**:
1.  Initialize `i = len1 - 1`, `j = len2 - 1`, `carry = 0`.
2.  Use a `StringBuilder` to collect the digits of the result.
3.  Perform the addition loop.
4.  Reverse and return the string.

---
