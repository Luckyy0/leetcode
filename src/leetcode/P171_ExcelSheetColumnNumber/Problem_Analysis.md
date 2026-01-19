# 171. Excel Sheet Column Number / Số Thứ Tự Cột Trong Excel

## Problem Description / Mô tả bài toán
Given a string `columnTitle` that represents the column title as appears in an Excel sheet, return its corresponding column number.
Cho một chuỗi `columnTitle` đại diện cho tiêu đề cột trong bảng tính Excel, hãy trả về số thứ tự cột tương ứng của nó.

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
Input: columnTitle = "A"
Output: 1
```

### Example 2:
```text
Input: columnTitle = "AB"
Output: 28
```

### Example 3:
```text
Input: columnTitle = "ZY"
Output: 701
```

## Constraints / Ràng buộc
- `1 <= columnTitle.length <= 7`
- `columnTitle` consists only of uppercase English letters.
- `columnTitle` is in the range `["A", "FXSHRXW"]`. (`FXSHRXW` is `2^31 - 1`).

---

## Theoretical Foundation / Cơ sở lý thuyết

### Base 26 Conversion / Chuyển đổi Cơ số 26
This is the inverse of Problem 168. We are converting a string in "Base 26" to a decimal integer.
Đây là bài toán ngược của Bài 168. Chúng ta đang chuyển đổi một chuỗi ở "Cơ số 26" sang một số nguyên thập phân.

**The Formula**:
For a string `S = s0 s1 s2 ... sn`:
`result = s0 * 26^n + s1 * 26^(n-1) + ... + sn * 26^0`

Alternatively, using an iterative polynomial calculation:
```
result = 0
for char c in columnTitle:
    val = c - 'A' + 1
    result = result * 26 + val
```

---

## Analysis / Phân tích

### Approach: Polynomial Accumulation

**Algorithm**:
1. Initialize `result = 0`.
2. Iterate through each character `c` in `columnTitle`:
    - Calculate integer value `v = c - 'A' + 1`.
    - `result = result * 26 + v`.
3. Return `result`.

### Complexity / Độ phức tạp
- **Time**: O(N) - where N is the length of the string.
- **Space**: O(1) - constant memory.

---

## Edge Cases / Các trường hợp biên
1.  **Single letter**: "A" -> 1.
2.  **Longest possible string**: Handles up to `2^31 - 1`.
3.  **Transitions**: "Z" -> 26, "AA" -> 27.
4.  **ZY**: 26 * 26 + 25 = 676 + 25 = 701. Correct.
