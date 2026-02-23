# Analysis for Max Area of Island
# *Phân tích cho bài toán Diện tích Đảo lớn nhất*

## 1. Problem Essence & Connected Components
## *1. Bản chất vấn đề & Các thành phần Liên thông*

### The Challenge
### *Thách thức*
We need to find all isolated groups of `1`s and calculate their sizes. The goal is to return the maximum size found. This is a classic graph traversal problem where each `1` is a node and adjacent `1`s share an edge.
*Chúng ta cần tìm tất cả các nhóm `1` bị cô lập và tính toán kích thước của chúng. Mục tiêu là trả về kích thước lớn nhất tìm được. Đây là bài toán duyệt đồ thị kinh điển.*

---

## 2. Strategy: Recursive DFS with In-place Marking
## *2. Chiến lược: DFS Đệ quy với Đánh dấu tại chỗ*

To find the area of an island, we start from an unvisited `1` and explore all reachable `1`s.
*Để tìm diện tích một hòn đảo, ta bắt đầu từ một ô `1` chưa được ghé thăm và khám phá tất cả các ô `1` có thể đến được.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate through Grid:** Scan every cell $(r, c)$ in the matrix.
    * **Duyệt qua Lưới:** Quét từng ô $(r, c)$ trong ma trận.*

2.  **Trigger DFS:** If `grid[r][c] == 1`:
    - Call a recursive function `calculateArea(r, c)`.
    - This function will:
        - Check bounds and if the current cell is `0`.
        - **Mark as visited:** Set `grid[r][c] = 0` (sinking the island) to prevent reprocessing.
        - **Aggregate:** Return $1 +$ the sum of areas of its 4 neighbors.
    * **Kích hoạt DFS:** Nếu gặp ô `1`, gọi hàm đệ quy tính diện tích. Đánh dấu ô đã thăm bằng cách gán `grid[r][c] = 0`, sau đó cộng dồn 1 và diện tích các ô lân cận.*

3.  **Update Global Maximum:** Keep track of the maximum area returned by DFS calls.
    * **Cập nhật Cực đại Toàn cục:** Theo dõi diện tích lớn nhất thu được.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **In-place Sovereignty:** Modifying the grid directly (`grid[r][c] = 0`) eliminates the need for an extra `boolean[][] visited` matrix, saving space.
    * **Thay đổi tại chỗ:** Việc sửa ma trận trực tiếp giúp tiết kiệm không gian bộ nhớ.*
*   **Simple Logic:** DFS naturally aggregates the size of a connected component through the return value of recursive calls.
    * **Logic Đơn giản:** DFS tự động tổng hợp kích thước thông qua giá trị trả về.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M$ and $N$ are matrix dimensions. Each cell is visited at most once.
    * **Độ phức tạp thời gian:** $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ in the worst case for the recursion stack (e.g., if the entire grid is one huge island in a serpentine shape).
    * **Độ phức tạp không gian:** $O(M \times N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Grid Segment:**
```
0 1 1
0 1 0
0 0 0
```
1. Scanner finds `(0, 1)`. Start DFS.
2. `grid[0][1] = 0`. Area = 1 + DFS(left) + DFS(right) + DFS(up) + DFS(down).
3. DFS(right) at `(0, 2)`: `grid[0][2] = 0`. Area = 1 + ...
4. DFS(down) from `(0, 1)` at `(1, 1)`: `grid[1][1] = 0`. Area = 1 + ...
5. Total area = 1 + 1 + 1 = 3.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "Area" or "Size" problems in grids, DFS is the most compact solution. "Sinking" the island (setting `1` to `0`) is a standard optimization to simplify visited-state management.
*Đối với các bài toán về "Diện tích" hoặc "Kích thước" trên lưới, DFS là giải pháp gọn gàng nhất. Việc "nhấn chìm" hòn đảo (gán 1 bằng 0) là một ruy chuẩn tối ưu.*
---
*Diện tích (Area) của một hòn đảo là minh chứng cho sự đoàn kết của những mảnh đất (1s). Trong đại dương của những sự hư ảo (0s), mỗi kết nối là một sự khẳng định của sự tồn tại. Dữ liệu dạy ta rằng bằng cách thấu hiểu từng tấc đất (DFS) và ghi nhận sự hiện diện của mình (Marking), ta có thể đo lường được tầm vóc thực sự của những gì liên kết và bền vững.*
The area (Area) of an island is a testament to the unity of pieces of land (1s). In the ocean of illusions (0s), every connection is an affirmation of existence. Data teaches us that by understanding every inch of land (DFS) and recording our presence (Marking), we can measure the true scale of what is connected and sustainable.
