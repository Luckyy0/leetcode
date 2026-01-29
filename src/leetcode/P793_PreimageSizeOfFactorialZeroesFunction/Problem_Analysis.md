# 793. Preimage Size of Factorial Zeroes Function / Kích thước Preimage của Hàm Số không Giai thừa

## Problem Description / Mô tả bài toán
Let `f(x)` be the number of zeroes at the end of `x!`.
Gọi `f(x)` là số lượng các số không ở cuối của `x!`.

Recall that `f(x) = floor(x/5) + floor(x/25) + floor(x/125) + ...`.
Nhớ lại rằng `f(x) = floor(x/5) + floor(x/25) + floor(x/125) + ...`.

Given an integer `k`, return the number of non-negative integers `x` such that `f(x) = k`.
Cho một số nguyên `k`, hãy trả về số lượng các số nguyên không âm `x` sao cho `f(x) = k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Step Function Property / Thuộc tính Hàm bậc thang
The function `f(x)` is non-decreasing.
Hàm `f(x)` là hàm không giảm.

Crucially, as `x` increases by 5, `f(x)` increases by at least 1 (often more if it hits a power of 5).
Quan trọng là khi `x` tăng thêm 5, `f(x)` tăng thêm ít nhất 1 (thường nhiều hơn nếu nó chạm vào một lũy thừa của 5).

Since `f(x)` only changes at multiples of 5, and it's constant on `[5n, 5n+4]`:
- If there exists `x` such that `f(x) = k`, there are exactly **5** such integers `x`.
- If there is no such `x`, there are **0** such integers.

Algorithm:
1. Binary search for `x` such that `f(x) = k`.
2. Range for binary search: `[0, 5*k]`.

### Complexity / Độ phức tạp
- **Time**: O(log K).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Targeted Binary Search
We search for the smallest `x` where `f(x) >= k`. If for that `x`, `f(x) == k`, the answer is 5. Otherwise, the function skipped value `k`, and the answer is 0.
Chúng ta tìm số `x` nhỏ nhất mà `f(x) >= k`. Nếu tại `x` đó, `f(x) == k`, câu trả lời là 5. Ngược lại, hàm đã bỏ qua giá trị `k` và câu trả lời là 0.

---
