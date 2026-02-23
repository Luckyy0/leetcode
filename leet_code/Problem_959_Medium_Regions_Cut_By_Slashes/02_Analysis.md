# Analysis for Regions Cut By Slashes
# *Phân tích cho bài toán Các Vùng bị Cắt bởi Dấu gạch chéo*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count distinct regions created by slashes in an $N \times N$ grid.
*Đếm số vùng riêng biệt được tạo bởi các dấu gạch chéo trong lưới N x N.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Standard graph problem: Find Connected Components.
- A single cell can be split into up to 4 regions (triangles) by 'X' shape.
- Or simpler: Upscale the grid.
- Represent each $1 \times 1$ cell as a $3 \times 3$ grid of smaller cells.
- A blank ' ' is just empty $3 \times 3$ space.
- A forward slash '/' connects top-right to bottom-left. In $3 \times 3$: `(0,2), (1,1), (2,0)` are barriers.
- A back slash '\' connects top-left to bottom-right. In $3 \times 3$: `(0,0), (1,1), (2,2)` are barriers.
- After constructing the $3N \times 3N$ grid, run BFS/DFS to count connected components of "empty space" (0s).
- Why $3 \times 3$? Because $2 \times 2$ is ambiguous for connections between corners (thin line vs thick line).
  - Example: `//` needs to separate regions.
  - In $2 \times 2$, '/' occupies `(0,1)` and `(1,0)`. Two '/' adjacent might touch.
  - $3 \times 3$ is safe and easy to implement.
*Mở rộng mỗi ô thành lưới $3 \times 3$. Dấu '/' và '\' trở thành các vật cản (số 1). Đếm số vùng số 0 liên thông bằng BFS/DFS.*

---

## 2. Strategy: Upscaling + DFS/BFS
## *2. Chiến lược: Mở rộng lưới + DFS/BFS*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Upscale:** Create `newGrid` of size $3N \times 3N$.
    *   **Mở rộng:** Tạo `newGrid` kích thước $3N \times 3N$.*

2.  **Fill Grid:**
    - Iterate `i, j` in `grid`.
    - If `grid[i][j] == '/'`: Set `(3i, 3j+2), (3i+1, 3j+1), (3i+2, 3j)` to 1.
    - If `grid[i][j] == '\'`: Set `(3i, 3j), (3i+1, 3j+1), (3i+2, 3j+2)` to 1.
    *   **Điền lưới:** Đánh dấu các đường chéo.*

3.  **Count Components:**
    - Iterate `r` from 0 to $3N-1$, `c` from 0 to $3N-1$.
    - If `newGrid[r][c] == 0`:
      - `count++`.
      - Start DFS/BFS from `(r, c)` to mark all reachable 0s as visited (or 1).
    *   **Đếm thành phần:** Duyệt và đếm vùng 0.*

4.  **Return:** `count`.
    *   **Trả về:** `count`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * 3;
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    regions++;
                    dfs(matrix, i, j, size);
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int[][] matrix, int r, int c, int size) {
        if (r < 0 || c < 0 || r >= size || c >= size || matrix[r][c] == 1) {
            return;
        }
        
        matrix[r][c] = 1; // Mark as visited
        
        dfs(matrix, r + 1, c, size);
        dfs(matrix, r - 1, c, size);
        dfs(matrix, r, c + 1, size);
        dfs(matrix, r, c - 1, size);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O((3N)^2) = O(9N^2) \approx O(N^2)$.
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(9N^2)$ for the matrix.
    *   **Độ phức tạp không gian:** $O(N^2)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Upscaling to $3 \times 3$ transforms the problem into a simple standard "Number of Islands" problem.
*Mở rộng thành $3 \times 3$ biến bài toán thành bài toán "Số lượng Đảo" tiêu chuẩn đơn giản.*
