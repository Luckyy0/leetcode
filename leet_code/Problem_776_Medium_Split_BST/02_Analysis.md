# Analysis for Split BST
# *Phân tích cho bài toán Chia Cây Tìm kiếm Nhị phân*

## 1. Problem Essence & Recursive Split
## *1. Bản chất vấn đề & Chia Đệ quy*

### The Challenge
### *Thách thức*
We need to cut the BST edges such that we get two valid BSTs.
If `root.val <= target`: Root belongs to the "Small" tree. Its left child is certainly $\le$ target. Its right child *might* have nodes $> target$, so we split the right child.
If `root.val > target`: Root belongs to the "Large" tree. Its right child is certainly $> target$. Its left child *might* have nodes $\le target$, so we split the left child.
*Chúng ta cần cắt các cạnh của BST sao cho thu được hai BST hợp lệ. Nếu giá trị gốc $\le$ đích, gốc thuộc về cây "Nhỏ". Nếu giá trị gốc $>$ đích, gốc thuộc về cây "Lớn".*

---

## 2. Strategy: Recursion
## *2. Chiến lược: Đệ quy*

### Algorithm
### *Thuật toán*

1.  **Function:** `splitBST(root, target)` returns `TreeNode[]{small, large}`.
    *   **Hàm:** `splitBST` trả về mảng chứa gốc cây Nhỏ và cây Lớn.*

2.  **Base Case:** If `root` is null, returns `{null, null}`.
    *   **Trường hợp cơ sở:** Nếu `root` là null, trả về `{null, null}`.*

3.  **Recursive Step:**
    - If `root.val <= target`:
        - Root is part of `small`.
        - Recursively split `root.right`: `res = splitBST(root.right, target)`.
        - `res[0]` is the smaller part of right subtree (still $\le$ target). `res[1]` is the larger part.
        - Attach `res[0]` to `root.right`. `res[1]` becomes the root of the disjoint "larger" tree that broke off.
        - Return `{root, res[1]}`.
    - If `root.val > target`:
        - Root is part of `large`.
        - Recursively split `root.left`: `res = splitBST(root.left, target)`.
        - `res[1]` (larger part of left subtree, $> target$) is attached to `root.left`. `res[0]` is the root of the "smaller" tree.
        - Return `{res[0], root}`.
    *   **Bước Đệ quy:** Nếu gốc $\le$ đích: gốc thuộc cây Nhỏ, chia cây con phải. Nếu gốc $>$ đích: gốc thuộc cây Lớn, chia cây con trái. Cập nhật con trỏ tương ứng và trả về kết quả.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public TreeNode[] splitBST(TreeNode root, int target) {
    if (root == null) return new TreeNode[]{null, null};
    
    if (root.val <= target) {
        // Root stays in "Small". Right child might have elements > target.
        TreeNode[] res = splitBST(root.right, target);
        // Connect the "small" part of the split to root's right
        root.right = res[0];
        // Return {Root (Small head), Large head}
        return new TreeNode[]{root, res[1]};
    } else {
        // Root stays in "Large". Left child might have elements <= target.
        TreeNode[] res = splitBST(root.left, target);
        // Connect the "large" part of split to root's left
        root.left = res[1];
        // Return {Small head, Root (Large head)}
        return new TreeNode[]{res[0], root};
    }
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$ where $H$ is tree height. We traverse a single path down. In worst case (skewed), $O(N)$.
    *   **Độ phức tạp thời gian:** $O(H)$.*
*   **Space Complexity:** $O(H)$ for recursion stack.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Tree:** 4 (L:2, R:6). Target 2.
1. `split(4)`: 4 > 2. Recurse `split(4.left=2)`.
2. `split(2)`: 2 <= 2. Recurse `split(2.right=1? No left=1 right=3 in example)`. Example used `root=[4,2,6,1,3,5,7]`. Subtree 2 has left 1, right 3.
   - Recurse `split(3)`.
3. `split(3)`: 3 > 2. Recurse `split(3.left=null)`.
   - Returns `{null, null}`.
   - `3.left` becomes `null` (large part of null split).
   - Return `{small=null, large=3}`.
4. Back to `split(2)`:
   - Recv `{null, 3}`.
   - `2.right` becomes `null` (small part).
   - Return `{2, 3}`. (Note: 2 still has left child 1).
5. Back to `split(4)`:
   - Recv `{2, 3}`.
   - `4.left` becomes `3` (large part of split).
   - Return `{2, 4}`.
**Result:** Small Root: 2 (Left 1, Right null). Large Root: 4 (Left 3, Right 6...). Correct.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple recursion along the search path handles the connections correctly.
*Đệ quy đơn giản dọc theo đường dẫn tìm kiếm xử lý các kết nối một cách chính xác.*
