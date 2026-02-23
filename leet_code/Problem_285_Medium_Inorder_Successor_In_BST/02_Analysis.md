# Analysis for Inorder Successor in BST
# *Phân tích cho bài toán Người kế vị Inorder trong BST*

## 1. Problem Essence & BST Properties
## *1. Bản chất vấn đề & Tính chất BST*

### The Definition
### *Định nghĩa*
Successor of `p` is the smallest node `S` such that `S.val > p.val`.

### Strategy: Binary Search
### *Chiến lược: Tìm kiếm nhị phân*
Start at `root`.
1.  **If `p.val >= root.val`:**
    - The successor must be in the right subtree (since `root` and `left` are $\le p.val$).
    - Move `root` to `root.right`.
2.  **If `p.val < root.val`:**
    - `root` is larger than `p`. So `root` is a *potential* successor.
    - But there might be a smaller successor in the left subtree.
    - Save `root` as `successor`, move `root` to `root.left` to look for smaller ones.

### Logic Refined
### *Logic tinh chỉnh*
- `succ = null`.
- Loop while `root != null`:
    - `if p.val >= root.val`: `root = root.right`
    - `else`: `succ = root`, `root = root.left`
- Return `succ`.

This handles all cases, including when `p` is in the tree or not (though problem says `p` is in tree).

---

## 2. Approach: Iterative BST Traversal
## *2. Hướng tiếp cận: Duyệt BST Lặp*

### Logic
### *Logic*
1.  `successor = null`.
2.  While `root` not null:
    - If `root.val <= p.val`: Discard root and left. Go Right.
    - If `root.val > p.val`: Root is valid candidate. Go Left to see if better exists.
        - `successor = root`.
        - `root = root.left`.
3.  Return `successor`.

### Complexity
### *Độ phức tạp*
$O(H)$ where H is height. In balanced tree $O(\log N)$. Worst case $O(N)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Directed Search:** No needed to backtrack or use parent pointers. The path from root dictates the bounds.
    *Tìm kiếm có hướng: Không cần quay lui hay dùng con trỏ cha. Đường đi từ gốc quy định các giới hạn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$.
    *Độ phức tạp thời gian: $O(H)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Root 5. p=3.
1.  Start 5. `5 > 3`. `succ = 5`. Go Left (3).
2.  Curr 3. `3 <= 3`. Go Right (4).
3.  Curr 4. `4 > 3`. `succ = 4`. Go Left (Null).
4.  Stop. Return 4.

**Input:** Root 2. p=1.
1.  Start 2. `2 > 1`. `succ = 2`. Go Left (1).
2.  Curr 1. `1 <= 1`. Go Right (Null).
3.  Stop. Return 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simple iterative approach is best.
*Cách tiếp cận lặp đơn giản là tốt nhất.*
---
*Người kế vị luôn đứng ngay sau bạn ở phía bên phải (right subtree) hoặc là bậc bề trên gần nhất đã rẽ trái (first ancestor turned left). Vị trí quyết định định mệnh.*
The successor always stands right behind you in the right subtree, or is the nearest ancestor who turned left. Position determines destiny.
