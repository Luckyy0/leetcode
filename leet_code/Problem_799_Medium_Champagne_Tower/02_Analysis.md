# Analysis for Champagne Tower
# *Phân tích cho bài toán Tháp Sâm panh*

## 1. Problem Essence & Simulation
## *1. Bản chất vấn đề & Mô phỏng*

### The Challenge
### *Thách thức*
We need to model how champagne flows through a pyramid of glasses.
When a glass is overflowing (contains $> 1$ unit), the excess amount $(amount - 1)$ is split equally and flows into the two glasses immediately below it.
*Chúng ta cần mô phỏng cách sâm panh chảy qua tháp ly. Khi một ly bị tràn (chứa $> 1$ đơn vị), lượng dư thừa $(amount - 1)$ được chia đều và chảy xuống hai ly ngay bên dưới.*

---

## 2. Strategy: Dynamic Programming (Simulation)
## *2. Chiến lược: Quy hoạch động (Mô phỏng)*

### Algorithm
### *Thuật toán*

1.  **Grid Setup:** Use a 2D array `tower[101][101]` to store the total amount of liquid that passes through or stays in each glass.
    *   **Thiết lập lưới:** Sử dụng mảng 2D `tower[101][101]` để lưu tổng lượng chất lỏng chảy qua hoặc đọng lại ở mỗi ly.*

2.  **Initial Pour:** Put all `poured` amount into `tower[0][0]`.
    *   **Lượng đổ ban đầu:** Đổ tất cả lượng `poured` vào `tower[0][0]`.*

3.  **Flow Down:**
    - Iterate through each row `r` from 0 to `query_row`.
    - For each glass `c` in row `r`:
      - Calculate overflow: `overflow = (tower[r][c] - 1.0) / 2.0`.
      - If `overflow > 0`:
        - Add `overflow` to `tower[r+1][c]`.
        - Add `overflow` to `tower[r+1][c+1]`.
    *   **Chảy xuống:** Duyệt qua từng hàng `r` từ 0 đến `query_row`. Với mỗi ly, nếu lượng sâm panh $> 1$, tính lượng tràn và cộng vào các ly ở hàng tiếp theo.*

4.  **Result Retrieval:**
    - The value in `tower[query_row][query_glass]` is the amount that *entered* that glass.
    - However, a glass can only hold at most 1 unit.
    - Return `min(1.0, tower[query_row][query_glass])`.
    *   **Lấy kết quả:** Giá trị tại `tower[query_row][query_glass]` là tổng lượng chảy vào ly đó. Vì một ly chỉ chứa tối đa 1 đơn vị, trả về `min(1.0, tower[query_row][query_glass])`.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(R^2)$, where $R$ is the number of rows (at most 100). This is a constant time operation effectively ($100 \times 100$).
    *   **Độ phức tạp thời gian:** $O(R^2)$, thực tế là khoảng $100^2$ phép tính.*
*   **Space Complexity:** $O(R^2)$ for the tower grid. Can be optimized to $O(R)$ using a single row update.
    *   **Độ phức tạp không gian:** $O(R^2)$, có thể tối ưu về $O(R)$ nếu cập nhật theo hàng.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `poured=2, row=1, glass=1`
1. `tower[0][0] = 2.0`.
2. Row 0: `tower[0][0]` overflow = `(2.0 - 1.0)/2.0 = 0.5`.
3. Add 0.5 to `tower[1][0]` and 0.5 to `tower[1][1]`.
4. Result at `tower[1][1]` is 0.5.
**Result:** 0.5.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simulation row by row is the most intuitive approach. Since the tower size is small (100 rows), $O(R^2)$ is perfectly fine.
*Mô phỏng theo từng hàng là cách tiếp cận trực quan nhất. Với kích thước tháp nhỏ (100 hàng), $O(R^2)$ hoàn toàn đáp ứng tốt.*
