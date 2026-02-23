# Analysis for Find the Duplicate Number
# *Phân tích cho bài toán Tìm số trùng lặp*

## 1. Problem Essence & Cycle Detection
## *1. Bản chất vấn đề & Phát hiện chu trình*

### The Setup
### *Cài đặt*
Array length `n+1`. Values `[1, n]`.
Pigeonhole Principle: At least one duplicate must exist.
Constraints: No modify array, $O(1)$ space.
This rules out Sorting ($O(N \log N)$ but modifies), Set ($O(N)$ space), Negative Marking ($O(1)$ space but modifies).

### Strategy: Linked List Cycle
### *Chiến lược: Chu trình danh sách liên kết*
Interpret the array as a function $f(i) = nums[i]$.
Indices $0 \dots n$. Values $1 \dots n$.
We can treat index `i` pointing to index `nums[i]`.
Since values are within index range (mostly), we trace the path:
$0 \to nums[0] \to nums[nums[0]] \dots$
Because of the duplicate, two indices point to the same value (node), creating a cycle.
The *duplicate number* is the **entry point** of the cycle.

Why?
If `nums[x] == nums[y] == target`, then both `x` and `y` point to `target`.
This is a cycle where multiple nodes point to one.

### Algorithm: Floyd's Tortoise and Hare
### *Thuật toán: Rùa và Thỏ của Floyd*
1.  **Phase 1:** Determine intersection.
    - `slow = nums[0]`, `fast = nums[0]`.
    - Do `slow = nums[slow]`, `fast = nums[nums[fast]]`.
    - Stop when `slow == fast`.
2.  **Phase 2:** Find entrance.
    - `slow = nums[0]` (Reset slow to start).
    - `fast` stays at intersection.
    - Move both 1 step at a time: `slow = nums[slow]`, `fast = nums[fast]`.
    - Meeting point is the Duplicate.

---

## 2. Approach: Floyd's Cycle Detection
## *2. Hướng tiếp cận: Phát hiện Chu trình Floyd*

### Logic
### *Logic*
1.  Slow/Fast pointers to find meeting point.
2.  Reset Slow to head.
3.  Move both until they meet.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Read-Only:** Meets the strict constraints perfectly.
*   **Linear Time:** $O(N)$ traversal.
    *Chỉ đọc: Đáp ứng các ràng buộc nghiêm ngặt. Thời gian tuyến tính: O(N).*

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

**Input:** `[1,3,4,2,2]`
Indices: 0 1 2 3 4
Values:  1 3 4 2 2
Graph:
0 -> 1
1 -> 3
3 -> 2
2 -> 4
4 -> 2 (Cycle 2-4-2)

1.  **Phase 1:**
    - S: 1, F: 1.
    - S: 1->3, F: 1->3->2.
    - S: 3->2, F: 2->4->2.
    - S: 2->4, F: 2->4->2... Wait.
    - Start `slow=nums[0]`, `fast=nums[0]`.
    - loop: S=3, F=2 (via 1->3->2).
    - loop: S=2, F=2 (via 2->4->2).
    - Meet at 2.
2.  **Phase 2:**
    - S=1 (from value 1 at index 0? No, `nums[0]`). Wait, start at 0?
    - `p1 = nums[0]`. `p2 = intersection (2)`. (Wait, standard algo resets ONE pointer to HEAD (0) ?? No, Head of linked list logic).
    - The linked list head is index 0. The value at index 0 is `nums[0]`.
    - Correct Phase 2: `ptr1 = nums[0]`. `ptr2 = intersection`. Move step by step.
    - Start: `ptr1 = 1`, `ptr2 = 2`.
    - 1 -> `nums[1] = 3`. 2 -> `nums[2] = 4`.
    - 3 -> `nums[3] = 2`. 4 -> `nums[4] = 2`.
    - Meet at 2. Return 2. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic implementation of Floyd's Cycle. Memorize this mapping: Array Value -> Next Index.
*Cài đặt kinh điển của Chu trình Floyd. Ghi nhớ ánh xạ: Giá trị mảng -> Chỉ số tiếp theo.*
---
*Những sự lặp lại (duplicates) thường tạo ra những vòng luẩn quẩn (cycles). Để thoát ra, ta cần tìm điểm bắt đầu của sự lặp lại đó.*
Repetitions (duplicates) often create vicious circles (cycles). To escape, we need to find the entry point of that repetition.
