# 1012. Numbers With Repeated Digits / Các số có Chữ số Lặp lại

## Problem Description / Mô tả bài toán
Given an integer `n`, return the number of positive integers in the range `[1, n]` that have **at least one** repeated digit.
Cho một số nguyên `n`, hãy trả về số lượng các số nguyên dương trong khoảng `[1, n]` mà có **ít nhất một** chữ số lặp lại.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combinatorics / Inverse Counting / Tổ hợp / Đếm Ngược
Count numbers with repeated digits = Total numbers - Numbers without repeated digits.
Đếm số có chữ số lặp lại = Tổng số - Số không có chữ số lặp lại.

Numbers without repeated digits are permutations.
- Count numbers with fewer digits than `n`.
- Count numbers with same digits as `n` up to `n` itself using Digit DP logic.

Algorithm:
1. Use `A(m, n)` representing permutations $P(m, n) = m! / (m-n)!$.
2. Convert `n` to digits list.
3. Count numbers with length 1 to `len-1`:
   - Length 1: 9.
   - Length `k`: $9 \times A(9, k-1)$.
4. Count numbers with length `len` less than or equal to `n`:
   - Iterate digits from left to right.
   - For current position `i`, try digits `d` from 0 (or 1 if first) to `digits[i]-1`.
   - If `d` is not used in prefix, add permutations for remaining positions.
   - If `digits[i]` itself is already used, break.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Complementary Counting with Arithmetic
Instead of finding repeats directly, calculate the count of numbers with *unique* digits and subtract from the total. Construct these unique-digit numbers digit-by-digit, considering length mismatches and prefix constraints separately.
Thay vì tìm các số lặp lại trực tiếp, hãy tính số lượng các số có các chữ số *duy nhất* và trừ đi khỏi tổng số. Xây dựng các số có chữ số duy nhất này theo từng chữ số, xem xét sự không khớp về độ dài và các ràng buộc tiền tố một cách riêng biệt.

---
