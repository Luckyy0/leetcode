# 1354. Construct Target Array With Multiple Sums / Xây dựng Mảng Mục tiêu với Nhiều Tổng

## Problem Description / Mô tả bài toán
Start with array `[1, 1, ..., 1]`.
In each step, replace any element with sum of all elements.
Given `target` array. Can we construct it?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Simulation
Working backwards from `target`.
Largest element `max` in `target` must have been the sum of previous state.
Previous state had: `max - (sum - max)`.
Basically: `prev_val = max % rest_sum`.
Using modulo because we could have applied the operation multiple times to the same index.
Algorithm:
1. Max Heap for `target`.
2. `Sum` = sum(target).
3. While `max > 1`:
   - Pop `max`.
   - `rest = Sum - max`.
   - If `rest == 1`, return true (reduce to 1s easily).
   - If `rest == 0` or `max <= rest`, return false (cannot reverse).
   - `prev = max % rest`.
   - If `prev == 0`, `prev = rest`? No, if modulo is 0 and rest!=1, it means `max` is multiple of `rest`, reduces to 0 (invalid for target > 1). Actually just `max % rest`. If `max % rest == 0`, result is 0 (invalid since base is 1), unless `rest==1`. But we handled `rest==1`. So if `prev == 0`, false.
   - Update `sum = rest + prev`.
   - Push `prev`.

### Complexity / Độ phức tạp
- **Time**: O(N log N log MaxVal) or O(N + log MaxVal * log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Reverse with PriorityQueue
Use a priority queue (max heap) to always process the largest element.
Calculate total sum.
Process:
1. Pop largest element `zoom`.
2. Compute `rest = sum - zoom`.
3. If `rest == 1`, return true (other elements sum to 1, likely `[1, zoom]` case with size 2, or just effectively solvable).
4. If `rest == 0` (only 1 element in array) or `zoom <= rest` (impossible to have come from sum), return false.
5. New value `next = zoom % rest`.
6. If `next == 0` (but `rest != 1`), impossible since array started at 1s.
7. Update sum and push `next` back to queue.
Repeat until max element is 1.
Sử dụng hàng đợi ưu tiên (max heap) để luôn xử lý phần tử lớn nhất.
Tính tổng.
Quy trình:
1. Pop phần tử lớn nhất `zoom`.
2. Tính `rest = sum - zoom`.
3. Nếu `rest == 1`, trả về true.
4. Nếu `rest == 0` hoặc `zoom <= rest`, trả về false.
5. Giá trị mới `next = zoom % rest`.
6. Nếu `next == 0`, không thể.
7. Cập nhật tổng và đẩy `next` trở lại hàng đợi.
Lặp lại cho đến khi phần tử tối đa là 1.

---
