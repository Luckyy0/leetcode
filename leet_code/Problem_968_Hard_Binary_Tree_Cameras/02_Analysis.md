# Analysis for Binary Tree Cameras
# *Phân tích cho bài toán Camera Cây Nhị phân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Minimize cameras to cover all nodes. A camera covers `parent`, `self`, `children`.
*Tối thiểu hóa số camera để phủ toàn bộ cây. Một camera phủ cha, chính nó, và con.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Local Greedy Strategy on Tree (Post-order Traversal).
- Always try to cover a node from its parent if possible (because placing a camera at a parent covers the parent, the node, and the parent's parent - potentially 3 nodes, whereas placing at a leaf only covers 2).
- Process from bottom up (leaves to root).
- Define States for a node:
  - **State 0 (Not Covered):** The node has no camera and is not covered by any child. It MUST be covered by its parent.
  - **State 1 (Has Camera):** The node has a camera.
  - **State 2 (Covered):** The node is covered (by a child), but has no camera itself.
- Transitions (Post-order):
  - Check left and right children states.
  - If any child is **State 0 (Not Covered)**: Current node MUST obtain a camera to cover the child. -> **State 1**, `cameras++`.
  - Else if any child is **State 1 (Has Camera)**: Current node is covered by that child. -> **State 2**.
  - Else (both children are State 2 - Covered): Current node is not covered yet. It should ideally be covered by its parent. -> **State 0**.
- Root Handling: If root ends up in **State 0 (not covered)**, it has no parent to cover it. We must add one more camera.
*Chiến lược tham lam cục bộ từ dưới lên (Post-order). Định nghĩa 3 trạng thái: Chưa được phủ (cần cha phủ), Có Camera, Đã được phủ (bởi con).*

---

## 2. Strategy: Greedy DFS
## *2. Chiến lược: DFS Tham lam*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Global Counter:** `cameras = 0`.
    *   **Biến đếm:** `cameras`.*

2.  **DFS Function:** Returns state (0, 1, 2).
    - Base Case (Null node): Treated as **State 2 (Covered)**. Because null nodes do not need cameras and do not demand coverage.
    - Recursive Step: `left = dfs(node.left)`, `right = dfs(node.right)`.
    - Logic:
      - If `left == 0 || right == 0`: Children need help. `cameras++`. Return **1**.
      - If `left == 1 || right == 1`: One child has camera. I am covered. Return **2**.
      - Else (both 2): Children OK but don't help me. I need help. Return **0**.
    *   **Hàm DFS:** Trả về trạng thái. Xử lý logic tham lam.*

3.  **Main Call:**
    - Call `dfs(root)`.
    - If result is **0** (root needs coverage), `cameras++`.
    *   **Gọi chính:** Xử lý trường hợp gốc chưa được phủ.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    int cameras = 0;
    
    // 0: Not Covered (Needs Camera from Parent)
    // 1: Has Camera
    // 2: Covered (No Camera)
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 2; // Null is considered covered
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if (left == 0 || right == 0) {
            // Children need coverage, must place camera here
            cameras++;
            return 1;
        }
        
        if (left == 1 || right == 1) {
            // At least one child has camera, so I am covered
            return 2;
        }
        
        // Children are covered but don't have cameras to cover me
        // I am not covered
        return 0;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit every node once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(H)$. Stack depth.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This greedy approach ensures optimality by deferring camera placement as high as possible.
*Cách tiếp cận tham lam này đảm bảo tính tối ưu bằng cách trì hoãn việc đặt camera càng cao càng tốt.*
