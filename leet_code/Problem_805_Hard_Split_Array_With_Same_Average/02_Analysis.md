# Analysis for Split Array With Same Average
# *Phân tích cho bài toán Chia mảng với trung bình cộng bằng nhau*

## 1. Problem Essence & Mathematical Condition
## *1. Bản chất vấn đề & Điều kiện Toán học*

### The Challenge
### *Thách thức*
We need to split array `nums` (length $n$, total sum $S$) into two non-empty arrays $A$ (length $k$) and $B$ (length $n-k$).
The condition `average(A) == average(B)` implies:
$Sum(A) / k = Sum(B) / (n - k)$
$Sum(A) / k = (S - Sum(A)) / (n - k)$
$(n-k) \cdot Sum(A) = k \cdot (S - Sum(A))$
$n \cdot Sum(A) - k \cdot Sum(A) = k \cdot S - k \cdot Sum(A)$
$n \cdot Sum(A) = k \cdot S \Rightarrow Sum(A) = S \cdot k / n$
*Chúng ta cần chia mảng thành hai phần A (độ dài k) và B (độ dài n-k). Điều kiện trung bình bằng nhau tương đương với $Sum(A) = S \cdot k / n$.*

For $Sum(A)$ to be an integer, $S \cdot k$ must be divisible by $n$.
Also, $1 \le k \le n/2$ (one of the arrays must have a length at most half of $n$).
*Để $Sum(A)$ là số nguyên, $S \cdot k$ phải chia hết cho $n$. Ta chỉ cần kiểm tra $k$ từ $1$ đến $n/2$.*

---

## 2. Strategy: DP or Bitset
## *2. Chiến lược: DP hoặc Bitset*

### Approach: Meet-in-the-middle or DP
### *Cách tiếp cận: Meet-in-the-middle hoặc DP*
$N=30$ is too large for simple recursion ($2^{30} \approx 10^9$) but acceptable for bit manipulation or pruned DP.
*N=30 là khá lớn cho đệ quy đơn giản. Tuy nhiên, ta có thể dùng DP hoặc tập hợp bit.*

For each possible length $k \in [1, n/2]$ such that $S \cdot k \% n == 0$:
Can we find $k$ elements in `nums` whose sum is $S \cdot k / n$?
*Với mỗi $k$ khả thi sao cho $S \cdot k \% n == 0$, ta xem có thể chọn k phần tử có tổng là $S \cdot k / n$ hay không.*

We can use an array of Bitsets (or similar state tracking) where `dp[k]` stores all possible sums using exactly $k$ elements.
*Sử dụng mảng Bitset: `dp[k]` lưu các tổng khả thi khi chọn đúng k phần tử.*

### Optimization
### *Tối ưu hóa*
- Prune lengths $k$ that cannot result in an integer sum.
- Use a single DP array (iterating backwards to avoid using the same element twice).
*Loại bỏ các độ dài k không tạo ra tổng nguyên. Dùng mảng DP duy nhất và duyệt ngược.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \cdot S)$. Each element is processed once, updating possible sums.
    *   **Độ phức tạp thời gian:** $O(N^2 \cdot S)$.*
*   **Space Complexity:** $O(N \cdot S)$. To store possible sums for each length.
    *   **Độ phức tạp không gian:** $O(N \cdot S)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `nums = [1, 2, 3, 4, 5, 6, 7, 8]`
- $n = 8, S = 36$.
- Possible $k \in [1, 4]$.
- Check $k=1: 36 \cdot 1 / 8 = 4.5$ (No).
- Check $k=2: 36 \cdot 2 / 8 = 9$ (Yes, e.g., $\{1, 8\}$).
- Check $k=3: 36 \cdot 3 / 8 = 13.5$ (No).
- Check $k=4: 36 \cdot 4 / 8 = 18$ (Yes, e.g., $\{1, 4, 5, 8\}$).
**Result:** True.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Check the mathematical condition first. If no valid $k$ exists, return `false`. Use DP or Bitset to find reachable sums efficiently.
*Kiểm tra điều kiện toán học trước. Nếu không có k hợp lệ, trả về false. Sử dụng DP hoặc Bitset để tìm các tổng có thể đạt được một cách hiệu quả.*
