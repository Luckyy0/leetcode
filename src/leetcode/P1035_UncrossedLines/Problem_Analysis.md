# 1035. Uncrossed Lines / Các đường không giao nhau

## Problem Description / Mô tả bài toán
You are given two integer arrays `nums1` and `nums2`. We write the integers of `nums1` and `nums2` (in the order they are given) on two separate horizontal lines.
Bạn được cho hai mảng số nguyên `nums1` và `nums2`. Chúng tôi viết các số nguyên của `nums1` và `nums2` (theo thứ tự đã cho) trên hai đường ngang riêng biệt.

We may draw connecting lines: a straight line connecting a number `nums1[i]` and `nums2[j]` such that:
- `nums1[i] == nums2[j]`.
- The line does not intersect any other connecting (non-horizontal) line.

Return the maximum number of connecting lines.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Longest Common Subsequence (LCS) / Chuỗi con Chung Dài nhất
The condition "lines do not intersect" combined with "order preserved" is effectively asking for the Longest Common Subsequence.
Điều kiện "các đường không giao nhau" kết hợp với "thứ tự được bảo toàn" thực chất là yêu cầu tìm Chuỗi con Chung Dài nhất.

Algorithm:
1. `dp[i][j]` = max lines using `nums1[0..i-1]` and `nums2[0..j-1]`.
2. If `nums1[i-1] == nums2[j-1]`: `dp[i][j] = dp[i-1][j-1] + 1`.
3. Else: `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Structural Equivalence to LCS
Recognize that drawing non-crossing lines between identical elements is mathematically isomorphic to finding the Longest Common Subsequence. We apply standard dynamic programming to solve this matching problem.
Nhận ra rằng việc vẽ các đường không cắt nhau giữa các phần tử giống hệt nhau là đẳng cấu về mặt toán học với việc tìm Chuỗi con Chung Dài nhất. Chúng ta áp dụng quy hoạch động tiêu chuẩn để giải quyết bài toán ghép nối này.

---
