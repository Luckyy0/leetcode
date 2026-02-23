# Analysis for Count Univalue Subtrees
# *Phân tích cho bài toán Đếm cây con đơn trị*

## 1. Problem Essence & Bottom-Up Check
## *1. Bản chất vấn đề & Kiểm tra từ dưới lên*

### The Naive Way
### *Cách ngây thơ*
For every node, check if its subtree is uni-value. Checking takes $O(N)$. Total $O(N^2)$.
*Kiểm tra từng nút tốn $O(N^2)$.*

### The Bottom-Up Optimization
### *Tối ưu hóa từ dưới lên*
A subtree rooted at `node` is uni-value IF:
1.  Left subtree is uni-value.
2.  Right subtree is uni-value.
3.  `node.val` equals `left.val` (if left exists).
4.  `node.val` equals `right.val` (if right exists).

If we use Post-Order traversal (Leaves first), we can return a boolean `isUnival` from children to parent.
*Một cây con là đơn trị nếu con trái đơn trị, con phải đơn trị và giá trị khớp với cha. Dùng duyệt Hậu thứ tự.*

---

## 2. Approach: DFS (Post-Order)
## *2. Hướng tiếp cận: DFS (Hậu thứ tự)*

### Logic
### *Logic*
Global `count = 0`.
Function `isUnival(node)` returns boolean:
1.  If `node` is null, it is technically "univalue" (conceptually true, or handle in caller). Base case: `node == null` return true.
2.  `leftIsUnival = isUnival(node.left)`.
3.  `rightIsUnival = isUnival(node.right)`.
4.  If `leftIsUnival` AND `rightIsUnival`:
    - Check values:
    - If `node.left != null` and `node.left.val != node.val`: return false.
    - If `node.right != null` and `node.right.val != node.val`: return false.
    - If passed checks: `count++`, return true.
5.  Else: return false.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Single Pass:** We visit every node once ($O(N)$). The boolean return allows parent to decide instantly without re-traversal.
    *Một lần duyệt: Thăm mỗi nút một lần. Giá trị trả về boolean giúp cha quyết định ngay lập tức.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:**
      5
     / \
    1   5
       /
      5

1.  Leave 1 (Left child of root).
    - Left null (T), Right null (T).
    - `count++` (1). Returns True.
2.  Leave 5 (Left child of right-5).
    - Returns True. `count++` (2).
3.  Node 5 (Right child of root).
    - Left (Leaf 5) returned True.
    - Right is null (True).
    - Value check: Left(5) == Self(5). Passed.
    - `count++` (3). Returns True.
4.  Root 5.
    - Left(1) returned True.
    - Right(Node 5) returned True.
    - Value check: Left(1) != Self(5). Failed.
    - Returns False.

Total count: 3. Wait, previous example analysis said 4. Let me re-check example 1 structure.

Example 1:
      5 (A)
     / \
    1   5 (B)
   / \   \
  5   5   5 (C)

Leaves: 5 (left-left), 5 (left-right), 5 (right-right-C). Total 3 leaves -> Count = 3.
Right Subtree B: Children (null, C(5)). C is unival. R-val 5 == B-val 5. B is unival. Count = 4.
Left Subtree (1): Children 5, 5. Unival? Yes. But Val 5 != Val 1. So 1 is NOT unival.
Root A: Left(1) NOT unival. Root NOT unival.

Total 4. My logic holds.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Pass information up: "Am I univalue?". Parent checks strictly.
*Truyền thông tin lên: "Tôi có phải đơn trị không?". Cha kiểm tra nghiêm ngặt.*
---
*Sự thống nhất (univalue) bắt đầu từ những cá nhân nhỏ nhất (lá), nhưng sự đồng thuận lớn hơn (cây) đòi hỏi sự dẫn dắt phù hợp từ cấp trên (gốc).*
Unity (univalue) starts from the smallest individuals (leaves), but larger consensus (tree) requires matching leadership from above (root).
