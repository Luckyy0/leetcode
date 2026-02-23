# Analysis for Merge Two Sorted Lists
# *Phân tích cho bài toán Gộp Hai Danh Sách Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two pointers `list1`, `list2`. *Hai con trỏ `list1`, `list2`.*
*   **Output:** One pointer `mergedHead`. *Một con trỏ `mergedHead`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   List size is small (up to 50).
*   Lists are sorted.
*   $O(N + M)$ time complexity is expected.
    *Độ phức tạp thời gian $O(N + M)$ được mong đợi.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Iterative with Dummy Node
### *Hướng tiếp cận: Lặp với Nút Giả*

*   **Intuition:** Compare the heads of both lists. Attach the smaller node to the result list and move the pointer forward. Repeat until one list is empty.
    *Ý tưởng: So sánh đầu của hai danh sách. Gắn nút nhỏ hơn vào danh sách kết quả và di chuyển con trỏ về phía trước. Lặp lại cho đến khi một danh sách trống.*
*   **Algorithm Steps:**
    1.  Create `dummy` node (sentinel). `current = dummy`.
    2.  While `list1 != null` and `list2 != null`:
        *   If `list1.val <= list2.val`:
            *   `current.next = list1`.
            *   `list1 = list1.next`.
        *   Else:
            *   `current.next = list2`.
            *   `list2 = list2.next`.
        *   `current = current.next`.
    3.  If `list1` is not null, attach it to end.
    4.  If `list2` is not null, attach it to end.
    5.  Return `dummy.next`.

*   **Complexity:**
    *   Time: $O(N + M)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`L1: 1->2`, `L2: 1->3`
1.  Dummy. `1 <= 1`. Attach L1(1). L1->2. Curr->1.
2.  `2 > 1`. Attach L2(1). L2->3. Curr->1.
3.  `2 <= 3`. Attach L1(2). L1->null. Curr->2.
4.  L1 empty. Attach remainder L2 (3).
Result: Dummy -> 1 -> 1 -> 2 -> 3. Correct.
