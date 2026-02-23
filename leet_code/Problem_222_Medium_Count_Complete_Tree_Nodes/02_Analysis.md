# Analysis for Count Complete Tree Nodes
# *Phân tích cho bài toán Đếm số nút của cây hoàn chỉnh*

## 1. Problem Essence & "Complete" Property
## *1. Bản chất vấn đề & Tính chất "Hoàn chỉnh"*

### The Naive Way
### *Cách ngây thơ*
Traverse every node ($O(N)$). This is trivial but ignored the "Complete" property and the requirement "less than $O(N)$".
*Duyệt mọi nút ($O(N)$). Tầm thường và không đạt yêu cầu.*

### The Property
### *Tính chất*
In a Complete Binary Tree:
- If `LeftHeight == RightHeight`: The Left Subtree is a **Full Binary Tree**.
    - We know exactly how many nodes it has: $2^{LH} - 1$.
    - Add root: Total $2^{LH}$.
    - Plus whatever is in the Right Subtree (Recurse right).
- If `LeftHeight > RightHeight`: The Right Subtree is a **Full Binary Tree** (one level shallower).
    - We know exactly how many nodes it has: $2^{RH} - 1$.
    - Add root: Total $2^{RH}$.
    - Plus whatever is in the Left Subtree (Recurse left).
*Nếu chiều cao trái bằng chiều cao phải: Cây con trái đầy đủ. Nếu chiều cao trái lớn hơn chiều cao phải: Cây con phải đầy đủ.*

---

## 2. Approach: Binary Search on Tree Structure
## *2. Hướng tiếp cận: Tìm kiếm nhị phân trên cấu trúc cây*

### Algorithm
### *Thuật toán*
1.  Compute `leftDepth(root)` and `rightDepth(root)`.
2.  Actually, we check `leftDepth(root.left)` vs `leftDepth(root.right)`?
    - Wait, efficient way is comparing depths of subtrees.
    - Let `H` be the depth of the whole tree (go all the way left).
    - Now check the right subtree's depth.
    - If `depth(root.right) == H - 1`: It means the left subtree is full.
        - `Nodes = (1 << (H-1)) + countNodes(root.right)`.
    - If `depth(root.right) < H - 1`: It means the right subtree is full (but one level less), and the "missing" nodes are on the left side.
        - `Nodes = (1 << (H-2)) + countNodes(root.left)`.

### Height Function
### *Hàm chiều cao*
Since it's a complete tree, calculating height is just going left until null. $O(H)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursion Skipping:** At every step, we discard half of the tree because we calculate its size using a formula ($2^h - 1$). We only recurse into the other half.
*   **Complexity:** We do $O(H)$ work (height check) at each of the $O(H)$ recursion levels. Total $O(H^2) = O(\log^2 N)$.
    *Bỏ qua đệ quy: Tại mỗi bước, ta tính toán kích thước một nửa cây bằng công thức và chỉ đệ quy vào nửa còn lại. Độ phức tạp $O(\log^2 N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log^2 N)$. Since $N \le 50000$, $\log N \approx 16$, so $16^2 = 256$ operations. Very fast.
    *Độ phức tạp thời gian: $O(\log^2 N)$. Rất nhanh.*
*   **Space Complexity:** $O(\log N)$ (Recursion stack).
    *Độ phức tạp không gian: $O(\log N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Height = 3 (Nodes 1..6).
        1
      /   \
     2     3
    / \   /
   4   5 6

1.  `countNodes(1)`. Find height of left spine: 3.
2.  Find height of right child (3)'s left spine:
    - Go `r -> 3 -> 6`. Height is 2.
    - `2 == 3 - 1`. The Left Subtree (rooted at 2) is FULL.
    - Nodes from left = $2^2 - 1 = 3$. Plus root = 4.
    - Total = `4 + countNodes(3)`.
3.  `countNodes(3)`. Height of (3) is 2.
    - Find height of right child (null)'s left spine. Height 0.
    - `0 != 2 - 1` (0 != 1). The Right Subtree is FULL (level 0).
    - Nodes from right = $2^0 - 1 = 0$. Plus root = 1.
    - Total = `1 + countNodes(6)`.
    - Wait, logic check: If right height < H-1, it means right side has height H-2. The "break" is on the left side.
    - `depth(3.right)` is 0. `H-1` is 1. Since `0 < 1`:
        - Right subtree forms full tree of height 1 (leaf 6? No wait).
    - Let's stick to the code logic:
        - `ld = depth(root.left)`
        - `rd = depth(root.right)`
        - If `ld == rd`: Left is full. Recurse Right.
        - If `ld > rd`: Right is full. Recurse Left.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This problem is a specific optimization on binary trees. The $O(\log^2 N)$ solutions stems from the fact that calculating height is $O(\log N)$ and we do it $\log N$ times.
*Bài toán này là sự tối ưu hóa cụ thể trên cây nhị phân. Giải pháp $O(\log^2 N)$ xuất phát từ việc tính chiều cao tốn $O(\log N)$ và ta thực hiện nó $\log N$ lần.*
---
*Đôi khi biết một nửa sự thật là đủ để suy ra toàn bộ bức tranh, nếu bức tranh đó "hoàn chỉnh".*
Sometimes knowing half the truth is enough to deduce the whole picture, provided the picture is "complete".
