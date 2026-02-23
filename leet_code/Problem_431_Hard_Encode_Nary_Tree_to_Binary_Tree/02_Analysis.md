# Analysis for Encode N-ary Tree to Binary Tree
# *Phân tích cho bài toán Mã hóa Cây N-phân thành Cây Nhị phân*

## 1. Problem Essence & Left-Child Right-Sibling Representation
## *1. Bản chất vấn đề & Biểu diễn Con-trái Anh-em-phải*

### The Challenge
### *Thách thức*
Representing a tree where nodes have arbitrary numbers of children using a structure where each node has at most two children. This is a classic problem in computer science handled by the **Left-Child Right-Sibling** (LCRS) representation.

### Strategy: Recursive Transform
### *Chiến lược: Chuyển đổi Đệ quy*

1.  **Encoding (N-ary to Binary):**
    -   For any N-ary node, its **first child** becomes its **left child** in the binary tree.
    -   Any **subsequent sibling** of that first child becomes the **right child** of the previous sibling in the binary tree.
    -   Example: `1 -> [2, 3, 4]`.
        -   Binary: `1.left = 2`.
        -   `2.right = 3`.
        -   `3.right = 4`.

2.  **Decoding (Binary to N-ary):**
    -   For any Binary node `bNode`, its **left child** and all of its **right-descendants** (right, right.right, ...) constitute the **children list** of the corresponding N-ary node.
    -   Recursively apply this logic.

---

## 2. Approach: Simple DFS
## *2. Hướng tiếp cận: DFS Đơn giản*

### Logic
### *Logic*
(See above). The recursion depth will be the height of the tree. The transformation is bi-directional and loses no information about the parent-child or sibling relationships.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Space Efficient:** Uses a standard binary tree structure without extra pointers or data fields.
    *Hiệu quả không gian: Sử dụng cấu trúc cây nhị phân tiêu chuẩn không cần thêm con trỏ hay trường dữ liệu.*
*   **Intuitive Mapping:** Perfectly maps the sibling order from N-ary trees into the right branch of binary nodes.
    *Ánh xạ trực quan: Ánh xạ hoàn hảo thứ tự anh em từ cây N-phân vào nhánh phải của các nút nhị phân.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. Each node is visited once during both encode and decode.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree (recursion stack). In the worst case (a flat N-ary tree), the binary tree will be skewed to the right.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**N-ary Tree:** `1 -> [3, 2, 4]` (3, 2, 4 are siblings)
1. **Encode:**
   - Root 1. Left child is 3.
   - Sibling of 3 is 2 $\to$ `3.right = 2`.
   - Sibling of 2 is 4 $\to$ `2.right = 4`.
   Binary: `1 (L: 3 -> R: 2 -> R: 4)`.
2. **Decode:**
   - Root 1. Look at left child 3.
   - Collect 3 and all nodes found by following `.right` pointers: `[3, 2, 4]`.
   - These are children of 1.
Result: Original structure restored.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Left-Child Right-Sibling recursive mapping.
*Ánh xạ đệ quy Con-trái Anh-em-phải.*
---
*Mọi sự đa dạng (N-ary children) đều có thể được gói gọn trong sự đơn sơ (binary tree) nếu ta biết cách sắp xếp trật tự. Bằng cách biến đứa con đầu lòng thành điểm tựa (left child) và những người anh em thành một chuỗi tiếp nối (right siblings), ta kiến tạo nên một dòng chảy thông tin không bao giờ đứt đoạn.*
All diversity (N-ary children) can be encapsulated in simplicity (binary tree) if we know how to arrange the order. By turning the firstborn into a support point (left child) and siblings into a sequence (right siblings), we create a flow of information that never breaks.
