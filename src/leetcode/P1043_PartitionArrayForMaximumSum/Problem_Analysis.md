# 1043. Partition Array for Maximum Sum / Phân chia Mảng để có Tổng Lớn nhất

## Problem Description / Mô tả bài toán
Given an integer array `arr`, partition the array into (contiguous) subarrays of length at most `k`. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
Cho một mảng số nguyên `arr`, hãy phân chia mảng thành các mảng con (liên tiếp) có độ dài tối đa là `k`. Sau khi phân chia, các giá trị của mỗi mảng con được thay đổi thành giá trị lớn nhất của mảng con đó.

Return the largest sum of the given array after partitioning.
Trả về tổng lớn nhất của mảng đã cho sau khi phân chia.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i]` = maximum sum for `arr[0...i-1]` (length `i`).
`dp[i]` = tổng lớn nhất cho `arr[0...i-1]` (độ dài `i`).

To compute `dp[i]`:
Consider the last partition ending at `i-1`. Its length `j` can be from 1 to `k`.
The partition is `arr[i-j...i-1]`.
Value of this partition = `max(arr[i-j...i-1]) * j`.
Remaining sum = `dp[i-j]`.

Transition:
`dp[i] = max(dp[i-j] + maxVal * j)` over `1 <= j <= k` and `i-j >= 0`.

### Complexity / Độ phức tạp
- **Time**: O(N * K).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Window-Based Optimization
Evaluate the optimal way to terminate a partition at each index. By looking back up to K steps, determine the best "last chunk" configuration (maximizing the local chunk value) combined with the optimal solution for the prefix.
Đánh giá cách tối ưu để kết thúc phân vùng tại mỗi chỉ số. Bằng cách nhìn lại tối đa K bước, xác định cấu hình "khối cuối cùng" tốt nhất (tối đa hóa giá trị khối cục bộ) kết hợp với giải pháp tối ưu cho tiền tố.

---
