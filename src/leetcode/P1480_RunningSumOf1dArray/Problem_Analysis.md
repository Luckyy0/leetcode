# 1480. Running Sum of 1d Array / Tổng Chạy của Mảng 1d

## Problem Description / Mô tả bài toán
Array `nums`. Return `runningSum` where `runningSum[i] = sum(nums[0]...nums[i])`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum
Iterate and accumulate. Modify in-place or new array.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: In-place Update
Iterate from index 1. `nums[i] += nums[i-1]`.
Lặp lại từ chỉ số 1. `nums[i] += nums[i-1]`.

---
