# Analysis for Verify Preorder Sequence in Binary Search Tree
# *Phân tích cho bài toán Xác minh chuỗi Preorder trong BST*

## 1. Problem Essence & Stack Simulation
## *1. Bản chất vấn đề & Mô phỏng Ngăn xếp*

### Preorder Property
### *Tính chất Tiền thứ tự*
BST Preorder: `Root -> Left -> Right`.
Rule: `Left < Root < Right`.
When we traverse `5, 2, 1, 3, 6`:
- `5` is Root.
- `2` < `5` (Left).
- `1` < `2` (Left of 2).
- `3` > `1` (Right of ?). `3` is > `1` and > `2` but < `5`. So `3` is right child of `2`.
- `6` > `5` (Right of Root).

Crucially, **once we go to the right branch of a node, we can never see a value smaller than that node again.**
Example bad: `[5, 2, 6, 1]`.
- `5` Root.
- `2` Left.
- `6` Right of 5. Now we are in the right subtree of `5`. All future values MUST be `> 5`.
- `1` < `5`. Violation!

### Strategy
### *Chiến lược*
Maintain a `low_bound` (the value of the root whose right subtree we are currently in).
Initially `low_bound = -infinity`.
1.  Use a Stack to track the path down the tree (decreasing values).
2.  Iterate `val` in preorder:
    - If `val < low_bound`: Return `false` (Violation).
    - While `stack` is not empty and `stack.peek() < val`:
        - We are moving to the right child of `stack.peek()`.
        - So, `low_bound = stack.pop()`.
    - Push `val` to stack.

---

## 2. Approach: Monotonic Stack
## *2. Hướng tiếp cận: Ngăn xếp đơn điệu*

### Logic
### *Logic*
1.  `stack` stores nodes on current left-leaning path.
2.  `minLimit` stores the lower bound constraint.
3.  For each `x`:
    - check `x < minLimit` -> False.
    - while `stack.top < x`: `minLimit = stack.pop()`. (We finished left subtree of `pop()`, now in right. `minLimit` updates).
    - `stack.push(x)`.
4.  Return `true`.

### Constant Space Follow-up
### *Tối ưu không gian hằng số*
We can reuse the `preorder` array as the stack! Use an index `i` as the stack pointer.
*Tái sử dụng mảng đầu vào làm stack để đạt O(1) space.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Nature:** BST structure enforces strict ordering limits that tighten as we traverse.
    *Bản chất sắp xếp: Cấu trúc BST áp đặt các giới hạn thứ tự nghiêm ngặt.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each node pushed and popped once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for stack (or $O(1)$ if reusing input).
    *Độ phức tạp không gian: $O(N)$ hoặc $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[5,2,6,1,3]`
1.  Stack `[5]`. MinLimit `-inf`.
2.  Val `2 < 5`. Push. Stack `[5, 2]`.
3.  Val `6`. `6 > 2`. Pop 2 (Limit=2). `6 > 5`. Pop 5 (Limit=5). Push 6. Stack `[6]`.
4.  Val `1`. `1 < Limit (5)`. **FALSE**.

**Input:** `[5,2,1,3,6]`
1.  Stack `[5]`. Limit `-inf`.
2.  Push `2`. Stack `[5, 2]`.
3.  Push `1`. Stack `[5, 2, 1]`.
4.  Val `3`. `3 > 1`. Pop 1 (Limit=1). `3 > 2`. Pop 2 (Limit=2). Push 3. Stack `[5, 3]`. Limit `2`.
5.  Val `6`. `6 > 3`. Pop 3 (Limit=3). `6 > 5`. Pop 5 (Limit=5). Push 6. Stack `[6]`. Limit `5`.
All valid.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Stack method simulates the traversal perfectly. Reusing the array is a clever trick for space.
*Phương pháp ngăn xếp mô phỏng duyệt cây hoàn hảo. Tái sử dụng mảng là mẹo thông minh.*
---
*Một khi đã rẽ phải (lựa chọn lớn hơn), bạn không thể quay lại lối mòn cũ (giá trị nhỏ hơn). Quá khứ đã đặt ra giới hạn thấp nhất cho tương lai.*
Once you turn right (choose bigger), you cannot go back to the old path (smaller values). The past has set a lower limit for the future.
