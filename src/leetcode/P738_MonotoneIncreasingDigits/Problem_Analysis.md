# 738. Monotone Increasing Digits / Các chữ số Tăng Đơn điệu

## Problem Description / Mô tả bài toán
An integer has **monotone increasing digits** if and only if each pair of adjacent digits `x` and `y` satisfy `x <= y`.
Một số nguyên có **các chữ số tăng đơn điệu** khi và chỉ khi mỗi cặp chữ số liền kề `x` và `y` thỏa mãn `x <= y`.

Given an integer `n`, return the largest integer that is less than or equal to `n` and has monotone increasing digits.
Cho một số nguyên `n`, hãy trả về số nguyên lớn nhất nhỏ hơn hoặc bằng `n` và có các chữ số tăng đơn điệu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Modification / Sửa đổi Tham lam
To find the largest monotone number `<= n`:
1. Find the first violation where `digits[i] > digits[i+1]`.
2. Once found, decrement `digits[i]` by 1.
3. Every digit after index `i` should be set to 9 to maximize the value.
4. If decrementing `digits[i]` creates a new violation with `digits[i-1]`, we must continue moving left.

### Complexity / Độ phức tạp
- **Time**: O(L) where L is the number of digits.
- **Space**: O(L) to store the digits in an array.

---

## Analysis / Phân tích

### Approach: Leftmost Violation Point
Scan from left to right. Locate the first position where monotonicity breaks. Mark the position. Any digits to the right of this position will eventually become `9`.
Quét từ trái sang phải. Xác định vị trí đầu tiên mà tính đơn điệu bị phá vỡ. Đánh dấu vị trí. Bất kỳ chữ số nào ở bên phải vị trí này cuối cùng sẽ trở thành số `9`.

---
