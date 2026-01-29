# 1491. Average Salary Excluding the Minimum and Maximum Salary / Lương Trung bình Ngoại trừ Lương Tối thiểu và Tối đa

## Problem Description / Mô tả bài toán
Array `salary`. Compute average excluding min and max.
All elements unique.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iteration
Find min, max, sum.
Avg = (Sum - Min - Max) / (Count - 2).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: One Pass
Iterate to accumulate sum and find min/max.
Compute result.
Lặp lại để tích lũy tổng và tìm min/max.
Tính kết quả.

---
