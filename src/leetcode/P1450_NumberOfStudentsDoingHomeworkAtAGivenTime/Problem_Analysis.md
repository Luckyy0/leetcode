# 1450. Number of Students Doing Homework at a Given Time / Số lượng Sinh viên Làm Bài tập về nhà tại một Thời điểm Nhất định

## Problem Description / Mô tả bài toán
Arrays `startTime` and `endTime`. `queryTime`.
Count students doing homework at `queryTime` (`start <= query <= end`).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iteration
Iterate arrays. Check condition.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Iterate `i`. If `startTime[i] <= queryTime <= endTime[i]`, count++.
Lặp lại `i`. Nếu `startTime[i] <= queryTime <= endTime[i]`, count++.

---
