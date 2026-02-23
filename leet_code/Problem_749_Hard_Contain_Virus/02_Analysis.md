# Analysis for Contain Virus
# *Phân tích cho bài toán Ngăn chặn Virus*

## 1. Problem Essence & Simulation
## *1. Bản chất vấn đề & Mô phỏng*

### The Challenge
### *Thách thức*
We are playing a game against a spreading virus. The strategy is fixed: always block the region that threatens the *most* new cells. The complexity comes from managing connected components, handling the "contained" state, and correctly counting required walls versus threatened cells.
*Chúng ta đang chơi một trò chơi chống lại virus lây lan. Chiến lược là cố định: luôn chặn khu vực đe dọa *nhiều* ô mới nhất. Sự phức tạp đến từ việc quản lý các thành phần liên thông, xử lý trạng thái "đã cách ly", và đếm chính xác số tường cần thiết so với số ô bị đe dọa.*

---

## 2. Strategy: Iterative Simulation
## *2. Chiến lược: Mô phỏng Lặp*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Identify Regions:** Use DFS/BFS to find all connected components of virus (`1`s). Ignore already contained virus cells (e.g., mark them as `-1` or `2`).
    *   **Xác định Khu vực:** Dùng DFS/BFS tìm các thành phần liên thông của virus. Bỏ qua các ô đã bị cách ly.*

2.  **Evaluate Threat:** For each region, calculate:
    - `threats`: The set of coordinates of neighboring `0`s (uninfected cells) that will effectively be infected. We use a `Set` because multiple virus cells can threaten the same empty cell, but it only counts as 1 threatened cell.
    - `walls`: The number of boundary edges between this region and uninfected cells. Note: If a `0` is adjacent to two `1`s from the region, we need **2 walls** but it counts as **1 threat**.
    *   **Đánh giá Mối đe dọa:** Với mỗi khu vực, tính toán tập hợp các ô `0` bị đe dọa (dùng Set) và số lượng tường cần thiết (số cạnh tiếp xúc).*

3.  **Selection & Containment:**
    - Find the region with the maximum `threats.size()`.
    - Add its `walls` count to the total answer.
    - Mark all cells in this region as "contained" (e.g., set to `-1`). These cells will no longer spread or interact.
    *   **Lựa chọn & Cách ly:** Chọn khu vực có số lượng đe dọa lớn nhất. Cộng số tường vào tổng. Đánh dấu khu vực này là "đã cách ly" (ví dụ: -1).*

4.  **Spread:**
    - For all *other* (uncontained) regions, turn their `threats` (neighbors) into virus cells (`1`).
    *   **Lây lan:** Với các khu vực còn lại (chưa cách ly), biến các ô lân cận của chúng thành virus.*

5.  **Termination:** Repeat until no threats exist.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O((NM)^2)$. In each round, we visit every cell. The number of rounds is bounded by the number of empty cells (since at least one cell is saved or infected each active round). With $50 \times 50$, this is feasible.
    *   **Độ phức tạp thời gian:** $O((NM)^2)$. Mỗi vòng duyệt toàn bộ lưới. Số vòng bị chặn bởi số lượng ô trống.*
*   **Space Complexity:** $O(NM)$ for visited arrays and storage of regions.
    *   **Độ phức tạp không gian:** $O(NM)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Grid:** Two clusters.
- Cluster A threatens 5 cells, requires 8 walls.
- Cluster B threatens 3 cells, requires 4 walls.
**Decision:** Contain A.
- Total walls += 8.
- Grid updates: A becomes contained (-1). B spreads to its 3 neighbors.
**Next Round:** Find regions again. Since A is -1, it's ignored. B is likely larger now. Repeat.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Crucial distinction: "Threatened cells" determining priority vs "Walls required" accumulating cost. A `Set` is needed for threats (unique cells), while a simple counter works for walls (edges).
*Phân biệt quan trọng: "Số ô bị đe dọa" quyết định sự ưu tiên so với "Số tường cần thiết" tích lũy chi phí. Cần dùng `Set` cho các mối đe dọa (các ô duy nhất), trong khi chỉ cần biến đếm cho số tường (các cạnh).*
---
*Trong cuộc chiến ngăn chặn nghịch cảnh (Contain Virus), sự ưu tiên không nằm ở nơi ồn ào nhất mà ở nơi gây tổn hại tiềm tàng lớn nhất (Max threats). Mỗi bức tường được dựng lên (Walls) là một sự hy sinh tài nguyên để bảo vệ tương lai. Dữ liệu dạy ta rằng bằng cách mô phỏng chính xác hậu quả của sự lây lan (Spread simulation), ta có thể đưa ra quyết định tối ưu nhất để cứu vãn những gì còn lại.*
In the battle to contain adversity (Contain Virus), priority lies not in the loudest place but in the place causing the greatest potential damage (Max threats). Every wall erected (Walls) is a sacrifice of resources to protect the future. Data teaches us that by accurately simulating the consequences of spread (Spread simulation), we can make the most optimal decision to salvage what remains.
