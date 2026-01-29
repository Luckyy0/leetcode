# 1271. Hexspeak

## Problem Description / Mô tả bài toán
Convert decimal number to Hexspeak.
Rules:
- Digits '0' -> 'O'
- Digits '1' -> 'I'
- Letters 'A', 'B', 'C', 'D', 'E', 'F' remain same.
- Others (2-9) are invalid.
If conversion contains invalid chars, return "ERROR".
Input is string representing decimal number (might be large, use Long).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hexadecimal Conversion / Chuyển đổi Thập lục phân
Convert input String to `Long`. Convert `Long` to Hex String (UpperCase).
Iterate characters.
Replace 0->O, 1->I.
If any char is not A-F, O, I (i.e., 2-9), return ERROR.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Base Conversion and Validation
Parse the input string as a `long`. Convert it to its hexadecimal representation (uppercase). Iterate through the hex string. If a character is '0', replace with 'O'. If '1', replace with 'I'. If it is a digit '2'-'9', the number cannot be represented in Hexspeak; return "ERROR". Characters 'A'-'F' are valid. Return the modified string.
Phân tích chuỗi đầu vào thành `long`. Chuyển đổi nó sang biểu diễn thập lục phân (chữ in hoa). Lặp qua chuỗi hex. Nếu một ký tự là '0', thay thế bằng 'O'. Nếu '1', thay thế bằng 'I'. Nếu là chữ số '2'-'9', số đó không thể được biểu diễn bằng Hexspeak; trả về "ERROR". Các ký tự 'A'-'F' là hợp lệ. Trả về chuỗi đã sửa đổi.

---
