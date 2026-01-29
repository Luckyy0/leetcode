# 762. Prime Number of Set Bits in Binary Representation / Số lượng Bit 1 là Số nguyên tố trong Biểu diễn Nhị phân

## Problem Description / Mô tả bài toán
Given two integers `left` and `right`, return the count of numbers in the inclusive range `[left, right]` having a **prime number of set bits** in their binary representation.
Cho hai số nguyên `left` và `right`, hãy trả về số lượng các số trong phạm vi `[left, right]` có **số lượng bit 1 là số nguyên tố** trong biểu diễn nhị phân của chúng.

Recall that the number of set bits the number of 1's in the binary representation. For example, 21 in binary is `10101`, which has 3 set bits.
Nhớ lại rằng số lượng bit 1 là số lượng số 1 trong biểu diễn nhị phân. Ví dụ: 21 trong hệ nhị phân là `10101`, có 3 bit 1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Counting and Primeness / Đếm Bit và Tính nguyên tố
We are dealing with 32-bit integers. The maximum number of set bits is 32.
Chúng ta đang xử lý các số nguyên 32 bit. Số lượng bit 1 tối đa là 32.

Primes <= 32: `[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]`.

Algorithm:
1. For each number:
   - Calculate bit count using `Integer.bitCount(n)`.
   - Check if the count is in the list of primes.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of integers in the range.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Direct bitCount Verification
Iterate through the range. Use the built-in bit counting function and a small set (or boolean array) to check for primality.
Lặp lại qua phạm vi. Sử dụng hàm đếm bit có sẵn và một tập hợp nhỏ (hoặc mảng boolean) để kiểm tra tính nguyên tố.

---
