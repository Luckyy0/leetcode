# 1134. Armstrong Number / Số Armstrong

## Problem Description / Mô tả bài toán
Given an integer `n`, return `true` if and only if it is an Armstrong number.
The k-digit number `n` is an Armstrong number if and only if the kth power of each digit sums to `n`.
Cho một số nguyên `n`, hãy trả về `true` nếu và chỉ nếu nó là một số Armstrong.
Số `n` gồm k chữ số là số Armstrong nếu và chỉ nếu lũy thừa k của mỗi chữ số cộng lại bằng `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit Extraction and Power / Trích xuất Chữ số và Lũy thừa
1. Convert to string to find K.
2. Sum digit^K.
3. Check sum == n.

---
