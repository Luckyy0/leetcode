# Analysis for Target Sum
# *Phân tích cho bài toán Tổng Mục tiêu*

## 1. Problem Essence & Subset Sum Transformation
## *1. Bản chất vấn đề & Biến đổi Tổng tập con*

### The Challenge
### *Thách thức*
Assigning `+` or `-` to each number to reach `target`. $N=20$ suggests $2^{20} \approx 10^6$, feasible for DFS. But it can be optimized using DP.

### Strategy: Math Transformation to Subset Sum
### *Chiến lược: Biến đổi Toán học về Tổng tập con*

1.  Let $P$ be the set of numbers assigned `+`, and $N$ be the set assigned `-`.
2.  $\text{sum}(P) - \text{sum}(N) = \text{target}$.
3.  We know $\text{sum}(P) + \text{sum}(N) = \text{sum}(\text{nums})$.
4.  Adding equations: $2 \times \text{sum}(P) = \text{target} + \text{sum}(\text{nums})$.
5.  $\text{sum}(P) = (\text{target} + \text{sum}(\text{nums})) / 2$.
6.  Problem reduces to: **Find the number of subsets of `nums` that sum up to `S'`, where `S' = (target + sum) / 2`.**
    - Constraints: `(target + sum)` must be even and $\ge 0$.

### Alternative: DP directly
### *Phương án thay thế: DP trực tiếp*

- `dp[current_sum]` = count.
- Shift index to handle negative sums. Range is [-1000, 1000]. `dp[2001]`.

---

## 2. Approach: 1D DP (Subset Sum)
## *2. Hướng tiếp cận: DP 1 chiều (Tổng tập con)*

### Logic
### *Logic*
(See above).
- `S = (sum + target) / 2`.
- `dp[j]` = number of subsets with sum `j`.
- `dp[j] += dp[j - num]` for `num` in `nums`. Iterate `j` backwards.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Reduction:** reduces exponentional complexity (unoptimized recursion) to pseudo-polynomial $O(N \cdot \text{sum})$.
    *Giảm thiểu: giảm độ phức tạp mũ xuống đa thức giả.*
*   **Simplicity:** Classic knapsack 0/1 variation.
    *Đơn giản: Biến thể của bài toán cái túi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \text{sum})$. Max sum is 1000. $20 \times 1000 = 20000$ ops. Extremely fast.
    *Độ phức tạp thời gian: $O(N \cdot \text{sum})$.*
*   **Space Complexity:** $O(\text{sum})$.
    *Độ phức tạp không gian: $O(\text{sum})$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums=[1, 1, 1, 1, 1]`, `target=3`.
1. Total Sum = 5. Target = 3.
2. New Target: $(5 + 3) / 2 = 4$.
3. Find subsets counting to 4.
   - `dp[0] = 1`.
   - Add `1`: `dp[4]+=dp[3]`, `dp[3]+=dp[2]`, ...
   - After 5 ones: `dp[4]` will be 5 (`5C4` or `5C1`).
Result: 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Transform to Subset Sum Problem and solve with 1D DP.
*Chuyển đổi sang Bài toán Tổng tập con và giải bằng DP 1 chiều.*
---
*Cuộc sống là một bài toán cân bằng (Target Sum). Những điều tích cực (plus) và tiêu cực (minus) luôn song hành. Thay vì cố gắng giải quyết từng xung đột nhỏ nhặt, hãy nhìn vào bức tranh tổng thể: ta chỉ cần chọn ra những điều tốt đẹp (Positive Subset) sao cho chúng đủ lớn để bù đắp phần còn lại và đạt được mục tiêu đời mình.*
Life is a balancing problem (Target Sum). Positive (Plus) and Negative (Minus) always go hand in hand. Instead of trying to solve every minor conflict, look at the big picture: we just need to choose good things (Positive Subset) so that they are large enough to make up for the rest and reach our life goals.
