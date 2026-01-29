# 902. Numbers At Most N Given Digit Set / Các số Tối đa là N từ Tập chữ số cho trước

## Problem Description / Mô tả bài toán
Given an array of `digits` (as strings) and an integer `n`, return the number of positive integers that can be generated using the digits from `digits` such that they are less than or equal to `n`.
Cho một mảng `digits` (dưới dạng chuỗi) và một số nguyên `n`, hãy trả về số lượng các số nguyên dương có thể được tạo ra bằng cách sử dụng các chữ số từ `digits` sao cho chúng nhỏ hơn hoặc bằng `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combinatorics and Digit DP / Tổ hợp và DP Chữ số
Algorithm:
1. Let `L` be the length of `n` (as a string).
2. Count all numbers with length `< L`:
   - For each length `i` from 1 to `L-1`, total numbers = `(digits.length)^i`.
3. Count numbers with length `L`:
   - Iterate through characters of `n` from left to right.
   - For character at index `j`, count digits in `digits` that are strictly smaller than `n[j]`.
   - For each such digit, we can form `(digits.length)^(L - 1 - j)` numbers.
   - If `n[j]` is not in `digits`, we stop.
   - If we reach the end and all characters matched, add 1.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Layered Counting
We handle the generation in two phases: first, by counting all numbers that are naturally smaller due to having fewer digits; second, by performing a prefix-based comparison for numbers with the same digit count as the target.
Chúng ta xử lý việc tạo số theo hai giai đoạn: đầu tiên, bằng cách đếm tất cả các số nhỏ hơn một cách tự nhiên do có ít chữ số hơn; thứ hai, bằng cách thực hiện so sánh dựa trên tiền tố cho các số có cùng số lượng chữ số với mục tiêu.

---
