# Analysis for Island Perimeter
# *Phân tích cho bài toán Chu vi Đảo*

## 1. Problem Essence & Shared Boundaries
## *1. Bản chất vấn đề & Các biên chung*

### The Challenge
### *Thách thức*
Calculating the total boundary length of an island. Each land cell contributes 4 units to the perimeter. However, for every shared boundary between two land cells, 2 units are subtracted (one from each cell).

### Strategy: One-Pass Scanning
### *Chiến lược: Duyệt một lần*

1.  **Iterate:** Traverse every cell in the grid.
2.  **Land Detection:** If `grid[i][j] == 1`:
    - Add 4 to the total `perimeter`.
    - **Check Up:** If there is land above (`i > 0 && grid[i-1][j] == 1`), the current cell and the one above share a boundary. Subtract 2.
    - **Check Left:** If there is land to the left (`j > 0 && grid[i][j-1] == 1`), the current cell and the one to the left share a boundary. Subtract 2.
3.  **Optimization:** Only checking "Up" and "Left" (or "Down" and "Right") is enough because each pair of neighbors will be caught exactly once.

---

## 2. Approach: Deductive Counting
## *2. Hướng tiếp cận: Đếm Khấu trừ*

### Logic
### *Logic*
(See above). The algorithm counts the "potential" perimeter and then corrects it by removing internally "consumed" boundaries.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N*M) Efficiency:** Single pass through the grid.
    *Hiệu quả O(N*M): Duyệt ma trận một lần.*
*   **Simple Logic:** No complex BFS/DFS needed, though they could be used.
    *Logic đơn giản: Không cần BFS/DFS phức tạp, dù chúng có thể được sử dụng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(R \cdot C)$, where $R$ and $C$ are rows and columns.
    *Độ phức tạp thời gian: $O(R \cdot C)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[0, 1], [1, 1]]`
1. `(0, 1)` is land. `Perimeter = 4`. No neighbor above or left is land.
2. `(1, 0)` is land. `Perimeter = 4 + 4 = 8`. Neighbor above `(0, 0)` is water. Neighbor left is out of bounds.
3. `(1, 1)` is land. `Perimeter = 8 + 4 = 12`.
   - Neighbor above `(0, 1)` is land. `Perimeter = 12 - 2 = 10`.
   - Neighbor left `(1, 0)` is land. `Perimeter = 10 - 2 = 8`.
Result: 8.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Accumulate grid cells and subtract shared edges.
*Tích lũy các ô lưới và trừ đi các cạnh chung.*
---
*Đất mẹ tạo nên chu vi (perimeter) từ những gì tiếp xúc với thế giới bên ngoài (water). Khi chúng ta đứng gần nhau, kết nối với nhau (shared boundaries), cái tôi cá nhân (individual perimeter) thu hẹp lại để nhường chỗ cho một sự thống nhất lớn lao hơn. Những gì nằm sâu trong tâm (internal edges) không cần phải phơi bày trước sóng gió, chính sự thầm lặng đó tạo nên sức mạnh của cả hòn đảo.*
Nature creates perimeter (perimeter) from what contacts with the outer world (water). When we stand close to each other, connect with each other (shared bounds), the individual (individual perimeter) narrowed to make room for a greater unity. What is deep in the heart (internal edges) does not need to be exposed to waves, that silence creates the strength of the whole island.
