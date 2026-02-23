# Analysis for Plus One Linked List
# *Phân tích cho bài toán Cộng Một vào Danh sách Liên kết*

## 1. Problem Essence & Carry Management
## *1. Bản chất vấn đề & Quản lý Nhớ*

### The Challenge
### *Thách thức*
Adding 1 to a number where digits move from least significant (tail) to most significant (head). However, linked lists are unidirectional (head to tail).

### Strategy 1: Reverse -> Add -> Reverse
### *Chiến lược 1: Đảo ngược -> Cộng -> Đảo ngược*
1.  Reverse the linked list.
2.  Add 1 to the new head, propagate the carry.
3.  Reverse the list back.
-   Complexity: $O(N)$.

### Strategy 2: Two Pointers (Smart Move)
### *Chiến lược 2: Hai con trỏ (Cách thông minh)*
1.  Find the rightmost digit that is NOT 9. Let's call this node `notNine`.
2.  Everything to the right of `notNine` will become 0 after adding 1.
3.  Increment `notNine.val`.
4.  Set all nodes after `notNine` to 0.
5.  If all nodes are 9, add a new head `1`.

### Strategy 3: Recursion
### *Chiến lược 3: Đệ quy*
1.  Base case: end of list.
2.  Recursive step: add carry from the next node.
3.  Propagate carry up to the head.

---

## 2. Approach: Two Pointers (O(N) Time, O(1) Space)
## *2. Hướng tiếp cận: Hai con trỏ (Thời gian O(N), Không gian O(1))*

### Logic
### *Logic*
(See Strategy 2). This is the most efficient because it doesn't require list reversal or stack space.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Extra Space:** No recursion or additional lists.
    *Không gian phụ O(1): Không đệ quy hay danh sách bổ sung.*
*   **One Pass (Technically):** We locate the `notNine` node and then update.
    *Một lần duyệt (Về kỹ thuật): Chúng ta định vị nút notNine và cập nhật.*

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

**Input:** `1 -> 2 -> 9 -> 9`
1. Dummy node `0 -> 1 -> 2 -> 9 -> 9`.
2. Traverse:
   - `0`: notNine = 0.
   - `1`: notNine = 1.
   - `2`: notNine = 2.
   - `9`: skip.
   - `9`: skip.
3. Increment `notNine` (2 becomes 3).
4. Set following to 0: `0 -> 1 -> 3 -> 0 -> 0`.
Result: `1 -> 3 -> 0 -> 0`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two pointers/Dummy node approach.
*Sử dụng hai con trỏ và nút giả.*
---
*Cuộc sống luôn có những điểm thay đổi (notNine). Khi chúng ta tiến tới một bước ngoặt quan trọng (carry), mọi thứ xung quanh có thể trở nên trống rỗng (set to zero) để nhường chỗ cho một chu kỳ mới tốt đẹp hơn.*
Life always has turning points (notNine). When we reach an important milestone (carry), everything around us can become empty (set to zero) to make room for a better new cycle.
