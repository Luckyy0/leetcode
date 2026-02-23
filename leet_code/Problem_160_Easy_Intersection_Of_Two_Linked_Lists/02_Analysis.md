# Analysis for Intersection of Two Linked Lists
# *Phân tích cho bài toán Giao điểm của hai danh sách liên kết*

## 1. Problem Essence & Efficiency
## *1. Bản chất vấn đề & Hiệu quả*

### The Difficulty: Different Lengths
### *Khó khăn: Độ dài khác nhau*
If two linked lists intersect, they share a common suffix. The only reason they wouldn't meet at the same time if we just iterated forward is that the part *before* the intersection might have different lengths.
*Nếu hai danh sách liên kết giao nhau, chúng chia sẻ một phần đuôi chung. Lý do duy nhất khiến chúng không gặp nhau cùng lúc nếu chúng ta chỉ duyệt thẳng là vì phần *trước* giao điểm có thể có độ dài khác nhau.*

### Constraints
### *Ràng buộc*
We need a solution with $O(M + N)$ time complexity and $O(1)$ space complexity. Using a `HashSet` to store nodes of one list would take $O(M)$ space, which is not optimal.
*Chúng ta cần một giải pháp với độ phức tạp thời gian $O(M + N)$ và không gian $O(1)$. Sử dụng `HashSet` để lưu trữ các nút của một danh sách sẽ tốn không gian $O(M)$, điều này không tối ưu.*

---

## 2. Approach: The Two-Pointer Convergence Trick
## *2. Hướng tiếp cận: Mẹo hội tụ hai con trỏ*

This is one of the most elegant linked list algorithms.
*Đây là một trong những thuật toán danh sách liên kết trang nhã nhất.*

### Logic
### *Logic*
1.  Initialize two pointers, `pA` at `headA` and `pB` at `headB`.
2.  Traverse both lists at the same speed.
3.  When `pA` reaches the end of list A, redirect it to the head of list B.
4.  When `pB` reaches the end of list B, redirect it to the head of list A.
5.  If they meet, the meeting point is the intersection node. If they both reach `null` simultaneously (after the redirects), they don't intersect.

### Why does this work? (The Math)
### *Tại sao logic này hoạt động? (Toán học)*
Let:
- $a$ = Length of list A before intersection.
- $b$ = Length of list B before intersection.
- $c$ = Length of the common intersected part.

- Pointer A travels distance: $a + c + b$.
- Pointer B travels distance: $b + c + a$.
- Since $a+c+b = b+c+a$, they will inevitably meet after both have traveled the exact same total distance!
*Giai thích: Tổng quãng đường Pointer A đi là $a + c + b$. Tổng quãng đường Pointer B đi là $b + c + a$. Vì hai tổng này bằng nhau, chúng chắc chắn sẽ gặp nhau tại điểm bắt đầu của phần chung $c$.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Zero Extra Memory:** No hash maps or additional lists are required.
    *Không tốn bộ nhớ bổ sung: Không yêu cầu hash map hay danh sách phụ.*
*   **Simple Implementation:** The switch-over logic eliminates the need to explicitly calculate lengths and skip the difference.
    *Triển khai đơn giản: Logic chuyển đổi loại bỏ việc phải tính toán độ dài và bỏ qua phần chênh lệch một cách thủ công.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M + N)$. In the worst case, each pointer travels the length of both lists.
    *Độ phức tạp thời gian: $O(M + N)$. Trong trường hợp xấu nhất, mỗi con trỏ đi hết chiều dài của cả hai danh sách.*
*   **Space Complexity:** $O(1)$. We only use two pointers.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng hai con trỏ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**List A:** `[4, 1, 8, 4, 5]` (Length 5)
**List B:** `[5, 6, 1, 8, 4, 5]` (Length 6)
**Intersection starts at 8.**

1. `pA` starts at 4, `pB` starts at 5.
2. `pA` moves 5 steps to end, then moves to head of B.
3. `pB` moves 6 steps to end, then moves to head of A.
4. After some steps, `pA` will have traveled `A_prefix + Intersection + B_prefix`.
5. Simultaneously, `pB` will have traveled `B_prefix + Intersection + A_prefix`.
6. They both land on `8` at the same moment.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The Two-Pointer approach for intersection is a must-know. It demonstrates the power of "balancing" distances in linked list problems. If you forget this approach during an interview, the backup is to calculate the lengths of both lists, find the difference $D$, advance the pointer of the longer list by $D$ steps, and then move both together. Both achieve $O(1)$ space, but the redirect method is cleaner.
*Phương pháp Hai con trỏ cho giao điểm là kiến thức bắt buộc phải biết. Nó chứng minh sức mạnh của việc "cân bằng" khoảng cách trong các bài toán danh sách liên kết. Nếu bạn quên cách này, phương án dự phòng là tính độ dài cả hai, tìm hiệu $D$, cho con trỏ danh sách dài hơn đi trước $D$ bước rồi mới đi cùng nhau. Cả hai đều đạt $O(1)$ không gian, nhưng phương pháp chuyển đổi sạch sẽ hơn.*
---
*Mọi con đường khác biệt cuối cùng sẽ gặp nhau nếu chúng ta đủ kiên nhẫn để đi trọn hành trình của nhau.*
All differing paths will eventually meet if we are patient enough to travel each other's entire journey.
