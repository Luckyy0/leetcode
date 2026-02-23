# Analysis for Delete Node in a BST
# *Phân tích cho bài toán Xóa Nút trong BST*

## 1. Problem Essence & BST Structural Integrity
## *1. Bản chất vấn đề & Tính toàn vẹn cấu trúc BST*

### The Challenge
### *Thách thức*
Deleting a node from a Binary Search Tree while maintaining the BST property (Left < Root < Right). The difficulty depends on the number of children the target node has.

### Strategy: Recursive Deletion
### *Chiến lược: Xóa Đệ quy*

1.  **Search:** Traverse the tree to find the node with `val == key`.
    - If `key < root.val`: Recurse to the `left` child.
    - If `key > root.val`: Recurse to the `right` child.
2.  **Delete:** Once the node is found:
    - **Case 1: No children (Leaf).** Simply return `null`.
    - **Case 2: One child.** Return the non-null child (left or right).
    - **Case 3: Two children.**
        - Find the **Inorder Successor** (smallest node in the right subtree).
        - Copy the successor's value to the current node.
        - Recursively delete the successor node from the right subtree.
3.  **Return:** Update and return the modified `root`.

---

## 2. Approach: Successor Replacement
## *2. Hướng tiếp cận: Thay thế bằng Nút kế sau*

### Logic
### *Logic*
(See above). Replacing with the inorder successor (or predecessor) is the standard way to handle nodes with two children because the successor is guaranteed to have at most one child (the right one), making its deletion easy.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Maintains Balance:** Minimal re-linking of nodes.
    *Duy trì sự cân bằng: Tối thiểu hóa việc liên kết lại các nút.*
*   **O(H) Efficiency:** Complexity is proportional to the height of the tree.
    *Hiệu quả O(H): Độ phức tạp tỷ lệ thuận với chiều cao của cây.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$, where $H$ is the height of the tree. In the worst case $O(n)$, in balanced case $O(\log n)$.
    *Độ phức tạp thời gian: $O(H)$.*
*   **Space Complexity:** $O(H)$ for the recursion stack.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Delete `3` from `5 [3 [2, 4], 6]`
1. Find node 3. It has two children (2 and 4).
2. Find successor of 3. In the right subtree `[4]`, the smallest is 4.
3. Replace value 3 with 4. Tree becomes `5 [4 [2, 4], 6]`.
4. Delete target 4 from the right subtree of node 4.
   - Node 4 in the subtree `[4]` is a leaf. Delete it.
Result: `5 [4 [2], 6]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive search with successor replacement for the 2-child case.
*Tìm kiếm đệ quy kết hợp thay thế bằng nút kế sau cho trường hợp 2 con.*
---
*Xóa bỏ một nút thắt (node) trong hệ thống không đơn thuần là sự biến mất, mà là một cuộc tái sắp xếp trật tự. Khi một "người đứng đầu" (node with 2 children) rời đi, ta phải tìm một người kế thừa xứng đáng nhất (successor) để duy trì sự ổn định của cả dòng tộc (BST property). Sự tinh tế trong việc chuyển giao giá trị và liên kết lại các mối quan hệ chính là cốt lõi của việc vận hành một cấu trúc bền vững.*
Deleting a node (node) in the system is not simply disappearance, but a reorganization of order. When a "leader" (node with 2 children) leaves, we must find the most worthy heir (successor) to maintain the stability of the entire clan (BST property). Sophistication in transferring values and relinking relationships is the core of operating a sustainable structure.
