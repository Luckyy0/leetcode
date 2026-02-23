# Analysis for Partition Equal Subset Sum
# *Phân tích cho bài toán Chia mảng thành hai tập hợp có Tổng bằng nhau*

## 1. Problem Essence & Subset Sum Transformation
## *1. Bản chất vấn đề & Chuyển đổi Tổng tập hợp con*

### The Challenge
### *Thách thức*
Splitting an array into two subsets with equal sums.
Let $S$ be the total sum of the array. If a partition exists, each subset must have a sum of $S/2$.
- If $S$ is odd, return `false`.
- The problem is reduced to: **Can we find a subset with sum exactly $S/2$?** This is the classic 0/1 Knapsack (Subset Sum) problem.

### Strategy: Dynamic Programming (0/1 Knapsack)
### *Chiến lược: Quy hoạch động (Cái túi 0/1)*
1.  **State Definition:** `dp[j]` is a boolean indicating whether a sum of `j` can be formed using a subset of the numbers processed so far.
2.  **Base Case:** `dp[0] = true` (an empty subset has sum 0).
3.  **Transition:** Loop through each number `num` and update the `dp` table from right to left (to ensure each number is used at most once):
    - `dp[j] = dp[j] || dp[j - num]` for `j` from `target` down to `num`.
4.  **Result:** Result is `dp[target]`.

---

## 2. Approach: Space-Optimized DP
## *2. Hướng tiếp cận: Quy hoạch động Tối ưu Không gian*

### Logic
### *Logic*
(See above). The right-to-left update is essential for the 1D space optimization to prevent using the same element multiple times in the same subset (0/1 constraint).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Substructure:** Breaking down the target sum into smaller achievable sums.
    *Cấu trúc con tối ưu: Chia nhỏ tổng mục tiêu thành các tổng nhỏ hơn có thể đạt được.*
*   **Space Management:** $O(S/2)$ space complexity is very efficient.
    *Quản lý không gian: Độ phức tạp không gian O(S/2) rất hiệu quả.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot S)$, where $N$ is number of elements and $S$ is the total sum.
    *Độ phức tạp thời gian: $O(N \cdot S)$.*
*   **Space Complexity:** $O(S)$.
    *Độ phức tạp không gian: $O(S)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [1, 5, 11, 5]`
- Total sum: 22. Target: 11.
1. `num = 1`: `dp[1] = true`.
2. `num = 5`: `dp[6], dp[5] = true`.
3. `num = 11`: `dp[11] = true` (because `dp[11-11]` was true).
Result: `dp[11] == true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Subset Sum DP with 1D space optimization.
*Quy hoạch động Tổng tập hợp con với tối ưu không gian 1D.*
---
*Sự công bằng (equal partition) trong toán học không chỉ là phép chia đôi, mà là việc tìm kiếm những tổ hợp (subsets) phù hợp để lấp đầy khoảng trống. Bằng cách xây dựng từng bước một (DP), ta có thể nhận biết được liệu một sự cân bằng hoàn hảo có thực sự tồn tại giữa những con số tưởng chừng như ngẫu nhiên hay không.*
Fairness (equal partition) in mathematics is not just a division by two, but a search for suitable combinations (subsets) to fill gaps. By building step by step (DP), we can identify whether a perfect balance truly exists among seemingly random numbers.
