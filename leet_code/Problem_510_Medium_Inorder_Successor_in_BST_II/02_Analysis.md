# Analysis for Inorder Successor in BST II
# *Phân tích cho bài toán Kế vị trong cây BST II*

## 1. Problem Essence & Parent Pointer Navigation
## *1. Bản chất vấn đề & Điều hướng qua Con trỏ Cha*

### The Challenge
### *Thách thức*
Finding the next larger node using parent pointers without traversing from root.
- Case 1: Node has a **Right Child**. Successor is the **leftmost** node in the right subtree.
- Case 2: Node has **No Right Child**. Successor is the nearest ancestor for which the node is in the **left subtree**.
    - Translation: Go UP until we come from the left.

### Strategy: Two Cases
### *Chiến lược: Hai trường hợp*

1.  **If `node.right != null`:**
    - Go `node.right`.
    - Loop `curr = curr.left` until `curr.left` is null.
    - Return `curr`.
2.  **If `node.right == null`:**
    - `curr = node`.
    - `parent = curr.parent`.
    - While `parent != null` and `curr == parent.right` (we differ from normal BST search where we check val, here we check structure. If we are right child of parent, parent is smaller than us, go up. If we are left child, parent is larger -> parent is successor).
    - Return `parent`.

---

## 2. Approach: Structural Traversal
## *2. Hướng tiếp cận: Duyệt Cấu trúc*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(H) Time:** Proportional to height. No full tree scan.
    *Thời gian O(H): Tỷ lệ với chiều cao. Không quét toàn bộ cây.*
*   **No Root Needed:** Local navigation.
    *Không cần Gốc: Điều hướng cục bộ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$.
    *Độ phức tạp thời gian: $O(H)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Node `1` (Left child of `2`). Right null.
1. `node.right` is null.
2. `parent` is `2`.
3. `curr(1) == parent.right(2.right)`? No, `1` is left child.
4. Loop ends. Return `2`.

**Input:** Node `2` (Root). Right `3`.
1. `node.right` is `3`.
2. Go to `3`. Left is null.
3. Return `3`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Check right subtree or climb up parents.
*Kiểm tra cây con phải hoặc leo lên các nút cha.*
---
*Để tìm người kế vị (successor), nếu bạn có nền tảng (right child), hãy tìm kiếm sâu bên trong đó. Nếu bạn đã đứng trên đỉnh của nhánh hiện tại (no right child), hãy nhìn lên (look up) những bậc tiền bối (parents). Người dẫn lối tiếp theo thường là người đã bao bọc bạn từ phía bên trái (ancestor where node is in left).*
To find a successor (Successor), if you have a foundation (Right Child), search deep within it. If you have stood on top of the current branch (No right child), look up (Look Up) the ancestors (parents). The next guide is usually the person who covered you from the left (Ancestor Where Node Is In Left).
