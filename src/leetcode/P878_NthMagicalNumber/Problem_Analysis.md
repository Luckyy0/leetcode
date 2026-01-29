# 878. Nth Magical Number / Số Ma thuật thứ N

## Problem Description / Mô tả bài toán
A positive integer is magical if it is divisible by either `a` or `b`.
Một số nguyên dương được gọi là ma thuật nếu nó chia hết cho `a` hoặc `b`.

Given `n, a, b`, return the `nth` magical number. Since the answer may be very large, return it **modulo 10^9 + 7**.
Cho `n, a, b`, trả về số ma thuật thứ `n`. Vì kết quả có thể rất lớn, hãy trả về theo **modulo 10^9 + 7**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Inclusion-Exclusion and Binary Search / Nguyên lý bao hàm - loại trừ và Tìm kiếm nhị phân
For a number `X`, the count of magical numbers $\le X$ is:
`count(X) = (X / a) + (X / b) - (X / LCM(a, b))`.

Algorithm:
1. Calculate `LCM = (a * b) / GCD(a, b)`.
2. Binary search for $X$:
   - `low = min(a, b)`, `high = n * min(a, b)`.
   - Calculate `count(mid)`.
   - Adjust `low`, `high` accordingly.

### Complexity / Độ phức tạp
- **Time**: O(log(N * min(a, b))).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Range-based Magic Hunt
We search for the value $X$ that encloses exactly $N$ multiples of either $a$ or $b$. The inclusion-exclusion principle properly handles the overlapping multiples (divisible by both), allowing for a monotonic count function suitable for binary search.
Chúng ta tìm kiếm giá trị $X$ bao hàm đúng $N$ bội số của $a$ hoặc $b$. Nguyên lý bao hàm-loại trừ xử lý chính xác các bội số trùng lặp (chia hết cho cả hai), cho phép tạo ra một hàm đếm đơn điệu phù hợp cho tìm kiếm nhị phân.

---
