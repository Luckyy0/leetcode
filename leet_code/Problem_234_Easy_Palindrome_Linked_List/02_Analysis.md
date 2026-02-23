# Analysis for Palindrome Linked List
# *Phân tích cho bài toán Danh sách liên kết đối xứng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Easy vs Efficient
### *Dễ vs Hiệu quả*
1.  **Naive ($O(N)$ Space):** Convert linked list to array/list. Check if array is palindrome. Easy but uses extra memory.
2.  **Efficient ($O(1)$ Space):** Modify the list in-place.

### The Strategy
### *Chiến lược*
To check palindrome without extra space:
1.  Find the **middle** of the linked list (Fast/Slow pointers).
2.  **Reverse** the second half of the list.
3.  Compare the first half and the reversed second half node by node.
4.  (Optional but polite) Restore (reverse back) the second half to keep original structure.
*1. Tìm điểm giữa. 2. Đảo ngược nửa sau. 3. So sánh nửa đầu và nửa sau đảo ngược. 4. Khôi phục lại (tùy chọn).*

---

## 2. Approach: Find Middle + Reverse
## *2. Hướng tiếp cận: Tìm giữa + Đảo ngược*

### Steps
### *Các bước*
1.  **Find Middle:**
    - `slow` moves 1 step, `fast` moves 2 steps.
    - When `fast` reaches end, `slow` is at middle.
2.  **Reverse:**
    - Reverse the list starting from `slow`.
    - Let the new head of reversed part be `secondHalfStart`.
3.  **Compare:**
    - `p1 = head`, `p2 = secondHalfStart`.
    - While `p2 != null`:
        - If `p1.val != p2.val`, return `false`.
        - Move both.
    - Return `true`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Memory Efficiency:** We use the existing nodes, just changing their `next` pointers temporarily.
    *Hiệu quả bộ nhớ: Sử dụng các nút hiện có, chỉ thay đổi con trỏ `next` tạm thời.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ (Find mid $N/2$, Reverse $N/2$, Compare $N/2$, Restore $N/2$).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `1 -> 2 -> 2 -> 1`

1.  **Find Mid:** `slow` stops at second `2`.
2.  **Reverse:** Second half `2 -> 1` becomes `1 -> 2`.
    - Original List logical view: `1 -> 2` (first half) and `1 -> 2` (reversed second half).
3.  **Compare:**
    - `1 == 1`? Yes.
    - `2 == 2`? Yes.
    - `p2` becomes null.
4.  **Return:** `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is the standard "Hard" version of an "Easy" problem. Mastering list reversal is key. Be careful with handling odd/even lengths (usually `slow` ends up at the exact middle or start of second half, `fast` checks nulls correctly cover both).
*Đây là phiên bản "Khó" chuẩn mực của một bài toán "Dễ". Thành thạo việc đảo ngược danh sách là chìa khóa. Cẩn thận với độ dài lẻ/chẵn.*
---
*Để hiểu bản thân (palindrome), đôi khi bạn phải nhìn lại một nửa cuộc đời mình (reverse second half).*
To understand yourself (palindrome), sometimes you have to look back at half of your life (reverse second half).
