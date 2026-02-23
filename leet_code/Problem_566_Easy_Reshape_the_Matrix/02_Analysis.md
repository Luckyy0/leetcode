# Analysis for Reshape the Matrix
# *Phân tích cho bài toán Thay đổi hình dạng Ma trận*

## 1. Problem Essence & Structural Integrity
## *1. Bản chất vấn đề & Tính toàn vẹn Cấu trúc*

### The Challenge
### *Thách thức*
In numerical computing, reshaping a matrix means changing its dimensions $(m \times n \rightarrow r \times c)$ without altering the data's order.
*Trong tính toán số học, việc định dạng lại một ma trận có nghĩa là thay đổi kích thước của nó $(m \times n \rightarrow r \times c)$ mà không làm thay đổi thứ tự của dữ liệu.*

The elements must flow row-by-row into the new structure. If the total number of elements ($m \times n \neq r \times c$) doesn't match, the operation is invalid.
*Các phần tử phải chảy theo từng hàng vào cấu trúc mới. Nếu tổng số phần tử ($m \times n \neq r \times c$) không khớp, thao tác này là không hợp lệ.*

---

## 2. Strategy: Linear Index Mapping (The Flattened View)
## *2. Chiến lược: Ánh xạ Chỉ số Tuyến tính (Cái nhìn Phẳng)*

Instead of using nested loops with complex index counters, we can treat the 2D matrix as a virtual 1D array.
*Thay vì sử dụng các vòng lặp lồng nhau với các bộ đếm chỉ số phức tạp, chúng ta có thể coi ma trận 2D như một mảng 1D ảo.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Feasibility Check:** Validate if `original_m * original_n == r * c`. If not, return the original matrix.
    * **Kiểm tra tính khả thi:** Xác nhận xem `original_m * original_n == r * c` hay không. Nếu không, hãy trả về ma trận gốc.*

2.  **Flat Index Mapping:** For any total index `k` in the flattened version (where $0 \le k < m \times n$):
    * **Ánh xạ Chỉ số Phẳng:** Đối với bất kỳ chỉ số tổng `k` nào trong phiên bản phẳng (trong đó $0 \le k < m \times n$):*
    - The row in the **original** matrix is `k / n`.
    - *Hàng trong ma trận **gốc** là `k / n`.*
    - The column in the **original** matrix is `k % n`.
    - *Cột trong ma trận **gốc** là `k % n`.*
    - The row in the **new** matrix is `k / c`.
    - *Hàng trong ma trận **mới** là `k / c`.*
    - The column in the **new** matrix is `k % c`.
    - *Cột trong ma trận **mới** là `k % c`.*

3.  **Iteration:** Loop from `k = 0` to `m*n - 1` and perform the assignment.
    * **Lặp:** Lặp từ `k = 0` đến `m*n - 1` và thực hiện phép gán.*

---

## 3. Structural Advantages & Efficiency
## *3. Ưu điểm Cấu trúc & Hiệu quả*

*   **Zero Redundancy:** We touch each element exactly once and compute its new coordinates in $O(1)$.
    * **Không dư thừa:** Chúng ta chạm vào mỗi phần tử đúng một lần và tính toán tọa độ mới của nó trong $O(1)$.*
*   **Intuitive Logic:** The flattened index approach avoids the bugs often associated with updating multiple independent row/column pointers.
    * **Logic trực quan:** Cách tiếp cận chỉ số phẳng tránh được các lỗi thường gặp khi cập nhật nhiều con trỏ hàng/cột độc lập.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$. Every element in the original matrix is visited once to fill the result matrix.
    * **Độ phức tạp thời gian:** $O(M \times N)$. Mọi phần tử trong ma trận gốc đều được thăm một lần để lấp đầy ma trận kết quả.*
*   **Space Complexity:** $O(R \times C)$ for the result matrix. Note that $R \times C = M \times N$.
    * **Độ phức tạp không gian:** $O(R \times C)$ cho ma trận kết quả. Lưu ý rằng $R \times C = M \times N$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `mat = [[1, 2], [3, 4]], r = 1, c = 4`
- Total elements = 4. `r * c` = 4. Valid.
- k=0: `mat[0/2][0%2]` -> `res[0/4][0%4]`: `res[0][0] = mat[0][0]` (1).
- k=1: `mat[1/2][1%2]` -> `res[1/4][1%4]`: `res[0][1] = mat[0][1]` (2).
- k=2: `mat[2/2][2%2]` -> `res[2/4][2%4]`: `res[0][2] = mat[1][0]` (3).
- k=3: `mat[3/2][3%2]` -> `res[3/4][3%4]`: `res[0][3] = mat[1][1]` (4).
- **Result:** `[[1, 2, 3, 4]]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always use a 1D mapping approach for matrix reshaping to keep your index logic clean and bug-free.
*Luôn sử dụng hướng tiếp cận ánh xạ 1D để định dạng lại ma trận nhằm giữ cho logic chỉ số của bạn sạch sẽ và không có lỗi.*
---
*Hình dạng (Shape) có thể thay đổi, nhưng bản chất (Data) bên trong vẫn vẹn nguyên. Trong sự chuyển dịch từ một cấu trúc này sang cấu trúc khác, tính liên tục (Order) chính là sợi dây kết nối cốt lõi giúp giữ vững giá trị ban đầu.*
The shape (Shape) can change, but the nature (Data) inside remains intact. In the shift from one structure to another, continuity (Order) is the core connection that maintains the original value.
