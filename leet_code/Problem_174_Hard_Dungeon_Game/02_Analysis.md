# Analysis for Dungeon Game
# *Phân tích cho bài toán Trò chơi trong ngục tối*

## 1. Problem Essence & Strategy Choice
## *1. Bản chất vấn đề & Lựa chọn chiến lược*

### Why Top-Down doesn't work?
### *Tại sao Hướng từ trên xuống không hiệu quả?*
Normally, pathfinding in a grid is solved from the start to the end. However, in this problem, the minimum health needed depends on the **future** rooms. If we use top-down DP, a path with high health at a certain cell might lead to a dead end of huge negative numbers later. We would need to track both "current health" and "minimum health needed", making the state space complex.
*Thông thường, tìm đường trong lưới được giải từ đầu đến cuối. Tuy nhiên, trong bài này, sức khỏe tối thiểu cần thiết phụ thuộc vào các căn phòng trong **tương lai**. Nếu dùng DP từ trên xuống, một con đường có máu cao ở hiện tại có thể dẫn đến một chuỗi số âm khổng lồ sau đó.*

### Bottom-Up DP (The Destination Logic)
### *Quy hoạch động từ dưới lên (Logic từ đích)*
The key insight for this problem is to work **backwards** from the princess (bottom-right) to the starting position (top-left). 
*Chìa khóa là làm việc **ngược** từ chỗ công chúa về vị trí bắt đầu.*

At each cell $(i, j)$, we ask: "What is the minimum health I need to *enter* this room such that I can survive the rest of the journey?".
*Tại mỗi ô $(i, j)$, chúng ta hỏi: "Sức khỏe tối thiểu tôi cần để *vào* căn phòng này là bao nhiêu để có thể sống sót trong phần còn lại của hành trình?"*

---

## 2. Approach: Reverse Dynamic Programming
## *2. Hướng tiếp cận: Quy hoạch động đảo ngược*

### State Definition
### *Định nghĩa trạng thái*
Let `dp[i][j]` be the minimum health required *at the moment the knight enters* room $(i, j)$.
*Gọi `dp[i][j]` là sức khỏe tối thiểu cần thiết tại thời điểm hiệp sĩ bước vào phòng $(i, j)$.*

### Transitions
### *Chuyển đổi*
1.  **Base Case (Princess's Room):**
    - The knight needs at least 1 HP AFTER dealing with the room.
    - So, starting HP needed: `dp[m-1][n-1] = max(1, 1 - dungeon[m-1][n-1])`.
2.  **General Transition:**
    - To move forward, the knight chooses the path that requires **less** health: `next_hp = min(dp[i+1][j], dp[i][j+1])`.
    - Health needed before entering current room: `dp[i][j] = max(1, next_hp - dungeon[i][j])`.
    *Lưu ý: Chúng ta luôn sử dụng `max(1, ...)` vì sức khỏe không bao giờ được phép giảm xuống 0 hoặc thấp hơn.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Global Optimality:** By working backwards, we eliminate the need to guess the path. Each cell correctly reflects the minimum requirement for all possible paths starting from that point.
    *Tối ưu toàn cục: Bằng cách làm ngược, chúng ta không cần đoán đường. Mỗi ô phản ánh chính xác yêu cầu tối thiểu cho mọi con đường bắt đầu từ đó.*
*   **Linear Execution:** The algorithm fills the DP table in a standard $O(M \times N)$ scan, making it highly efficient for the given constraints.
    *Thực thi tuyến tính: Thuật toán điền vào bảng DP theo cách quét tiêu chuẩn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M$ and $N$ are the dimensions of the dungeon. We visit each cell once.
    *Độ phức tạp thời gian: $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$. We store the DP table. (Can be optimized to $O(N)$ by using only one row since we only look at the row below).
    *Độ phức tạp không gian: $O(M \times N)$, có thể tối ưu xuống $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Dungeon:**
```
[-2, -3, 3]
[-5, -10, 1]
[10, 30, -5]
```

1.  **End (2,2):** `max(1, 1 - (-5)) = 6`.
2.  **(2,1):** `max(1, 6 - 30) = 1`.
3.  **(2,0):** `max(1, 1 - 10) = 1`.
4.  **(1,2):** `max(1, 6 - 1) = 5`.
5.  **(1,1):** `max(1, min(1, 5) - (-10)) = 11`.
6.  ... calculating towards top left ...
7.  **(0,0):** Final result will be **7**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Dungeon Game is the perfect example of why the direction of Dynamic Programming matters. If you encounter a pathfinding problem where the "best" decision depends on future outcomes rather than past prefixes, always try a **backward approach**. The constraint that health must be at least 1 at all times is the most common place for errors; always wrap your subtraction in a `max(1, ...)` logic.
*Dungeon Game là ví dụ hoàn hảo về lý do tại sao hướng đi của Quy hoạch động lại quan trọng. Nếu bạn gặp một bài toán tìm đường mà quyết định "tốt nhất" phụ thuộc vào kết quả tương lai thay vì tiền tố quá khứ, hãy luôn thử **cách tiếp cận ngược**. Ràng buộc rằng sức khỏe phải luôn tối thiểu là 1 là nơi dễ xảy ra sai sót nhất.*
---
*Cuộc đời đôi khi không phải là việc ta đã tích lũy được bao nhiêu từ quá khứ, mà là ta cần chuẩn bị tâm thế sắt đá như thế nào để vượt qua những phong ba bão tố còn ở phía trước.*
Life is sometimes not about how much we have accumulated from the past, but about how iron-willed we need to prepare ourselves to overcome the storms that lie ahead.
