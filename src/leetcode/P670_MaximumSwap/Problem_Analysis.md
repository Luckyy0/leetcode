# 670. Maximum Swap / Hoán đổi Tối đa

## Problem Description / Mô tả bài toán
You are given a non-negative integer `num`. You can swap two digits at most once to get the maximum valued number.
Bạn được cho một số nguyên không âm `num`. Bạn có thể hoán đổi hai chữ số nhiều nhất một lần để có được số có giá trị lớn nhất.

Return the maximum valued number you can get.
Trả về số có giá trị lớn nhất mà bạn có thể nhận được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach / Tiếp cận Tham lam
To maximize a number, we want the largest available digit to be at the most significant position (leftmost).
Để tối đa hóa một số, chúng ta muốn chữ số lớn nhất hiện có nằm ở vị trí quan trọng nhất (ngoài cùng bên trái).

Strategy:
1. Record the last position of each digit (0-9).
2. For each digit from left to right, check if there's a larger digit appearing later (from 9 down to `currentDigit + 1`).
3. If such a digit exists, swap and return.

### Complexity / Độ phức tạp
- **Time**: O(L) where L is the number of digits.
- **Space**: O(1) as we only store a fixed-size array of 10 elements.

---

## Analysis / Phân tích

### Approach: Rightmost Index Tracking
Store the positions of digits 0-9 in an array. Iterate through the digits of the number. For each digit, look for a larger digit (starting from 9) that appears to its right. The first such pair found and swapped gives the maximum result.
Lưu trữ các vị trí của các chữ số 0-9 trong một mảng. Lặp qua các chữ số của số. Đối với mỗi chữ số, hãy tìm một chữ số lớn hơn (bắt đầu từ 9) xuất hiện ở bên phải của nó. Cặp đầu tiên được tìm thấy và hoán đổi sẽ mang lại kết quả tối đa.

---
