# 166. Fraction to Recurring Decimal / Phân Số Sang Số Thập Phân Vô Hạn Tuần Hoàn

## Problem Description / Mô tả bài toán
Given two integers representing the `numerator` and `denominator` of a fraction, return the fraction in string format.
Cho hai số nguyên đại diện cho `tử số (numerator)` và `mẫu số (denominator)` của một phân số, hãy trả về phân số đó dưới dạng chuỗi.

If the fractional part is repeating, enclose the repeating part in parentheses.
Nếu phần thập phân có tính tuần hoàn, hãy đặt phần tuần hoàn trong dấu ngoặc đơn.

If multiple answers are possible, return **any of them**.
Nếu có nhiều kết quả khả thi, hãy trả về **bất kỳ kết quả nào**.

It is **guaranteed** that the length of the answer string is less than `10^4` for all the given test cases.
**Đảm bảo** rằng độ dài của chuỗi kết quả nhỏ hơn `10^4` cho tất cả các bộ kiểm tra.

### Example 1:
```text
Input: numerator = 1, denominator = 2
Output: "0.5"
```

### Example 2:
```text
Input: numerator = 2, denominator = 1
Output: "2"
```

### Example 3:
```text
Input: numerator = 4, denominator = 333
Output: "0.(012)"
```

## Constraints / Ràng buộc
- `-2^31 <= numerator, denominator <= 2^31 - 1`
- `denominator != 0`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Integer Division and Remainder / Phép chia Số nguyên và Số dư
A rational number `a / b` either has a terminating decimal expansion or a repeating one.
- **Terminating**: The remainder eventually becomes 0.
- **Repeating**: The same remainder appears again during the long division process.

### Cycle Detection / Phát hiện Chu kỳ
To find the repeating part:
1. Perform long division step-by-step.
2. Store each remainder and its corresponding index in the result string using a **Hash Map**.
3. If a remainder repeats, it means the sequence of digits starting from the first occurrence of that remainder will repeat.
4. Insert `(` at the recorded index and `)` at the current end.

---

## Analysis / Phân tích

### Approach: Long Division with Hash Map

**Algorithm**:
1. Handle the **sign**: If one of the numbers is negative, add `-`.
2. Handle the **integer part**.
3. Handle the **fractional part**:
    - Subtract integer part to get remainder.
    - Loop while `remainder != 0`:
        - If remainder exists in map, insert `(` and `)`.
        - Else, record `(remainder, current_length)` and update remainder: `remainder *= 10`, `digit = remainder / denominator`, `remainder %= denominator`.
4. Return string.

**Special Note**: Use `long` to avoid overflow during `abs(-2147483648)`.

### Complexity / Độ phức tạp
- **Time**: O(Denominator) - in worst case we visit all possible remainders.
- **Space**: O(Denominator) - to store remainders in the map.

---

## Edge Cases / Các trường hợp biên
1.  **Zero numerator**: Return "0".
2.  **Negative numbers**: Handle sign correctly.
3.  **Large denominator**: `abs(-2^31)` overflow handled by `long`.
4.  **No fractional part**.
5.  **Terminating decimal**.
