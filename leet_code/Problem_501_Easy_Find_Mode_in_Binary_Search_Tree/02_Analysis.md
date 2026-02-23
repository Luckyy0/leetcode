# Analysis for Find Mode in Binary Search Tree
# *Phân tích cho bài toán Tìm Mode trong Cây Nhị phân Tìm kiếm*

## 1. Problem Essence & In-order Traversal
## *1. Bản chất vấn đề & Duyệt Trung thứ tự*

### The Challenge
### *Thách thức*
Finding the most frequent element(s) in a BST.
- A naïve approach would use a HashMap to count frequencies ($O(N)$ space).
- The "Follow up" asks for $O(1)$ extra space.
- Key Property: In-order traversal of a BST yields a sorted sequence. In a sorted sequence, duplicates are adjacent.

### Strategy: Two-Pass or Single-Pass with Dynamic Updates
### *Chiến lược: Hai lần Duyệt hoặc Một lần Duyệt với Cập nhật Động*

1.  **In-order Traversal:** Traverse `Left -> Node -> Right`. The values will appear as $x_1, x_1, x_1, x_2, x_2, ...$.
2.  **Tracking Steps:**
    - Maintain `currentVal`, `currentCount`, `maxCount`.
    - Compare `node.val` with `currentVal`.
    - If equal, increment `currentCount`. Else, reset `currentCount = 1`.
    - If `currentCount > maxCount`: Clear result list, add current value, update `maxCount`.
    - If `currentCount == maxCount`: Add current value to result list.
3.  **Space Consideration:**
    - Recursion stack is $O(H)$ (allowed).
    - Result list is $O(K)$ where $K$ is number of modes. Technically this is output space.
    - So logic is truly $O(1)$ auxiliary.

---

## 2. Approach: Recursive In-order
## *2. Hướng tiếp cận: Duyệt Trung thứ tự Đệ quy*

### Logic
### *Logic*
(See above). We need member variables or a pass-by-reference object to maintain state (`prev`, `count`, `max`) across recursive calls.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Order:** Handled entirely by BST property. No sorting needed.
    *Thứ tự đã sắp xếp: Được xử lý hoàn toàn bởi tính chất BST. Không cần sắp xếp.*
*   **Linear Scan:** We process each node once.
    *Duyệt tuyến tính: Chúng ta xử lý mỗi nút một lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$ stack space ($O(1)$ extra).
    *Độ phức tạp không gian: $O(1)$ phụ trợ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, null, 2, 2]` -> Tree: `1 -> Right: 2 -> Left: 2`.
1. Inorder: `1, 2, 2`.
2. Visit `1`:
   - `prev` was null. `currCount = 1`. `maxCount = 1`. Modes `[1]`.
   - `prev = 1`.
3. Visit `2` (first one):
   - `val != prev`. `currCount = 1`. Matches `maxCount`? Yes (1). Append `2`. Modes `[1, 2]`.
   - `prev = 2`.
4. Visit `2` (second one):
   - `val == prev`. `currCount = 2`.
   - `currCount > maxCount`. New Max 2. Clear modes. Add `2`. Modes `[2]`.
Result: `[2]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

In-order traversal tracking consecutive counts.
*Duyệt trung thứ tự theo dõi số lượng liên tiếp.*
---
*Trong một thế giới đầy những bản sao (duplicates), thứ tự (sorted order) giúp ta nhận ra đâu là giá trị cốt lõi. Bằng cách đi qua từng phần tử một cách tuần tự (in-order), ta không cần bộ nhớ lớn để ghi nhớ tất cả, mà chỉ cần so sánh hiện tại với quá khứ gần nhất (prev node) để tìm ra tần số rung động mạnh nhất (mode).*
In a world full of copies (duplicates), order (Sorted Order) helps us realize what the core value is. By going through each element sequentially (in-order), we do not need a large memory to remember all, but just compare the current with the nearest past (Prev Node) to find the strongest vibration frequency (Mode).
