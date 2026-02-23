# Analysis for Flatten a Multilevel Doubly Linked List
# *Phân tích cho bài toán Làm phẳng Danh sách Liên kết Đôi đa cấp*

## 1. Problem Essence & Recursive Insertion
## *1. Bản chất vấn đề & Chèn Đệ quy*

### The Challenge
### *Thách thức*
Merging hierarchical child lists into a main sequence. This is effectively a DFS (Depth-First Search) where we explore the `child` branch completely before continuing with the `next` neighbor.

### Strategy: DFS with Re-linking
### *Chiến lược: DFS với Liên kết lại*
1.  **Iterate through the list:** Start from `head`.
2.  **Detection:** When a node `curr` has a `child`:
    -   Save the `curr.next` node in a temporary variable `nextTemp`.
    -   Recursively flatten the `child` list.
    -   **Re-link:**
        -   Connect `curr.next` to the head of the flattened child list.
        -   Connect the child's head `prev` back to `curr`.
        -   Set `curr.child = null`.
        -   Find the **tail** of the flattened child list.
        -   If `nextTemp` exists, connect the child's tail `next` to `nextTemp`, and `nextTemp.prev` back to the tail.
3.  Continue from the next node.

---

## 2. Approach: Iterative/DFS Hybrid
## *2. Hướng tiếp cận: Kết hợp Lặp/DFS*

### Logic
### *Logic*
(See above). The recursive nature ensures that if the child list itself has its own children, they are handled at the deeper level before being attached back to the main list.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **In-Place Transformation:** Reuses existing pointers, minimizing memory usage.
    *Chuyển đổi tại chỗ: Tái sử dụng các con trỏ hiện có, giảm thiểu việc sử dụng bộ nhớ.*
*   **Logical Consistency:** Treats the `child` pointer as a "sub-branch" that takes priority, similar to a preorder traversal on a tree.
    *Tính nhất quán logic: Coi con trỏ child như một "nhánh con" được ưu tiên, tương tự như việc duyệt preorder trên một cây.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is total nodes. Each node is visited once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(D)$, where $D$ is the maximum depth of the nested child lists (recursion stack).
    *Độ phức tạp không gian: $O(D)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `1 -> 2 -> 3 (child: 7 -> 8) -> 4`
1. Move to 3. `nextTemp = 4`.
2. Head of child is 7.
3. Link `3.next = 7`, `7.prev = 3`. `3.child = null`.
4. Tail of child list is 8.
5. Link `8.next = 4`, `4.prev = 8`.
Result: `1-2-3-7-8-4`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive DFS to flatten and re-link sub-lists.
*DFS đệ quy để làm phẳng và liên kết lại các danh sách con.*
---
*Những ngã rẽ (child lists) trong cuộc hành trình đôi khi làm ta xao lãng khỏi con đường chính (main list). Tuy nhiên, bằng cách đối diện (traversal) và tích hợp chúng vào hiện tại của mình, ta không chỉ mở rộng trải nghiệm mà còn tạo nên một chuỗi cuộc đời liền mạch (flattened list), nơi mọi ký ức ẩn giấu đều được đưa ra ánh sáng.*
Turning points (child lists) in the journey sometimes distract us from the main path (main list). However, by facing (traversal) and integrating them into our present, we not only expand our experience but also create a seamless sequence of life (flattened list), where every hidden memory is brought to light.
