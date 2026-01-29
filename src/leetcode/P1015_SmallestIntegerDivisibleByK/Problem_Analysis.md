# 1015. Smallest Integer Divisible by K / Số nguyên Nhỏ nhất Chia hết cho K

## Problem Description / Mô tả bài toán
Given a positive integer `k`, you need to find the length of the smallest positive integer `n` such that `n` is divisible by `k`, and `n` only contains the digit `1`.
Cho một số nguyên dương `k`, bạn cần tìm độ dài của số nguyên dương nhỏ nhất `n` sao cho `n` chia hết cho `k`, và `n` chỉ chứa chữ số `1`.

Return the length of `n`. If no such `n` exists, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modular Arithmetic / Pigeonhole Principle / Số học Modulo / Nguyên lý Chuồng bồ câu
Numbers with only 1s: `1, 11, 111, ...`.
Recursive formula: `N_next = N_prev * 10 + 1`.
Modulo formula: `rem_next = (rem_prev * 10 + 1) % k`.

1. If `k` is even, a number ending in 1 cannot be divisible by even `k`.
2. If `k` is divisible by 5, number ending in 1 cannot be divisible.
3. Generally, if `gcd(k, 10) != 1`, impossible.

Algorithm:
1. Initialize `rem = 0`.
2. Loop `len` from 1 to `k`.
3. `rem = (rem * 10 + 1) % k`.
4. If `rem == 0`, return `len`.
5. If loop completes, return -1 (due to pigeonhole principle, remainders start cycling).

### Complexity / Độ phức tạp
- **Time**: O(K).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Remainder Cycling
Simulate the division process for the sequence 1, 11, 111... using modular arithmetic. If the remainder becomes zero, we found the solution. If the remainders start repeating (cycle detection), no solution exists. Since there are only K possible remainders, checking up to K iterations is sufficient.
Mô phỏng quá trình chia cho dãy số 1, 11, 111... bằng số học modulo. Nếu số dư bằng 0, chúng ta đã tìm thấy giải pháp. Nếu số dư bắt đầu lặp lại (phát hiện chu kỳ), không tồn tại giải pháp. Vì chỉ có K số dư có thể có, việc kiểm tra tối đa K lần lặp lại là đủ.

---
