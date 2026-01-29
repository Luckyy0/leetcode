# 1512. Number of Good Pairs / Số lượng Cặp Tốt

## Problem Description / Mô tả bài toán
Array `nums`. `(i, j)` is good if `nums[i] == nums[j]` and `i < j`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Map
Count frequencies.
If a number appears `count` times, it contributes `count * (count - 1) / 2` pairs.
Sum for all numbers.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Count Frequencies
Iterate, count in array/map. Compute formula.
Lặp lại, đếm trong mảng/bản đồ. Tính công thức.

---
