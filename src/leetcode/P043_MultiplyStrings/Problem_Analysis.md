# 43. Multiply Strings / Nhân Chuỗi

## Problem Description / Mô tả bài toán
Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.
Cho hai số nguyên không âm `num1` và `num2` được biểu diễn dưới dạng chuỗi, trả về tích của `num1` và `num2`, cũng được biểu diễn dưới dạng chuỗi.

**Note**: You must not use any built-in BigInteger library or convert the inputs to integer directly.
**Lưu ý**: Bạn không được sử dụng bất kỳ thư viện BigInteger có sẵn nào hoặc chuyển đổi đầu vào thành số nguyên trực tiếp.

### Example 1:
```text
Input: num1 = "2", num2 = "3"
Output: "6"
```

### Example 2:
```text
Input: num1 = "123", num2 = "456"
Output: "56088"
```

## Constraints / Ràng buộc
- `1 <= num1.length, num2.length <= 200`
- `num1` and `num2` consist of digits only.
- Both `num1` and `num2` do not contain any leading zero, except the number 0 itself.

---

## Analysis / Phân tích

### Approach: Elementary Math (Schoolbook Multiplication) / Toán Tiểu Học (Nhân Sách Giáo Khoa)
- **Idea**: Simulate the multiplication process digit by digit.
- **Ý tưởng**: Mô phỏng quá trình nhân từng chữ số một.
    - Result length is at most `m + n`.
    - Create an array `pos` of size `m + n`.
    - Loop `i` from `m-1` down to 0.
    - Loop `j` from `n-1` down to 0.
    - `mul = num1[i] * num2[j]`.
    - `sum = mul + pos[i + j + 1]`.
    - `pos[i + j + 1] = sum % 10`.
    - `pos[i + j] += sum / 10`.
- **Time Complexity**: O(m * n).
- **Space Complexity**: O(m + n).

---

## Edge Cases / Các trường hợp biên
1.  **Zero**: "0" * "123" -> "0".
2.  **Single Digits**: "2" * "3" -> "6".
