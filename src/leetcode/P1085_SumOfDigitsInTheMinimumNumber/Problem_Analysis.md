# 1085. Sum of Digits in the Minimum Number / Tổng các Chữ số trong Số Nhỏ nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return 0 if the sum of the digits of the minimum integer in `nums` is odd, or 1 otherwise.
Cho một mảng số nguyên `nums`, hãy trả về 0 nếu tổng các chữ số của số nguyên nhỏ nhất trong `nums` là lẻ, hoặc 1 nếu ngược lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simple Iteration
1. Find min element.
2. Sum digits of min.
3. Check parity.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Min-Sum Parity Check
Scan the array to find the minimum value. Compute the sum of its digits. Return 1 if the sum is even, and 0 if it is odd.
Quét mảng để tìm giá trị nhỏ nhất. Tính tổng các chữ số của nó. Trả về 1 nếu tổng là chẵn, và 0 nếu là lẻ.

---
