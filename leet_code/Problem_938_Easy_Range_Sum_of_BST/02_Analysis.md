# Analysis for Range Sum of BST
# *Phân tích cho bài toán Tổng Phạm vi của Cây Nhị phân Tìm kiếm*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Sum all node values in a BST that fall within `[low, high]`.
*Tính tổng tất cả các giá trị nút trong BST nằm trong khoảng `[low, high]`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Standard recursive traversal (DFS).
- Use BST property to prune unnecessary branches.
- If `node.val < low`, all nodes in left subtree are also `< low`. So only go right.
- If `node.val > high`, all nodes in right subtree are also `> high`. So only go left.
- If `low <= node.val <= high`, add `node.val` and traverse both children.
*Duyệt đệ quy tiêu chuẩn (DFS). Tận dụng tính chất BST để cắt tỉa nhánh. Nếu `node.val < low`, chỉ đi phải. Nếu `node.val > high`, chỉ đi trái. Nếu trong khoảng, cộng giá trị và đi cả hai.*

---

## 2. Strategy: Recursive DFS with Pruning
## *2. Chiến lược: DFS Đệ quy với Cắt tỉa*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Base Case:** If `root == null`, return 0.
    *   **Trường hợp cơ sở:** Nếu `root == null`, trả về 0.*

2.  **Recursive Step:**
    - If `root.val < low`: Return `rangeSumBST(root.right, low, high)`.
    - If `root.val > high`: Return `rangeSumBST(root.left, low, high)`.
    - Else: Return `root.val + rangeSumBST(root.left) + rangeSumBST(root.right)`.
    *   **Bước đệ quy:** Kiểm tra điều kiện và gọi đệ quy.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) return 0;
    
    if (root.val < low) {
        return rangeSumBST(root.right, low, high);
    }
    
    if (root.val > high) {
        return rangeSumBST(root.left, low, high);
    }
    
    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ worst case (visit all nodes). Pruning helps on average.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$ for recursion stack.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple recursion exploiting BST properties is efficient and clean.
*Đệ quy đơn giản tận dụng tính chất BST là hiệu quả và gọn gàng.*
