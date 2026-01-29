# 1323. Maximum 69 Number / Số 69 Lớn nhất

## Problem Description / Mô tả bài toán
Integer consisting of 6 and 9.
Change at most one 6 to 9.
Return max possible number.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach
To maximize number, change the **first** (most significant) digit '6' to '9'.
Convert to string/char array. Find first '6'. Change to '9'. Return.

### Complexity / Độ phức tạp
- **Time**: O(L) where L is number of digits.
- **Space**: O(L).

---

## Analysis / Phân tích

### Approach: String Manipulation
Convert the integer to a string or character array. Iterate from left to right (most significant digit to least). Isolate the first occurrence of '6' and change it to '9'. Stop after the first change. Convert back to integer and return.
Chuyển đổi số nguyên thành chuỗi hoặc mảng ký tự. Lặp lại từ trái sang phải (chữ số có nghĩa lớn nhất đến nhỏ nhất). Cô lập lần xuất hiện đầu tiên của '6' và đổi thành '9'. Dừng lại sau lần thay đổi đầu tiên. Chuyển đổi lại thành số nguyên và trả về.

---
