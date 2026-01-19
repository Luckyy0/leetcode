# 168. Excel Sheet Column Title / Tiêu Đề Cột Trong Excel

## Problem Description / Mô tả bài toán
Given an integer `columnNumber`, return its corresponding column title as it appears in an Excel sheet.
Cho một số nguyên `columnNumber`, hãy trả về tiêu đề cột tương ứng của nó như trong bảng tính Excel.

For example:
```text
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
```

### Example 1:
```text
Input: columnNumber = 1
Output: "A"
```

### Example 2:
```text
Input: columnNumber = 28
Output: "AB"
```

### Example 3:
```text
Input: columnNumber = 701
Output: "ZY"
```

## Constraints / Ràng buộc
- `1 <= columnNumber <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Base 26 Conversion (1-Indexed) / Chuyển đổi Cơ số 26 (Bắt đầu từ 1)
Excel column titles represent a numbering system with base 26. However, unlike standard base-26 (0-25), this system is 1-indexed (1-26).
Tiêu đề cột Excel đại diện cho một hệ thống đánh số cơ số 26. Tuy nhiên, không giống như cơ số 26 tiêu chuẩn (0-25), hệ thống này bắt đầu từ 1 (1-26).

**The Logic**:
To handle the 1-indexing correctly:
1.  Decrement `columnNumber` by 1 at each step to shift from `1..26` to `0..25`.
2.  Take the remainder `remainder = columnNumber % 26`.
3.  Convert the remainder to a character: `(char) ('A' + remainder)`.
4.  Update `columnNumber = columnNumber / 26`.
5.  Repeat until `columnNumber` is 0.

---

## Analysis / Phân tích

### Approach: Iterative Modulo/Division

**Algorithm**:
```
StringBuilder res = ""
while columnNumber > 0:
    columnNumber-- (shift to 0-indexed)
    res.append((char) ('A' + columnNumber % 26))
    columnNumber /= 26
res.reverse()
return res
```

### Complexity / Độ phức tạp
- **Time**: O(log26(N)) - the number of characters in the title.
- **Space**: O(log26(N)) - to store the result.

---

## Edge Cases / Các trường hợp biên
1.  **Multiple of 26** (e.g., 26, 52): Crucial to subtract 1 first to get 'Z' correctly.
2.  **Single letter**: 1 -> "A", 26 -> "Z".
3.  **Maximum integer value**: Handled by long if needed, but the number of divisions is small.
4.  **Transitions**: 26 (Z) -> 27 (AA).
