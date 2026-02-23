# Analysis for Lowest Common Ancestor of a Binary Tree
# *Phân tích cho bài toán Tổ tiên chung thấp nhất của Cây nhị phân*

## 1. Problem Essence & Generic Tree Traversal
## *1. Bản chất vấn đề & Duyệt cây tổng quát*

### The Challenge
### *Thách thức*
Unlike BST, we have no numerical property to guide us. We must search the entire tree.
LCA is the node X such that `p` is in X's left subtree (or X is p) and `q` is in X's right subtree (or X is q).
*Không như BST, không có tính chất số học. Phải duyệt toàn bộ.*

### The Condition
### *Điều kiện*
For a node `curr`, if:
1.  Recursion on Left returns **Found** (p or q).
2.  Recursion on Right returns **Found** (p or q).
Then `curr` is the LCA.
If `curr` itself is `p` or `q`, then `curr` is potential LCA (or the other node is a child).

---

## 2. Approach: Depth First Search (Post-order)
## *2. Hướng tiếp cận: Tìm kiếm theo chiều sâu (Hậu thứ tự)*

### Algorithm
### *Thuật toán*
function `LCA(root, p, q)`:
1.  **Base Case:** If `root == null` OR `root == p` OR `root == q`: return `root`.
2.  **Recursive Step:**
    - `left = LCA(root.left, p, q)`
    - `right = LCA(root.right, p, q)`
3.  **Process:**
    - If `left != null` AND `right != null`: It means one node is in left and one is in right. Current node `root` is the split point. **Return `root`**.
    - If `left != null`: Return `left` (Propagate the found node upwards).
    - If `right != null`: Return `right` (Propagate the found node upwards).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bottom-Up Propagation:** The recursion bubbles up the found nodes. The first node to receive signals from *both* sides declares itself the LCA.
    *Lan truyền từ dưới lên: Đệ quy nổi các nút tìm thấy lên. Nút đầu tiên nhận tín hiệu từ *cả hai* phía sẽ tự tuyên bố là LCA.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ because we visit every node in the worst case.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ for recursion stack.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Tree `3 -> (5, 1)`. Find `(5, 1)`.
1.  Call `LCA(3)`.
    - Call `LCA(5)`. Since `5 == p`, return 5.
    - Call `LCA(1)`. Since `1 == q`, return 1.
    - `left=5`, `right=1`. Both not null. Return 3.

**Input:** Tree `3 -> (5 -> (6, 2 -> (7, 4)), 1)`. Find `(5, 4)`.
1.  Call `LCA(3)`.
    - Call `LCA(5)`. Since `5 == p`, return 5. (**Crucial**: Does not search below 5 for 4. If 4 is below 5, 5 is the LCA. This logic works because we assume p and q exist).
    - Call `LCA(1)`. Returns null.
    - `left=5`, `right=null`. Return 5.

Wait, if 4 is below 5, we returned 5 immediately without confirming 4 is below. But since problem guarantees p and q exist, if we found 5 and couldn't find 4 in the other branch (right subtree of 3), then 4 MUST be under 5. Efficient!
*Điều quan trọng: Nếu gặp `p` hoặc `q`, trả về ngay lập tức. Nếu nút kia nằm dưới, logic vẫn đúng do giả định tồn tại.*

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic "Divide and Conquer" on trees. The logic "If I found something on left AND right, I am the boss" is intuitive.
*Đây là "Chia để trị" kinh điển. Logic "Nếu tìm thấy ở cả trái và phải, tôi là sếp" rất trực quan.*
---
*Cha mẹ là nơi con cái gặp gỡ. Nguồn gốc là nơi mọi nhánh sông đổ về.*
Parents are where children meet. The origin is where all branches return.
