# Analysis for Binary Tree Pruning
# *Phân tích cho bài toán Cắt tỉa cây nhị phân*

## 1. Problem Essence & Recursive Definition
## *1. Bản chất vấn đề & Định nghĩa đệ quy*

### The Challenge
### *Thách thức*
The goal is to remove subtrees that do not contain any node with a value of `1`. This means a node should be removed if:
1.  Its value is `0`.
2.  Its left subtree contains no `1`s (and thus is pruned/null).
3.  Its right subtree contains no `1`s (and thus is pruned/null).
This hierarchical dependency naturally suggests a bottom-up recursive approach.
*Mục tiêu là loại bỏ các cây con không chứa bất kỳ nút nào có giá trị `1`. Điều này có nghĩa là một nút nên được loại bỏ nếu: Giá trị của nó là `0`, cây con bên trái không chứa số `1` (đã bị cắt tỉa), và cây con bên phải cũng không chứa số `1`. Sự phụ thuộc phân cấp này tự nhiên gợi ý một cách tiếp cận đệ quy từ dưới lên.*

---

## 2. Strategy: Post-order Traversal
## *2. Chiến lược: Duyệt hậu thứ tự (Post-order Traversal)*

### Recursive Logic
### *Logic đệ quy*
We process children before parents. By the time we decide whether to prune the current node, its left and right children have already been processed and potentially pruned.
*Chúng ta xử lý các nút con trước nút cha. Đến khi quyết định có cắt tỉa nút hiện tại hay không, các nút con bên trái và bên phải của nó đã được xử lý và có khả năng đã bị cắt tỉa.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Base Case:** If the current node is `null`, return `null`.
    *   **Trường hợp cơ bản:** Nếu nút hiện tại là `null`, trả về `null`.*

2.  **Recursive Step:**
    - Recurse on the left child: `node.left = pruneTree(node.left)`.
    - Recurse on the right child: `node.right = pruneTree(node.right)`.
    *   **Bước đệ quy:** Thực hiện đệ quy trên nút con bên trái và nút con bên phải.*

3.  **Pruning Decision:**
    - After recursion, if `node.left` is `null`, `node.right` is `null`, and `node.val` is `0`:
      - This node is now a leaf with value `0`, and it's part of a subtree with no `1`s.
      - Return `null` to tell the parent to prune this node.
    - Otherwise, return the `node` itself.
    *   **Quyết định cắt tỉa:** Sau khi đệ quy, nếu cả hai nút con đều `null` và giá trị nút hiện tại là `0`, thì đây là lá có giá trị `0`. Trả về `null` để nút cha cắt tỉa nút này. Ngược lại, trả về chính nút đó.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public TreeNode pruneTree(TreeNode root) {
    if (root == null) return null;
    
    // Bottom-up: process children first
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    
    // If the node is a leaf and its value is 0, prune it
    if (root.left == null && root.right == null && root.val == 0) {
        return null;
    }
    
    return root;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes in the binary tree. We visit each node exactly once.
    *   **Độ phức tạp thời gian:** $O(N)$, với $N$ là số lượng nút trong cây. Mỗi nút được thăm đúng một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree. This is the space used by the recursion stack. In the worst case (a skewed tree), $H = N$.
    *   **Độ phức tạp không gian:** $O(H)$, với $H$ là chiều cao của cây. Đây là không gian được sử dụng bởi ngăn xếp đệ quy.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `root = [1, null, 0, 0, 1]`
1. Visit `1` (root). Go Right to `0`.
2. Visit `0`. Go Left to `0`.
3. Visit `0` (leaf). `val=0`. Returns `null` to parent.
4. Back at `0`. Left is now `null`. Go Right to `1`.
5. Visit `1` (leaf). Returns `1` to parent.
6. Back at `0`. Left is `null`, Right is `1`. Not a candidate for pruning. Returns `0` to parent.
7. Back at `1` (root). Left is `null`, Right is `0`. Returns `1`.
**Result:** `[1, null, 0, null, 1]`

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Post-order recursion is the most natural and efficient way to prune trees because it ensures that leaf-level pruning decisions propagate upward correctly.
*Đệ quy hậu thứ tự là cách tự nhiên và hiệu quả nhất để cắt tỉa cây vì nó đảm bảo các quyết định cắt tỉa ở cấp lá được truyền lên phía trên một cách chính xác.*
