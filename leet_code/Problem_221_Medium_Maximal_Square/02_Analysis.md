# Analysis for Maximal Square
# *Phân tích cho bài toán Hình vuông lớn nhất*

## 1. Problem Essence & Dynamic Programming
## *1. Bản chất vấn đề & Quy hoạch động*

### The Naive Check
### *Kiểm tra ngây thơ*
For every cell `(i, j)` that is `1`, we could try to expand a square. This would be roughly $O((MN)^2)$ or $O(MN \cdot \min(M,N))$, which is acceptable for small inputs but not optimal.

### The DP State
### *Trạng thái DP*
Let `dp[i][j]` represent the **side length of the largest square** whose **bottom-right corner** is at `(i, j)`.
*Gọi `dp[i][j]` là **cạnh của hình vuông lớn nhất** có **góc dưới cùng bên phải** tại `(i, j)`.*

If `matrix[i][j] == '1'`, then `dp[i][j]` depends on three neighbors:
1.  Top `(i-1, j)`
2.  Left `(i, j-1)`
3.  Top-Left `(i-1, j-1)`

The logic is: To form a square of size $k$ ending at `(i, j)`, we need squares of size $k-1$ ending at all three neighboring positions.
*Logic là: Để tạo thành hình vuông kích thước $k$ tại `(i, j)`, ta cần các hình vuông kích thước $k-1$ tại cả ba vị trí lân cận.*

Formula:
$$dp[i][j] = \min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1$$

If `matrix[i][j] == '0'`, then `dp[i][j] = 0`.

---

## 2. Approach: Dynamic Programming (2D -> 1D Space)
## *2. Hướng tiếp cận: Quy hoạch động (Không gian 2D -> 1D)*

### Logic
### *Logic*
1.  Create a DP table.
2.  Iterate through the matrix.
3.  Update `dp` values based on the formula.
4.  Track `maxSide`.
5.  Return `maxSide * maxSide`.

### Space Optimization
### *Tối ưu hóa không gian*
Notice `dp[i][j]` only depends on the current row and the previous row. We can reduce space from $O(MN)$ to $O(N)$ using two arrays (or even one array with a temp variable for `prev_diagonal`).
*Lưu ý `dp[i][j]` chỉ phụ thuộc vào hàng hiện tại và hàng trước đó. Có thể giảm không gian xuống $O(N)$.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Subproblem Overlap:** The DP approach perfectly captures the overlapping subproblems structure of square formation.
    *Chồng chập bài toán con: Cách tiếp cận DP nắm bắt hoàn hảo cấu trúc bài toán con chồng chập của việc tạo hình vuông.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$. Visit every cell once.
    *Độ phức tạp thời gian: $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ for full table, or $O(N)$ for optimized.
    *Độ phức tạp không gian: $O(N)$ nếu tối ưu.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:**
```
1 1
1 1
```

1.  `(0,0)`: val=1. `dp[0][0]=1`. Max=1.
2.  `(0,1)`: val=1. `dp[0][1]=1`.
3.  `(1,0)`: val=1. `dp[1][0]=1`.
4.  `(1,1)`: val=1.
    - Neighbors: Top(1), Left(1), TopLeft(1).
    - `dp[1][1] = min(1, 1, 1) + 1 = 2`.
    - Max=2.

Result: `2 * 2 = 4`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic 2D DP problem. The recurrence relation `min(top, left, topleft) + 1` is the key insight. Just remember it defines the square by its bottom-right corner.
*Đây là bài toán DP 2D kinh điển. Hệ thức truy hồi `min(trên, trái, trên-trái) + 1` là mấu chốt. Hãy nhớ nó định nghĩa hình vuông bằng góc dưới bên phải.*
---
*Một hình vuông vững chãi được xây dựng từ sự đồng thuận của ba người hàng xóm: trên, trái và chéo.*
A sturdy square is built from the consensus of three neighbors: top, left, and diagonal.
