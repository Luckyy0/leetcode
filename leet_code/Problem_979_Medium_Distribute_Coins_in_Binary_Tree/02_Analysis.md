# Analysis for Distribute Coins in Binary Tree
# *Phân tích cho bài toán Phân phối Tiền xu trong Cây Nhị phân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Balance coins so each node has 1. Minimize moves.
*Cân bằng đồng xu sao cho mỗi nút có 1. Tối thiểu hóa số lần di chuyển.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Total coins = Total nodes.
- For any subtree, if it has `C` coins and `N` nodes, it has a "balance" of `C - N`.
  - If `C - N > 0`, it must push `C - N` coins up to its parent.
  - If `C - N < 0`, it must pull `|C - N|` coins down from its parent.
- The number of moves through the edge connecting this subtree to its parent is exactly `|C - N|`.
- Summing `|C - N|` for all subtrees gives the total moves.
- Use Post-order DFS. Each node returns its "excess" (`val + left_excess + right_excess - 1`).
- `Moves += abs(left_excess) + abs(right_excess)`.
*Với mỗi cây con, số lượng xu thừa hoặc thiếu chính là số lần di chuyển cần thực hiện qua cạnh nối với cha. Tổng hợp các giá trị tuyệt đối này lại.*

---

## 2. Strategy: Post-order DFS
## *2. Chiến lược: DFS Hậu thứ tự*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Global:** `moves = 0`.
    *   **Biến toàn cục:** `moves`.*

2.  **DFS(node):** Returns int (balance/excess).
    - Base: `node == null` -> return 0.
    - `left = dfs(node.left)`.
    - `right = dfs(node.right)`.
    - `moves += abs(left) + abs(right)`.
    - Return `node.val + left + right - 1`. (-1 because node needs 1 for itself).
    *   **DFS:** Tính số dư và cộng dồn số bước di chuyển.*

3.  **Return:** `moves`.
    *   **Trả về:** `moves`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    
    // Returns the excess coins of the subtree rooted at node
    // Positive: Surplus coins to push up
    // Negative: Deficit coins to pull down
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int leftExcess = dfs(node.left);
        int rightExcess = dfs(node.right);
        
        // The number of moves through the edges to children is simply the absolute excess flow
        moves += Math.abs(leftExcess) + Math.abs(rightExcess);
        
        // Current node's excess to return to parent
        // It has 'val' coins, receives 'left' and 'right', and needs 1 for itself.
        return node.val + leftExcess + rightExcess - 1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit each node once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$. Recursive stack.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple and elegant post-order traversal calculating flow through edges.
*Duyệt hậu thứ tự đơn giản và thanh lịch tính toán luồng qua các cạnh.*
