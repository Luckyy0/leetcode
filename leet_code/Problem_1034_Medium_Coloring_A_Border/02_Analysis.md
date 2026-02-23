# Analysis for Coloring A Border
# *Phân tích bài toán Tô Màu Viền*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an $m \times n$ grid of colored squares, you start at a specific cell `(row, col)`. Your goal is to find the "connected component" of this starting cell (all orthogonally adjacent cells of the same original color) and color only the **border** of this component with a new `color`. A cell is considered on the border if it's on the edge of the grid or adjacent to a cell of a different original color.
*Cho một lưới $m \times n$ các ô vuông có màu, bạn bắt đầu tại một ô `(row, col)`. Nhiệm vụ của bạn là thâu tóm "vùng liên thông" của ô xuất phát này (chứa tất cả các ô kề cạnh có cùng màu gốc) và CHỈ TÔ MÀU **viền ngoài** của vùng này bằng một `màu mới`. Một ô nằm trên viền ngoài nếu nó nằm sát mép bảng (mép lưới) hoặc kề cạnh với một ô mang màu gốc khác biệt.*

---

## 2. Strategy (Depth-First Search - Flood Fill)
## *2. Chiến lược (Tìm kiếm theo chiều sâu - Vết Dầu Loang)*

### Logic and Rules
### *Lý luận và Quy tắc*

We can use a Depth-First Search (DFS) or Breadth-First Search (BFS) to explore the connected component. During the traversal, we track which cells belong to the component and naturally check their physical surroundings.
*Thuật toán DFS (Vết dầu loang) là lựa chọn tự nhiên nhất. Ta bắt đầu đổ bộ từ ô xuất phát, loang ra tứ phía để tìm tất cả các ô cùng màu. Trong lúc lan truyền, ta kiểm tra môi trường xung quanh của từng ô để xác định xem ô đó có nằm ngoài "đường biên" hay không.*

1. **Identification:** For any visited cell matching the original color, check its 4 neighbors. It is a border cell if:
   - It is literally on the boundary of the matrix (`r == 0`, `c == 0`, `r == m-1`, or `c == n-1`).
   - Or, at least one of its neighbors has a distinctly different color than the starting cell's original color.
*1. **Nhận diện Viền:** Đối với bất kỳ ô nào đã ghé thăm và trùng màu gốc, hãy check 4 ô hàng xóm của nó. Nó CHẮC CHẮN là đường viền nếu:
   - Nó chạm ranh giới mép ma trận (ví dụ: `Tọa độ r == 0`, `c == 0`, v.v.).
   - HOẶC (cực kỳ quan trọng), ít nhất 1 đứa hàng xóm của nó LÀ KẺ NGOẠI LAI mang màu sắc tà đạo khác hẳn màu gốc đang xét.*
2. **Delayed Coloring:** To avoid incorrectly assuming a cell is a border because a neighboring cell's color was prematurely updated, we temporarily mark visited cells with a special negative value (e.g., `-originalColor`). After DFS explicitly finishes, we safely translate all confirmed border cells to the new color, and restore non-border cells mathematically back to their original positive color!
*2. **Đổ Màu Trì Hoãn:** Không được tham lam tô màu mới ngay lập tức! Nếu ta đổi màu mới cho 1 ô đang duyệt, những ô hàng xóm ở phía sau sẽ bị LÚ và lầm tưởng ô vừa đổi là một "Kẻ Ngoại Lai" (vì màu đã khác màu gốc). Cách thông minh: Đánh dấu ô đang duyệt là Tọa độ "Âm" (ví dụ `-màu_gốc` = Đã Đi Qua Dấu Chân). Sau khi thuật toán DFS lặn vào ngóc ngách xong xuôi, vòng cuối ta mới Lôi tất cả Nút "Biên Giới" ra Bơm Màu Mới, và Trả lại Sự trong sạch (Giá trị dương) cho các ô không phải viền.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int originalColor = grid[row][col];
        if (originalColor == color) return grid; // No work needed
        
        dfs(grid, row, col, originalColor);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    private void dfs(int[][] grid, int r, int c, int originalColor) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != originalColor) {
            return;
        }
        
        grid[r][c] = -originalColor; // Visited mark
        
        dfs(grid, r + 1, c, originalColor);
        dfs(grid, r - 1, c, originalColor);
        dfs(grid, r, c + 1, originalColor);
        dfs(grid, r, c - 1, originalColor);
        
        // Restore non-border cells
        if (r > 0 && r < grid.length - 1 && c > 0 && c < grid[0].length - 1 &&
            Math.abs(grid[r + 1][c]) == originalColor &&
            Math.abs(grid[r - 1][c]) == originalColor &&
            Math.abs(grid[r][c + 1]) == originalColor &&
            Math.abs(grid[r][c - 1]) == originalColor) {
            
            grid[r][c] = originalColor; // Revert because it's completely surrounded
        }
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(m \times n)$, where $m$ and $n$ are the matrix dimensions. We visit each valid cell inside the connected component exactly once.
*   *   **Độ phức tạp thời gian:** $O(m \times n)$. Đội thám hiểm DFS chỉ ghé thăm mỗi ô trong mảng đúng một lần. Hoạt động vô cùng trơn tru tuyến tính trên diện tích hình chữ nhật.*
*   **Space Complexity:** $O(m \times n)$, accounting explicitly for the recursive call stack depth if the component forms a massive snake structurally filling the grid entirely.
*   *   **Độ phức tạp không gian:** $O(m \times n)$. Bộ nhớ bị tốn đi vào Cái Ống Khói Gọi Đệ quy `DFS` của hệ thống. Ở tình huống quái thai nhất (Lưới tô 1 màu zic zắc con rắn), đệ quy rớt sâu tới tận cùng kích thước mảng! Chỗ này cần Ram bù trừ.*
