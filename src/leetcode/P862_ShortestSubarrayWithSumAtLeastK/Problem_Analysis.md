# 862. Shortest Subarray with Sum at Least K / Mảng con Ngắn nhất có Tổng ít nhất là K

## Problem Description / Mô tả bài toán
Given an integer array `nums` and an integer `k`, return the length of the shortest non-empty subarray with a sum of at least `k`. If there is no such subarray, return `-1`.
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về độ dài của mảng con không rỗng ngắn nhất có tổng ít nhất là `k`. Nếu không có mảng con như vậy, hãy trả về `-1`.

Note: The array can contain negative numbers.
Lưu ý: Mảng có thể chứa các số âm.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window with Deque / Cửa sổ trượt với Deque
Because of negative numbers, a standard two-pointer sliding window doesn't work (sum is not monotonic).
Vì có các số âm, cửa sổ trượt hai con trỏ tiêu chuẩn không hoạt động (tổng không đơn điệu).

Algorithm:
1. Use prefix sums `P[i] = nums[0] + ... + nums[i-1]`.
2. We want to find `j > i` such that `P[j] - P[i] >= k` and `j - i` is minimized.
3. Use a `Deque<Integer>` to store indices of `P` in increasing order of `P` values.
4. For each `P[j]`:
   - While `P[j] - P[deque.first()] >= k`, update result and remove `first`. (Found a candidate).
   - While `P[j] <= P[deque.last()]`, remove `last`. (New prefix sum is better - smaller value with larger index).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Monotonic Deque for Prefix Sums
The deque maintains a set of "promising" starting points for a subarray. By removing indices that are strictly worse than the current index (larger prefix sum but earlier position), we keep only candidates that could potentially yield a shorter valid subarray.
Deque duy trì một tập hợp các điểm bắt đầu "hứa hẹn" cho một mảng con. Bằng cách loại bỏ các chỉ số kém hơn chỉ số hiện tại (tổng tiền tố lớn hơn nhưng vị trí sớm hơn), chúng ta chỉ giữ lại các ứng viên có khả năng tạo ra một mảng con hợp lệ ngắn hơn.

---
