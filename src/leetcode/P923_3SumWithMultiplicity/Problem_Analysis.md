# 923. 3Sum With Multiplicity / 3Sum với Bội số

## Problem Description / Mô tả bài toán
Given an integer array `arr` and an integer `target`, return the number of tuples `(i, j, k)` such that `i < j < k` and `arr[i] + arr[j] + arr[k] == target`.
Cho một mảng số nguyên `arr` và một số nguyên `target`, hãy trả về số lượng các bộ ba `(i, j, k)` sao cho `i < j < k` và `arr[i] + arr[j] + arr[k] == target`.

Since the answer may be very large, return it **modulo 10^9 + 7**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combinatorial Count with Map / Đếm Tổ hợp với Map
Algorithm:
1. Count the frequency of each number in `arr`.
2. Iterate through all unique values `x, y, z` such that `x + y + z == target`:
   - Case 1: `x < y < z` -> Count = `count[x] * count[y] * count[z]`.
   - Case 2: `x == y < z` -> Count = `comb(count[x], 2) * count[z]`.
   - Case 3: `x < y == z` -> Count = `count[x] * comb(count[y], 2)`.
   - Case 4: `x == y == z` -> Count = `comb(count[x], 3)`.

Note: `comb(n, 2) = n * (n-1) / 2`, `comb(n, 3) = n * (n-1) * (n-2) / 6`.

### Complexity / Độ phức tạp
- **Time**: O(UniqueValues^2) or O(N + Range^2).
- **Space**: O(Range).

---

## Analysis / Phân tích

### Approach: Symmetric Reduction
Translate the triplet search into a frequency-based calculation. By iterating through unique sorted values, we handle all combinations without redundancy, applying standard binomial coefficients to account for identical elements.
Chuyển đổi việc tìm kiếm bộ ba thành tính toán dựa trên tần suất. Bằng cách lặp qua các giá trị duy nhất đã sắp xếp, chúng ta xử lý tất cả các tổ hợp mà không dư thừa, áp dụng các hệ số nhị thức tiêu chuẩn để tính đến các phần tử giống nhau.

---
