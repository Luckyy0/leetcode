# Analysis for Flip Binary Tree To Match Preorder Traversal
# *Phân tích cho bài toán Lật cây nhị phân để khớp với Duyệt tiền thứ tự*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Match the preorder traversal of a tree to `voyage` by flipping subtrees.
*Khớp duyệt tiền thứ tự của cây với `voyage` bằng cách lật các cây con.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Preorder traversal processes ROOT -> LEFT -> RIGHT.
- If we flip, it becomes ROOT -> RIGHT -> LEFT.
- We traverse the tree and `voyage` simultaneously using an index `i`.
- At any node `curr`:
  - `curr.val` MUST match `voyage[i]`. If not, impossible -> return `[-1]`.
  - Increment `i`.
  - Next, check `curr.left`.
  - If `curr.left` exists and its value DOES NOT match `voyage[i]`:
    - This means the standard traversal order (left first) is wrong.
    - We MUST flip to try matching right child first.
    - Check if `curr.right` exists and `curr.right.val == voyage[i]`.
    - If so, record flip, process `curr.right` then `curr.left`.
    - If not, impossible.
  - If `curr.left` matches or doesn't exist, process normally (left then right).
- Global index `i` is crucial.
*Duyệt đồng thời cây và mảng `voyage`. Nếu giá trị con trái không khớp với giá trị tiếp theo trong `voyage`, thử lật (duyệt phải trước). Nếu vẫn không khớp -> không thể.*

---

## 2. Strategy: DFS with Global Index
## *2. Chiến lược: DFS với Chỉ số Toàn cục*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Global Vars:** `index = 0`, `result` list.
    *   **Biến toàn cục:** `index`, `result`.*

2.  **DFS(node):**
    - Base: if node is null, return true.
    - Check: if `node.val != voyage[index]`, return false.
    - `index++`.
    - Logic:
      - If `node.left` exists and `node.left.val != voyage[index]`:
        - Flip needed! Add `node.val` to result.
        - `return dfs(node.right) && dfs(node.left)`. (Note order swapped).
      - Else:
        - `return dfs(node.left) && dfs(node.right)`.
    *   **DFS:** Kiểm tra giá trị. Nếu con trái lệch pha -> Lật và đổi thứ tự duyệt.*

3.  **Result:** If DFS returns false, return `[-1]`. Else return `result`.
    *   **Kết quả:** Trả về danh sách hoặc [-1].*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    List<Integer> flipped;
    int index;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.flipped = new ArrayList<>();
        this.index = 0;
        this.voyage = voyage;
        
        if (dfs(root)) {
            return flipped;
        } else {
            return Arrays.asList(-1);
        }
    }
    
    private boolean dfs(TreeNode node) {
        if (node == null) return true;
        
        if (node.val != voyage[index++]) {
            return false;
        }
        
        // Critical Logic: Check if left child mismatches next expected value
        if (node.left != null && node.left.val != voyage[index]) {
            // Must flip
            flipped.add(node.val);
            // Process Right then Left
            return dfs(node.right) && dfs(node.left);
        } else {
            // Standard order: Left then Right
            return dfs(node.left) && dfs(node.right);
        }
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit each node once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for recursion stack.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a global index to track progress in `voyage` aligns perfectly with preorder DFS. Flip logic is deterministic.
*Sử dụng chỉ số toàn cục để theo dõi tiến trình trong `voyage` phù hợp hoàn hảo với preorder DFS. Logic lật là xác định chắc chắn.*
