# 1458. Max Dot Product of Two Subsequences / Tích Dot Tối đa của Hai Chuỗi con

## Problem Description / Mô tả bài toán
Arrays `nums1`, `nums2`.
Pick Subsequence from `nums1` and `nums2` of SAME LENGTH.
Dot product `sum(nums1[i] * nums2[j] ...)`.
Maximize dot product. Non-empty.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (LCS adaptation)
`dp[i][j]` = max dot product using subsequences from `nums1[0..i]` and `nums2[0..j]`.
Transition:
At `i`, `j`:
1. `nums1[i] * nums2[j] + max(0, dp[i-1][j-1])` (Use both `i` and `j`, extend previous best (if positive) or start new).
2. `dp[i-1][j]` (Skip `nums1[i]`).
3. `dp[i][j-1]` (Skip `nums2[j]`).
`dp[i][j] = max(option1, option2, option3)`.

### Complexity / Độ phức tạp
- **Time**: O(N * M).
- **Space**: O(N * M).

---

## Analysis / Phân tích

### Approach: 2D DP
Initialize DP table. Handle edge case of negative values (might pick single pair).
`dp[i][j]` stores max dot product.
To ensure non-empty: Option 1 calculates direct product. If `dp[i-1][j-1] < 0`, we take just `nums1[i]*nums2[j]` to restart subarray?
Actually, `max(nums1[i]*nums2[j], nums1[i]*nums2[j] + dp[i-1][j-1])`.
Also consider `dp[i-1][j]` and `dp[i][j-1]`.
We need to ensure non-empty. So initialize with very small.
Khởi tạo bảng DP. Xử lý trường hợp biên của các giá trị âm.
`dp[i][j]` lưu trữ tích dot tối đa.
Để đảm bảo không rỗng: `max(nums1[i]*nums2[j], nums1[i]*nums2[j] + dp[i-1][j-1])`.
Đồng thời xem xét `dp[i-1][j]` và `dp[i][j-1]`.

---
