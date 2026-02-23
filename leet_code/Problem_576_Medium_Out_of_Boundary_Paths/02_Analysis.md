# Analysis for Out of Boundary Paths
# *Phân tích cho bài toán Đường ra ngoài Biên*

## 1. Problem Essence & State Propagation
## *1. Bản chất vấn đề & Sự Lan truyền Trạng thái*

### The Challenge
### *Thách thức*
We need to count how many paths (of length up to `maxMove`) lead the ball out of an $m \times n$ grid starting from a given cell.
*Chúng ta cần đếm xem có bao nhiêu con đường (độ dài tối đa `maxMove`) đưa quả bóng ra khỏi lưới $m \times n$ bắt đầu từ một ô cho trước.*

Since after each move the ball can be in any of the 4 adjacent cells, this is a path-counting problem that exhibits overlapping subproblems and optimal substructure—perfect for Dynamic Programming.
*Vì sau mỗi lần di chuyển, quả bóng có thể ở bất kỳ ô nào trong 4 ô liền kề, đây là một bài toán đếm đường đi có các bài toán con chồng lấn và cấu trúc con tối ưu—hoàn hảo cho Quy hoạch động.*

---

## 2. Strategy: DP with Move Counting (State Compression)
## *2. Chiến lược: DP với Bộ đếm Bước đi (Nén Trạng thái)*

We can define the state based on (moves remaining, row, column). However, it's easier to think about it as "moves taken".
*Chúng ta có thể định nghĩa trạng thái dựa trên (số bước còn lại, hàng, cột). Tuy nhiên, dễ dàng hơn khi coi đó là "số bước đã thực hiện".*

### State Definition
### *Định nghĩa Trạng thái*
`dp[k][i][j]`: The number of ways to reach cell $(i, j)$ in exactly `k` moves.
*`dp[k][i][j]`: Số cách để đến được ô $(i, j)$ trong chính xác `k` bước.*

### Transition Logic
### *Logic Chuyển trạng thái*
For each step `k` from 1 to `maxMove`:
*Đối với mỗi bước `k` từ 1 đến `maxMove`:*

1.  **Iterate through all cells $(i, j)$:**
    * **Duyệt qua tất cả các ô $(i, j)$:**
    - At each cell $(i, j)$, there are paths arriving from its 4 neighbors: $(i-1, j), (i+1, j), (i, j-1), (i, j+1)$.
    - *Tại mỗi ô $(i, j)$, có các con đường đến từ 4 láng giềng của nó: $(i-1, j), (i+1, j), (i, j-1), (i, j+1)$.*
    - **But wait!** It's easier to propagate *outward*: For every path at $(i, j)$ with `k-1` moves:
    - * **Nhưng hãy khoan!** Dễ dàng hơn khi lan truyền *ra ngoài*: Đối với mỗi con đường tại $(i, j)$ với `k-1` bước:*
    - Look at the 4 neighbors. If a neighbor is **out of bounds**, add the current count to the total `pathsCount`.
    - *Hãy nhìn vào 4 láng giềng. Nếu một láng giềng nằm **ngoài biên**, hãy cộng số lượng hiện tại vào tổng `pathsCount`.*
    - If a neighbor is **inside**, add the current count to `next_dp[ni][nj]`.
    - *Nếu một láng giềng nằm **trong biên**, hãy cộng số lượng hiện tại vào `next_dp[ni][nj]`.*

2.  **Modulo Arithmetic:** Perform all additions modulo $10^9 + 7$.
    * **Phép toán Modulo:** Thực hiện tất cả các phép cộng theo modulo $10^9 + 7$.*

3.  **Space Compression:** `dp[k]` only depends on `dp[k-1]`. We only need two grids of size $m \times n$.
    * **Nén Không gian:** `dp[k]` chỉ phụ thuộc vào `dp[k-1]`. Chúng ta chỉ cần hai lưới kích thước $m \times n$.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Iterative Propagation:** By iterating through moves level by level, we naturally build the total paths count.
    * **Lan truyền Lặp:** Bằng cách lặp qua các bước theo từng cấp độ, chúng ta xây dựng tổng số đường đi một cách tự nhiên.*
*   **Directional Generality:** The 4-direction movements are handled using a directions array `{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}` for cleaner code.
    * **Tính tổng quát của hướng:** Các chuyển động theo 4 hướng được xử lý bằng một mảng các hướng `{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}` để mã nguồn sạch sẽ hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \times M \times N)$, where $K$ is `maxMove`. For each move, we scan the entire grid.
    * **Độ phức tạp thời gian:** $O(K \times M \times N)$, trong đó $K$ là `maxMove`. Đối với mỗi bước đi, chúng ta quét toàn bộ lưới.*
*   **Space Complexity:** $O(M \times N)$ if we use space compression (storing current and next move grids).
    * **Độ phức tạp không gian:** $O(M \times N)$ nếu chúng ta sử dụng nén không gian (lưu trữ lưới bước hiện tại và bước tiếp theo).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Grid 1x1, Moves=1, Start=[0,0]**
- k=1:
  - Ball at (0,0). Try 4 directions.
  - Up: Out. count=1.
  - Down: Out. count=2.
  - Left: Out. count=3.
  - Right: Out. count=4.
- Total Paths = 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For move-limited pathfinding on a grid, iterative DP with space compression is the most reliable approach.
*Đối với việc tìm đường giới hạn bước đi trên lưới, DP lặp với nén không gian là cách tiếp cận đáng tin cậy nhất.*
---
*Cuộc hành trình (Path) hướng ra thế giới bên ngoài (Out of bounds) luôn đầy rẫy những ngả rẽ. Mỗi bước chân là một sự lan tỏa của khả năng (Probability/Count). Dù không gian (Grid) có hạn chế, sự kiên trì trong từng nước đi (maxMove) sẽ giúp ta tìm thấy mọi con đường dẫn tới sự tự do bên ngoài biên giới.*
The journey (Path) towards the outside world (Out of bounds) is always full of crossroads. Every step is a spread of possibility (Probability/Count). Although space (Grid) is limited, persistence in every move (maxMove) will help us find every path to freedom outside the border.
