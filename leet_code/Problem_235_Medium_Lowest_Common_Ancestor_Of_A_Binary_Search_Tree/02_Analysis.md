# Analysis for Lowest Common Ancestor of a Binary Search Tree
# *Phân tích cho bài toán Tổ tiên chung thấp nhất của Cây tìm kiếm nhị phân (BST)*

## 1. Problem Essence & BST Property
## *1. Bản chất vấn đề & Tính chất BST*

### The Split
### *Sự phân tách*
In a BST:
- All nodes in Left Subtree < Root.
- All nodes in Right Subtree > Root.

The LCA of `p` and `q` is the node where `p` and `q` **diverge** for the first time.
- If both `p` and `q` are smaller than Root, the LCA must be in the Left Subtree.
- If both `p` and `q` are larger than Root, the LCA must be in the Right Subtree.
- If one is smaller and one is larger (or equal), then the **Root itself** is the split point (LCA).
*LCA là nơi `p` và `q` phân tách lần đầu tiên. Nếu cả hai nhỏ hơn Root -> Trái. Cả hai lớn hơn Root -> Phải. Nếu khác phía -> Root là LCA.*

---

## 2. Approach: Iterative Walking
## *2. Hướng tiếp cận: Đi bộ lặp*

### Logic
### *Logic*
1.  Start at `curr = root`.
2.  While `curr` exists:
    - If `p.val > curr.val` AND `q.val > curr.val`: `curr = curr.right`.
    - Else If `p.val < curr.val` AND `q.val < curr.val`: `curr = curr.left`.
    - Else: We found the split! Return `curr`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **No Backtracking:** We move down the tree strictly. No need to store parent pointers or use recursion stack.
    *Không quay lui: Di chuyển thẳng xuống cây. Không cần stack.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$ where $H$ is height. $O(N)$ worst case, $O(\log N)$ balanced.
    *Độ phức tạp thời gian: $O(H)$.*
*   **Space Complexity:** $O(1)$ (Iterative).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:**
      6
     / \
    2   8
   / \
  0   4

**Find LCA(2, 8):**
- Root 6. `2 < 6` and `8 > 6`. Split! Return **6**.

**Find LCA(2, 4):**
- Root 6. `2 < 6` and `4 < 6`. Go Left (to 2).
- Curr 2. `2 == 2`. It's not both smaller or both larger. Split! Return **2**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is the easiest LCA variation thanks to BST properties. Do not use the generic Binary Tree LCA algorithm ($O(N)$) here as it's overkill and slower.
*Đây là biến thể LCA dễ nhất nhờ tính chất BST. Đừng dùng thuật toán LCA chung ($O(N)$) vì nó thừa và chậm hơn.*
---
*Đôi khi việc tìm điểm chung nằm ở việc nhận ra khi nào hai con đường bắt đầu rẽ sang hai hướng khác nhau.*
Sometimes finding common ground lies in recognizing when two paths start diverging in different directions.
