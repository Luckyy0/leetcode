# Analysis for Insert into a Sorted Circular Linked List
# *Phân tích cho bài toán Chèn vào Danh sách Liên kết Vòng đã sắp xếp*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
A circular list has no fixed start or end. We need to find the specific "gap" where the new value fits. There are three cases for the gap:
1.  **Intermediate:** `prev.val <= insertVal <= curr.val`.
2.  **Boundary (Min/Max):** The value is smaller than the minimum or larger than the maximum. In a sorted circular list, this gap is where the list "wraps around" (`prev.val > curr.val`).
3.  **Uniform:** All nodes in the list have the same value.
*Danh sách vòng không có điểm đầu hay điểm cuối cố định. Ta cần tìm "khoảng trống" phù hợp. Có ba trường hợp: ở giữa hai số, tại điểm xoay vòng (lớn nhất/nhỏ nhất), hoặc khi tất cả các nút giống hệt nhau.*

---

## 2. Strategy: Single Pass Traversal
## *2. Chiến lược: Duyệt một vòng*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Empty List:** If `head` is null, create a new node that points to itself and return it.
2.  **Single Node / Traversal:** Start with `prev = head` and `curr = head.next`.
3.  **Check Condition while traversing:**
    - **Case 1:** `insertVal` fits between `prev` and `curr` (`prev.val <= insertVal && insertVal <= curr.val`).
    - **Case 2:** We reach the "wrap-around" point (`prev.val > curr.val`):
        - If `insertVal >= prev.val` (it's the new max).
        - OR `insertVal <= curr.val` (it's the new min).
    - **Case 3:** We looped back to `head` without finding a spot (all nodes same value).
4.  **Insert:** Once a condition is met, insert the new node between `prev` and `curr`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We traverse the list at most once.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

The "wrap-around" point (where `prev.val > curr.val`) is the most critical edge case to identify in circular linked list problems. It acts as the effective boundary between the largest and smallest elements.
*Điểm xoay vòng (khi `prev.val > curr.val`) là trường hợp biên quan trọng nhất. Nó đóng vai trò là ranh giới giữa phần tử lớn nhất và nhỏ nhất.*
---
*Sự tuần hoàn (Circular) xóa nhòa ranh giới giữa khởi đầu và kết thúc, nhưng trật tự (Sorted) vẫn luôn tồn tại trong từng bước đi. Trong vòng lặp vô tận của dữ liệu, ta tìm kiếm điểm rơi của sự thật bằng cách quan sát sự chuyển giao (Between points) và sự đảo chiều (Wrap-around). Dữ liệu dạy ta rằng ngay cả trong một chu kỳ không dứt, việc chèn đúng vào vị trí phù hợp (Correct placement) sẽ giữ cho toàn bộ hệ thống luôn trong trạng thái ổn định.*
Cycle (Circular) blurs the boundary between beginning and end, but order (Sorted) always exists in every step. In the infinite loop of data, we search for the falling point of truth by observing transition (Between points) and reversal (Wrap-around). Data teaches us that even in an endless cycle, inserting right into the appropriate position (Correct placement) will keep the entire system in a stable state.
