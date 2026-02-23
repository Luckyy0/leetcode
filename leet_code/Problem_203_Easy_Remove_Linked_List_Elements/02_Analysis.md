# Analysis for Remove Linked List Elements
# *Phân tích cho bài toán Xóa phần tử trong danh sách liên kết*

## 1. Problem Essence & The Loophole
## *1. Bản chất vấn đề & Lỗ hổng*

### The "Head" Problem
### *Vấn đề với nút "Head"*
Removing a node in the middle is easy: `curr.next = curr.next.next`.
The challenge is when the node to remove is the **head** itself (or multiple heads in a row, like `[7, 7, 7, ...]` remove 7).
*Xóa một nút ở giữa thì dễ. Thử thách là khi nút cần xóa chính là **head** (hoặc nhiều head liên tiếp).*

If we don't handle the head separately, we'll need complex `if/else` logic or loop conditions.
*Nếu không xử lý riêng phần head, chúng ta sẽ cần logic `if/else` phức tạp.*

---

## 2. Approach: Dummy/Sentinel Node
## *2. Hướng tiếp cận: Nút giả/Nút lính canh*

### Logic
### *Logic*
Create a `dummy` node that points to `head`. This transforms the problem so that we are *always* deleting a node that is *after* some other node (even if it's the original head).
*Tạo một nút `dummy` trỏ đến `head`. Điều này biến đổi bài toán sao cho chúng ta *luôn* xóa một nút nằm *sau* một nút khác.*

1.  `ListNode dummy = new ListNode(0);`
2.  `dummy.next = head;`
3.  `curr = dummy;`
4.  While `curr.next != null`:
    - If `curr.next.val == val`:
        - `curr.next = curr.next.next;` (Delete it. **Do NOT advance `curr` yet**, check the new `next` in the next iteration).
    - Else:
        - `curr = curr.next;` (Move forward).
5.  Return `dummy.next`.

*1. Tạo nút dummy. 2. Trỏ dummy vào head. 3. Duyệt từ dummy. 4. Nếu `next` có giá trị cần xóa, bỏ qua nó (đừng di chuyển `curr`). Ngược lại, di chuyển `curr`. 5. Trả về `dummy.next`.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Uniformity:** The code for deleting the first node is exactly the same as deleting the last node.
    *Sự đồng nhất: Mã để xóa nút đầu tiên giống hệt mã để xóa nút cuối cùng.*
*   **Edge Case Safety:** Automatically handles empty lists and lists containing only value `val`.
    *An toàn với trường hợp biên: Tự động xử lý danh sách rỗng và danh sách chỉ chứa giá trị `val`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit each node once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$. Only pointers.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 6, 3]`, `val = 6`

1.  `dummy -> 1 -> 2 -> 6 -> 3`. `curr` at dummy.
2.  `curr.next` is 1 != 6. `curr` moves to 1.
3.  `curr.next` is 2 != 6. `curr` moves to 2.
4.  `curr.next` is 6 == 6.
    - `curr.next` becomes `6.next` (which is 3).
    - List: `dummy -> 1 -> 2 -> 3`.
    - `curr` stays at 2.
5.  `curr.next` is 3 != 6. `curr` moves to 3.
6.  End. Return `dummy.next` (1).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Always use a **Dummy Node** for linked list problems that involve modifying the head or structure of the list. It eliminates the need for special "head handling" code.
*Luôn sử dụng **Nút giả (Dummy Node)** cho các bài toán danh sách liên kết liên quan đến việc sửa đổi đầu hoặc cấu trúc của danh sách. Nó loại bỏ nhu cầu viết mã xử lý riêng cho phần đầu.*
---
*Đôi khi một thủ lĩnh giả (dummy) lại là người bảo vệ tốt nhất cho sự toàn vẹn của cả đội hình.*
Sometimes a dummy leader is the best protector of the team's integrity.
