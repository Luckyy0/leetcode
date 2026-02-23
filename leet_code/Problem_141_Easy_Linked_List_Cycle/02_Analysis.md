# Analysis for Linked List Cycle
# *Phân tích cho bài toán Chu trình trong Danh sách liên kết*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Detecting Infinite Loops
### *Phát hiện vòng lặp vô hạn*
*   The fundamental goal is to detect if a linked list contains a cycle. A cycle occurs when a node's `next` pointer points back to a previously visited node.
    *Mục tiêu cơ bản là phát hiện xem một danh sách liên kết có chứa chu trình hay không. Một chu trình xảy ra khi con trỏ `next` của một nút trỏ ngược lại một nút đã được truy cập trước đó.*
*   The primary challenge is to solve this in **O(N) time** and **O(1) space**. While a `HashSet` can detect cycles by storing visited nodes, it requires $O(N)$ extra space, which is suboptimal for this specific constraint.
    *Thử thách chính là giải quyết vấn đề này trong **thời gian O(N)** và **không gian O(1)**. Mặc dù một `HashSet` có thể phát hiện chu trình bằng cách lưu trữ các nút đã truy cập, nó yêu cầu không gian bổ sung $O(N)$, điều này không tối ưu cho ràng buộc cụ thể này.*

---

## 2. Approach: Floyd's Tortoise and Hare Algorithm
## *2. Hướng tiếp cận: Thuật toán Rùa và Thỏ của Floyd*

This is the classic, elegant solution for cycle detection in a sequence or linked list.
*Đây là giải pháp kinh điển và thanh lịch để phát hiện chu trình trong một chuỗi hoặc danh sách liên kết.*

### Logic
### *Logic*
1.  **Two Pointers:** Initialize two pointers, `slow` (the tortoise) and `fast` (the hare), both starting at the `head`.
    *Hai con trỏ: Khởi tạo hai con trỏ, `slow` (rùa) và `fast` (thỏ), cả hai đều bắt đầu tại `head`.*
2.  **Movement:**
    -   `slow` moves one step at a time (`slow = slow.next`).
    -   `fast` moves two steps at a time (`fast = fast.next.next`).
3.  **The Encounter:**
    -   If there is **no cycle**, `fast` will eventually reach the end of the list (`null`).
        *Nếu **không có chu trình**, `fast` cuối cùng sẽ đi đến cuối danh sách (`null`).*
    -   If there is **a cycle**, `fast` will enter the loop and eventually "lap" the `slow` pointer. At some point, `fast` and `slow` will meet at the exact same node.
        *Nếu **có chu trình**, `fast` sẽ đi vào vòng lặp và cuối cùng sẽ "bắt kịp" con trỏ `slow`. Tại một thời điểm nào đó, `fast` và `slow` sẽ gặp nhau tại cùng một nút.*

### Why do they always meet?
### *Tại sao chúng luôn gặp nhau?*
Imagine two runners on a circular track. Even if one is faster, they will eventually meet as the faster runner completes more laps and catches up to the slower one from behind. In discrete steps, because the distance between them decreases by 1 each step (from the perspective of the loop), they are guaranteed to collide.
*Hãy tưởng tượng hai người chạy trên một đường chạy hình tròn. Ngay cả khi một người nhanh hơn, cuối cùng họ sẽ gặp nhau khi người chạy nhanh hơn hoàn thành nhiều vòng hơn và bắt kịp người chạy chậm hơn từ phía sau. Trong các bước rời rạc, vì khoảng cách giữa chúng giảm đi 1 sau mỗi bước (nhìn từ góc độ vòng lặp), chúng chắc chắn sẽ va chạm.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Memory Efficiency:** No extra data structures are needed. Two pointer variables use constant space regardless of list size.
    *Hiệu quả bộ nhớ: Không cần cấu trúc dữ liệu bổ sung. Hai biến con trỏ sử dụng không gian hằng số bất kể kích thước danh sách.*
*   **Simple Termination:** The condition `fast == null || fast.next == null` provides a clear exit point for acyclic lists.
    *Kết thúc đơn giản: Điều kiện `fast == null || fast.next == null` cung cấp một điểm thoát rõ ràng cho các danh sách không có chu trình.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. 
    -   If no cycle: `fast` reaches the end in $N/2$ steps.
    -   If cycle exists: In the worst case, once both pointers enter the cycle, they will meet in at most one full lap of the cycle.
    *Độ phức tạp thời gian: $O(N)$. Nếu không có chu trình: `fast` đạt đến cuối trong $N/2$ bước. Nếu có chu trình: Trong trường hợp xấu nhất, một khi cả hai con trỏ đều vào chu trình, chúng sẽ gặp nhau trong tối đa một vòng quay của chu trình.*
*   **Space Complexity:** $O(1)$. Only two pointers are stored throughout the execution.
    *Độ phức tạp không gian: $O(1)$. Chỉ có hai con trỏ được lưu trữ trong suốt quá trình thực thi.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `3 -> 2 -> 0 -> -4 (connects back to 2)`

-   Step 0: `slow=3`, `fast=3`
-   Step 1: `slow=2`, `fast=0`
-   Step 2: `slow=0`, `fast=2` (fast went -4 -> 2)
-   Step 3: `slow=-4`, `fast=-4` (fast went 0 -> -4) -> **MEET!**

**Result:** True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Floyd's Cycle-Finding algorithm is the gold standard for this problem. It is expected in any professional interview. The key is correctly handling the `null` checks for the fast pointer's two-step leap. This pattern of "slow and fast pointers" is widely applicable in other problems like finding the middle of a linked list.
*Thuật toán phát hiện chu trình của Floyd là tiêu chuẩn vàng cho bài toán này. Nó thường được yêu cầu trong bất kỳ cuộc phỏng vấn chuyên nghiệp nào. Chìa khóa là xử lý chính xác các kiểm tra `null` cho bước nhảy hai bước của con trỏ nhanh. Mô hình "con trỏ chậm và nhanh" này được áp dụng rộng rãi trong các bài toán khác như tìm điểm giữa của một danh sách liên kết.*
---
*Đôi khi việc chạy thật nhanh chỉ để thấy rằng chúng ta đang quay trở lại nơi đã bắt đầu.*
Sometimes running very fast is just to realize we are returning to where we started.
