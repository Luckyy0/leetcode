# Analysis for Binary Tree Paths
# *Phân tích cho bài toán Đường dẫn cây nhị phân*

## 1. Problem Essence & DFS
## *1. Bản chất vấn đề & Tìm kiếm theo chiều sâu (DFS)*

### The Traversal
### *Duyệt cây*
We need to visit every node. When we reach a leaf, we record the path taken to get there.
Standard DFS (Pre-order ideally) works best. passing the current `path` string down.

### String vs StringBuilder
### *String vs StringBuilder*
- **String:** Immutable. `path + "->" + node.val` creates new strings at every step. $O(N^2)$ worst case for deep trees.
- **StringBuilder:** Mutable. Append `->val`. Backtrack (set length back) after returning. $O(N)$.
However, since constraints are small (Height $\le 100$), String concatenation is fast enough and easier to write. I will present the StringBuilder approach as it is more optimal.
*Dùng String tiện nhưng chậm. Dùng StringBuilder nhanh, tối ưu O(N).*

---

## 2. Approach: DFS with StringBuilder
## *2. Hướng tiếp cận: DFS với StringBuilder*

### Logic
### *Logic*
1.  `dfs(node, currentSB, resultList)`
2.  Append `node.val`.
3.  If Leaf (`left==null` and `right==null`):
    - Add `currentSB.toString()` to list.
4.  Else:
    - Append `->`.
    - If left: `dfs(left)`.
    - If right: `dfs(right)`.
5.  Backtrack: Remove `node.val` and `->` from `currentSB`.

Wait, backtracking with SB is tricky because `val` length varies.
Simpler: Pass `currentPath` string.
`dfs(node, path)`:
  path += node.val
  if leaf: add path
  else: path += "->"
        dfs(left, path)
        dfs(right, path)
Since path is String (passed by value-ish in Java in terms of reference to immutable), recursion stack handles "backtracking".

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Recursion stack:** Holds the history implicitly.
    *Ngăn xếp đệ quy: Giữ lịch sử một cách ngầm định.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ with StringBuilder, $O(N^2)$ with String (due to copying). Given $N=100$, String is fine.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ stack + $O(N)$ result.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `1 -> (2->5, 3)`
1.  `dfs(1, "")`. Path "1". Not leaf.
2.  Recurse `dfs(2, "1->")`. Path "1->2". Not leaf.
3.  Recurse `dfs(5, "1->2->")`. Path "1->2->5". IS LEAF. Add.
4.  Return to 2. Recurse right (null). Return to 1.
5.  Recurse `dfs(3, "1->")`. Path "1->3". IS LEAF. Add.

Result: `["1->2->5", "1->3"]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

String parameter is cleaner for interview unless specific memory constraints apply.
*Tham số String sạch sẽ hơn cho phỏng vấn.*
---
*Đường dẫn (path) được định nghĩa bởi đích đến (lá). Nếu không đi đến tận cùng, bạn chỉ là một nhánh cụt (node giữa).*
The path is defined by the destination (leaf). If you don't go to the end, you're just a stub (middle node).
