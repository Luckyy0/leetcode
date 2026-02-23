# Analysis for Longest Line of Consecutive One in Matrix
# *Phân tích cho bài toán Đường thẳng số 1 liên tiếp dài nhất trong Ma trận*

## 1. Problem Essence & Multi-Directional Continuity
## *1. Bản chất vấn đề & Tính liên tục Đa hướng*

### The Challenge
### *Thách thức*
We are given a binary matrix and need to find the longest "line" of 1s. A line can exist in four orientations: Horizontal, Vertical, Diagonal, and Anti-diagonal.
*Chúng ta được trao một ma trận nhị phân và cần tìm "đường thẳng" các số 1 dài nhất. Một đường thẳng có thể tồn tại theo bốn hướng: Ngang, Dọc, Chéo chính và Chéo phụ.*

Testing every possible line starting at every cell would be redundant and slow ($O(M \times N \times \max(M, N))$).
*Việc thử mọi đường thẳng có thể bắt đầu tại mọi ô sẽ bị dư thừa và chậm chạp ($O(M \times N \times \max(M, N))$).*

---

## 2. Strategy: 3D Dynamic Programming (State Tracking)
## *2. Chiến lược: Quy hoạch động 3 chiều (Theo dõi trạng thái)*

The length of a line ending at cell $(i, j)$ in a specific direction is simply 1 plus the length of the line ending at its neighbor in the *opposite* direction.
*Độ dài của một đường thẳng kết thúc tại ô $(i, j)$ theo một hướng cụ thể đơn giản là 1 cộng với độ dài của đường thẳng kết thúc tại ô láng giềng của nó theo hướng *ngược lại*.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **DP State:** Define `dp[i][j][k]` where `k` represents the 4 directions:
    * **Trạng thái DP:** Định nghĩa `dp[i][j][k]` trong đó `k` đại diện cho 4 hướng:*
    - `k=0`: Horizontal (left neighbor `dp[i][j-1]`)
    - *`k=0`: Chiều ngang (láng giềng bên trái `dp[i][j-1]`)*
    - `k=1`: Vertical (top neighbor `dp[i-1][j]`)
    - *`k=1`: Chiều dọc (láng giềng phía trên `dp[i-1][j]`)*
    - `k=2`: Diagonal (top-left neighbor `dp[i-1][j-1]`)
    - *`k=2`: Đường chéo chính (láng giềng phía trên-bên trái `dp[i-1][j-1]`)*
    - `k=3`: Anti-diagonal (top-right neighbor `dp[i-1][j+1]`)
    - *`k=3`: Đường chéo phụ (láng giềng phía trên-bên phải `dp[i-1][j+1]`)*

2.  **Transition:** If `mat[i][j] == 1`:
    * **Chuyển trạng thái:** Nếu `mat[i][j] == 1`:*
    - `dp[i][j][0] = dp[i][j-1][0] + 1`
    - `dp[i][j][1] = dp[i-1][j][1] + 1`
    - `dp[i][j][2] = dp[i-1][j-1][2] + 1`
    - `dp[i][j][3] = dp[i-1][j+1][3] + 1`
    - (With proper bounds checking for indices).
    - *(Với việc kiểm tra giới hạn chỉ số thích hợp).*

3.  **Global Maximum:** Maintain a `max_len` variable and update it at every cell for all directions.
    * **Giá trị lớn nhất toàn cục:** Duy trì một biến `max_len` và cập nhật nó tại mỗi ô cho tất cả các hướng.*

---

## 3. Structural Advantages & Efficiency
## *3. Ưu điểm Cấu trúc & Hiệu quả*

*   **Optimal Substructure:** We build upon previously computed results, ensuring each cell is processed exactly once for each of the 4 directions.
    * **Cấu trúc con tối ưu:** Chúng ta xây dựng dựa trên các kết quả đã tính toán trước đó, đảm bảo mỗi ô được xử lý đúng một lần cho mỗi hướng trong số 4 hướng.*
*   **Sequential Processing:** The array is processed row by row, which is cache-friendly and easy to implement.
    * **Xử lý tuần tự:** Mảng được xử lý theo từng hàng, điều này thân thiện với bộ nhớ đệm và dễ triển khai.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$. We iterate through every cell once and perform a constant number of operations (4 directions).
    * **Độ phức tạp thời gian:** $O(M \times N)$. Chúng ta duyệt qua mọi ô một lần và thực hiện một số lượng thao tác hằng số (4 hướng).*
*   **Space Complexity:** $O(M \times N)$. To store the 3D DP table. For very large matrices, this can be optimized to $O(N)$ with multiple rows of storage.
    * **Độ phức tạp không gian:** $O(M \times N)$. Để lưu trữ bảng DP 3 chiều. Đối với các ma trận rất lớn, điều này có thể tối ưu hóa thành $O(N)$ với nhiều hàng lưu trữ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:**
```
[0, 1, 1, 0]
[0, 1, 1, 0]
[0, 0, 0, 1]
```
- At `(0, 1)`, all DP values = 1.
- At `(0, 2)`, horizontal `dp[0][2][0] = dp[0][1][0] + 1 = 2`. Others = 1.
- At `(1, 1)`, vertical `dp[1][1][1] = dp[0][1][1] + 1 = 2`.
- At `(1, 2)`, diagonal `dp[1][2][2] = dp[0][1][2] + 1 = 2`, horizontal `dp[1][2][0] = dp[1][1][0] + 1 = 2`, vertical `dp[1][2][1] = dp[0][2][1] + 1 = 2`.
- At `(2, 3)`, check `dp[1][2][2]` (top-left) -> `2+1=3`.
- Result: 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use Dynamic Programming to aggregate counts in multiple directions simultaneously without redundant scans.
*Sử dụng Quy hoạch động để tổng hợp các bộ đếm theo nhiều hướng cùng lúc mà không cần quét dư thừa.*
---
*Sự kiên trì (Consecutive) luôn tạo nên những đường thẳng vững chãi. Cho dù đi theo hướng nào (Horizontal, Vertical, Diagonal), chỉ cần giữ vững kết nối (mat[i][j] == 1), ta sẽ tạo nên chiều dài ấn tượng nhất.*
Perseverance (Consecutive) always creates solid lines. No matter which direction you go (Horizontal, Vertical, Diagonal), as long as you maintain the connection (mat[i][j] == 1), you will create the most impressive length.
