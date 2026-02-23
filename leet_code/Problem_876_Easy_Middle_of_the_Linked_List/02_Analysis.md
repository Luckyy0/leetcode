# Analysis for Middle of the Linked List
# *Phân tích cho bài toán Nút giữa của Danh sách Liên kết*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the middle node of a linked list in a single pass. If the length is even, return the second of the two middle nodes.
*Tìm nút ở giữa của một danh sách liên kết trong một lượt duyệt duy nhất. Nếu độ dài chẵn, hãy trả về nút thứ hai trong hai nút ở giữa.*

---

## 2. Strategy: Fast and Slow Pointers (Tortoise and Hare)
## *2. Chiến lược: Con trỏ Nhanh và Chậm (Rùa và Thỏ)*

### Key Concept
### *Khái niệm chính*
Use two pointers starting at the `head`.
- **Slow pointer (`slow`)**: Moves one step at a time.
- **Fast pointer (`fast`)**: Moves two steps at a time.
When the fast pointer reaches the end of the list, the slow pointer will be exactly at the middle.
*Sử dụng hai con trỏ bắt đầu tại `head`. Con trỏ chậm di chuyển 1 bước mỗi lần. Con trỏ nhanh di chuyển 2 bước mỗi lần. Khi con trỏ nhanh đến cuối danh sách, con trỏ chậm sẽ ở chính xác vị trí ở giữa.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `slow = head, fast = head`.
    *   **Khởi tạo:** Cả hai con trỏ đều trỏ vào `head`.*

2.  **Pointer Movement Loop:**
    - While `fast != null` and `fast.next != null`:
        - `slow = slow.next`
        - `fast = fast.next.next`
    *   **Vòng lặp di chuyển:** Trong khi con trỏ nhanh và nút kế tiếp của nó không null: di chuyển `slow` 1 bước và `fast` 2 bước.*

3.  **Result:** Return `slow`.
    *   **Kết quả:** Trả về con trỏ `slow`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We traverse the list once.
    *   **Độ phức tạp thời gian:** $O(N)$, vì chúng ta duyệt qua danh sách một lần.*
*   **Space Complexity:** $O(1)$, only two pointer variables are used.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The fast-and-slow pointer technique is the standard and most efficient way to find midpoints or detect cycles in a linked list.
*Kỹ thuật con trỏ nhanh-chậm là cách tiêu chuẩn và hiệu quả nhất để tìm điểm giữa hoặc phát hiện chu trình trong danh sách liên kết.*
