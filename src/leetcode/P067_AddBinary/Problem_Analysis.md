# 67. Add Binary / Cộng Nhị Phân

## Problem Description / Mô tả bài toán
Given two binary strings `a` and `b`, return their sum as a binary string.
Cho hai chuỗi nhị phân `a` và `b`, trả về tổng của chúng dưới dạng chuỗi nhị phân.

### Example 1:
```text
Input: a = "11", b = "1"
Output: "100"
```

### Example 2:
```text
Input: a = "1010", b = "1011"
Output: "10101"
```

## Constraints / Ràng buộc
- `1 <= a.length, b.length <= 10^4`
- `a` and `b` consist only of `'0'` or `'1'` characters.
- Each string does not contain leading zeros except for the zero itself.

---

## Analysis / Phân tích

### Approach: Column Addition (Simulation) / Cộng Theo Cột (Mô Phỏng)
- **Idea**: Simulate binary addition from right to left (least significant bit).
- **Ý tưởng**: Mô phỏng phép cộng nhị phân từ phải sang trái (bit ít quan trọng nhất).
- **Steps**:
    - Iterate `i` and `j` from end of strings strings.
    - `sum = carry`.
    - If `i >= 0`, `sum += a.charAt(i) - '0'`.
    - If `j >= 0`, `sum += b.charAt(j) - '0'`.
    - Append `sum % 2` to result.
    - `carry = sum / 2`.
    - Reverse the result.
- **Time Complexity**: O(max(N, M)).
- **Space Complexity**: O(max(N, M)).

---

## Edge Cases / Các trường hợp biên
1.  **Diff Lengths**: Handled by check `i >= 0`.
2.  **Carry at End**: Need to append carry if `carry != 0`.
3.  **Zero**: "0" + "0" -> "0".
