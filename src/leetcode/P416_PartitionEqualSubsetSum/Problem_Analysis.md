# 416. Partition Equal Subset Sum / Chia Tập Hợp Có Tổng Bằng Nhau

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return `true` if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or `false` otherwise.
Cho một mảng số nguyên `nums`, hãy trả về `true` nếu bạn có thể chia mảng thành hai tập hợp con sao cho tổng các phần tử trong cả hai tập hợp con là bằng nhau, ngược lại trả về `false`.

### Example 1:
```text
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
```

### Example 2:
```text
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 200`
- `1 <= nums[i] <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### 0/1 Knapsack (DP) / Bài toán Cái túi 0/1 (DP)
This is a variation of the Subset Sum Problem, which is a specific case of the 0/1 Knapsack problem.
1. If the total sum of all elements is odd, it's impossible to split into two equal integer sums. Return `false`.
2. Let `target = total_sum / 2`. The problem reduces to: "Is there a subset of `nums` that sums up to `target`?"
3. Dynamic Programming:
   - Define `dp[i]` as a boolean value indicating whether a sum `i` can be achieved using a subset of the elements seen so far.
   - Base case: `dp[0] = true` (an empty subset has sum 0).
   - For each number `n` in `nums`, update the `dp` array: `dp[i] = dp[i] || dp[i - n]`.
   - Important: To avoid using the same element multiple times for the same sum, iterate the inner loop from `target` down to `n`.

### Complexity / Độ phức tạp
- **Time**: O(N * Sum/2) where N is the number of elements and Sum is the total sum.
- **Space**: O(Sum/2) for the boolean DP array.

---

## Analysis / Phân tích

### Approach: 1D Dynamic Programming

**Algorithm**:
1.  Sum the array and check parity.
2.  Initialize `dp[target + 1]`.
3.  Fill `dp` iteratively.

---
