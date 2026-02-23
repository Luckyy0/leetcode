# Analysis for Invert Binary Tree
# *Phân tích cho bài toán Đảo ngược cây nhị phân*

## 1. Problem Essence & Recursive Swap
## *1. Bản chất vấn đề & Hoán đổi đệ quy*

### The Meme
### *Cái Meme*
"Max Howell (creator of Homebrew) was rejected by Google for not being able to invert a binary tree on a whiteboard."
This problem is famous.
*Max Howell bị Google từ chối vì không đảo ngược được cây nhị phân. Bài toán này rất nổi tiếng.*

### The Logic
### *Logic*
To invert a tree means:
For every node, swap its left child and right child.
And do this recursively for all children.
*Đảo ngược cây nghĩa là: Với mỗi nút, hoán đổi con trái và con phải. Và làm đệ quy cho tất cả các con.*

---

## 2. Approach: DFS Recursion
## *2. Hướng tiếp cận: Đệ quy DFS*

### Algorithm
### *Thuật toán*
1.  **Base Case:** If `root == null`, return `null`.
2.  **Swap:** `temp = root.left`, `root.left = root.right`, `root.right = temp`.
3.  **Recurse:**
    - `invertTree(root.left)`
    - `invertTree(root.right)`
4.  **Return:** `root`.

(Note: You can recurse first then swap, or swap first then recurse. Both work).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Tree Traversal:** It's a standard Post-order or Pre-order traversal. We visit every node exactly once.
    *Duyệt cây: Đây là duyệt Tiền thứ tự hoặc Hậu thứ tự. Thăm mỗi nút đúng 1 lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ (Height of tree) for recursion stack.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

Tree:
  4
 / \
2   7

1.  `invert(4)`:
    - Swap 2 and 7.
    - `invert(7)` (was right, now left).
    - `invert(2)` (was left, now right).
    - Result:
      4
     / \
    7   2

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Don't overthink it. Just swap left and right pointers.
*Đừng nghĩ quá phức tạp. Chỉ cần hoán đổi con trỏ trái và phải.*
---
*Đôi khi cuộc sống bị đảo lộn, nhưng miễn là gốc rễ (root) còn đó, mọi thứ vẫn ổn.*
Sometimes life gets turned upside down, but as long as the root is there, everything is fine.
