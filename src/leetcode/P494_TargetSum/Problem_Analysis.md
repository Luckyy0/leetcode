# 494. Target Sum / Tổng Mục Tiêu

## Problem Description / Mô tả bài toán
You are given an integer array `nums` and an integer `target`.
Cho một mảng số nguyên `nums` và một số nguyên `target`.

You want to build an expression out of nums by adding one of the symbols `+` and `-` before each integer in nums and then concatenate all the integers.
Bạn muốn tạo một biểu thức từ `nums` bằng cách thêm một trong các ký tự `+` hoặc `-` vào trước mỗi số nguyên trong `nums` và sau đó nối tất cả các số nguyên lại.

- For example, if `nums = [2, 1]`, you can add a `+` before `2` and a `-` before `1` and concatenate them to build the expression `+2-1`.

Return the number of different expressions that you can build, which evaluates to `target`.
Hãy trả về số lượng các biểu thức khác nhau mà bạn có thể tạo ra sao cho kết quả tính toán bằng `target`.

### Example 1:
```text
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

### Example 2:
```text
Input: nums = [1], target = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 20`
- `0 <= nums[i] <= 1000`
- `0 <= sum(nums[i]) <= 1000`
- `-1000 <= target <= 1000`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Subset Sum) / Quy hoạch động (Tổng tập con)
Let `P` be the set of elements assigned `+` and `N` be the set of elements assigned `-`.
$Sum(P) - Sum(N) = target$
$Sum(P) - Sum(N) + Sum(P) + Sum(N) = target + Sum(P) + Sum(N)$
$2 * Sum(P) = target + Sum(nums)$
$Sum(P) = (target + Sum(nums)) / 2$

This reduces the problem to finding the number of subsets whose sum is exactly `(target + Sum(nums)) / 2`.
This is only possible if `(target + Sum(nums))` is even and non-negative.

Algorithm:
1. `totalSum = sum(nums)`.
2. Check if `(target + totalSum)` is even and and `abs(target) <= totalSum`.
3. `targetSubsetSum = (target + totalSum) / 2`.
4. Run standard 1D subset sum DP: `dp[i]` is the number of ways to get sum `i`.
5. Return `dp[targetSubsetSum]`.

### Complexity / Độ phức tạp
- **Time**: O(N * S) where S is the target sum.
- **Space**: O(S).

---

## Analysis / Phân tích

### Approach: Mathematical Transformation to Subset Sum

**Algorithm**:
1.  Verify feasibility.
2.  Calculate target subset sum.
3.  1D DP for count of subset sums.

---
