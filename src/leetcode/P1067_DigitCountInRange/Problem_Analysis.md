# 1067. Digit Count in Range / Đếm Chữ số trong Khoảng

## Problem Description / Mô tả bài toán
Given an integer `d` between 0 and 9, and two integers `low` and `high` as lower and upper bounds, return the number of times that `d` occurs as a digit in all integers between `low` and `high`, including the bounds.
Cho một số nguyên `d` giữa 0 và 9, và hai số nguyên `low` và `high` lần lượt là giới hạn dưới và giới hạn trên, hãy trả về số lần mà `d` xuất hiện dưới dạng một chữ số trong tất cả các số nguyên nằm giữa `low` và `high`, bao gồm cả các giới hạn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit DP / Mathematical Counting / Quy hoạch Động Chữ số
Problem: `count(d, high) - count(d, low - 1)`.
Function `count(d, n)`: count occurrences of digit `d` in range `[1, n]`.

For each position (power of 10):
- Calculate full cycles of 0-9.
- Calculate occurrences in the remainder.

Special case: `d = 0`. Leading zeros are not counted.
Standard Digit DP logic works.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Position-wise Counting
Implement a function `count(N, d)` that counts the digit `d` in numbers up to `N`. Solve for each digit position (units, tens, hundreds...) by calculating how many times `d` appears at that position based on higher and lower bits. Handle `d=0` specially to ignore leading zeros. The result is `count(high, d) - count(low-1, d)`.
Triển khai một hàm `count(N, d)` đếm chữ số `d` trong các số lên đến `N`. Giải quyết cho từng vị trí chữ số (đơn vị, hàng chục, hàng trăm...) bằng cách tính toán số lần `d` xuất hiện tại vị trí đó dựa trên các bit cao hơn và thấp hơn. Xử lý `d=0` một cách đặc biệt để bỏ qua các số 0 ở đầu. Kết quả là `count(high, d) - count(low-1, d)`.

---
