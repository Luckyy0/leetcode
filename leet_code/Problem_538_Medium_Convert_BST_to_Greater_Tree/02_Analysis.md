# Analysis for Convert BST to Greater Tree
# *Phân tích cho bài toán Chuyển đổi BST thành Cây Lớn hơn*

## 1. Problem Essence & Reverse In-order
## *1. Bản chất vấn đề & Duyệt Trung thứ tự Ngược*

### The Challenge
### *Thách thức*
Adding sum of all greater nodes to current node.
- In BST, greater nodes are in Right Subtree.
- If we process nodes from largest to smallest, we can maintain a running sum.

### Strategy: Right -> Root -> Left Traversal
### *Chiến lược: Duyệt Phải -> Gốc -> Trái*

1.  **Traversal:** Reverse In-order. Visit Right child, then Node, then Left child.
2.  **State:** `sum` accumulates values of visited nodes (which are all greater than current node coming from Right).
3.  **Update:** `node.val += sum`. Update `sum = node.val`.

---

## 2. Approach: Recursive DFS
## *2. Hướng tiếp cận: DFS Đệ quy*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Processing:** Directly utilizes BST property.
    *Xử lý đã sắp xếp: Tận dụng trực tiếp tính chất BST.*
*   **O(N) Time:** Single pass.
    *Thời gian O(N): Một lần duyệt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ recursion stack.
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[4, 1, 6]` `(1 < 4 < 6)`
1. Traverse Right (6).
   - Right of 6 (null).
   - Process 6. `sum = 0`. `6 += 0` -> 6. `newSum = 6`.
   - Left of 6 (null).
2. Process 4. `sum = 6`. `4 += 6` -> 10. `newSum = 10`.
3. Traverse Left (1).
   - Right of 1 (null).
   - Process 1. `sum = 10`. `1 += 10` -> 11. `newSum = 11`.
   - Left of 1 (null).
Result: `[10, 11, 6]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Reverse In-order Traversal maintaining running sum.
*Duyệt trung thứ tự ngược duy trì tổng chạy.*
---
*Để trở nên vĩ đại hơn (Greater Tree), ta cần biết trân trọng những giá trị đi trước (greater nodes). Bằng cách đi ngược dòng (Reverse traversal) từ đỉnh cao nhất, ta tích lũy tất cả những tinh hoa để làm giàu thêm cho chính mình.*
To become greater (Greater Tree), we need to cherish the values that came before (Greater Nodes). By going upstream (Reverse Traversal) from the highest peak, we accumulate all the quintessence to enrich ourselves.
