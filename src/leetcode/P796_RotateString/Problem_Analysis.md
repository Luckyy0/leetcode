# 796. Rotate String / Xoay Chuỗi

## Problem Description / Mô tả bài toán
Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of shifts on `s`.
Cho hai chuỗi `s` và `goal`, hãy trả về `true` khi và chỉ khi `s` có thể trở thành `goal` sau một số lần dịch chuyển trên `s`.

A shift on `s` consists of moving the leftmost character of `s` to the rightmost position.
Một lần dịch chuyển trên `s` bao gồm việc di chuyển ký tự ngoài cùng bên trái của `s` sang vị trí ngoài cùng bên phải.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Substring check / Kiểm tra Chuỗi con
If we concatenate `s` with itself (`s + s`), the resulting string contains all possible rotations of `s` as substrings.
Nếu chúng ta nối `s` với chính nó (`s + s`), chuỗi kết quả sẽ chứa tất cả các phép xoay có thể có của `s` dưới dạng các chuỗi con.

Algorithm:
1. Check if `s.length() == goal.length()`.
2. Check if `(s + s).contains(goal)`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is length of string (due to string search).
- **Space**: O(N) to store concatenated string.

---

## Analysis / Phân tích

### Approach: Concatenation trick
Cleverly bypass the need for multiple manual shifts by using a double-length string that encompasses the entire rotation cycle.
Vượt qua nhu cầu dịch chuyển thủ công nhiều lần một cách thông minh bằng cách sử dụng một chuỗi có độ dài gấp đôi bao hàm toàn bộ chu kỳ xoay.

---
