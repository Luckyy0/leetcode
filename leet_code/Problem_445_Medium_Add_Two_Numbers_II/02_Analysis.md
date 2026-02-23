# Analysis for Add Two Numbers II
# *Phân tích cho bài toán Cộng hai số II*

## 1. Problem Essence & Right-to-Left Addition
## *1. Bản chất vấn đề & Phép cộng từ Phải sang Trái*

### The Challenge
### *Thách thức*
Adding two numbers represented by linked lists where the most significant digit (MSB) is at the head. Standard addition proceeds from least significant digit (LSB) to MSB. Since we cannot reverse the input lists directly (optional, but stacks are more elegant), we need a way to process them in reverse.

### Strategy: Two Stacks
### *Chiến lược: Hai Ngăn xếp*

1.  **Iterate and Push:**
    - Push all digits of `l1` onto `stack1`.
    - Push all digits of `l2` onto `stack2`.
2.  **Add from Least Significant Digit:**
    - While either stack is not empty or there's a carry:
        - Pop a digit from `stack1` (if available, else 0).
        - Pop a digit from `stack2` (if available, else 0).
        - Sum = `digit1 + digit2 + carry`.
        - Create a new node with `val = Sum % 10`.
        - **Head-Insertion:** Insert this node at the **beginning** of a new result list (to maintain MSB-first order).
        - Update `carry = Sum / 10`.
3.  **Result:** Return the head of the result list.

---

## 2. Approach: Stack-based Reversal
## *2. Hướng tiếp cận: Đảo ngược dựa trên Ngăn xếp*

### Logic
### *Logic*
(See above). The stack naturally reverses the order of traversal, allowing us to perform manual column-wise addition from the "end" of the numbers.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Non-destructive:** Does not modify the original linked lists.
    *Không phá hủy: Không làm thay đổi các danh sách liên kết gốc.*
*   **Intuitive Logic:** Standard addition rule is perfectly followed.
    *Logic trực quan: Tuân thủ hoàn hảo các quy tắc phép cộng tiêu chuẩn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(m + n)$, where $m, n$ are lengths of the lists.
    *Độ phức tạp thời gian: $O(m + n)$.*
*   **Space Complexity:** $O(m + n)$ for the two stacks.
    *Độ phức tạp không gian: $O(m + n)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `l1 = [7,2,4,3], l2 = [5,6,4]`
1. `stack1: [7,2,4,3]`, `stack2: [5,6,4]`.
2. Pop 3, 4. Sum = 7. `res: [7]`. Carry = 0.
3. Pop 4, 6. Sum = 10. `res: [0, 7]`. Carry = 1.
4. Pop 2, 5. Sum = 8. `res: [8, 0, 7]`. Carry = 0.
5. Pop 7, (0). Sum = 7. `res: [7, 8, 0, 7]`. Carry = 0.
Result: `[7, 8, 0, 7]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Two stacks for LSB-to-MSB addition with head insertion.
*Hai ngăn xếp cho phép cộng từ LSB lên MSB kết hợp chèn vào đầu.*
---
*Trong toán học cũng như trong cuộc sống, đôi khi ta phải lùi lại một bước (stack reversal) để nhìn thấu những chi tiết nhỏ nhất (LSB). Bằng cách tích lũy từ những điều nền tảng và tiến dần về phía quan trọng nhất (MSB), ta xây dựng nên một kết quả trọn vẹn và vững chắc. Sự kết nối giữa quá khứ (stacks) và hiện tại (linked list) chính là cội nguồn của mọi sự phát triển.*
In mathematics as well as in life, sometimes we have to take a step back (stack reversal) to see the smallest details (LSB). By accumulating from the fundamentals and gradually moving towards the most important part (MSB), we build a complete and solid result. The connection between the past (stacks) and the present (linked list) is the source of all development.
