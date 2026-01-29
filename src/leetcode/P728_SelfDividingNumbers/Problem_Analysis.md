# 728. Self Dividing Numbers / Số Tự chia

## Problem Description / Mô tả bài toán
A self-dividing number is a number that is divisible by every digit it contains.
Số tự chia là một số chia hết cho mọi chữ số mà nó chứa.

For example, 128 is a self-dividing number because `128 % 1 == 0`, `128 % 2 == 0`, and `128 % 8 == 0`.
A self-dividing number is not allowed to contain the digit zero.
Số tự chia không được phép chứa chữ số 0.

Given two integers `left` and `right`, return a list of all the self-dividing numbers in the range `[left, right]`.
Cho hai số nguyên `left` và `right`, hãy trả về danh sách tất cả các số tự chia trong phạm vi `[left, right]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force Enumeration / Liệt kê vét cạn
For each number in the range, we manually check its digits.
Đối với mỗi số trong phạm vi, chúng ta kiểm tra thủ công các chữ số của nó.

1. Extract digits using modulo and division.
2. Check:
   - Digit is not 0.
   - `number % digit == 0`.

### Complexity / Độ phức tạp
- **Time**: O(N * log M) where N is the number of items and M is the average value.
- **Space**: O(1) beyond the result storage.

---

## Analysis / Phân tích

### Approach: Digits Extraction and Verification
Simple iteration with digit extraction.
Lặp lại đơn giản với việc trích xuất chữ số.

---
