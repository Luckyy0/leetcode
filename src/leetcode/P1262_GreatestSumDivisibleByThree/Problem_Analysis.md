# 1262. Greatest Sum Divisible by Three / Tổng Lớn nhất Chia hết cho Ba

## Problem Description / Mô tả bài toán
Given array `nums`. Maximum sum of elements such that sum is divisible by 3.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Modular Arithmetic
Maintain max sum with modulo 0, 1, 2.
`dp[0]`, `dp[1]`, `dp[2]`.
Iterate `x`.
For each `state k in [0, 1, 2]`:
new sum = `dp[k] + x`.
update `dp[new_sum % 3] = max(dp[new_sum % 3], new_sum)`.
Need temporary array to avoid using updated values from same iteration.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Remainder DP
Maintain an array `dp` of size 3, where `dp[i]` represents the maximum sum found so far that has a remainder of `i` when divided by 3. Initialize `dp` with 0 (or very small numbers for 1 and 2 to indicate unreachable). Iterate through each number `num` in the input array. Update the `dp` states: for each remainder `i`, `dp[(i + num) % 3]` can be updated using `dp[i] + num`. Use a temporary array for updates to avoid using values from the current step. Finally, return `dp[0]`.
Duy trì một mảng `dp` có kích thước 3, trong đó `dp[i]` đại diện cho tổng lớn nhất được tìm thấy cho đến nay có số dư là `i` khi chia cho 3. Khởi tạo `dp` bằng 0 (hoặc các số rất nhỏ cho 1 và 2 để biểu thị không thể đạt được). Lặp lại qua từng số `num` trong mảng đầu vào. Cập nhật các trạng thái `dp`: đối với mỗi số dư `i`, `dp[(i + num) % 3]` có thể được cập nhật bằng `dp[i] + num`. Sử dụng một mảng tạm thời cho các bản cập nhật để tránh sử dụng các giá trị từ bước hiện tại. Cuối cùng, trả về `dp[0]`.

---
