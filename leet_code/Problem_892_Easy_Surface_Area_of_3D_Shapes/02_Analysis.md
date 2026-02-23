# Analysis for Surface Area of 3D Shapes
# *Phân tích cho bài toán Diện tích Bề mặt của Hình khối 3D*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Calculate the total surface area of stacked cubes on an $N \times N$ grid including all exposed faces (top, bottom, and 4 sides).
*Tính tổng diện tích bề mặt của các khối lập phương xếp chồng lên nhau trên lưới $N \times N$ bao gồm tất cả các mặt lộ ra (trên, dưới và 4 bên).*

### KEY LOGIC
### *Logic chính*
Assume each tower `v = grid[i][j]` contributes independently.
- A tower of height `v > 0` has:
  - Top face: 1
  - Bottom face: 1
  - 4 sides: $v \times 4$
  - Total: $4v + 2$.
However, towers are adjacent. When two towers are adjacent, they cover each other's sides.
- If `grid[i][j]` is adjacent to `grid[i][j+1]`, the "hidden" or "glued" area is `2 * min(height1, height2)`.
*Giả sử mỗi tháp đóng góp độc lập. Một tháp cao `v > 0` có tổng diện tích $4v + 2$. Tuy nhiên, khi hai tháp liền kề, chúng che mất một phần diện tích của nhau (phần dán keo). Diện tích bị che là `2 * min(height1, height2)`.*

---

## 2. Strategy: Additive and Subtractive
## *2. Chiến lược: Cộng và Trừ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate:** Loop through each cell `(i, j)`.
    *   **Duyệt:** Quét qua từng ô `(i, j)`.*

2.  **Add Individual Contribution:**
    - If `grid[i][j] > 0`, add `4 * grid[i][j] + 2` to `ans`.
    *   **Cộng đóng góp cá nhân:** Nếu chiều cao > 0, cộng `4 * v + 2`.*

3.  **Subtract Overlaps:** Check neighbors (down and right to avoid double counting).
    - If `i < n - 1`: subtract `2 * min(grid[i][j], grid[i+1][j])`.
    - If `j < n - 1`: subtract `2 * min(grid[i][j], grid[i][j+1])`.
    *   **Trừ phần chồng lấn:** Kiểm tra hàng xóm (phía dưới và bên phải để tránh đếm hai lần). Trừ đi `2 * min` chiều cao của hai tháp kề nhau.*

4.  **Return `ans`**.
    *   **Trả về kết quả.**

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int surfaceArea(int[][] grid) {
    int n = grid.length;
    int area = 0;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] > 0) {
                area += grid[i][j] * 4 + 2;
            }
            // Subtract overlap with the cell below
            if (i < n - 1) {
                area -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
            }
            // Subtract overlap with the cell to the right
            if (j < n - 1) {
                area -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
            }
        }
    }
    
    return area;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the grid size.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Calculating the total potential area first and then subtracting the shared surfaces is simpler to implement than trying to calculate the exposed surface of each cell directly by checking 4 neighbors.
*Việc tính tổng diện tích tiềm năng trước rồi trừ đi các phần bề mặt chung sẽ đơn giản hơn so với việc cố gắng tính trực tiếp bề mặt lộ ra của từng ô bằng cách kiểm tra 4 hướng.*
