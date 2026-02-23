# Analysis for Smallest Subtree with all the Deepest Nodes
# *Phân tích cho bài toán Cây con Nhỏ nhất chứa Tất cả các Nút Sâu nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to find a node that is a common ancestor to all nodes at the maximum depth, and we want this ancestor to be as deep as possible (the "smallest" such subtree).
*Chúng ta cần tìm một nút là tổ tiên chung của tất cả các nút ở độ sâu tối đa, và chúng ta muốn tổ tiên này nằm càng sâu càng tốt (cây con "nhỏ nhất" như vậy).*

---

## 2. Strategy: Recursive Depth Calculation
## *2. Chiến lược: Tính toán Độ sâu đệ quy*

### Key Logic
### *Logic chính*
For any node:
- If `depth(left) == depth(right)`: It means the deepest nodes are present in both subtrees. Therefore, this node is the lowest common ancestor for all deepest nodes in its subtree.
- If `depth(left) > depth(right)`: All deepest nodes must be in the left subtree.
- If `depth(right) > depth(left)`: All deepest nodes must be in the right subtree.
*Đối với bất kỳ nút nào: Nếu độ sâu bên trái bằng độ sâu bên phải, điều đó có nghĩa là các nút sâu nhất hiện diện trong cả hai cây con. Do đó, nút này là tổ tiên chung thấp nhất cho tất cả các nút sâu nhất trong cây con của nó. Nếu độ sâu bên trái lớn hơn, tất cả các nút sâu nhất phải ở cây con bên trái, và ngược lại.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define a Recursive Helper:** `dfs(node)` returns a pair: `{depth, subtree_root}`.
    *   **Định nghĩa hàm đệ quy:** `dfs(node)` trả về một cặp: `{độ sâu, gốc_cây_con}`.*

2.  **Base Case:** If node is null, return `{0, null}`.
    *   **Trường hợp cơ sở:** Nếu nút là null, trả về `{0, null}`.*

3.  **Recursive Step:**
    - `L = dfs(node.left)`
    - `R = dfs(node.right)`
    - If `L.depth == R.depth`, return `{L.depth + 1, node}`.
    - If `L.depth > R.depth`, return `{L.depth + 1, L.subtree_root}`.
    - If `R.depth > L.depth`, return `{R.depth + 1, R.subtree_root}`.
    *   **Bước đệ quy:** Tính L và R từ hai phía. Nếu độ sâu bằng nhau, nút hiện tại là gốc cây con cần tìm cho đoạn này. Nếu một bên sâu hơn, hãy chuyển tiếp gốc cây con từ bên đó lên.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class Result {
    int depth;
    TreeNode node;
    Result(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}

public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return dfs(root).node;
}

private Result dfs(TreeNode node) {
    if (node == null) return new Result(0, null);
    Result left = dfs(node.left);
    Result right = dfs(node.right);
    
    if (left.depth == right.depth) {
        return new Result(left.depth + 1, node);
    } else if (left.depth > right.depth) {
        return new Result(left.depth + 1, left.node);
    } else {
        return new Result(right.depth + 1, right.node);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, as we visit each node exactly once.
    *   **Độ phức tạp thời gian:** $O(N)$, vì chúng ta ghé thăm mỗi nút đúng một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree (for the recursion stack).
    *   **Độ phức tạp không gian:** $O(H)$, với $H$ là chiều cao của cây.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This recursive approach is extremely efficient because it determines both the depth and the target candidate in a single post-order traversal.
*Cách tiếp cận đệ quy này cực kỳ hiệu quả vì nó xác định cả độ sâu và ứng viên mục tiêu trong một lần duyệt theo thứ tự sau (post-order).*
