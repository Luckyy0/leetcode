# Analysis for Projection Area of 3D Shapes
# *Phân tích cho bài toán Diện tích Hình chiếu của Hình khối 3D*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to calculate the total visible surface area of a 3D block structure from three orthogonal directions: Top (XY), Front (XZ), and Side (YZ).
*Chúng ta cần tính tổng diện tích bề mặt nhìn thấy được của một cấu trúc khối 3D từ ba hướng trực giao: Trên (XY), Trước (XZ) và Bên (YZ).*

### KEY LOGIC
### *Logic chính*
1.  **Top View (XY Plane):** Visible area is simply the number of cells `(i, j)` where `grid[i][j] > 0`. Each non-zero cell contributes 1 unit to the area.
    *   **Nhìn từ trên (Mặt phẳng XY):** Diện tích nhìn thấy đơn giản là số lượng ô `(i, j)` mà tại đó `grid[i][j] > 0`. Mỗi ô khác 0 đóng góp 1 đơn vị diện tích.*
2.  **Front View (XZ Plane):** Visible area is the sum of the maximum heights of each **row**. The shadow is determined by the tallest tower in each row.
    *   **Nhìn từ trước (Mặt phẳng XZ):** Diện tích nhìn thấy là tổng chiều cao lớn nhất của mỗi **hàng**. Chiếc bóng được xác định bởi tháp cao nhất trong mỗi hàng.*
3.  **Side View (YZ Plane):** Visible area is the sum of the maximum heights of each **column**. The shadow is determined by the tallest tower in each column.
    *   **Nhìn từ bên (Mặt phẳng YZ):** Diện tích nhìn thấy là tổng chiều cao lớn nhất của mỗi **cột**. Chiếc bóng được xác định bởi tháp cao nhất trong mỗi cột.*

---

## 2. Strategy: Single Pass Iteration
## *2. Chiến lược: Duyệt một lần*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize `area = 0`**.
    *   **Khởi tạo `area = 0`**.*

2.  **Iterate:** Loop `i` from `0` to `n-1`.
    - Initialize `bestRow = 0` and `bestCol = 0`.
    - Loop `j` from `0` to `n-1`.
        - **Top View:** If `grid[i][j] > 0`, increment `area`.
        - **Front View:** Update `bestRow = max(bestRow, grid[i][j])`.
        - **Side View:** Update `bestCol = max(bestCol, grid[j][i])`. Note the transposed indices `[j][i]` to access column `i`.
    - Add `bestRow + bestCol` to `area`.
    *   **Duyệt:** Chạy vòng lặp `i` từ `0` đến `n-1`. Khởi tạo `bestRow = 0` và `bestCol = 0`. Chạy vòng lặp `j` từ `0` đến `n-1`. Nếu `grid[i][j] > 0`, tăng `area`. Cập nhật `bestRow` bằng max của hàng `i`. Cập nhật `bestCol` bằng max của cột `i` (lưu ý dùng chỉ số chuyển vị `[j][i]`). Cộng `bestRow + bestCol` vào `area`.*

3.  **Return `area`**.
    *   **Trả về `area`**.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int projectionArea(int[][] grid) {
    int n = grid.length;
    int area = 0;
    
    for (int i = 0; i < n; i++) {
        int bestRow = 0;
        int bestCol = 0;
        for (int j = 0; j < n; j++) {
            if (grid[i][j] > 0) area++; // Top View
            bestRow = Math.max(bestRow, grid[i][j]); // Front View Logic
            bestCol = Math.max(bestCol, grid[j][i]); // Side View Logic
        }
        area += bestRow + bestCol;
    }
    
    return area;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the grid dimension. We visit each cell effectively twice (once directly, once transposed) within nested loops.
    *   **Độ phức tạp thời gian:** $O(N^2)$, với $N$ là kích thước lưới.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Calculating max row and max column values simultaneously by using transposed indices (`grid[j][i]`) is a clean way to solve matrix problems in a single pass.
*Việc tính toán giá trị lớn nhất của hàng và cột đồng thời bằng cách sử dụng chỉ số chuyển vị (`grid[j][i]`) là một cách gọn gàng để giải quyết các bài toán ma trận trong một lần duyệt.*
