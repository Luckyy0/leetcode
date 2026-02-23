# Analysis for Knight Probability in Chessboard
# *Phân tích cho bài toán Xác suất Quân Mã trên Bàn cờ*

## 1. Problem Essence & Iterative Probability
## *1. Bản chất vấn đề & Xác suất Lặp*

### The Challenge
### *Thách thức*
A knight moves randomly in one of 8 directions. At each step, there's a chance it falls off the board. We need to find the total probability that it stays on the board after $K$ moves.
*Một quân mã di chuyển ngẫu nhiên theo một trong 8 hướng. Tại mỗi bước, có khả năng nó bị rơi khỏi bàn cờ. Chúng ta cần tìm tổng xác suất để nó vẫn còn trên bàn cờ sau $K$ bước.*

---

## 2. Strategy: Dynamic Programming (State Space)
## *2. Chiến lược: Quy hoạch động (Không gian Trạng thái)*

We can define `dp[k][r][c]` as the probability that the knight is at square $(r, c)$ after exactly $k$ moves.
*Chúng ta có thể định nghĩa `dp[k][r][c]` là xác suất quân mã ở ô $(r, c)$ sau đúng $k$ bước.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** 
    - At step $0$, the knight is at `(row, column)` with probability $1.0$.
    - `dp[0][row][column] = 1.0`.
    * **Khởi tạo:** Tại bước 0, quân mã ở vị trí bắt đầu với xác suất 1.0.*

2.  **Transitions:** 
    - For each step `k` from 1 to $K$:
        - For each square `(r, c)` on the $N \times N$ board:
            - If the probability at `dp[k-1][r][c]` is greater than 0:
                - For each of the **8 knight moves**:
                    - Calculate the new position `(nr, nc)`.
                    - If `(nr, nc)` is still on the board:
                        - `dp[k][nr][nc] += dp[k-1][r][c] / 8.0`.
    * **Chuyển đổi:** Với mỗi bước từ 1 đến $K$, từ mỗi ô có xác suất > 0, hãy thử 8 nước đi của mã. Nếu nước đi mới vẫn nằm trong bàn cờ, hãy cộng dồn xác suất (chia 8).*

3.  **Result Aggregation:**
    - After $K$ steps, the probability of being "on the board" is the sum of all values in `dp[K][r][c]` for all $0 \le r, c < N$.
    * **Tổng hợp kết quả:** Sau $K$ bước, xác suất "trên bàn cờ" là tổng tất cả các giá trị trong mảng DP cuối cùng.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Space Optimization:** Notice that `dp[k]` only depends on `dp[k-1]`. We can reduce the space complexity from $O(K \times N^2)$ to $O(N^2)$ by using two 2D arrays (current and previous).
    * **Tối ưu không gian:** Chỉ cần hai mảng 2D thay vì mảng 3D.*
*   **Precision:** Use `double` to handle small probability values without losing precision during accumulation.
    * **Độ chính xác:** Sử dụng kiểu `double`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \times N^2 \times 8) = O(K \times N^2)$. Since $N \le 25, K \le 100$, the operations are roughly $62,500$, which is very fast.
    * **Độ phức tạp thời gian:** $O(K \times N^2)$.*
*   **Space Complexity:** $O(N^2)$.
    * **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**N = 3, K = 1, start = (0, 0)**
1. Initial: `dp[0][0][0] = 1.0`.
2. Move 1:
   - From (0,0), can move to: (1,2) and (2,1).
   - `dp[1][1][2] += 1.0 / 8.0 = 0.125`.
   - `dp[1][2][1] += 1.0 / 8.0 = 0.125`.
3. Total Probability: $0.125 + 0.125 = 0.25$.
**Result:** 0.25. (Example 1 for $K=2$ would recurse once more).

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Probability problems with fixed transitions are essentially state-space traversals. DP allows us to merge paths that lead to the same state (cell), preventing an exponential explosion of paths ($8^K$).
*Các bài toán xác suất với các bước chuyển cố định thực chất là duyệt không gian trạng thái. DP cho phép chúng ta gộp các con đường dẫn đến cùng một trạng thái, tránh việc bùng nổ số lượng đường đi.*
---
*Mỗi bước nhảy (Move) của quân mã là một sự đánh đổi giữa sự sống và cái chết (On/Off board). Trong không gian giới hạn của bàn cờ (Chessboard), xác suất là nhịp cầu kết nối sự bất định của hiện tại với sự tồn tại của tương lai. Dữ liệu dạy ta rằng bằng cách chia sẻ gánh nặng của sự ngẫu nhiên (Divide by 8) và tích lũy từng mảnh nhỏ của khả năng (DP), ta có thể thấu thị được định mệnh của một cuộc hành trình.*
Every move (Move) of the knight is a trade-off between life and death (On/Off board). In the limited space of the chessboard (Chessboard), probability is the bridge connecting the uncertainty of the present with the existence of the future. Data teaches us that by sharing the burden of randomness (Divide by 8) and accumulating every small fragment of possibility (DP), we can see the destiny of a journey.
