# Analysis for Open the Lock
# *Phân tích cho bài toán Mở Khóa*

## 1. Problem Essence & Shortest Path
## *1. Bản chất vấn đề & Đường đi Ngắn nhất*

### The Challenge
### *Thách thức*
We have a state space of $10^4 = 10,000$ possible combinations ("0000" to "9999"). Since we want the **minimum** number of moves, this is a classic Breadth-First Search (BFS) problem on an unweighted graph where nodes are states and edges represent a single turn of a wheel.
*Không gian trạng thái có $10,000$ tổ hợp ("0000" đến "9999"). Vì muốn tìm số bước đi **tối thiểu**, đây là bài toán Tìm kiếm theo Chiều rộng (BFS) kinh điển trên đồ thị không trọng số, nơi các nút là trạng thái và cạnh là một lần xoay bánh xe.*

---

## 2. Strategy: BFS
## *2. Chiến lược: BFS*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Validations:** If "0000" is in `deadends`, we fail immediately.
    *   **Kiểm tra:** Nếu "0000" nằm trong `deadends`, thất bại ngay lập tức.*

2.  **Queue & Visited Set:**
    - Initialize `Queue` with "0000".
    - Initialize `Visited` set containing `deadends` (to treat them as visited/blocked) and "0000".
    *   **Hàng đợi & Tập Đã thăm:** Khởi tạo hàng đợi với "0000". Tập đã thăm chứa `deadends` (để coi như bị chặn) và "0000".*

3.  **Process Levels:**
    - While queue is not empty:
        - Get size of current level. Iterate that many times.
        - Pop `current`. If `current == target`, return `steps`.
        - Generate 8 Neighbors: For each of the 4 wheels, rotate +1 and -1 (handling wrap-around 0 <-> 9).
        - If neighbor not in `Visited`:
            - Add to `Queue`.
            - Add to `Visited`.
    - Increment `steps` after processing each level.
    *   **Xử lý Từng lớp:** Trong khi hàng đợi chưa rỗng: Lấy kích thước lớp hiện tại. Duyệt từng phần tử. Nếu trùng đích thì trả về số bước. Sinh 8 lân cận (xoay +1, -1 cho 4 vị trí). Nếu chưa thăm thì thêm vào hàng đợi.*

4.  **Termination:** If queue empties without reaching target, return -1.
    *   **Kết thúc:** Nếu hàng đợi rỗng mà chưa đến đích, trả về -1.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(10^4 \cdot 4^2 + D)$, where $D$ is size of deadends. There are at most 10,000 states. For each state, we generate 8 neighbors, doing string operations.
    *   **Độ phức tạp thời gian:** $O(1)$ về lý thuyết (vì không gian cố định) hoặc $O(N \cdot L)$ với $N$ là số trạng thái.*
*   **Space Complexity:** $O(10^4 + D)$ to store visited set and queue.
    *   **Độ phức tạp không gian:** $O(10^4)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Start: "0000", Target: "0202", Dead: "0201"**
1. Q: ["0000"], Steps: 0.
2. Neighbors of "0000": "1000", "9000", "0100", "0900", ...
3. Path might be: 0000 -> 1000 -> 1100 -> 1200 -> 1201 -> 1202 -> 0202. (6 steps).
4. Note: BFS will explore all directions. Bidirectional BFS could be faster but standard BFS is sufficient here.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Standard BFS is robust. Using a HashSet for deadends provides O(1) lookup. Dealing with string manipulation is efficient enough given the small string length (4).
*BFS chuẩn là đủ mạnh. Sử dụng HashSet cho các ngõ cụt giúp tra cứu O(1). Thao tác chuỗi đủ hiệu quả vì độ dài chuỗi nhỏ (4).*
---
*Mỗi chiếc khóa (Lock) là một mê cung số (Digital maze) nơi mỗi vòng xoay dẫn đến những ngã rẽ mới. Để không lạc lối vào những ngõ cụt (Deadends) và tìm ra chìa khóa trong thời gian ngắn nhất (Min turns), ta phải lan tỏa khả năng tìm kiếm đều khắp mọi hướng (BFS). Dữ liệu dạy ta rằng đôi khi lùi lại (Rotation -1) cũng là một cách để tiến tới đích nhanh hơn.*
Each lock (Lock) is a digital maze (Digital maze) where every turn leads to new crossroads. To avoid getting lost in dead ends (Deadends) and find the key in the shortest time (Min turns), we must spread our search evenly in all directions (BFS). Data teaches us that sometimes stepping back (Rotation -1) is also a way to reach the destination faster.
