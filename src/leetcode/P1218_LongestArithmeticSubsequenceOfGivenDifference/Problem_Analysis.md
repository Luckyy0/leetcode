# 1218. Longest Arithmetic Subsequence of Given Difference / Chuỗi con Cấp số cộng Dài nhất với Hiệu số Cho trước

## Problem Description / Mô tả bài toán
Given an integer array `arr` and an integer `difference`, return the length of the longest subsequence such that difference between adjacent elements in the subsequence equals `difference`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with HashMap
`dp[val]` = length of longest arithmetic subseq ending with value `val`.
Iterate `x` in `arr`:
`dp[x] = dp[x - diff] + 1`.
Max value in dp map.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Hash Map DP
Iterate through the array. For each element `x`, checking if the previous term of the arithmetic progression `x - difference` exists. If it does, we extend that subsequence. Store lengths in a map: `dp[x] = dp.getOrDefault(x - difference, 0) + 1`. This finds the longest subsequence ending at each element in O(1) per element.
Lặp qua mảng. Đối với mỗi phần tử `x`, kiểm tra xem số hạng trước đó của cấp số cộng `x - difference` có tồn tại hay không. Nếu có, chúng ta mở rộng chuỗi con đó. Lưu trữ độ dài trong bản đồ: `dp[x] = dp.getOrDefault(x - difference, 0) + 1`. Điều này tìm thấy chuỗi con dài nhất kết thúc tại mỗi phần tử trong O(1) cho mỗi phần tử.

---
