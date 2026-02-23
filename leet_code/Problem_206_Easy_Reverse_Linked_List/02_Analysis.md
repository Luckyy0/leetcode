# Analysis for Reverse Linked List
# *Phân tích cho bài toán Đảo ngược danh sách liên kết*

## 1. Problem Essence & Pointer Manipulation
## *1. Bản chất vấn đề & Thao tác con trỏ*

### The Core Task
### *Nhiệm vụ cốt lõi*
A linked list is defined by arrows pointing forward. To reverse it, we must make every arrow point backward.
$1 \rightarrow 2 \rightarrow 3 \rightarrow \text{null}$ becomes $\text{null} \leftarrow 1 \leftarrow 2 \leftarrow 3$.
*Danh sách liên kết được định nghĩa bởi các mũi tên chỉ về phía trước. Để đảo ngược nó, chúng ta phải làm cho mọi mũi tên chỉ về phía sau.*

### The Trap
### *Cạm bẫy*
When we change `curr.next` to point to `prev`, we lose the reference to the *original* `next` node. We must save it first.
*Khi chúng ta thay đổi `curr.next` để trỏ vào `prev`, chúng ta mất tham chiếu đến nút `next` *ban đầu*. Chúng ta phải lưu nó trước.*

---

## 2. Approach 1: Iterative (O(1) Space)
## *2. Hướng tiếp cận 1: Lặp (Không gian O(1))*

This is the standard, most efficient way.
*Đây là cách tiêu chuẩn, hiệu quả nhất.*

### Logic
### *Logic*
1.  Initialize `prev = null`.
2.  Initialize `curr = head`.
3.  While `curr != null`:
    - `nextTemp = curr.next` (Save the future).
    - `curr.next = prev` (Reverse the arrow).
    - `prev = curr` (Move prev forward).
    - `curr = nextTemp` (Move curr forward).
4.  Return `prev` (This is the new head).

---

## 3. Approach 2: Recursive (O(N) Space)
## *3. Hướng tiếp cận 2: Đệ quy (Không gian O(N))*

This is elegant but uses stack space.
*Cách này thanh lịch nhưng tốn không gian ngăn xếp.*

### Logic
### *Logic*
To reverse a list `head`:
1.  First, reverse the rest of the list (`head.next`).
2.  Then, make the original `next` node point back to `head`.
    - `head.next.next = head;`
3.  Finally, make `head` point to `null` (it is now the tail).
    - `head.next = null;`

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit each node once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** 
    - Iterative: $O(1)$.
    - Recursive: $O(N)$ (Stack depth).
    *Độ phức tạp không gian: Lặp $O(1)$, Đệ quy $O(N)$.*

---

## 5. Visualized Dry Run (Iterative)
## *5. Chạy thử bằng hình ảnh (Lặp)*

**Input:** `1 -> 2 -> 3 -> null`

1.  `prev=null, curr=1`.
    - `next=2`. `1->null`. `prev=1`. `curr=2`.
2.  `prev=1, curr=2`.
    - `next=3`. `2->1`. `prev=2`. `curr=3`.
3.  `prev=2, curr=3`.
    - `next=null`. `3->2`. `prev=3`. `curr=null`.
4.  Return `prev` (3).
    - Result: `3 -> 2 -> 1 -> null`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Reverse Linked List is foundational. You should be able to write the Iterative solution in your sleep. It is the building block for many Hard problems (like "Reverse Nodes in k-Group" or "Palindrome Linked List"). Always visualize the three pointers: `prev`, `curr`, `next`.
*Đảo ngược danh sách liên kết là nền tảng. Bạn nên có khả năng viết giải pháp Lặp ngay cả khi đang ngủ. Nó là khối xây dựng cho nhiều bài toán Khó (như "Đảo ngược nút trong nhóm k" hoặc "Danh sách liên kết đối xứng"). Hãy luôn hình dung ba con trỏ: `prev`, `curr`, `next`.*
---
*Để tiến về phía trước trong một thế giới đảo ngược, ta phải biết buông bỏ quá khứ (next) để kết nối lại với những gì đã qua (prev).*
To move forward in a reversed world, one must know how to let go of the future (next) to reconnect with what has passed (prev).
