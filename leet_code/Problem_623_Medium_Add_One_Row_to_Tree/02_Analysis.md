# Analysis for Add One Row to Tree
# *Phân tích cho bài toán Thêm một Hàng vào Cây*

## 1. Problem Essence & Structural Redesign
## *1. Bản chất vấn đề & Tái thiết kế Cấu trúc*

### The Challenge
### *Thách thức*
We need to insert a full layer of new nodes into an existing binary tree at a specific depth. This requires careful handling of the parent pointers and the transfer of existing subtrees to the new nodes.
*Chúng ta cần chèn một lớp nút mới hoàn chỉnh vào một cây nhị phân hiện có tại một độ sâu cụ thể. Việc này đòi hỏi phải xử lý cẩn thận các con trỏ cha và việc chuyển các cây con hiện có sang các nút mới.*

Two main scenarios:
*Hai kịch bản chính:*
1.  Inserting at the very top (`depth == 1`).
2.  Inserting somewhere inside or at the bottom (`depth > 1`).

---

## 2. Strategy: Recursive Depth Tracking (DFS)
## *2. Chiến lược: Theo dõi Độ sâu Đệ quy (DFS)*

A recursive DFS approach is elegant here because we can pass the "remaining depth" as an argument.
*Cách tiếp cận DFS đệ quy rất thanh lịch ở đây vì chúng ta có thể chuyển "độ sâu còn lại" như một đối số.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Special Case (Depth 1):** If `depth == 1`, create a new node with `val`, set its `left` to the old `root`, and return the new node.
    * **Trường hợp Đặc biệt (Độ sâu 1):** Nếu `depth == 1`, hãy tạo một nút mới với `val`, đặt `left` của nó là `root` cũ, và trả về nút mới.*

2.  **Base Case for Recursion:** If `node == null`, return.
    * **Trường hợp Cơ sở cho Đệ quy:** Nếu `node == null`, hãy quay lại.*

3.  **Target Depth Logic (Depth - 1):** If the current node is at `depth - 1`, it's the parent of where the new row should be.
    * **Logic Độ sâu Mục tiêu (Depth - 1):** Nếu nút hiện tại ở độ sâu `depth - 1`, nó là cha của nơi hàng mới nên được thêm vào.*
    - Save `node.left` and `node.right`.
    - Create new Left node: `node.left = new TreeNode(val)`.
    - Create new Right node: `node.right = new TreeNode(val)`.
    - Attach old subtrees: `node.left.left = oldLeft` and `node.right.right = oldRight`.

4.  **Recursive Step:** Otherwise, call the function recursively for children with `depth - 1`.
    * **Bước Đệ quy:** Nếu không, hãy gọi hàm đệ quy cho các nút con với `depth - 1`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Breadth-First Alternative:** This problem can also be solved with BFS (queue) by reaching the `depth - 1` level and then modifying all nodes in that level. DFS is usually more concise in code.
    * **Giải pháp thay thế Duyệt theo chiều rộng:** Bài toán này cũng có thể được giải bằng BFS (hàng đợi) bằng cách tiếp cận mức `depth - 1` và sau đó sửa đổi tất cả các nút ở mức đó. DFS thường ngắn gọn hơn về mã.*
*   **Asymmetric Attachment:** Note the rule: the old left child becomes the new left-node's *left* child, but the old right child becomes the new right-node's *right* child. This maintains the "expanded" shape of the tree.
    * **Gắn kết bất đối xứng:** Lưu ý quy tắc: con trái cũ trở thành con *trái* của nút trái mới, nhưng con phải cũ trở thành con *phải* của nút phải mới. Điều này duy trì hình dạng "mở rộng" của cây.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of nodes. In the worst case, we might visit all nodes up to the specified depth.
    * **Độ phức tạp thời gian:** $O(N)$ trong đó $N$ là số lượng nút. Trong trường hợp xấu nhất, chúng ta có thể ghé thăm tất cả các nút cho đến độ sâu được chỉ định.*
*   **Space Complexity:** $O(H)$ for the recursion stack, where $H$ is the height of the tree ($O(N)$ in a skewed tree).
    * **Độ phức tạp không gian:** $O(H)$ cho ngăn xếp đệ quy, trong đó $H$ là chiều cao của cây (có thể là $O(N)$ trong một cây bị lệch).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [4,2,6], val=1, depth=2
1. depth=2, cur node is at depth 1. (Condition depth-1 == 1 met).
2. Old left = 2, Old right = 6.
3. New Left = node(1), New Right = node(1).
4. Connect: 4.left = node(1), 4.right = node(1).
5. Downward connect: node(1).left = 2, node(1).right = 6.
**Result:** [4, 1, 1, 2, null, null, 6].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Tree insertion problems are often about identifying the "parent" level. By focusing on `depth - 1`, we gain control over the links that need to be broken and rebuilt.
*Các bài toán chèn vào cây thường xoay quanh việc xác định mức "cha". Bằng cách tập trung vào `depth - 1`, chúng ta có quyền kiểm soát các liên kết cần bị phá vỡ và xây dựng lại.*
---
*Sự phát triển (Growth) đôi khi yêu cầu sự chen ngang (Insertion) của những giá trị mới. Trong cấu trúc của cây (Tree), việc thêm một hàng (Add a row) không xóa bỏ quá khứ mà là kế thừa và mở rộng nó. Dữ liệu dạy ta cách tạo ra những nhịp cầu mới (New nodes) để kết nối lịch sử (Old subtrees) với một tương lai rộng lớn hơn.*
Growth (Growth) sometimes requires the insertion (Insertion) of new values. In the structure of a tree (Tree), adding a row (Add a row) does not delete the past but inherits and expands it. Data teaches us how to create new bridges (New nodes) to connect history (Old subtrees) with a broader future.
