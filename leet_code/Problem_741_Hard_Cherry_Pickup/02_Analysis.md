# Analysis for Cherry Pickup
# *Phân tích cho bài toán Nhặt Cherry (Cherry Pickup)*

## 1. Problem Essence & Simultaneous Traversal
## *1. Bản chất vấn đề & Duyệt đồng thời*

### The Challenge
### *Thách thức*
The problem involves making a round trip: from `(0,0)` to `(N-1,N-1)` and back. A naive greedy approach (maximize path 1, then maximize path 2) fails because picking cherries on the first path might destroy a crucial bridge or cluster needed for the second trip.
*Bài toán yêu cầu thực hiện một chuyến đi khứ hồi: từ `(0,0)` đến `(N-1,N-1)` và quay lại. Cách tiếp cận tham lam ngây thơ (tối đa hóa lượt đi, sau đó tối đa hóa lượt về) sẽ thất bại vì việc nhặt cherry ở lượt đi có thể phá hủy một cây cầu hoặc cụm quan trọng cần thiết cho lượt về.*

The key insight is that going from `(N-1, N-1)` back to `(0, 0)` is mathematically equivalent to a second person going from `(0, 0)` to `(N-1, N-1)`. Thus, we can model this as **two people starting at (0, 0) and moving to (N-1, N-1) simultaneously**.
*Nhận định mấu chốt là việc đi từ `(N-1, N-1)` về `(0, 0)` tương đương toán học với việc người thứ hai đi từ `(0, 0)` đến `(N-1, N-1)`. Do đó, ta có thể mô hình hóa bài toán thành **hai người cùng xuất phát từ (0, 0) và di chuyển đến (N-1, N-1) đồng thời**.*

---

## 2. Strategy: 3D Dynamic Programming
## *2. Chiến lược: Quy hoạch động 3 chiều*

### State Definition
### *Định nghĩa Trạng thái*
Instead of tracking full coordinates `(r1, c1)` and `(r2, c2)`, we observe that after `k` steps, both people must be at cells where `r + c = k`.
*Thay vì theo dõi tọa độ đầy đủ `(r1, c1)` và `(r2, c2)`, ta nhận thấy rằng sau `k` bước, cả hai người phải ở các ô mà `r + c = k`.*

Let `dp[r1][c1][c2]` be the maximum cherries collected when:
- Person 1 is at `(r1, c1)`
- Person 2 is at `(r2, c2)`
- Note: We can derive `r2` because `r1 + c1 = r2 + c2`. So `r2 = r1 + c1 - c2`.
Thus, we can reduce the state to `dp[r1][c1][c2]` or even better, `dp[k][c1][c2]` (where `k` is the number of steps). However, since `k` is implied by the indices, we often use `dp[r1][c1][c2]` but implement it layer by layer or simply use `r1` and `c1`, `c2`.
*Gọi `dp[r1][c1][c2]` là số cherry tối đa thu được khi: Người 1 ở `(r1, c1)`, Người 2 ở `(r2, c2)`. Lưu ý: Ta có thể suy ra `r2` vì `r1 + c1 = r2 + c2`. Vậy `r2 = r1 + c1 - c2`. Do đó ta có thể giảm trạng thái xuống còn 3 chiều.*

### Transition Logic
### *Logic Chuyển đổi*
At each step, Person 1 moves (Down or Right) and Person 2 moves (Down or Right). This gives 4 combinations:
1.  Both move Right.
2.  P1 Down, P2 Right.
3.  P1 Right, P2 Down.
4.  Both move Down.

We take the max of these previous states and add the cherries at current cells `(r1, c1)` and `(r2, c2)`.
*Tại mỗi bước, Người 1 di chuyển (Xuống hoặc Phải) và Người 2 di chuyển (Xuống hoặc Phải). Có 4 tổ hợp. Ta lấy giá trị lớn nhất từ các trạng thái trước đó và cộng thêm số cherry tại các ô hiện tại.*

**Crucial Rule:** If `(r1, c1) == (r2, c2)`, they are at the same cell. We count the cherry only **once**.
*Quy tắc quan trọng: Nếu `(r1, c1) == (r2, c2)`, họ đang ở cùng một ô. Ta chỉ tính quả cherry **một lần**.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$. The state space is roughly $N \times N \times N$.
    *   **Độ phức tạp thời gian:** $O(N^3)$. Không gian trạng thái xấp xỉ $N^3$.*
*   **Space Complexity:** $O(N^2)$ if we optimize the DP table to store only the current and previous layer, or $O(N^3)$ without optimization. Given $N=50$, $50^3 = 125,000$ requires very little memory, so $O(N^3)$ space is acceptable and simpler.
    *   **Độ phức tạp không gian:** $O(N^2)$ nếu tối ưu hóa, hoặc $O(N^3)$ bình thường. Với $N=50$, $O(N^3)$ là chấp nhận được.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `[[0, 1], [1, 0]]` (N=2)
- Step 0: P1(0,0), P2(0,0). Cherries = 0.
- Step 1:
  - (Right, Right): P1(0,1), P2(0,1). Max prev (0) + grid[0][1] (1/2? same cell counts once) -> 0+1 = 1.
  - (Down, Down): P1(1,0), P2(1,0). Max prev (0) + grid[1,0] (1) -> 1.
  - (Right, Down): P1(0,1), P2(1,0). Max prev (0) + grid[0][1] + grid[1][0] -> 1+1 = 2. **Best path so far.**
  - (Down, Right): P1(1,0), P2(0,1). Same as above -> 2.
- Step 2: Destination (1,1). From best step 1 (score 2). Add grid[1][1] (0). Total = 2.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

This is a classic "Double DP" problem. Whenever you need to traverse twice and the second traversal depends on the state change of the first, consider traversing simultaneously.
*Đây là bài toán "Quy hoạch động Kép" kinh điển. Bất cứ khi nào cần duyệt hai lần và lần duyệt sau phụ thuộc vào thay đổi trạng thái của lần đầu, hãy cân nhắc việc duyệt đồng thời.*
---
*Hành trình song hành (Simultaneous traversal) cho phép ta tối ưu hóa lợi ích chung mà không rơi vào bẫy của sự ích kỷ cục bộ (Greedy). Trong không gian giới hạn của lưới cherry, hai người bạn đồng hành (Two pointers) phải phối hợp nhịp nhàng, chia sẻ tài nguyên khi gặp nhau (Same cell check) và tách ra để khai phá những vùng đất mới, đảm bảo rằng tổng thành quả thu được là lớn nhất có thể.*
Simultaneous traversal (Simultaneous traversal) allows us to optimize mutual benefit without falling into the trap of local selfishness (Greedy). Within the confined space of the cherry grid, two companions (Two pointers) must coordinate smoothly, sharing resources when meeting (Same cell check) and separating to explore new lands, ensuring that the total harvest is maximized.
