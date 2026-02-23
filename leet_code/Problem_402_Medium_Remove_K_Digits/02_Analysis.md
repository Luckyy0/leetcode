# Analysis for Remove K Digits
# *Phân tích cho bài toán Xóa K Chữ số*

## 1. Problem Essence & Monotonicity
## *1. Bản chất vấn đề & Tính đơn điệu*

### The Challenge
### *Thách thức*
Creating the smallest number by removing $k$ digits. To make a number as small as possible, we want the most significant digits (leftmost) to be as small as possible. This suggests a greedy strategy where we prioritize smaller digits at the front.

### Strategy: Monotonic Stack
### *Chiến lược: Ngăn xếp Đơn điệu*
1.  **Greedy Choice:** As we traverse the number from left to right, if the current digit is smaller than the previous one, removing the previous digit will always result in a smaller number (e.g., in "14" vs "13", removing 4 makes it 1, which is better than removing 1 to get 4).
2.  **Implementation:**
    - Use a stack to maintain digits in non-decreasing order.
    - For each digit `d` in `num`:
        - While the stack is not empty, `k > 0`, and the top of the stack is greater than `d`:
            - Pop the stack and decrement `k`.
        - Push `d` to the stack.
3.  **Post-processing:**
    - If `k` is still greater than 0, remove digits from the end (pop from stack).
    - Construct the string from the stack.
    - Remove leading zeros.
    - If the result is empty, return "0".

---

## 2. Approach: Iterative Greedy (Stack)
## *2. Hướng tiếp cận: Tham lam Lặp (Ngăn xếp)*

### Logic
### *Logic*
(See above). The stack ensures that we always "replace" a larger digit with a smaller subsequent digit if possible within our $k$ removals budget.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Each digit is pushed and popped at most once.
    *Hiệu quả O(N): Mỗi chữ số được đẩy vào và lấy ra khỏi ngăn xếp tối đa một lần.*
*   **Predictable Result:** Handles cases like leading zeros naturally through the construction process.
    *Kết quả dễ dự đoán: Xử lý các trường hợp như số 0 ở đầu một cách tự nhiên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the stack storage.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `num = "1432219", k = 3`
1. `1`: Stack `[1]`
2. `4`: Stack `[1, 4]` (4 > 1, OK)
3. `3`: 3 < 4, Pop 4, k=2. Stack `[1, 3]`
4. `2`: 2 < 3, Pop 3, k=1. Stack `[1, 2]`
5. `2`: Stack `[1, 2, 2]` (2 == 2, OK)
6. `1`: 1 < 2, Pop 2, k=0. Stack `[1, 2, 1]`
7. `9`: Stack `[1, 2, 1, 9]`
Final string: "1219".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Monotonic stack with greedy replacement.
*Ngăn xếp đơn điệu với thay thế tham lam.*
---
*Trong cuộc đời, đôi khi chúng ta phải biết buông bỏ (remove) những gì cồng kềnh và to lớn ở phía trước (significant digits) để dọn đường cho những điều khiêm nhường nhưng giá trị hơn (smaller digits) xuất hiện. Bằng cách luôn giữ một tinh thần cầu tiến và tinh gọn (monotonic stack), ta sẽ đạt được trạng thái tối ưu nhất giữa những bộn bề dữ liệu.*
In life, sometimes we must know how to let go (remove) of what is bulky and large in front (significant digits) to make way for humble but more valuable things (smaller digits). By always keeping a progressive and lean spirit (monotonic stack), we will achieve the most optimal state amidst the mess of data.
