# 852. Peak Index in a Mountain Array / Chỉ số Đỉnh trong Mảng Núi

## Problem Description / Mô tả bài toán
An array is a mountain if:
- `arr.length >= 3`
- There exists some `i` with `0 < i < n - 1` such that:
  - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
  - `arr[i] > arr[i + 1] > ... > arr[n - 1]`

Return the index `i` such that the array is a mountain.
Trả về chỉ số `i` sao cho mảng đó là một mảng núi.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Monotonicity / Tìm kiếm Nhị phân trên tính Đơn điệu
Since the sequence increases and then decreases, we can use binary search.
Vì dãy số tăng rồi giảm, chúng ta có thể sử dụng tìm kiếm nhị phân.

Algorithm:
1. `low = 0, high = n - 1`.
2. While `low < high`:
   - `mid = low + (high - low) / 2`.
   - If `arr[mid] < arr[mid + 1]`, the peak is on the right side.
   - Else, the peak is `mid` or on the left side.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Derivative-based Search
We are looking for the point where the "slope" changes from positive to negative. Binary search allows us to find this inflection point in logarithmic time.
Chúng ta đang tìm điểm mà tại đó "độ dốc" thay đổi từ dương sang âm. Tìm kiếm nhị phân cho phép chúng ta tìm thấy điểm uốn này trong thời gian logarit.

---
