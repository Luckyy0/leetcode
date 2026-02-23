# Analysis for Delete Node in a Linked List
# *Phân tích cho bài toán Xóa nút trong Danh sách liên kết*

## 1. Problem Essence & The "Imposter" Trick
## *1. Bản chất vấn đề & Mẹo "Kẻ mạo danh"*

### The Constraint
### *Ràng buộc*
Normally, to delete a node, we need its **predecessor** (`prev.next = node.next`).
Here, we ONLY have access to the node itself. We cannot reach the predecessor.
*Bình thường cần nút tiền nhiệm. Ở đây không có, không thể truy cập tiền nhiệm.*

### The Solution
### *Giải pháp*
If you can't disappear, become someone else, then make *them* disappear.
1.  Copy the value from the `next` node to the current `node`. (`node.val = node.next.val`)
2.  Delete the `next` node. (`node.next = node.next.next`)

Effectively, the current node becomes a clone of the next node, and the next node is removed. The result looks exactly as if the current node was deleted.
*Nếu không thể biến mất, hãy trở thành người khác, rồi làm *người đó* biến mất. 1. Chép giá trị nút sau vào nút hiện tại. 2. Xóa nút sau.*

---

## 2. Approach: Copy and Skip
## *2. Hướng tiếp cận: Sao chép và Bỏ qua*

### Algorithm
### *Thuật toán*
- `node.val = node.next.val`
- `node.next = node.next.next`

### Preconditions (Given by problem)
### *Điều kiện tiên quyết*
- Node is not the tail. (Crucial, because we need a `next` node to copy from).
*Nút không phải là đuôi. (Quan trọng, vì cần nút kế tiếp để sao chép).*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Time:** No traversal needed.
    *Thời gian O(1): Không cần duyệt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**List:** `4 -> 5 -> 1 -> 9`. Delete `5`.
Node is `5`. Next is `1`.

1.  Copy value: Node `5` becomes `1`. List: `4 -> 1 -> 1 -> 9`.
2.  Skip next: Node points to `9`. List: `4 -> 1 -> 9`.

Result: `4, 1, 9`. Logically, the value `5` is gone.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic "Brain Teaser". It's not about algorithm complexity but about lateral thinking.
*Đây là bài toán đố mẹo kinh điển. Không phải về độ phức tạp thuật toán mà là tư duy ngoại biên.*
---
*Để xóa bỏ quá khứ (node), hãy lấy tương lai (next node) lấp đầy vào hiện tại, và quên đi sự tồn tại của tương lai cũ.*
To delete the past (node), fill the present with the future (next node), and forget the existence of the old future.
