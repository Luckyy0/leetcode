# Analysis for Closest Binary Search Tree Value
# *Phân tích cho bài toán Giá trị BST gần nhất*

## 1. Problem Essence & BST Property
## *1. Bản chất vấn đề & Tính chất BST*

### The Search
### *Tìm kiếm*
We want `min(|node.val - target|)`.
We can view this as a binary search.
At `node`, if `target < node.val`, the closest value could be `node.val` OR something in the Left sub-tree. Right sub-tree will only be further away (since all values > `node.val`).
Conversely, if `target > node.val`, go Right.

### Strategy
### *Chiến lược*
Start at root.
Track `closest` value found so far.
Iterate:
1.  Update `closest` if `abs(curr.val - target) < abs(closest - target)`.
2.  If `target < curr.val`: `curr = curr.left`.
3.  Else: `curr = curr.right`.

---

## 2. Approach: Iterative Search
## *2. Hướng tiếp cận: Tìm kiếm lặp*

### Logic
### *Logic*
1.  `closest = root.val`.
2.  While `root != null`:
    - `val = root.val`.
    - If `abs(val - target) < abs(closest - target)`: `closest = val`.
    - If `target < val`: `root = left`.
    - Else: `root = right`.
3.  Return `closest`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Time:** We discard half the tree at each step, just like binary search.
    *Thời gian Lôgarit: Loại bỏ một nửa cây ở mỗi bước.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$ where $H$ is height. Average $O(\log N)$.
    *Độ phức tạp thời gian: $O(H)$.*
*   **Space Complexity:** $O(1)$ iterative.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Root 4, Target 3.7.
1.  Curr 4. `|4 - 3.7| = 0.3`. Closest = 4.
2.  `3.7 < 4`. Go Left (Node 2).
3.  Curr 2. `|2 - 3.7| = 1.7`. `1.7 > 0.3`. Keep Closest 4.
4.  `3.7 > 2`. Go Right (Node 3).
5.  Curr 3. `|3 - 3.7| = 0.7`. `0.7 > 0.3`. Keep Closest 4.
6.  `3.7 > 3`. Go Right (Null). Stop.
Result: 4. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard BST traversal.
*Duyệt BST chuẩn.*
---
*Đôi khi chúng ta tìm kiếm điều hoàn hảo (target), nhưng cuộc sống đưa ta đến điều gần gũi nhất (closest value). Biết chấp nhận cái "gần nhất" cũng là một loại hạnh phúc.*
Sometimes we seek perfection (target), but life brings us the closest value. Knowing how to accept the "closest" is also a kind of happiness.
