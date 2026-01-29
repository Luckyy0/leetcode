# 1309. Decrypt String from Alphabet to Integer Mapping / Giải mã Chuỗi từ Bản đồ Bảng chữ cái sang Số nguyên

## Problem Description / Mô tả bài toán
Map: 1='a' ... 9='i', 10#='j' ... 26#='z'.
Given string `s`. Decrypt it.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Parsing
Iterate string.
Look ahead. If `i+2` is '#', parse `s[i..i+1]` as number 10-26.
Else, parse `s[i]` as number 1-9.
Convert number to char.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linear Scan with Lookahead
Iterate through the string. At each index `i`, check if `i + 2` is within bounds and `s.charAt(i + 2) == '#'`. If yes, the current character is formed by the two digits `s.substring(i, i + 2)`; parse this number and map to 'j'-'z', then advance `i` by 3. If no, the current character is formed by the single digit `s.charAt(i)`; parse and map to 'a'-'i', then advance `i` by 1.
Lặp lại qua chuỗi. Tại mỗi chỉ mục `i`, kiểm tra xem `i + 2` có nằm trong giới hạn và `s.charAt(i + 2) == '#'` hay không. Nếu có, ký tự hiện tại được tạo bởi hai chữ số `s.substring(i, i + 2)`; phân tích số này và ánh xạ tới 'j'-'z', sau đó tăng `i` thêm 3. Nếu không, ký tự hiện tại được tạo bởi một chữ số duy nhất `s.charAt(i)`; phân tích và ánh xạ tới 'a'-'i', sau đó tăng `i` thêm 1.

---
