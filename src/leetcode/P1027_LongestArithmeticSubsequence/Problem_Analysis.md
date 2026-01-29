# 1027. Longest Arithmetic Subsequence / Chuỗi con Cấp số cộng Dài nhất

## Problem Description / Mô tả bài toán
Given an array `nums` of integers, return the length of the longest arithmetic subsequence in `nums`.
Cho một mảng các số nguyên `nums`, hãy trả về độ dài của chuỗi con cấp số cộng dài nhất trong `nums`.

Recall that a subsequence of an array `nums` is a list `nums[i_1], nums[i_2], ..., nums[i_k]` with `0 <= i_1 < i_2 < ... < i_k <= nums.length - 1`, and that a sequence `seq` is arithmetic if `seq[i+1] - seq[i]` are all the same value (for `0 <= i < seq.length - 1`).
Hãy nhớ rằng một chuỗi con của mảng `nums` là một danh sách `nums[i_1], nums[i_2], ..., nums[i_k]` với `0 <= i_1 < i_2 < ... < i_k <= nums.length - 1`, và một chuỗi `seq` là cấp số cộng nếu `seq[i+1] - seq[i]` đều có cùng giá trị.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with HashMap / Quy hoạch Động với HashMap
`dp[i][diff]` = length of the longest arithmetic subsequence ending at index `i` with common difference `diff`.
`dp[i][diff]` = độ dài của chuỗi con cấp số cộng dài nhất kết thúc tại chỉ số `i` với công sai `diff`.

Range of Diff: `0 <= nums[i] <= 500`, so diff is inside `[-500, 500]`.
We can offset the `diff` to make it non-negative for array indices (add 500).

Algorithm:
1. Initialize `dp[n][1001]` with 0 or 1.
2. Iterate `i` from 1 to `n-1`.
3. Iterate `j` from 0 to `i-1`.
4. `diff = nums[i] - nums[j]`. Offset `diff + 500`.
5. `dp[i][diff] = dp[j][diff] + 1`.
6. Update global max.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or O(N * RangeOfValues).

---

## Analysis / Phân tích

### Approach: Difference-Indexed State
Use dynamic programming where the state is defined by the current index and the arithmetic difference. By checking all previous indices $j < i$, we extend existing subsequences with difference $\Delta = nums[i] - nums[j]$, effectively determining the longest chain for any given step size.
Sử dụng quy hoạch động trong đó trạng thái được xác định bởi chỉ số hiện tại và hiệu số cấp số cộng. Bằng cách kiểm tra tất cả các chỉ số trước đó $j < i$, chúng ta mở rộng các chuỗi con hiện có với hiệu số $\Delta = nums[i] - nums[j]$, xác định hiệu quả chuỗi dài nhất cho bất kỳ kích thước bước nào.

---
