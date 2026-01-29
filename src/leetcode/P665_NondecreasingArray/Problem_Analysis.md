# 665. Non-decreasing Array / Mảng Không Giảm

## Problem Description / Mô tả bài toán
Given an array `nums` with `n` integers, your task is to check if it could become non-decreasing by modifying **at most one element**.
Cho một mảng `nums` với `n` số nguyên, nhiệm vụ của bạn là kiểm tra xem nó có thể trở thành mảng không giảm bằng cách sửa đổi **nhiều nhất một phần tử** hay không.

We define an array is non-decreasing if `nums[i] <= nums[i + 1]` holds for every `i` (0-indexed) such that (0 <= i <= n - 2).
Chúng tôi định nghĩa một mảng là không giảm nếu `nums[i] <= nums[i + 1]` giữ nguyên cho mỗi `i` sao cho (0 <= i <= n - 2).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach / Tiếp cận Tham lam
When we find an anomaly `nums[i] > nums[i+1]`, we must modify either `nums[i]` or `nums[i+1]`.
Khi chúng ta tìm thấy một điểm bất thường `nums[i] > nums[i+1]`, chúng ta phải sửa đổi `nums[i]` hoặc `nums[i+1]`.

The optimal strategy is:
1. Try to make `nums[i] = nums[i+1]`. This is valid if it doesn't break the non-decreasing property with `nums[i-1]`.
2. Otherwise, make `nums[i+1] = nums[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the array.
- **Space**: O(1) as we only use a counter and the internal state.

---

## Analysis / Phân tích

### Approach: Local Deficiency Check
Scan the array. Whenever `nums[i] > nums[i+1]`, increment a counter. If it exceeds 1, return false. Adjust the local values greedily to minimize future violations.
Quét mảng. Bất cứ khi nào `nums[i] > nums[i+1]`, hãy tăng bộ đếm. Nếu nó vượt quá 1, hãy trả về false. Điều chỉnh các giá trị cục bộ một cách tham lam để giảm thiểu các vi phạm trong tương lai.

---
