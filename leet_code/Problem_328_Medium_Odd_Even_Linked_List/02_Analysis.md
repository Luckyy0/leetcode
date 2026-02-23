# Analysis for Odd Even Linked List
# *Phân tích cho bài toán Danh sách Liên kết Lẻ Chẵn*

## 1. Problem Essence & Pointer Manipulation
## *1. Bản chất vấn đề & Thao tác Con trỏ*

### The Challenge
### *Thách thức*
Separate odd/even nodes in place. Maintain relative order.
Indices are 1-based (Odd, Even, Odd, Even...).
Input: `1->2->3->4->5`.
Output: `1->3->5 -> 2->4`.

### Strategy: Two Pointers
### *Chiến lược: Hai Con trỏ*
Use `odd` pointer for odd list, `even` pointer for even list.
Loop proceeds by jumping `next.next`.
Start: `odd = head`, `even = head.next`, `evenHead = even`.
While `even != null && even.next != null`:
  `odd.next = even.next`: Link current odd to next odd.
  `odd = odd.next`: Move odd forward.
  `even.next = odd.next`: Link current even to "next" even (which is after new odd).
  `even = even.next`: Move even forward.
Finally:
`odd.next = evenHead`: Connect tail of odd list to head of even list.

---

## 2. Approach: Iterative
## *2. Hướng tiếp cận: Lặp*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **In-Place:** Only modifies `next` pointers.
    *Tại chỗ: Chỉ sửa đổi các con trỏ `next`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 1 -> 2 -> 3 -> 4 -> 5
Odd: 1. Even: 2. EvenHead: 2.
1. Loop: `even` (2) ok, `even.next` (3) ok.
   - `odd.next` = 3. `odd` = 3.
   - `even.next` = 4 (3.next). `even` = 4.
   List: 1->3, 2->4. Remainder: 4->5.
2. Loop: `even` (4) ok, `even.next` (5) ok.
   - `odd.next` = 5. `odd` = 5.
   - `even.next` = null (5.next). `even` = null.
   List: 1->3->5, 2->4->null.
3. Loop terminate (`even` is null? No but `even` became null... wait check conditions).
   If updated `even` is null, loop condition `even != null` handles it next iter.
   Actually `even.next` became `odd.next` which was null.
   So `even` becomes null.
   Next check `even != null` fails. Loop ends.
Connect `odd` (5) to `evenHead` (2).
Result: 1->3->5->2->4->null. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Linked List manipulation.
*Thao tác Danh sách Liên kết tiêu chuẩn.*
---
*Đôi khi những thứ khác biệt (odd and even) cần được tách ra để thấy rõ bản chất của từng nhóm, nhưng cuối cùng chúng vẫn phải được kết nối lại (linked) để tạo nên một tổng thể hoàn chỉnh.*
Sometimes difference (odd and even) need to be separated to clearly see the nature of each group, but eventually they must be reconnected (linked) to create a complete whole.
