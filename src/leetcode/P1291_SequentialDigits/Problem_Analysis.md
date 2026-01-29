# 1291. Sequential Digits / Các chữ số Tuần tự

## Problem Description / Mô tả bài toán
Integer has sequential digits if each digit is 1 more than previous.
Return sorted list of such integers in range `[low, high]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Enumeration / String Generation
The "sequential digits" pattern is very restrictive.
"123", "234", "1234", "123456789".
Base string: "123456789".
Generate substrings of length 2 to 9.
Convert to int. Filter by `low` and `high`.

### Complexity / Độ phức tạp
- **Time**: Minimal (very few sequential numbers).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Generate and Filter
Generate all possible sequential numbers by taking substrings of "123456789". Convert them to integers. Filter the numbers that fall within `[low, high]`. Sort the result.
Tạo tất cả các số tuần tự có thể bằng cách lấy các chuỗi con của "123456789". Chuyển đổi chúng thành số nguyên. Lọc các số nằm trong phạm vi `[low, high]`. Sắp xếp kết quả.

---
