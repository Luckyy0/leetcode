# Analysis for Longest Univalue Path
# *Phân tích cho bài toán Đường đi Đồng nhất Dài nhất*

## 1. Problem Essence & Local Path Junction
## *1. Bản chất vấn đề & Điểm nối Đường đi cục bộ*

### The Challenge
### *Thách thức*
We need to find the longest sequence of connected nodes in a binary tree where all nodes share the same value. The path can bend at any node, meaning it can go up from a left sub-branch and down into a right sub-branch if all three (parent, left child, right child) share the same value.
*Chúng ta cần tìm chuỗi các nút kết nối dài nhất trong cây nhị phân mà tất cả các nút đều có cùng giá trị. Đường đi có thể bẻ cong tại bất kỳ nút nào.*

---

## 2. Strategy: Recursive Post-order DFS
## *2. Chiến lược: DFS Hậu thứ tự*

The core idea is to process each node and determine the longest univalue "arrow" starting from it and going down into its children.
*Ý tưởng cốt lõi là xử lý từng nút và xác định "mũi tên" đồng nhất dài nhất bắt đầu từ đó và hướng xuống các con.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Define Recursive Function `dfs(node)`:**
    * **Hàm đệ quy `dfs(node)`:** *
    - Calculate `left` (longest univalue path down from left child).
    - Calculate `right` (longest univalue path down from right child).
    - **Initialization:** Let `arrowLeft = 0`, `arrowRight = 0`.
    - **Check Left Child:** If `node.left` exists and its value matches `node.val`, `arrowLeft = left + 1`.
    - **Check Right Child:** If `node.right` exists and its value matches `node.val`, `arrowRight = right + 1`.

2.  **Update Global Maximum:**
    - The path *passing through* the current node as a junction has length `arrowLeft + arrowRight`.
    - Update `ans = max(ans, arrowLeft + arrowRight)`.
    * **Cập nhật Cực đại Toàn cục:** Đường đi *đi qua* nút hiện tại như một điểm nối có độ dài là `arrowLeft + arrowRight`.*

3.  **Return Value:**
    - Return `max(arrowLeft, arrowRight)` to the parent node. This represents the longest single-branch univalue path available for the parent to connect to.
    * **Giá trị trả về:** Trả về `max(arrowLeft, arrowRight)` cho nút cha.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Bottom-Up Aggregation:** By using post-order traversal, we ensure that children's information is fully computed before the parent processes its own state.
    * **Tổng hợp từ dưới lên:** Đảm bảo thông tin của các con được tính toán đầy đủ trước khi nút cha xử lý.*
*   **Path vs. Height:** Standard tree height logic is modified here to only accumulate values if they are "univalue."
    * **Đường đi và Chiều cao:** Logic chiều cao cây tiêu chuẩn được sửa đổi để chỉ tích lũy nếu chúng cùng giá trị.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We visit each node exactly once.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$ for the recursion stack, where $H$ is the height of the tree.
    * **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [5, 4, 5, 1, 1, null, 5]
1. DFS reaches leaf 5 (right child of right child). Returns 0.
2. Parent 5 (right child of root):
   - Right child matches? Yes. `arrowRight = 0 + 1 = 1`.
   - Max updated to 1. Returns 1.
3. Root 5:
   - Left child matches? (4 vs 5) No. `arrowLeft = 0`.
   - Right child matches? (5 vs 5) Yes. `arrowRight = 1 + 1 = 2`.
   - Max updated to 2.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In path problems that can "bend" at a node, use a recursive function that returns the longest **single branch** while updating a global variable with the combination of **both branches**. This "bend-point" logic is common in tree problems (e.g., Maximum Path Sum).
*Trong các bài toán đường đi có thể "bẻ cong", hãy dùng hàm đệ quy trả về nhánh đơn dài nhất và cập nhật biến toàn cục bằng tổng hai nhánh.*
---
*Đường đi (Path) là sự kết nối của những bản ngã tương đồng (Univalue). Trong cấu trúc của cây (Tree), mỗi nút có thể là một điểm kết thúc, một bước đệm, hoặc một trái tim nối liền hai nhánh rẽ (Junction). Dữ liệu dạy ta rằng bằng cách lắng nghe từ dưới lên (Post-order) và gom góp những mũi tên đồng nhất (Arrows), ta có thể tìm thấy nhịp đập dài nhất của sự nhất quán trong một rừng những giá trị khác biệt.*
The path (Path) is the connection of similar selves (Univalue). In the structure of the tree (Tree), each node can be an end point, a stepping stone, or a heart connecting two branches (Junction). Data teaches us that by listening from the bottom up (Post-order) and gathering unidirectional arrows (Arrows), we can find the longest beat of consistency in a forest of different values.
