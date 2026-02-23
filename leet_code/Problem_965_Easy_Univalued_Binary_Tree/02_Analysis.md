# Analysis for Univalued Binary Tree
# *Phân tích cho bài toán Cây Nhị phân Đơn trị*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Check if all nodes in the tree have the same value.
*Kiểm tra xem tất cả các nút trong cây có cùng giá trị hay không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Simple traversal (DFS or BFS).
- Compare every node's value with the root's value.
- If any node differs, return `false`.
- If traversal completes, return `true`.
*Duyệt cây đơn giản. So sánh giá trị của mỗi nút với giá trị gốc.*

---

## 2. Strategy: Recursive DFS
## *2. Chiến lược: DFS Đệ quy*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Check Null:** If `root` is null, valid (trivial).
    *   **Kiểm tra Null:** Nếu null -> true.*

2.  **Check Children:**
    - If `root.left` exists and `root.left.val != root.val`: return `false`.
    - If `root.right` exists and `root.right.val != root.val`: return `false`.
    *   **Kiểm tra Con:** Nếu con có giá trị khác -> false.*

3.  **Recurse:** Return `isUnivalTree(root.left)` AND `isUnivalTree(root.right)`.
    *   **Đệ quy:** Kiểm tra tiếp cây con.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Basic recursion handles this perfectly.
*Đệ quy cơ bản xử lý tốt vấn đề này.*
