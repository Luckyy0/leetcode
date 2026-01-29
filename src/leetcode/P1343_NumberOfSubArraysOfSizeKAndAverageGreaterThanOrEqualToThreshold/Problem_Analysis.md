# 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold / Số lượng Mảng con Kích thước K và Trung bình Lớn hơn hoặc Bằng Ngưỡng

## Problem Description / Mô tả bài toán
Array `arr`, ints `k`, `threshold`.
Count sub-arrays of size `k` with average >= `threshold`.
Equivalent to sum >= `k * threshold`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window
Window size `k`.
Compute initial sum of `arr[0...k-1]`.
Check condition.
Slide window: `sum += arr[i] - arr[i-k]`.
Check condition.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sliding Window
Instead of calculating average (floating point), calculate `targetSum = k * threshold`. Maintain a running sum of the window of size `k`.
Initialize sum with first `k` elements. If `sum >= targetSum`, count.
For `i` from `k` to `n-1`:
Update sum: add `arr[i]`, subtract `arr[i-k]`.
If `sum >= targetSum`, count.
Thay vì tính trung bình (dấu phẩy động), hãy tính `targetSum = k * threshold`. Duy trì tổng chạy của cửa sổ kích thước `k`.
Khởi tạo tổng với `k` phần tử đầu tiên. Nếu `sum >= targetSum`, đếm.
Đối với `i` từ `k` đến `n-1`:
Cập nhật tổng: cộng `arr[i]`, trừ `arr[i-k]`.
Nếu `sum >= targetSum`, đếm.

---
