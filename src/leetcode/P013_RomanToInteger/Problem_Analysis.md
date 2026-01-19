# 13. Roman to Integer / Chuyển Đổi Số La Mã Sang Số Nguyên

## Problem Description / Mô tả bài toán
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Số La Mã được biểu diễn bởi bảy ký hiệu khác nhau: I, V, X, L, C, D và M.

| Symbol | Value |
|---|---|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

Given a roman numeral, convert it to an integer.
Cho một số La Mã, hãy chuyển đổi nó thành số nguyên.

### Example 1:
```text
Input: s = "III"
Output: 3
```

### Example 2:
```text
Input: s = "IV"
Output: 4
```

### Example 3:
```text
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 15`
- `s` guarantees to be a valid roman numeral in the range `[1, 3999]`.

---

## Analysis / Phân tích

### Approach: Right to Left Scan / Duyệt Từ Phải Sang Trái
- **Idea**: Scan the string. If a value is smaller than the value to its right, subtract it. Otherwise, add it.
- **Ý tưởng**: Duyệt chuỗi. Nếu một giá trị nhỏ hơn giá trị bên phải nó, trừ nó đi. Ngược lại, cộng nó vào.
    - Example: `IV`: `I` (1) < `V` (5) -> `-1 + 5 = 4`.
    - Example: `VI`: `I` (1), `V` (5) -> `1 + 5 = 6` (if scanning left to right with lookahead).
- **Implementation (Right to Left)**:
    - Last character is always added.
    - Loop from second last to start.
    - If `current < right`, result -= current.
    - Else result += current.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Single Character**: "I", "M".
2.  **Subtraction cases**: "IV", "IX", "CM".
3.  **Complex cases**: "MCMXCIV".
