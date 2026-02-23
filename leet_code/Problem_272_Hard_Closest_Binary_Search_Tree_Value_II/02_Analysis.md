# Analysis for Closest Binary Search Tree Value II
# *Phân tích cho bài toán Giá trị BST gần nhất II*

## 1. Problem Essence & Optimization
## *1. Bản chất vấn đề & Tối ưu hóa*

### The Naive Way ($O(N)$)
### *Cách ngây thơ*
Inorder traversal -> Sorted Array.
Find `k` closest elements in sorted array.
Time $O(N)$. Space $O(N)$. Simple but follow-up asks for less than $O(N)$.

### The Optimal Way ($O(k \log N)$ or $O(k)$ relative)
### *Cách tối ưu*
We need the "Predecessor" and "Successor" iterators.
Think of the BST as a sorted list.
We find the closest element roughly (Binary Search).
Then we expand outwards (like finding k closest in a sorted array) using `pred()` and `succ()` functions.
However, `pred` / `succ` takes $O(H)$ or $O(\log N)$.
Total $O(k \log N)$ if we restart search from root, or amortized $O(1)$ if we use stacks to maintain state.

### Using Two Stacks
### *Dùng hai ngăn xếp*
1.  Initialize `predStack`: path to nodes `< target`.
2.  Initialize `succStack`: path to nodes `>= target`.
3.  These acts as iterators.
    - `getPredecessor(predStack)`: standard BST predecessor logic but using stack state.
    - `getSuccessor(succStack)`: standard BST successor logic.
4.  Merge: Compare top of `predStack` vs `succStack` (distances to target), pick closest, advance iterator. Repeat `k` times.

---

## 2. Approach: Two Stacks Iterator
## *2. Hướng tiếp cận: Iterator Hai Ngăn xếp*

### Logic
### *Logic*
1.  **Init:**
    - Fill `predStack` with all ancestors `< target` while going down to approx target location. (Specifically, finding the predecessor node).
    - Fill `succStack` with all ancestors `> target`.
    - Actually simpler: Just standard `inorder` traversal logic but one stack goes "reverse inorder" (Right-Root-Left) starting from target-ish, other goes "inorder" (Left-Root-Right).
    - Function `initSucc(node, target, stack)`: If node is null return. If `target < node.val`, push node, go left. Else go right. (This finds successor candidates).
    - Function `initPred(node, target, stack)`: If `target > node.val`, push node, go right. Else go left.

2.  **Iterate:**
    - Peek at `predStack`, `succStack`.
    - Compare `abs(pred.val - target)` vs `abs(succ.val - target)`.
    - If pred closer: Add `pred.val`. Move pred iterator (pop, then push right child and its left descendants... standard iterator logic).
    - Else: Add `succ.val`. Move succ iterator.

### Standard Iterator Logic
### *Logic Iterator chuẩn*
`next()` on stack:
- Node = stack.pop().
- result = Node.val.
- if Node.right != null: push right, then all left children.

Here we want tailored initialization.
Initialize Stack for "values >= target":
- Root to target search.
- When moving left (curr > target), push curr. curr = curr.left.
- When moving right (curr < target), curr = curr.right. (Don't push, because curr is smaller).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficiency:** We only traverse `k` nodes around the target.
    *Hiệu quả: Chỉ duyệt k nút xung quanh target.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H + k)$. (Init takes H, then k steps).
    *Độ phức tạp thời gian: $O(H + k)$.*
*   **Space Complexity:** $O(H)$ for stacks.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Root: 2, 1, 3. Target 2.1. k=2.
1.  **Init Succ (>= 2.1):**
    - Root 2 < 2.1. Go right.
    - Node 3 > 2.1. Push 3. Go left (null).
    - SuccStack: `[3]`.
2.  **Init Pred (<= 2.1):**
    - Root 2 < 2.1. Push 2. Go right.
    - Node 3 > 2.1. Go left.
    - PredStack: `[2]`.
3.  **Merge:**
    - Pred: 2 (diff 0.1). Succ: 3 (diff 0.9).
    - Pick 2. Res: `[2]`.
    - Advance Pred: Pop 2. Right child is 3.
    - Wait, 2's right child is 3?
    - `predNext()` logic: Pop 2. Go to `2.left` (reverse inorder). Node 1. Push 1. Go right (null).
    - PredStack: `[1]`.
4.  **Merge 2:**
    - Pred: 1 (diff 1.1). Succ: 3 (diff 0.9).
    - Pick 3. Res: `[2, 3]`.
    - Advance Succ.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two-stack iterator is complex to implement correctly. For $N=10^4$, $O(N)$ Inorder is perfectly acceptable and much safer in interviews unless $H \ll N$ and strict constraint. I will provide the Two Stacks solution as it answers the Follow-up.
*Iterator hai ngăn xếp rất khó cài đặt chính xác. O(N) Inorder là an toàn hơn. Nhưng sẽ cung cấp giải pháp Two Stacks cho câu hỏi mở rộng.*
---
*Đôi khi chúng ta cần nhìn về cả hai phía (trước và sau) để tìm ra những người bạn đồng hành gần gũi nhất.*
Sometimes we need to look both ways (predecessor and successor) to find the closest companions.
