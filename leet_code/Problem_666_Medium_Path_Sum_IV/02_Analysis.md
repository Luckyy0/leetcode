# Analysis for Path Sum IV
# *Phân tích cho bài toán Tổng Đường đi IV*

## 1. Problem Essence & Sparse Tree Representation
## *1. Bản chất vấn đề & Biểu diễn Cây Thưa*

### The Challenge
### *Thách thức*
The binary tree is given in a non-standard "compressed" format where each node's location and value are packed into a single integer. We need to reconstruct the relationships and sum up all root-to-leaf paths.
*Cây nhị phân được cho dưới định dạng "nén" không tiêu chuẩn, trong đó vị trí và giá trị của mỗi nút được gói gọn trong một số nguyên duy nhất. Chúng ta cần tái thiết lập các mối quan hệ và tính tổng tất cả các đường đi từ gốc đến lá.*

---

## 2. Strategy: Coordinate Mapping & DFS
## *2. Chiến lược: Ánh xạ Tọa độ & DFS*

Since the total nodes are very few (max depth 4 means max 15 nodes), we can use a Map to store the tree and a recursive function to traverse it.
*Vì tổng số nút rất ít (độ sâu tối đa 4 nghĩa là tối đa 15 nút), chúng ta có thể sử dụng một Map để lưu trữ cây và một hàm đệ quy để duyệt cây.*

### Coordinate System
### *Hệ thống Tọa độ*
Represent a node as a key: `depth * 10 + position`.
*Biểu diễn một nút dưới dạng khóa: `độ sâu * 10 + vị trí`.*
- Root: `11` (Depth 1, Position 1).
- Node $(d, p)$ has children:
    - Left: $(d+1, 2p-1)$.
    - Right: $(d+1, 2p)$.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Parse and Map:** Iterate through `nums`, extract `d`, `p`, and `v`. Store `tree[d*10 + p] = v`.
    * **Phân tích và Ánh xạ:** Duyệt qua `nums`, trích xuất `d`, `p`, và `v`. Lưu vào bản đồ `tree`.*

2.  **Recursive Traversal (DFS):** Define `dfs(nodeKey, currentSum)`.
    * **Duyệt Đệ quy (DFS):** Định nghĩa hàm `dfs(Khóa_nút, Tổng_hiện_tại)`.*
    - Retrieve value of current node from the map.
    - Calculate keys for potential left and right children.
    - Check if children exist in the map:
        - If neither exists: The current node is a **leaf**. Add `currentSum + nodeValue` to the global answer.
        - If child(ren) exist: Recurse for each existing child with `currentSum + nodeValue`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Leaf Identification:** In this packed format, we identify leaves by "probing" for children. If both $(d+1, 2p-1)$ and $(d+1, 2p)$ fail to return a value, the search path ends.
    * **Nhận dạng Lá:** Trong định dạng nén này, ta nhận diện lá bằng cách "thử" tìm các nút con. Nếu cả hai nút con tiềm năng đều không trả về giá trị, đường tìm kiếm kết thúc.*
*   **Memory Efficiency:** A `HashMap` or a simple array of size 50 is sufficient since keys range from 11 to 48.
    * **Hiệu quả Bộ nhớ:** Một `HashMap` hoặc mảng đơn giản kích thước 50 là đủ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes (integers in `nums`). We process each number once.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$, for the map/array to store node values and the recursion stack.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [113, 215, 221]
1. `tree = {11:3, 21:5, 22:1}`.
2. `dfs(11, 0)`:
   - Node 11 has children 21 and 22.
   - Recurse `dfs(21, 3)` and `dfs(22, 3)`.
3. `dfs(21, 3)`:
   - Node 21 has no sub-children. It's a leaf!
   - `total += 3 + 5 = 8`.
4. `dfs(22, 3)`:
   - Node 22 has no sub-children. It's a leaf!
   - `total += 3 + 1 = 4`.
**Result:** 8 + 4 = 12.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sparse data structures shouldn't always be converted back to full objects. Using local coordinate math ($d*10+p$) with a simple Map is often the cleanest way to traverse structures that have a predictable, repeating geometry like full binary trees.
*Dữ liệu thưa không phải lúc nào cũng cần được chuyển đổi ngược thành các thực thể phức tạp. Sử dụng toán học tọa độ địa phương với một Map đơn giản thường là cách sạch sẽ nhất để duyệt các cấu trúc có hình học lặp lại có thể dự đoán được.*
---
*Mọi con số (Integer) đều chứa đựng một bản đồ ẩn (Coordinate). Trong thế giới của những mã số ba chữ số (Path Sum IV), mỗi ký tự đều là một lời chỉ dẫn về vị thế (Depth, Position) và giá trị (Value). Dữ liệu dạy ta rằng bằng cách giải mã những tọa độ này và lần theo từng nhánh rẽ (DFS), ta có thể tìm thấy sự hòa quyện của toàn bộ các con đường (Path sums), từ gốc rễ đến tận cùng các kẽ lá.*
Every number (Integer) contains a hidden map (Coordinate). In the world of three-digit codes (Path Sum IV), each character is a guide to position (Depth, Position) and value (Value). Data teaches us that by decoding these coordinates and following each branch (DFS), we can find the fusion of all paths (Path sums), from the roots to the very tips of the leaves.
