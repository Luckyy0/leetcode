# 709. To Lower Case / Chuyển thành Chữ thường

## Problem Description / Mô tả bài toán
Given a string `s`, return the string after replacing every uppercase letter with the same lowercase letter.
Cho một chuỗi `s`, hãy trả về chuỗi đó sau khi thay thế mọi chữ cái viết hoa bằng chữ cái viết thường tương ứng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### ASCII/Unicode Manipulation / Thao tác ASCII/Unicode
Uppercase letters 'A' to 'Z' have ASCII values 65 to 90.
Các chữ cái viết hoa từ 'A' đến 'Z' có giá trị ASCII từ 65 đến 90.

Lowercase letters 'a' to 'z' have ASCII values 97 to 122.
Các chữ cái viết thường từ 'a' đến 'z' có giá trị ASCII từ 97 đến 122.

The difference is 32. We can convert an uppercase character `c` to lowercase by adding 32 (or using `c | 32`).
Sự khác biệt là 32. Chúng ta có thể chuyển đổi một ký tự viết hoa `c` thành chữ thường bằng cách cộng thêm 32.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the string.
- **Space**: O(N) for string reconstruction.

---

## Analysis / Phân tích

### Approach: Linear Transformation
Iterate through the string, check if a character is in the range `['A', 'Z']`, and transform it.
Lặp qua chuỗi, kiểm tra xem một ký tự có nằm trong phạm vi `['A', 'Z']` không và chuyển đổi nó.

---
