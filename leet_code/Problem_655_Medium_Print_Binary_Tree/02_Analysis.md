# Analysis for Print Binary Tree
# *Phân tích cho bài toán In Cây Nhị phân*

## 1. Problem Essence & Geometric Tree Layout
## *1. Bản chất vấn đề & Bố cục Hình học của Cây*

### The Challenge
### *Thách thức*
We need to project a binary tree into a 2D matrix according to specific mathematical rules that ensure a symmetrical, layered appearance.
*Chúng ta cần chiếu một cây nhị phân vào một ma trận 2D theo các quy tắc toán học cụ thể để đảm bảo giao diện phân tầng và đối xứng.*

The grid dimensions and child placements are strictly defined by the tree's height.
*Kích thước lưới và vị trí các nút con được xác định nghiêm ngặt bởi chiều cao của cây.*

---

## 2. Strategy: Multi-pass Recursion
## *2. Chiến lược: Đệ quy Đa bước*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Calculate Height:** First, we need to find the maximum depth of the tree (`height`). Note: in this problem, a single root has height 0.
    * **Tính Chiều cao:** Đầu tiên, tìm độ sâu tối đa. Lưu ý: một nút gốc có chiều cao là 0.*

2.  **Initialize Matrix:**
    * **Khởi tạo Ma trận:** *
    - Rows $M = \text{height} + 1$.
    - Columns $N = 2^{\text{height} + 1} - 1$.
    - Fill everything with `""`.

3.  **Recursive Fill:** Use a recursive function `fill(node, row, col)`:
    * **Điền Đệ quy:** *
    - Base case: If `node == null`, return.
    - Place `node.val` at `matrix[row][col]`.
    - Offsets for children at row `r`: $2^{\text{height} - r - 1}$.
    - Left child: `fill(node.left, row + 1, col - offset)`.
    - Right child: `fill(node.right, row + 1, col + offset)`.

4.  **Result:** Convert the 2D array/list structure to the required output format.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Mathematical Regularity:** The placement rule $c \pm 2^{\text{height}-r-1}$ ensures that the horizontal distance between nodes halves at each level, mimicking how humans draw binary trees.
    * **Tính quy luật toán học:** Quy tắc đặt vị trí giúp khoảng cách ngang giữa các nút giảm đi một nửa sau mỗi tầng, mô phỏng cách con người vẽ cây nhị phân.*
*   **Grid Certainty:** Because the height is small ($\le 10$), the grid size is manageable ($11 \times 2047$ max).
    * **Sự chắc chắn của lưới:** Vì chiều cao nhỏ ($\le 10$), kích thước lưới nằm trong tầm kiểm soát.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H \times 2^H)$, which is proportional to the number of cells in the matrix. Even though we visit each tree node once, we must initialize the matrix.
    * **Độ phức tạp thời gian:** $O(H \times 2^H)$, tỷ lệ thuận với số ô trong ma trận.*
*   **Space Complexity:** $O(H \times 2^H)$ to store the matrix.
    * **Độ phức tạp không gian:** $O(H \times 2^H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Tree:** [1, 2] -> Height = 1.
1. Rows = 2, Cols = $2^2 - 1 = 3$. Matrix: 2x3.
2. Root 1 at (0, (3-1)/2) = (0, 1).
3. Offset for row 0: $2^{1-0-1} = 2^0 = 1$.
4. Left 2 at (1, 1-1) = (1, 0).
**Result:** [["", "1", ""], ["2", "", ""]]

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "visual" tree problems, calculating dimensions first is essential. Use the problem's provided formulas directly to calculate child offsets, as they are designed to prevent overlaps and ensure symmetry.
*Đối với các bài toán "trực quan" về cây, việc tính toán kích thước trước là rất thiết yếu. Hãy sử dụng trực tiếp các công thức được cung cấp để tính độ lệch của nút con.*
---
*Sự trình bày (Layout) là ngôn ngữ của cấu trúc. Trong không gian hai chiều, một cây nhị phân không chỉ là tập hợp các nút, mà là một sự sắp đặt hài hòa của các khoảng trắng và giá trị (Symmetry). Dữ liệu dạy ta rằng bằng cách xác định chiều cao (Height) và tâm điểm (Middle), ta có thể biến một cấu trúc dữ liệu trừu tượng thành một hình ảnh cân đối và rõ ràng.*
Layout (Layout) is the language of structure. In two-dimensional space, a binary tree is not just a collection of nodes, but a harmonious arrangement of spaces and values (Symmetry). Data teaches us that by determining height (Height) and focal point (Middle), we can turn an abstract data structure into a balanced and clear image.
