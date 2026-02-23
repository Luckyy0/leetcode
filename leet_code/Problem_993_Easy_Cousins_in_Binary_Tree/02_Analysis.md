# Analysis for Cousins in Binary Tree
# *Phân tích cho bài toán Anh em họ trong Cây nhị phân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Verify if two nodes in a binary tree have the *same depth* but *different parents*.
*Xác minh xem hai nút trong cây nhị phân có *cùng độ sâu* nhưng khác *cha mẹ* hay không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Since node values are unique, we just need to search for the values `x` and `y` in the tree.
- A standard traversal (DFS or BFS) is perfect.
- During traversal, we need to track:
  1. The depth of the current node.
  2. The parent of the current node.
- When we find a node whose value matches `x` or `y`, we record its depth and parent.
- After the traversal, we simply check the two conditions: `depthX == depthY` and `parentX != parentY`.
*Duyệt cây DFS (hoặc BFS). Lưu lại độ sâu và nút cha của x và y khi tìm thấy. Cuối cùng đem so sánh.*

---

## 2. Strategy: Depth-First Search (DFS)
## *2. Chiến lược: Tìm kiếm theo Chiều sâu (DFS)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Global Variables:** `xDepth`, `yDepth`, `xParent`, `yParent`. Initialize them to identify the nodes.
    *   **Biến toàn cục:** Lưu độ sâu và nút cha của x và y.*

2.  **DFS Function:** `dfs(TreeNode node, TreeNode parent, int depth, int x, int y)`
    - Base case: `if (node == null) return;`
    - Check current node:
      - If `node.val == x`: `xDepth = depth`, `xParent = parent`.
      - If `node.val == y`: `yDepth = depth`, `yParent = parent`.
    - Recurse: `dfs(node.left, node, depth + 1, x, y)`.
    - Recurse: `dfs(node.right, node, depth + 1, x, y)`.
    *   **Hàm DFS:** Duyệt và cập nhật biến toàn cục khi tìm thấy x hoặc y.*

3.  **Result Evaluation:** Compare the recorded values. `return (xDepth == yDepth) && (xParent != yParent)`.
    *   **Đánh giá Kết quả:** Trả về kết quả đối chiếu.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    int xDepth = -1;
    int yDepth = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return (xDepth == yDepth) && (xParent != yParent);
    }
    
    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) {
            return;
        }
        
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        
        dfs(node.left, node, depth + 1, x, y);
        dfs(node.right, node, depth + 1, x, y);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of nodes in the tree. We visit each node exactly once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$ where $H$ is the height of the tree, representing the recursion stack depth. In the worst case (skewed tree), $O(N)$.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

DFS is a lightweight and clean approach for tree queries involving parents and depths.
*DFS là một cách tiếp cận gọn nhẹ và sạch sẽ cho các truy vấn cây liên quan đến cha mẹ và độ sâu.*
