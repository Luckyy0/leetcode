# Analysis for Kth Smallest Element in a BST
# *Phân tích cho bài toán Phần tử nhỏ thứ K trong BST*

## 1. Problem Essence & In-Order Traversal
## *1. Bản chất vấn đề & Duyệt Trung thứ tự*

### BST Property
### *Tính chất BST*
In a Binary Search Tree, an **In-Order Traversal** (Left -> Node -> Right) yields the values in **sorted ascending order**.
*Trong BST, Duyệt Trung thứ tự cho ra các giá trị theo thứ tự tăng dần.*

### The Solution(s)
### *Giải pháp*
1.  **Full Traversal:** Traverse the whole tree, store in List, return `list[k-1]`. Space $O(N)$.
2.  **Iterative Traversal (Early Stop):** Use a stack. Stop as soon as we pop the k-th element. Space $O(H)$.
3.  **Recursive Traversal (Early Stop):** Maintain a global counter.

---

## 2. Approach: Iterative In-Order (Stack)
## *2. Hướng tiếp cận: Duyệt trung thứ tự lặp (Ngăn xếp)*

### Logic
### *Logic*
1.  Initialize Stack. `curr = root`.
2.  Go as left as possible, pushing to stack.
3.  Pop node. **This is the next smallest element.**
4.  Decrement `k`. If `k == 0`, return `node.val`.
5.  `curr = node.right`. Repeat.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Nature:** Exploits the fundamental property of BSTs naturally.
    *Tính chất đã sắp xếp: Khai thác tính chất cơ bản của BST một cách tự nhiên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H + K)$. We go down to the leftmost leaf ($O(H)$) and then process $k$ nodes.
    *Độ phức tạp thời gian: $O(H + K)$.*
*   **Space Complexity:** $O(H)$ for the stack.
    *Độ phức tạp không gian: $O(H)$.*

### Follow-up: Frequent Modifications?
If we modify often, $O(K)$ is slow if $K$ is large ($K \approx N$).
We can augment the tree nodes to store the **count of nodes in the left subtree**.
- `node.leftCount`.
- If `k == leftCount + 1`: Current node is the answer.
- If `k <= leftCount`: Recurse left (`k`).
- If `k > leftCount + 1`: Recurse right (`k - leftCount - 1`).
This makes lookup $O(H)$ ($O(\log N)$ if balanced).
*Nếu sửa đổi thường xuyên (Follow-up): Lưu số lượng nút con trong cây con trái. Giúp tìm kiếm trong $O(\log N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `root` with structure `5 (L:3, R:6)`, `3 (L:2, R:4)`, `2 (L:1)`. `k=3`.
Tree:
      5
     / \
    3   6
   / \
  2   4
 /
1

1.  Push 5, 3, 2, 1. Stack: `[5, 3, 2, 1]`.
2.  Pop 1. k=2. Right=null.
3.  Pop 2. k=1. Right=null.
4.  Pop 3. k=0. **Return 3**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard BST problem. In-Order traversal is the canonical way to process BSTs in sorted order.
*Bài toán BST tiêu chuẩn. Duyệt trung thứ tự là cách chuẩn mực để xử lý BST theo thứ tự.*
---
*Trong một thế giới có trật tự (BST), việc tìm người đứng thứ K chỉ đơn giản là đi theo lề lối đã định sẵn.*
In an ordered world (BST), finding the K-th person is simply following the established path.
