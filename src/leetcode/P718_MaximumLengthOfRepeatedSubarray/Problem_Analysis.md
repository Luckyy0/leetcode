# 718. Maximum Length of Repeated Subarray / Độ dài Tối đa của Mảng con Lặp lại

## Problem Description / Mô tả bài toán
Given two integer arrays `nums1` and `nums2`, return the maximum length of a subarray that appears in both arrays.
Cho hai mảng số nguyên `nums1` và `nums2`, hãy trả về độ dài tối đa của một mảng con xuất hiện trong cả hai mảng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
Let `dp[i][j]` be the length of the longest common suffix of `nums1[0...i-1]` and `nums2[0...j-1]`.
Gọi `dp[i][j]` là độ dài của hậu tố chung dài nhất của `nums1[0...i-1]` và `nums2[0...j-1]`.

If `nums1[i-1] == nums2[j-1]`:
`dp[i][j] = dp[i-1][j-1] + 1`

Otherwise:
`dp[i][j] = 0`

Result is `max(dp[i][j])` for all `i, j`.

### Complexity / Độ phức tạp
- **Time**: O(N * M) where N, M are lengths of the arrays.
- **Space**: O(N * M) or O(M) with space optimization.

---

## Analysis / Phân tích

### Approach: 2D DP Table
Fill a table where each cell `(i, j)` stores the length of the matching subarray ending at those positions.
Điền vào một bảng trong đó mỗi ô `(i, j)` lưu trữ độ dài của mảng con phù hợp kết thúc tại các vị trí đó.

---
