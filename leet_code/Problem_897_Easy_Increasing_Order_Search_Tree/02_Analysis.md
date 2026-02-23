# Analysis for Increasing Order Search Tree
# *Phân tích cho bài toán Cây Tìm kiếm Thứ tự Tăng dần*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Flatten a BST into an increasing linked list (only right children) using in-order traversal.
*Làm phẳng một cây BST thành một danh sách liên kết tăng dần (chỉ có con phải) bằng cách duyệt theo thứ tự giữa (in-order).*

### KEY LOGIC
### *Logic chính*
When traversing in-order (Left -> Root -> Right), we get nodes in sorted order.
- Create a dummy node to act as the head of the new tree.
- Maintain a `current` pointer to the last node added to the new tree.
- During traversal:
  - `current.right = node`.
  - `node.left = null`.
  - `current = node`.
*Khi duyệt theo thứ tự giữa (Trái -> Gốc -> Phải), ta nhận được các nút theo thứ tự đã sắp xếp. Tạo một nút giả làm đầu của cây mới. Duy trì một con trỏ `current` đến nút cuối cùng được thêm vào cây mới. Trong quá trình duyệt: Gán con phải của `current` là nút hiện tại, xóa con trái của nút hiện tại, cập nhật `current`.*

---

## 2. Strategy: In-Order Traversal with Relinking
## *2. Chiến lược: Duyệt In-Order với Liên kết lại*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `dummy` node. `curr = dummy`.
    *   **Khởi tạo:** Nút `dummy`. `curr = dummy`.*

2.  **Define `inorder(node)`:**
    - If `node` is null, return.
    - `inorder(node.left)`.
    - **Process Node:**
        - `node.left = null`. (Unlink left child to avoid cycles/invalid structure).
        - `curr.right = node`.
        - `curr = node`.
    - `inorder(node.right)`.
    *   **Định nghĩa `inorder(node)`:** Nếu `node` null, trả về. Duyệt trái. Xử lý nút: xóa con trái, nối vào `curr.right`, cập nhật `curr`. Duyệt phải.*

3.  **Start traversal:** `inorder(root)`.
    *   **Bắt đầu duyệt:** `inorder(root)`.*

4.  **Return:** `dummy.right`.
    *   **Trả về:** `dummy.right`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class Solution {
    TreeNode curr;
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        
        node.left = null; // Important: disconnect left child
        curr.right = node;
        curr = node;
        
        inorder(node.right);
    }
}
```

Wait, simpler recursive implementation might not work because modifying `node.left = null` inside `inorder` *before* `inorder(node.right)` is fine, but we must be careful not to lose the reference to `node.right` if we modify links. But here, `node.left` is processed *before* `node` is processed, so setting `node.left = null` is safe because `inorder(node.left)` has already returned. However, `inorder(node.right)` needs the original `node.right`. `curr.right = node` modifies the previous node's right child, not `node`'s right child. Ah, but `node` itself will be modified when it becomes `curr`. So we need to store `node.right`? No.
Actually, when we do `inorder(node.right)`, we pass the original right child. The modification happening is `curr.right = node`, which is fine. The issue is `node`'s right child might be overwritten? No, `curr` points to `ans`, then `node1`, then `node2`.
Let's trace:
       2
      / \
     1   3
`inorder(2)` calls `inorder(1)`.
`inorder(1)` calls `inorder(null)`. Returns.
Process 1: `1.left = null`. `curr(dummy).right = 1`. `curr = 1`.
`inorder(1.right)` -> `inorder(null)`. Returns.
Back to `inorder(2)`.
Process 2: `2.left = null`. `curr(1).right = 2`. `curr = 2`.
`inorder(2.right)` -> `inorder(3)`.
Process 3: `3.left = null`. `curr(2).right = 3`. `curr = 3`.

The logic holds.

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$ for recursion stack, where $H$ is height.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a global or class-level `current` pointer simplifies the relinking process during traversal.
*Sử dụng một con trỏ `current` toàn cục hoặc cấp lớp giúp đơn giản hóa quá trình liên kết lại trong khi duyệt.*
