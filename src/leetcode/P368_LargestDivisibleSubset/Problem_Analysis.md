# 368. Largest Divisible Subset / Tập Con Lớn Nhất Chia Hết

## Problem Description / Mô tả bài toán
Given a set of **distinct** positive integers `nums`, return the largest subset `answer` such that every pair `(answer[i], answer[j])` of elements in this subset satisfies:
- `answer[i] % answer[j] == 0`, or
- `answer[j] % answer[i] == 0`
Cho một tập hợp các số nguyên dương **khác nhau** `nums`, trả về tập con lớn nhất sao cho mọi cặp phần tử thỏa mãn điều kiện chia hết.

If there are multiple solutions, return any of them.

### Example 1:
```text
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
```

### Example 2:
```text
Input: nums = [1,2,4,8]
Output: [1,2,4,8]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 2 * 10^9`
- All the integers in `nums` are **unique**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sorting + DP / Sắp Xếp + Quy Hoạch Động
The condition `a % b == 0` or `b % a == 0` is transitive if sorted.
If `a < b < c` and `b` divides `a` (impossible, `b` must be multiple of `a` if `b > a`).
Let's sort `nums` ascending.
If `nums[j] % nums[i] == 0` (where `i < j`), then `nums[j]` can extend any divisible subset ending at `nums[i]`.
This is exactly **Longest Increasing Subsequence (LIS)** but with divisibility check instead of inequality.
`dp[i]` = max length of divisible subset ending at `nums[i]`.
`parent[i]` = index of previous element in subset.
Reconstruct path from max length index.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Sort + DP

**Algorithm**:
1.  Sort `nums`.
2.  `dp` array init 1. `prev` array init -1.
3.  `maxLen`, `maxIdx`.
4.  Loop `i` from 1 to N-1.
    - Loop `j` from 0 to `i-1`.
    - If `nums[i] % nums[j] == 0` and `dp[j] + 1 > dp[i]`:
        - `dp[i] = dp[j] + 1`.
        - `prev[i] = j`.
5.  Update global max.
6.  Backtrack from `maxIdx` using `prev` to build result.

---
